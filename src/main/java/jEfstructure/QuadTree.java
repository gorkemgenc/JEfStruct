package jEfstructure;

import jEfenums.NodeType;
import exceptions.QuadTreeException;

import java.util.ArrayList;
import java.util.List;

public class QuadTree<T> {

    private Node<T> root_;
    private int count_ = 0;

    public QuadTree(double minX, double minY, double maxX, double maxY) {
        this.root_ = new Node<T>(minX, minY, maxX - minX, maxY - minY, null);
    }

    public Node<T> getRootNode() {
        return this.root_;
    }

    public void set(double x, double y, T value) {

        Node<T> root = this.root_;
        if (x < root.getX() || y < root.getY() || x > root.getX() + root.getW() || y > root.getY() + root.getH()) {
            throw new QuadTreeException("Out of bounds : (" + x + ", " + y + ")");
        }
        if (this.insert(root, new Point<T>(x, y, value))) {
            this.count_++;
        }
    }

    public T get(double x, double y, T opt_default) {
        Node<T> node = this.find(this.root_, x, y);
        return node != null ? node.getPoint().getValue() : opt_default;
    }

    public T remove(double x, double y) {
        Node<T> node = this.find(this.root_, x, y);
        if (node != null) {
            T value = node.getPoint().getValue();
            node.setPoint(null);
            node.setNodeType(NodeType.EMPTY);
            this.balance(node);
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
        return this.root_.getNodeType() == NodeType.EMPTY;
    }

    public int getCount() {
        return this.count_;
    }

    public void clear() {
        this.root_.setNw(null);
        this.root_.setNe(null);
        this.root_.setSw(null);
        this.root_.setSe(null);
        this.root_.setNodeType(NodeType.EMPTY);
        this.root_.setPoint(null);
        this.count_ = 0;
    }

    public Point<T>[] getKeys() {
        final List<Point<T>> arr = new ArrayList<Point<T>>();
        this.traverse(this.root_, new Func<T>() {
            @Override
            public void call(QuadTree<T> quadTree, Node<T> node) {
                arr.add(node.getPoint());
            }
        });
        return arr.toArray((Point<T>[]) new Point[arr.size()]);
    }

    public List<T> getValues() {
        final List<T> arr = new ArrayList<T>();
        this.traverse(this.root_, new Func<T>() {
            @Override
            public void call(QuadTree<T> quadTree, Node<T> node) {
                arr.add(node.getPoint().getValue());
            }
        });

        return arr;
    }

    public Point<T>[] searchIntersect(final double xmin, final double ymin, final double xmax, final double ymax) {
        final List<Point<T>> arr = new ArrayList<Point<T>>();
        this.navigate(this.root_, new Func<T>() {
            @Override
            public void call(QuadTree<T> quadTree, Node<T> node) {
                Point<T> pt = node.getPoint();
                if (pt.getX() < xmin || pt.getX() > xmax || pt.getY() < ymin || pt.getY() > ymax) {
                    // Definitely not within the polygon!
                } else {
                    arr.add(node.getPoint());
                }

            }
        }, xmin, ymin, xmax, ymax);
        return arr.toArray((Point<T>[]) new Point[arr.size()]);
    }

    public Point<T>[] searchWithin(final double xmin, final double ymin, final double xmax, final double ymax) {
        final List<Point<T>> arr = new ArrayList<Point<T>>();
        this.navigate(this.root_, new Func<T>() {
            @Override
            public void call(QuadTree<T> quadTree, Node<T> node) {
                Point<T> pt = node.getPoint();
                if (pt.getX() > xmin && pt.getX() < xmax && pt.getY() > ymin && pt.getY() < ymax) {
                    arr.add(node.getPoint());
                }
            }
        }, xmin, ymin, xmax, ymax);
        return arr.toArray((Point<T>[]) new Point[arr.size()]);
    }

    public void navigate(Node<T> node, Func<T> func, double xmin, double ymin, double xmax, double ymax) {
        switch (node.getNodeType()) {
            case LEAF:
                func.call(this, node);
                break;

            case POINTER:
                if (intersects(xmin, ymax, xmax, ymin, node.getNe()))
                    this.navigate(node.getNe(), func, xmin, ymin, xmax, ymax);
                if (intersects(xmin, ymax, xmax, ymin, node.getSe()))
                    this.navigate(node.getSe(), func, xmin, ymin, xmax, ymax);
                if (intersects(xmin, ymax, xmax, ymin, node.getSw()))
                    this.navigate(node.getSw(), func, xmin, ymin, xmax, ymax);
                if (intersects(xmin, ymax, xmax, ymin, node.getNw()))
                    this.navigate(node.getNw(), func, xmin, ymin, xmax, ymax);
                break;
        }
    }

    private boolean intersects(double left, double bottom, double right, double top, Node<T> node) {
        return !(node.getX() > right ||
                (node.getX() + node.getW()) < left ||
                node.getY() > bottom ||
                (node.getY() + node.getH()) < top);
    }

    public QuadTree<T> clone() {
        double x1 = this.root_.getX();
        double y1 = this.root_.getY();
        double x2 = x1 + this.root_.getW();
        double y2 = y1 + this.root_.getH();
        final QuadTree<T> clone = new QuadTree<T>(x1, y1, x2, y2);

        this.traverse(this.root_, new Func<T>() {
            @Override
            public void call(QuadTree<T> quadTree, Node<T> node) {
                clone.set(node.getPoint().getX(), node.getPoint().getY(), node.getPoint().getValue());
            }
        });


        return clone;
    }

    public void traverse(Node<T> node, Func<T> func) {
        switch (node.getNodeType()) {
            case LEAF:
                func.call(this, node);
                break;

            case POINTER:
                this.traverse(node.getNe(), func);
                this.traverse(node.getSe(), func);
                this.traverse(node.getSw(), func);
                this.traverse(node.getNw(), func);
                break;
        }
    }

    public Node<T> find(Node<T> node, double x, double y) {
        Node<T> resposne = null;
        switch (node.getNodeType()) {
            case EMPTY:
                break;

            case LEAF:
                resposne = node.getPoint().getX() == x && node.getPoint().getY() == y ? node : null;
                break;

            case POINTER:
                resposne = this.find(this.getQuadrantForPoint(node, x, y), x, y);
                break;

            default:
                throw new QuadTreeException("Invalid nodeType");
        }
        return resposne;
    }

    private boolean insert(Node<T> parent, Point<T> point) {
        Boolean result = false;
        switch (parent.getNodeType()) {
            case EMPTY:
                this.setPointForNode(parent, point);
                result = true;
                break;
            case LEAF:
                if (parent.getPoint().getX() == point.getX() && parent.getPoint().getY() == point.getY()) {
                    this.setPointForNode(parent, point);
                    result = false;
                } else {
                    this.split(parent);
                    result = this.insert(parent, point);
                }
                break;
            case POINTER:
                result = this.insert(
                        this.getQuadrantForPoint(parent, point.getX(), point.getY()), point);
                break;

            default:
                throw new QuadTreeException("Invalid nodeType in parent");
        }
        return result;
    }

    private void split(Node<T> node) {
        Point<T> oldPoint = node.getPoint();
        node.setPoint(null);

        node.setNodeType(NodeType.POINTER);

        double x = node.getX();
        double y = node.getY();
        double hw = node.getW() / 2;
        double hh = node.getH() / 2;

        node.setNw(new Node<T>(x, y, hw, hh, node));
        node.setNe(new Node<T>(x + hw, y, hw, hh, node));
        node.setSw(new Node<T>(x, y + hh, hw, hh, node));
        node.setSe(new Node<T>(x + hw, y + hh, hw, hh, node));

        this.insert(node, oldPoint);
    }

    private void balance(Node<T> node) {
        switch (node.getNodeType()) {
            case EMPTY:
            case LEAF:
                if (node.getParent() != null) {
                    this.balance(node.getParent());
                }
                break;

            case POINTER: {
                Node<T> nw = node.getNw();
                Node<T> ne = node.getNe();
                Node<T> sw = node.getSw();
                Node<T> se = node.getSe();
                Node<T> firstLeaf = null;

                if (nw.getNodeType() != NodeType.EMPTY) {
                    firstLeaf = nw;
                }
                if (ne.getNodeType() != NodeType.EMPTY) {
                    if (firstLeaf != null) {
                        break;
                    }
                    firstLeaf = ne;
                }
                if (sw.getNodeType() != NodeType.EMPTY) {
                    if (firstLeaf != null) {
                        break;
                    }
                    firstLeaf = sw;
                }
                if (se.getNodeType() != NodeType.EMPTY) {
                    if (firstLeaf != null) {
                        break;
                    }
                    firstLeaf = se;
                }

                if (firstLeaf == null) {
                    node.setNodeType(NodeType.EMPTY);
                    node.setNw(null);
                    node.setNe(null);
                    node.setSw(null);
                    node.setSe(null);

                } else if (firstLeaf.getNodeType() == NodeType.POINTER) {
                    break;

                } else {
                    node.setNodeType(NodeType.LEAF);
                    node.setNw(null);
                    node.setNe(null);
                    node.setSw(null);
                    node.setSe(null);
                    node.setPoint(firstLeaf.getPoint());
                }

                if (node.getParent() != null) {
                    this.balance(node.getParent());
                }
            }
            break;
        }
    }

    private Node<T> getQuadrantForPoint(Node<T> parent, double x, double y) {
        double mx = parent.getX() + parent.getW() / 2;
        double my = parent.getY() + parent.getH() / 2;
        if (x < mx) {
            return y < my ? parent.getNw() : parent.getSw();
        } else {
            return y < my ? parent.getNe() : parent.getSe();
        }
    }

    private void setPointForNode(Node<T> node, Point<T> point) {
        if (node.getNodeType() == NodeType.POINTER) {
            throw new QuadTreeException("Can not set point for node of type POINTER");
        }
        node.setNodeType(NodeType.LEAF);
        node.setPoint(point);
    }
}
