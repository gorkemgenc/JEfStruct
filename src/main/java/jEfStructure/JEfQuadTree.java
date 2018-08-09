package jEfStructure;

import jEfEnums.JEfNodeType;
import jEfExceptions.JEfQuadTreeException;

import java.util.ArrayList;
import java.util.List;

public class JEfQuadTree<T> {

    private JEfNode<T> root_;
    private int count_ = 0;

    public JEfQuadTree(double minX, double minY, double maxX, double maxY) {
        this.root_ = new JEfNode<T>(minX, minY, maxX - minX, maxY - minY, null);
    }

    public JEfNode<T> getRootNode() {
        return this.root_;
    }

    public void set(double x, double y, T value) {

        JEfNode<T> root = this.root_;
        if (x < root.getX() || y < root.getY() || x > root.getX() + root.getW() || y > root.getY() + root.getH()) {
            throw new JEfQuadTreeException("Out of bounds : (" + x + ", " + y + ")");
        }
        if (this.insert(root, new JEfPoint<T>(x, y, value))) {
            this.count_++;
        }
    }

    public T get(double x, double y, T opt_default) {
        JEfNode<T> JEfNode = this.find(this.root_, x, y);
        return JEfNode != null ? JEfNode.getJEfPoint().getValue() : opt_default;
    }

    public T remove(double x, double y) {
        JEfNode<T> JEfNode = this.find(this.root_, x, y);
        if (JEfNode != null) {
            T value = JEfNode.getJEfPoint().getValue();
            JEfNode.setJEfPoint(null);
            JEfNode.setNodeType(JEfNodeType.EMPTY);
            this.balance(JEfNode);
            this.count_--;
            return value;
        } else {
            return null;
        }
    }

    public boolean contains(double x, double y) {
        return this.get(x, y, null) != null;
    }

    public boolean isEmpty() {
        return this.root_.getNodeType() == JEfNodeType.EMPTY;
    }

    public int getCount() {
        return this.count_;
    }

    public void clear() {
        this.root_.setNw(null);
        this.root_.setNe(null);
        this.root_.setSw(null);
        this.root_.setSe(null);
        this.root_.setNodeType(JEfNodeType.EMPTY);
        this.root_.setJEfPoint(null);
        this.count_ = 0;
    }

    public JEfPoint<T>[] getKeys() {
        final List<JEfPoint<T>> arr = new ArrayList<JEfPoint<T>>();
        this.traverse(this.root_, new IjEfFunc<T>() {
            @Override
            public void call(JEfQuadTree<T> JEfQuadTree, JEfNode<T> JEfNode) {
                arr.add(JEfNode.getJEfPoint());
            }
        });
        return arr.toArray((JEfPoint<T>[]) new JEfPoint[arr.size()]);
    }

    public List<T> getValues() {
        final List<T> arr = new ArrayList<T>();
        this.traverse(this.root_, new IjEfFunc<T>() {
            @Override
            public void call(JEfQuadTree<T> JEfQuadTree, JEfNode<T> JEfNode) {
                arr.add(JEfNode.getJEfPoint().getValue());
            }
        });

        return arr;
    }

    public JEfPoint<T>[] searchIntersect(final double xmin, final double ymin, final double xmax, final double ymax) {
        final List<JEfPoint<T>> arr = new ArrayList<JEfPoint<T>>();
        this.navigate(this.root_, new IjEfFunc<T>() {
            @Override
            public void call(JEfQuadTree<T> JEfQuadTree, JEfNode<T> JEfNode) {
                JEfPoint<T> pt = JEfNode.getJEfPoint();
                if (pt.getX() < xmin || pt.getX() > xmax || pt.getY() < ymin || pt.getY() > ymax) {
                    // Definitely not within the polygon!
                } else {
                    arr.add(JEfNode.getJEfPoint());
                }

            }
        }, xmin, ymin, xmax, ymax);
        return arr.toArray((JEfPoint<T>[]) new JEfPoint[arr.size()]);
    }

    public JEfPoint<T>[] searchWithin(final double xmin, final double ymin, final double xmax, final double ymax) {
        final List<JEfPoint<T>> arr = new ArrayList<JEfPoint<T>>();
        this.navigate(this.root_, new IjEfFunc<T>() {
            @Override
            public void call(JEfQuadTree<T> JEfQuadTree, JEfNode<T> JEfNode) {
                JEfPoint<T> pt = JEfNode.getJEfPoint();
                if (pt.getX() > xmin && pt.getX() < xmax && pt.getY() > ymin && pt.getY() < ymax) {
                    arr.add(JEfNode.getJEfPoint());
                }
            }
        }, xmin, ymin, xmax, ymax);
        return arr.toArray((JEfPoint<T>[]) new JEfPoint[arr.size()]);
    }

    public void navigate(JEfNode<T> JEfNode, IjEfFunc<T> ijEfFunc, double xmin, double ymin, double xmax, double ymax) {
        switch (JEfNode.getNodeType()) {
            case LEAF:
                ijEfFunc.call(this, JEfNode);
                break;

            case POINTER:
                if (intersects(xmin, ymax, xmax, ymin, JEfNode.getNe()))
                    this.navigate(JEfNode.getNe(), ijEfFunc, xmin, ymin, xmax, ymax);
                if (intersects(xmin, ymax, xmax, ymin, JEfNode.getSe()))
                    this.navigate(JEfNode.getSe(), ijEfFunc, xmin, ymin, xmax, ymax);
                if (intersects(xmin, ymax, xmax, ymin, JEfNode.getSw()))
                    this.navigate(JEfNode.getSw(), ijEfFunc, xmin, ymin, xmax, ymax);
                if (intersects(xmin, ymax, xmax, ymin, JEfNode.getNw()))
                    this.navigate(JEfNode.getNw(), ijEfFunc, xmin, ymin, xmax, ymax);
                break;
        }
    }

    private boolean intersects(double left, double bottom, double right, double top, JEfNode<T> JEfNode) {
        return !(JEfNode.getX() > right ||
                (JEfNode.getX() + JEfNode.getW()) < left ||
                JEfNode.getY() > bottom ||
                (JEfNode.getY() + JEfNode.getH()) < top);
    }

    public JEfQuadTree<T> clone() {
        double x1 = this.root_.getX();
        double y1 = this.root_.getY();
        double x2 = x1 + this.root_.getW();
        double y2 = y1 + this.root_.getH();
        final JEfQuadTree<T> clone = new JEfQuadTree<T>(x1, y1, x2, y2);

        this.traverse(this.root_, new IjEfFunc<T>() {
            @Override
            public void call(JEfQuadTree<T> JEfQuadTree, JEfNode<T> JEfNode) {
                clone.set(JEfNode.getJEfPoint().getX(), JEfNode.getJEfPoint().getY(), JEfNode.getJEfPoint().getValue());
            }
        });


        return clone;
    }

    public void traverse(JEfNode<T> JEfNode, IjEfFunc<T> ijEfFunc) {
        switch (JEfNode.getNodeType()) {
            case LEAF:
                ijEfFunc.call(this, JEfNode);
                break;

            case POINTER:
                this.traverse(JEfNode.getNe(), ijEfFunc);
                this.traverse(JEfNode.getSe(), ijEfFunc);
                this.traverse(JEfNode.getSw(), ijEfFunc);
                this.traverse(JEfNode.getNw(), ijEfFunc);
                break;
        }
    }

    public JEfNode<T> find(JEfNode<T> JEfNode, double x, double y) {
        JEfNode<T> resposne = null;
        switch (JEfNode.getNodeType()) {
            case EMPTY:
                break;

            case LEAF:
                resposne = JEfNode.getJEfPoint().getX() == x && JEfNode.getJEfPoint().getY() == y ? JEfNode : null;
                break;

            case POINTER:
                resposne = this.find(this.getQuadrantForPoint(JEfNode, x, y), x, y);
                break;

            default:
                throw new JEfQuadTreeException("Invalid nodeType");
        }
        return resposne;
    }

    private boolean insert(JEfNode<T> parent, JEfPoint<T> JEfPoint) {
        Boolean result = false;
        switch (parent.getNodeType()) {
            case EMPTY:
                this.setPointForNode(parent, JEfPoint);
                result = true;
                break;
            case LEAF:
                if (parent.getJEfPoint().getX() == JEfPoint.getX() && parent.getJEfPoint().getY() == JEfPoint.getY()) {
                    this.setPointForNode(parent, JEfPoint);
                    result = false;
                } else {
                    this.split(parent);
                    result = this.insert(parent, JEfPoint);
                }
                break;
            case POINTER:
                result = this.insert(
                        this.getQuadrantForPoint(parent, JEfPoint.getX(), JEfPoint.getY()), JEfPoint);
                break;

            default:
                throw new JEfQuadTreeException("Invalid nodeType in parent");
        }
        return result;
    }

    private void split(JEfNode<T> JEfNode) {
        JEfPoint<T> oldJEfPoint = JEfNode.getJEfPoint();
        JEfNode.setJEfPoint(null);

        JEfNode.setNodeType(JEfNodeType.POINTER);

        double x = JEfNode.getX();
        double y = JEfNode.getY();
        double hw = JEfNode.getW() / 2;
        double hh = JEfNode.getH() / 2;

        JEfNode.setNw(new JEfNode<T>(x, y, hw, hh, JEfNode));
        JEfNode.setNe(new JEfNode<T>(x + hw, y, hw, hh, JEfNode));
        JEfNode.setSw(new JEfNode<T>(x, y + hh, hw, hh, JEfNode));
        JEfNode.setSe(new JEfNode<T>(x + hw, y + hh, hw, hh, JEfNode));

        this.insert(JEfNode, oldJEfPoint);
    }

    private void balance(JEfNode<T> JEfNode) {
        switch (JEfNode.getNodeType()) {
            case EMPTY:
            case LEAF:
                if (JEfNode.getParent() != null) {
                    this.balance(JEfNode.getParent());
                }
                break;

            case POINTER: {
                JEfNode<T> nw = JEfNode.getNw();
                JEfNode<T> ne = JEfNode.getNe();
                JEfNode<T> sw = JEfNode.getSw();
                JEfNode<T> se = JEfNode.getSe();
                JEfNode<T> firstLeaf = null;

                if (nw.getNodeType() != JEfNodeType.EMPTY) {
                    firstLeaf = nw;
                }
                if (ne.getNodeType() != JEfNodeType.EMPTY) {
                    if (firstLeaf != null) {
                        break;
                    }
                    firstLeaf = ne;
                }
                if (sw.getNodeType() != JEfNodeType.EMPTY) {
                    if (firstLeaf != null) {
                        break;
                    }
                    firstLeaf = sw;
                }
                if (se.getNodeType() != JEfNodeType.EMPTY) {
                    if (firstLeaf != null) {
                        break;
                    }
                    firstLeaf = se;
                }

                if (firstLeaf == null) {
                    JEfNode.setNodeType(JEfNodeType.EMPTY);
                    JEfNode.setNw(null);
                    JEfNode.setNe(null);
                    JEfNode.setSw(null);
                    JEfNode.setSe(null);

                } else if (firstLeaf.getNodeType() == JEfNodeType.POINTER) {
                    break;

                } else {
                    JEfNode.setNodeType(JEfNodeType.LEAF);
                    JEfNode.setNw(null);
                    JEfNode.setNe(null);
                    JEfNode.setSw(null);
                    JEfNode.setSe(null);
                    JEfNode.setJEfPoint(firstLeaf.getJEfPoint());
                }

                if (JEfNode.getParent() != null) {
                    this.balance(JEfNode.getParent());
                }
            }
            break;
        }
    }

    private JEfNode<T> getQuadrantForPoint(JEfNode<T> parent, double x, double y) {
        double mx = parent.getX() + parent.getW() / 2;
        double my = parent.getY() + parent.getH() / 2;
        if (x < mx) {
            return y < my ? parent.getNw() : parent.getSw();
        } else {
            return y < my ? parent.getNe() : parent.getSe();
        }
    }

    private void setPointForNode(JEfNode<T> JEfNode, JEfPoint<T> JEfPoint) {
        if (JEfNode.getNodeType() == JEfNodeType.POINTER) {
            throw new JEfQuadTreeException("Can not set JEfPoint for JEfNode of type POINTER");
        }
        JEfNode.setNodeType(JEfNodeType.LEAF);
        JEfNode.setJEfPoint(JEfPoint);
    }
}
