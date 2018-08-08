package jEfrotation;

import jEfenums.Direction;
import jEfexceptions.MatrixNullException;

import java.util.Arrays;

public class MatrixRotation<T> {

    public static <T> T[][] rotateMatrix(T matrix[][], Direction direction) {
            if(matrix == null) throw new MatrixNullException("Matrix is null");
            if(direction == Direction.LEFT) return rotateInnerLeft(matrix);
            return rotateInnerRight(matrix);
    }

    public static <T> T[][] transpose(T[][] matrix){

        if(matrix == null) throw new MatrixNullException("Matrix is null");

        int length = matrix.length;
        int columnLength = matrix[0].length;
        T[][] temp = (T[][])new Object[columnLength][length];

        for(int i=0; i< length; i++){
            for(int j=0; j<columnLength; j++){
                temp[j][i] = matrix[i][j];
            }
        }

        Arrays.asList(temp).toArray();

        return temp;
    }

    private static <T> T[][] rotateInnerLeft(T[][] matrix){

        T[][] transpose = transpose(matrix);

        for (int  i = 0; i < transpose.length/2; i++) {
            for (int j = 0; j < transpose[0].length; j++) {
                T x = transpose[i][j];
                transpose[i][j] = transpose[transpose.length -1 -i][j];
                transpose[transpose.length -1 -i][j] = x;
            }
        }

        return transpose;
    }

    private static <T> T[][] rotateInnerRight(T[][] matrix){

        T[][] transpose = transpose(matrix);

        for (int  j = 0; j < transpose.length; j++) {
            for (int i = 0; i < transpose[j].length/2; i++) {
                T x = transpose[j][i];
                transpose[j][i] = transpose[j][transpose[0].length -1 -i];
                transpose[j][transpose[0].length -1 -i] = x;
            }
        }
        return transpose;
    }
}
