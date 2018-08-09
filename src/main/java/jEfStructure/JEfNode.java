package jEfStructure;

import jEfEnums.JEfNodeType;

public class JEfNode<T> {

    private double x;
    private double y;
    private double w;
    private double h;
    private JEfNode<T> opt_parent;
    private JEfPoint<T> JEfPoint;
    private JEfNodeType nodetype = JEfNodeType.EMPTY;
    private JEfNode<T> nw;
    private JEfNode<T> ne;
    private JEfNode<T> sw;
    private JEfNode<T> se;

    public JEfNode(double x, double y, double w, double h, JEfNode<T> opt_parent) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.opt_parent = opt_parent;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getW() {
        return w;
    }

    public double getH() {
        return h;
    }

    public JEfNode<T> getParent() {
        return opt_parent;
    }

    public void setJEfPoint(JEfPoint<T> JEfPoint) {
        this.JEfPoint = JEfPoint;
    }

    public JEfPoint<T> getJEfPoint() {
        return this.JEfPoint;
    }

    public void setNodeType(JEfNodeType nodetype) {
        this.nodetype = nodetype;
    }

    public JEfNodeType getNodeType() {
        return this.nodetype;
    }


    public void setNw(JEfNode<T> nw) {
        this.nw = nw;
    }

    public void setNe(JEfNode<T> ne) {
        this.ne = ne;
    }

    public void setSw(JEfNode<T> sw) {
        this.sw = sw;
    }

    public void setSe(JEfNode<T> se) {
        this.se = se;
    }

    public JEfNode<T> getNe() {
        return ne;
    }

    public JEfNode<T> getNw() {
        return nw;
    }

    public JEfNode<T> getSw() {
        return sw;
    }

    public JEfNode<T> getSe() {
        return se;
    }
}
