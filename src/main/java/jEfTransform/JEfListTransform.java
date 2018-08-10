package jEfTransform;

import jEfExceptions.JEfListNullException;
import jEfHelper.JEfModifier;

import java.math.BigInteger;
import java.util.List;

public class JEfListTransform<T>{

    public static <T> BigInteger[] toBigIntList(List<String> list) throws JEfListNullException{

        if(list == null) throw new JEfListNullException("List is null");
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

    public static int[] toIntList(List<Integer> list){

        if(list == null) throw new JEfListNullException("List is null");
        if(list.size() == 0) return null;

        Integer[] result = list.toArray(new Integer[list.size()]);
        return JEfModifier.intArray(result);
    }

    public static String[] toStringList(List<String> list){

        if(list == null) throw new JEfListNullException("List is null");
        if(list.size() == 0) return null;

        return list.toArray(new String[list.size()]);
    }
}
