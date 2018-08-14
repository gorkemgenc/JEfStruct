package jEfModify;

import jEfEnums.JEfDirection;
import jEfExceptions.JEfMatrixNullException;
import java.util.Arrays;

public class JEfMatrixRotation<T> {

    /***
     * This function rotates matrix with given direction. Function returns matrix to left or right 90 degree.
     * If matrix is null function throw a JEfMatrixNullException
     * @param matrix
     * @param JEfDirection
     * @param <T>
     * @return
     */
    public static <T> T[][] rotateMatrix(T matrix[][], JEfDirection JEfDirection) {

            if(matrix == null) throw new JEfMatrixNullException();
            if(JEfDirection == JEfDirection.LEFT) return rotateInnerLeft(matrix);
            return rotateInnerRight(matrix);
    }

    /***
     * This function creates transpose of given generic type of matrix.
     * If matrix is null, function throw a JEfMatrixNullException. You can give different rows and columns count matrix.
     * @param matrix
     * @param <T>
     * @return
     */
    public static <T> T[][] transpose(T[][] matrix){

        if(matrix == null) throw new JEfMatrixNullException();

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
