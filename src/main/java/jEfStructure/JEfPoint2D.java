package jEfStructure;

import java.util.Comparator;

public class JEfPoint2D implements Comparable<JEfPoint2D> {

    public static final Comparator<JEfPoint2D> X_ORDER = new XOrder();
    public static final Comparator<JEfPoint2D> Y_ORDER = new YOrder();
    public static final Comparator<JEfPoint2D> R_ORDER = new ROrder();

    private final double x;
    private final double y;

    public JEfPoint2D(double x, double y) {
        if (Double.isInfinite(x) || Double.isInfinite(y))
            throw new IllegalArgumentException("Coordinates must be finite");
        if (Double.isNaN(x) || Double.isNaN(y))
            throw new IllegalArgumentException("Coordinates cannot be NaN");
        if (x == 0.0) this.x = 0.0;
        else          this.x = x;

        if (y == 0.0) this.y = 0.0;
        else          this.y = y;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public double distanceTo(JEfPoint2D that) {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    public int compareTo(JEfPoint2D that) {
        if (this.y < that.y) return -1;
        if (this.y > that.y) return +1;
        if (this.x < that.x) return -1;
        if (this.x > that.x) return +1;
        return 0;
    }

    private static class XOrder implements Comparator<JEfPoint2D> {
        public int compare(JEfPoint2D p, JEfPoint2D q) {
            if (p.x < q.x) return -1;
            if (p.x > q.x) return +1;
            return 0;
        }
    }

    private static class YOrder implements Comparator<JEfPoint2D> {
        public int compare(JEfPoint2D p, JEfPoint2D q) {
            if (p.y < q.y) return -1;
            if (p.y > q.y) return +1;
            return 0;
        }
    }

    private static class ROrder implements Comparator<JEfPoint2D> {
        public int compare(JEfPoint2D p, JEfPoint2D q) {
            double delta = (p.x*p.x + p.y*p.y) - (q.x*q.x + q.y*q.y);
            if (delta < 0) return -1;
            if (delta > 0) return +1;
            return 0;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        JEfPoint2D that = (JEfPoint2D) other;
        return this.x == that.x && this.y == that.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public int hashCode() {
        int hashX = ((Double) x).hashCode();
        int hashY = ((Double) y).hashCode();
        return 31*hashX + hashY;
    }
}