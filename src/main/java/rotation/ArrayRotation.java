package rotation;

import enums.Direction;
import exceptions.ArrayNullException;

public class ArrayRotation<T> {

    public static <T> void rotate(T[] array, Direction direction, int rotateCount) throws ArrayNullException{

        if(array == null ) throw new ArrayNullException("Array is null");
        int length = array.length;

        if(length == 0) return;
        int count = rotateCount % length;
        if(count == 0) return;

        int directionCount = getCountRelatedDirection(direction, count, length);

        rotationInner(array, directionCount, length);
    }

    private static int getCountRelatedDirection(Direction direction, int count, int length){
        int localCount = count;
        if(direction == Direction.RIGHT){
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
