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
        Integer[][] matrix = new Integer[][]{{1,2,3},
                {4,5,6},
                {7,8,9}};

        Object[][] rotateLeftMatrix = new Integer[][]{{3,6,9},
                {2,5,8},
                {1,4,7}};

        Object[][] result = MatrixRotation.rotateMatrix(matrix, Direction.LEFT);
        for(int i=0; i<rotateLeftMatrix.length; i++){
            for(int j=0; j<rotateLeftMatrix[i].length; j++){
                Assert.assertEquals(result[i][j], rotateLeftMatrix[i][j]);
            }
        }
    }

    @Test
    public void testRotateMatrixLeftByOne() {
        Integer[][] matrix = new Integer[][]{{1}};

        Integer[][] rotateLeftMatrix = new Integer[][]{{1}};

        Object[][] result = MatrixRotation.rotateMatrix(matrix, Direction.LEFT);
        for(int i=0; i<rotateLeftMatrix.length; i++){
            for(int j=0; j<rotateLeftMatrix[i].length; j++){
                Assert.assertEquals(result[i][j], rotateLeftMatrix[i][j]);
            }
        }
    }

    @Test
    public void testRotateMatrixLeftWithDifferentSize() {
        Integer[][] matrix = new Integer[][]{{1,2,3,4},
                {4,5,6,7},
                {7,8,9,8}};

        Integer[][] rotateLeftMatrix = new Integer[][]{{4,7,8},
                {3,6,9},
                {2,5,8},
                {1,4,7}};

        Object[][] result = MatrixRotation.rotateMatrix(matrix, Direction.LEFT);
        for(int i=0; i<rotateLeftMatrix.length; i++){
            for(int j=0; j<rotateLeftMatrix[i].length; j++){
                Assert.assertEquals(result[i][j], rotateLeftMatrix[i][j]);
            }
        }
    }

    @Test
    public void testRotateMatrixRight() {
        String[][] matrix = new String[][]{{"1","2","3"},
                {"4","5","6"},
                {"7","8","9"}};

        String[][] rotateRightMatrix = new String[][]{{"7","4","1"},
                {"8","5","2"},
                {"9","6","3"}};

        Object[][] result = MatrixRotation.rotateMatrix(matrix, Direction.RIGHT);
        for(int i=0; i<rotateRightMatrix.length; i++){
            for(int j=0; j<rotateRightMatrix[i].length; j++){
                Assert.assertEquals(result[i][j], rotateRightMatrix[i][j]);
            }
        }
    }

    @Test
    public void testTranspose(){
        Integer[][] matrix = new Integer[][]{{1,2,3},
                {4,5,6}};

        Integer[][] transposeMatrix = new Integer[][]{{1,4},{2,5},{3,6}};

        Object[][] result = MatrixRotation.transpose(matrix);
        for(int i=0; i<transposeMatrix.length; i++){
            for(int j=0; j<transposeMatrix[i].length; j++){
                Assert.assertEquals(result[i][j], transposeMatrix[i][j]);
            }
        }
    }
}