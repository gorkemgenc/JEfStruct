package jEfTransform;

import jEfExceptions.JEfListNullException;
import jEfHelper.JEfModifier;
import java.math.BigInteger;
import java.util.List;

public class JEfListTransform<T>{

    /***
     * This function transforms String list to BıgInteger array. If array is null function throws JEfArrayNullException exception
     * If list size is zero function returns null
     * If there is an invalid element function throws a RuntimeException exception
     * @param list
     * @param <T>
     * @return
     * @throws JEfListNullException
     */
    public static <T> BigInteger[] toBigIntList(List<String> list) throws JEfListNullException{

        if(list == null) throw new JEfListNullException();
        if(list.size() == 0) return null;

        int length = list.size();
        BigInteger[] result = new BigInteger[length];

        for(int i=0; i<length; i++){
        try{
            BigInteger bigInteger = new BigInteger(list.get(i));
            result[i] = bigInteger;
        }
        catch (RuntimeException e){
            return null;
        }
    }
        return result;
    }

    /***
     * This function transforms Integer list to int array. If list is null function throws JEfListNullException exception
     * If array length is zero function returns null
     * @param list
     * @return
     */
    public static int[] toIntList(List<Integer> list) throws JEfListNullException{

        if(list == null) throw new JEfListNullException();
        if(list.size() == 0) return null;

        Integer[] result = list.toArray(new Integer[list.size()]);
        return JEfModifier.intArray(result);
    }

    /***
     * This function transforms String list to String array. If list is null function throws JEfListNullException exception
     * If array length is zero function returns null
     * @param list
     * @return
     */
    public static String[] toStringList(List<String> list) throws JEfListNullException{

        if(list == null) throw new JEfListNullException();
        if(list.size() == 0) return null;

        return list.toArray(new String[list.size()]);
    }
}
