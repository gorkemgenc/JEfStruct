package jEfStructure;

import java.util.Queue;
import java.util.Random;

public class JEfGrid {

    private static int _n;
    private static double _d;
    protected static int rows;
    protected static int columns;
    private static Random random;

    public JEfGrid(int n, double d) {
        _n = n;
        _d = d;
        rows = (int) (Math.ceil(1.0 / d));
        columns = (int) (Math.ceil(1.0 / d));
        random = new Random();
    }

    private static Queue<JEfPoint2D>[][] grid = (Queue<JEfPoint2D>[][]) new Queue[rows+2][columns+2];

    public static void createQueue(){
        for(int k = 0; k < _n; k++) {
            double x = uniform(0.0, 1.0);
            double y = uniform(0.0, 1.0);
            JEfPoint2D p  = new JEfPoint2D(x, y);
            int row = 1 + (int) (x * rows);
            int col = 1 + (int) (y * columns);
            for (int i = row-1; i <= row+1; i++) {
                for (int j = col-1; j <= col+1; j++) {
                    for (JEfPoint2D q : grid[i][j])
                        if (p.distanceTo(q) <= _d)
                            System.out.println(p + " <--> " + q);
                }
            }
            grid[row][col].add(p);
        }
    }


    private static double uniform(double a, double b) {
        if (!(a < b)) {
            throw new IllegalArgumentException("invalid range: [" + a + ", " + b + ")");
        }
        return a + uniform() * (b-a);
    }

    private static double uniform() {
        return random.nextDouble();
    }
}
