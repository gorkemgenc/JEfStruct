package jEfTransform;

import jEfExceptions.JEfArrayNullException;
import jEfExceptions.JEfListNullException;

import java.util.*;

public class JEfMax<T extends Number, K extends Number> {

    private static boolean comparison(Number a, Number b)
    {
        return a.doubleValue() - b.doubleValue() < 0;
    }

    public static <T> T maxList(List<T> list) throws JEfListNullException{

        if(list == null || list.size() == 0) throw new JEfListNullException("List is null");
        T min = list.get(0);

        for (int i=1; i<list.size(); i++){
            if(comparison((Number)list.get(i),(Number)min)){
                min = list.get(i);
            }
        }
        return min;
    }

    public static <T> T maxArray(T[] array) throws JEfArrayNullException{

        if(array == null || array.length == 0) throw new JEfArrayNullException("Array is null");
        T min = array[0];

        for (int i=1; i<array.length; i++){
            if(comparison((Number)array[i],(Number)min)){
                min = array[i];
            }
        }
        return min;
    }

    public static <T> T maxQueue(Queue<T> queue){
        return null;
    }

    public static <T> T maxHashSet(HashSet<T> set){
        return null;
    }

    public static <T, K> T maxHashMapByValue(HashMap<K,T> map){
        return null;
    }

    public static <T, K> K maxHashMapByKey(HashMap<K,T> map){
        return null;
    }

    public static <T, K> T maxHashTableByValue(Hashtable<T, K> hashTable){
        return null;
    }

    public static <T, K> K maxHashTableByKey(Hashtable<T, K> hashTable){
        return null;
    }
}
