package rotation;

import jEfenums.Direction;
import exceptions.StringNullException;

public class jEfString {
    public static String rotate(String str, Direction direction, int rotateCount) throws StringNullException {

        if(str == null ) throw new StringNullException("String is null");
        int length = str.length();

        if(length == 0) return str;
        int count = rotateCount % length;
        if(count == 0) return str;

        int directionCount = getCountRelatedDirection(direction, count, length);

        return rotationInner(str.toCharArray(), directionCount, length);
    }

    private static int getCountRelatedDirection(Direction direction, int count, int length){
        int localCount = count;
        if(direction == Direction.RIGHT){
            localCount = length - count;
        }
        return localCount;
    }

    private static String rotationInner(char[] str, int directionCount, int length){

        rotateArrayInner(str, 0, directionCount-1);
        rotateArrayInner(str, directionCount, length-1);
        rotateArrayInner(str, 0, length-1);

        return String.valueOf(str);
    }

    private static void rotateArrayInner(char[] array, int start, int end){

        while(start < end){
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
