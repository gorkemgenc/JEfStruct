package jEfStructure;

public class JEfPoint<T> implements Comparable<JEfPoint<T>> {

    private double x;
    private double y;
    private T opt_value;

    public JEfPoint(double x, double y, T opt_value) {
        this.x = x;
        this.y = y;
        this.opt_value = opt_value;
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

    public T getValue() {
        return opt_value;
    }

    public void setValue(T opt_value) {
        this.opt_value = opt_value;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    @Override
    public int compareTo(JEfPoint<T> JEfPoint) {
        if (this.x < JEfPoint.x) {
            return -1;
        } else if (this.x > JEfPoint.x) {
            return 1;
        } else {
            if (this.y < JEfPoint.y) {
                return -1;
            } else if (this.y > JEfPoint.y) {
                return 1;
            }
            return 0;
        }

    }
}
