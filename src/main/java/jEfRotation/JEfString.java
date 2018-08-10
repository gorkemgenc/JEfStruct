package jEfRotation;

import jEfEnums.JEfDirection;
import jEfExceptions.JEfStringNullException;

public class JEfString {

    /***
     * This function rotates given string with given rotateCount. You can rotate string to right or left with given a rotatecount.
     * If string is null, function throws a JEfStringNullException;
     * If string length is zero or rotateCount equals to list size function does nothing.
     * @param str
     * @param JEfDirection
     * @param rotateCount
     * @return
     * @throws JEfStringNullException
     */
    public static String rotate(String str, JEfDirection JEfDirection, int rotateCount) throws JEfStringNullException {

        if(str == null ) throw new JEfStringNullException();
        int length = str.length();
        if(checkBaseControls(rotateCount, length)) return str;

        int count = rotateCount % length;
        int directionCount = getCountRelatedDirection(JEfDirection, count, length);
        return rotationInner(str.toCharArray(), directionCount, length);
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
