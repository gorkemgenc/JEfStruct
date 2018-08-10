package jEfTransform;

import jEfExceptions.JEfArrayNullException;
import java.math.BigInteger;
import java.util.Arrays;

public class JEfArrayTransform<T>{

    /***
     * This function transforms String array to BıgInteger array. If array is null function throws JEfArrayNullException exception
     * If array length is zero function returns null
     * If there is an invalid element function throws a RuntimeException exception
     * @param array
     * @param <T>
     * @return
     * @throws JEfArrayNullException
     */
    public static <T> BigInteger[] toBigIntArray(String[] array) throws JEfArrayNullException{

        if(array == null) throw new JEfArrayNullException();
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

    /***
     * This function transforms String array to int array. If array is null function throws JEfArrayNullException exception
     * If array length is zero function returns null
     * If there is an invalid element function throws a RuntimeException exception
     * @param array
     * @param <T>
     * @return
     */
    public static <T> int[] toIntArray(String[] array){

        if(array == null) throw new JEfArrayNullException();
        if(array.length == 0) return null;

        return Arrays.asList(array).stream().mapToInt(Integer::parseInt).toArray();
    }

    /***
     * This function transforms int array to String array. If array is null function throws JEfArrayNullException exception
     * If array length is zero function returns null
     * @param array
     * @param <T>
     * @return
     */
    public static <T> String[] toStringArray(int[] array){
        return Arrays.stream(array).mapToObj(String::valueOf).toArray(String[]::new);
    }
}
