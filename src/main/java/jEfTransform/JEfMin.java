package jEfTransform;

import jEfExceptions.JEfArrayNullException;
import jEfExceptions.JEfListNullException;
import jEfExceptions.jEfQueueEmptyException;
import jEfExceptions.jEfSetIsNullException;

import java.util.*;

public class JEfMin<T extends Number, K extends Number> {

    private static boolean comparison(Number a, Number b)
    {
        return a.doubleValue() - b.doubleValue() < 0;
    }

    public static <T> T minList(List<T> list) throws JEfListNullException {

        if(list == null || list.size() == 0) throw new JEfListNullException("List is null");
        T min = list.get(0);

        for (int i=1; i<list.size(); i++){
            if(comparison((Number)list.get(i),(Number)min)){
                min = list.get(i);
            }
        }
        return min;
    }

    public static <T> T minArray(T[] array) throws JEfArrayNullException{

        if(array == null || array.length == 0) throw new JEfArrayNullException("Array is null");
        T min = array[0];

        for (int i=1; i<array.length; i++){
            if(comparison((Number)array[i],(Number)min)){
                min = array[i];
            }
        }
        return min;
    }

    public static <T> T minQueue(Queue<T> queue){

        if ( queue == null || queue.size() == 0 ) throw new jEfQueueEmptyException("Queue is empty");

        Queue<T> tempQueue = queue;

        T min = tempQueue.peek();

        while(!tempQueue.isEmpty()) {
            T variable = tempQueue.poll();
            if (comparison((Number)variable, (Number)min)) {
                min = variable;
            }
        }
        return min;
    }

    public static <T> T minHashSet(HashSet<T> set){

        if ( set == null || set.size() == 0 ) throw new jEfSetIsNullException("Set is empty");

        Set<T> tempSet = set;

        T min = tempSet.iterator().next();

        for(T key : tempSet) {
            if (comparison((Number)key, (Number)min)) {
                min = key;
            }
        }
        return min;
    }

    public static <K,T> T minHashMapByValue(HashMap<K,T> map){

        if( map.size() == 0 ) throw new jEfSetIsNullException("Set is empty");

        Map.Entry<K,T> entry = map.entrySet().iterator().next();

        T min = entry.getValue();

        for (Map.Entry<K,T> tempEntry : map.entrySet()) {
            T value = tempEntry.getValue();
            if (comparison((Number)value, (Number)min)) {
                min = value;
            }
        }
        return min;
    }

    public static <K,T> K minHashMapByKey(HashMap<K,T> map){

        if( map.size() == 0 ) throw new jEfSetIsNullException("Set is empty");

        K min = map.keySet().stream().findFirst().get();

        for (Map.Entry<K,T> entry : map.entrySet()) {
            K key = entry.getKey();
            if (comparison((Number)key, (Number)min)) {
                min = key;
            }
        }
        return min;
    }

    public static <K, T> T minHashTableByValue(Hashtable<K, T> hashTable){

        if( hashTable.size() == 0 ) throw new jEfSetIsNullException("Set is empty");

        Map.Entry<K,T> entry = hashTable.entrySet().iterator().next();

        T min = entry.getValue();

        for (Map.Entry<K,T> tempEntry : hashTable.entrySet()) {
            T value = tempEntry.getValue();
            if (comparison((Number)value, (Number)min)) {
                min = value;
            }
        }
        return min;
    }

    public static <K, T> K minHashTableByKey(Hashtable<K, T> hashTable){

        if( hashTable.size() == 0 ) throw new jEfSetIsNullException("Set is empty");

        K min = hashTable.keySet().stream().findFirst().get();

        for (Map.Entry<K,T> entry : hashTable.entrySet()) {
            K key = entry.getKey();
            if (comparison((Number)key, (Number)min)) {
                min = key;
            }
        }
        return min;
    }
}
