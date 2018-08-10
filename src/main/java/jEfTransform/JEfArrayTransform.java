package jEfTransform;

import jEfExceptions.JEfArrayNullException;

import java.math.BigInteger;
import java.util.Arrays;

public class JEfArrayTransform<T>{

    public static <T> BigInteger[] toBigIntArray(String[] array) throws JEfArrayNullException{

        if(array == null) throw new JEfArrayNullException("Array is null");
        if(array.length == 0) return null;

        int length = array.length;
        BigInteger[] result = new BigInteger[length];

        for(int i=0; i<length; i++){
            try{
                BigInteger bigInteger = new BigInteger(array[i]);
                result[i] = bigInteger;
            }
            catch (RuntimeException e){
                return null;
            }
        }
        return result;
    }

    public static <T> int[] toIntArray(String[] array){
        return Arrays.asList(array).stream().mapToInt(Integer::parseInt).toArray();
    }

    public static <T> String[] toStringArray(int[] array){
        return Arrays.stream(array).mapToObj(String::valueOf).toArray(String[]::new);
    }
}
