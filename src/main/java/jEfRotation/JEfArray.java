package jEfRotation;

import jEfEnums.JEfDirection;
import jEfExceptions.JEfArrayNullException;

public class JEfArray<T> {

    public static <T> void rotate(T[] array, JEfDirection JEfDirection, int rotateCount) throws JEfArrayNullException {

        if(array == null ) throw new JEfArrayNullException("Array is null");
        int length = array.length;

        if(length == 0) return;
        int count = rotateCount % length;
        if(count == 0) return;

        int directionCount = getCountRelatedDirection(JEfDirection, count, length);

        rotationInner(array, directionCount, length);
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
