package rotation;

import enums.Direction;
import exceptions.MatrixNullException;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class MatrixRotationTest extends TestCase {

    @Test(expected = MatrixNullException.class)
    public void testMatrixNullException(){
        try {
            MatrixRotation.transpose(null);
            fail( "Matrix is null" );
        }
        catch (MatrixNullException expectedException) {
        }
    }

    @Test
    public void testRotateMatrixLeft() {
        int[][] matrix = new int[][]{{1,2,3},
                {4,5,6},
                {7,8,9}};

        int[][] rotateLeftMatrix = new int[][]{{3,6,9},
                {2,5,8},
                {1,4,7}};

        MatrixRotation.rotateMatrix(matrix, Direction.LEFT);
        Assert.assertTrue(matrix.equals(rotateLeftMatrix));
    }

    @Test
    public void testRotateMatrixLeftByOne() {
        int[][] matrix = new int[][]{{1}};

        int[][] rotateLeftMatrix = new int[][]{{1}};

        MatrixRotation.rotateMatrix(matrix, Direction.LEFT);
        Assert.assertTrue(matrix.equals(rotateLeftMatrix));
    }

    @Test
    public void testRotateMatrixLeftWithDifferentSize() {
        int[][] matrix = new int[][]{{1,2,3,4},
                {4,5,6,7},
                {7,8,9,8}};

        int[][] rotateLeftMatrix = new int[][]{{4,7,8},
                {3,6,9},
                {2,5,8},
                {1,4,7}};

        MatrixRotation.rotateMatrix(matrix, Direction.LEFT);
        Assert.assertTrue(matrix.equals(rotateLeftMatrix));
    }

    @Test
    public void testRotateMatrixRight() {
        String[][] matrix = new String[][]{{"1","2","3"},
                {"4","5","6"},
                {"7","8","9"}};

        String[][] rotateRightMatrix = new String[][]{{"7","4","1"},
                {"8","5","2"},
                {"9","6","3"}};

        MatrixRotation.rotateMatrix(matrix, Direction.LEFT);
        Assert.assertTrue(matrix.equals(rotateRightMatrix));
    }

    @Test
    public void testTranspose(){
        int[][] matrix = new int[][]{{1,2,3},
                {4,5,6}};

        int[][] transposeMatrix = new int[][]{{1,4},{2,5},{3,6}};

        MatrixRotation.transpose(matrix);
        Assert.assertTrue(matrix.equals(transposeMatrix));
    }
}