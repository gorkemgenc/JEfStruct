package jEfRotation;

import jEfEnums.JEfDirection;
import jEfExceptions.JEfListNullException;

import java.util.List;

public class JEfList<T> {
    public static <T> void rotate(List<T> list, JEfDirection JEfDirection, int rotateCount) throws JEfListNullException {

        if(list == null ) throw new JEfListNullException("Array is null");
        int length = list.size();

        if(length == 0) return;
        int count = rotateCount % length;
        if(count == 0) return;

        int directionCount = getCountRelatedDirection(JEfDirection, count, length);

        rotationInner(list, directionCount, length);
    }

    private static int getCountRelatedDirection(JEfDirection JEfDirection, int count, int length){
        int localCount = count;
        if(JEfDirection == JEfDirection.RIGHT){
            localCount = length - count;
        }
        return localCount;
    }

    private static <T> void rotationInner(List<T> list, int directionCount, int length){
        rotateArrayInner(list, 0, directionCount-1);
        rotateArrayInner(list, directionCount, length-1);
        rotateArrayInner(list, 0, length-1);
    }

    private static <T> void rotateArrayInner(List<T> list, int start, int end){

        while(start < end){
            T temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }
}
