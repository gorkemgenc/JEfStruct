package rotation;

import Enums.Direction;
import exceptions.ArrayNullException;
import exceptions.ListNullException;

import java.util.List;

public class ListRotation<T> {
    public static <T> void rotate(List<T> list, Direction direction, int rotateCount) throws ListNullException {

        if(list == null ) throw new ArrayNullException("Array is null");
        int length = list.size();

        if(length == 0) return;
        int count = rotateCount % length;
        if(count == 0) return;

        int directionCount = getCountRelatedDirection(direction, count, length);

        rotationInner(list, directionCount, length);
    }

    private static int getCountRelatedDirection(Direction direction, int count, int length){
        int localCount = count;
        if(direction == Direction.RIGHT){
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
