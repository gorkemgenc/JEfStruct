package jEfModify;

import jEfEnums.JEfDirection;
import jEfExceptions.JEfArrayNullException;

public class JEfArray<T> {

    /***
     * This function rotates generic type array with given rotateCount. You can rotate array to right or left with given a rotatecount.
     * If array is null, function throws a JEfArrayNullException;
     * If array length is zero or rotateCount equals to array length function does nothing.
     * @param array
     * @param JEfDirection
     * @param rotateCount
     * @param <T>
     * @throws JEfArrayNullException
     */
    public static <T> void rotate(T[] array, JEfDirection JEfDirection, int rotateCount) throws JEfArrayNullException {

        if(array == null ) throw new JEfArrayNullException();

        int length = array.length;
        if(checkBaseControls(rotateCount, length)) return;

        int count = rotateCount % length;
        int directionCount = getCountRelatedDirection(JEfDirection, count, length);
        rotationInner(array, directionCount, length);
    }

    private static <T> boolean checkBaseControls(int rotateCount, int length){

        if(length == 0) return true;

        int count = rotateCount % length;
        if(count == 0) return true;
        return false;
    }

    private static int getCountRelatedDirection(JEfDirection JEfDirection, int count, int length){

        int localCount = count;
        if(JEfDirection == JEfDirection.RIGHT){
            localCount = length - count;
        }
        return localCount;
    }

    private static <T> void rotationInner(T[] array, int directionCount, int length){

        rotateArrayInner(array, 0, directionCount-1);
        rotateArrayInner(array, directionCount, length-1);
        rotateArrayInner(array, 0, length-1);
    }

    private static <T> void rotateArrayInner(T[] array, int start, int end){

        while(start < end){
            T temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
