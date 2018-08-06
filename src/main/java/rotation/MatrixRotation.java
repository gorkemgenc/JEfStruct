package rotation;

import enums.Direction;
import exceptions.MatrixNullException;

public class MatrixRotation<T> {

    public static <T> void rotateMatrix(T matrix[][], Direction direction) {
            if(matrix == null) throw new MatrixNullException("Matrix is null");
            if(direction == Direction.LEFT) rotateInnerLeft(matrix);
            rotateInnerRight(matrix);
    }

    public static <T> void transpose(T[][] matrix){

        if(matrix == null) throw new MatrixNullException("Matrix is null");

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                T temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private static <T> void rotateInnerLeft(T[][] matrix){

        transpose(matrix);

        for (int  j = 0; j < matrix[0].length/2; j++) {
            for (int i = 0; i < matrix.length; i++) {
                T x = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length -1 -j];
                matrix[i][matrix[0].length -1 -j] = x;
            }
        }

    }

    private static <T> void rotateInnerRight(T[][] matrix){

        transpose(matrix);

        for (int  j = 0; j < matrix[0].length/2; j++) {
            for (int i = 0; i < matrix.length; i++) {
                T x = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length -1 -j];
                matrix[i][matrix[0].length -1 -j] = x;
            }
        }
    }
}
