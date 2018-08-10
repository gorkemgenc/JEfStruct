package jEfTransform;

import jEfExceptions.*;
import java.util.*;

public class JEfMin<T extends Number, K extends Number> {

    private static boolean comparison(Number a, Number b)
    {
        return a.doubleValue() - b.doubleValue() < 0;
    }

    /***
     * This function returns the minimum element of generic type of list. Generic type extends from Number class.
     * If list is null or list size is zero, function throws a JEfListNullException exception
     * @param list
     * @param <T>
     * @return
     * @throws JEfListNullException
     */
    public static <T> T minList(List<T> list) throws JEfListNullException {

        if(list == null || list.size() == 0) throw new JEfListNullException();
        T min = list.get(0);

        for (int i=1; i<list.size(); i++){
            if(comparison((Number)list.get(i),(Number)min)){
                min = list.get(i);
            }
        }
        return min;
    }

    /***
     * This function returns the minimum element of generic type of array. Generic type extends from Number class.
     * If array is null or array length is zero, function throws a JEfArrayNullException exception
     * @param array
     * @param <T>
     * @return
     * @throws JEfArrayNullException
     */
    public static <T> T minArray(T[] array) throws JEfArrayNullException{

        if(array == null || array.length == 0) throw new JEfArrayNullException();
        T min = array[0];

        for (int i=1; i<array.length; i++){
            if(comparison((Number)array[i],(Number)min)){
                min = array[i];
            }
        }
        return min;
    }

    /***
     * This function returns the minimum element of generic type of Java Queue. Generic type extends from Number class.
     * If Queue is empty or Queue size is zero, function throws a JEfQueueEmptyException exception
     * @param queue
     * @param <T>
     * @return
     */
    public static <T> T minQueue(Queue<T> queue) throws JEfQueueEmptyException{

        if ( queue == null || queue.size() == 0 ) throw new JEfQueueEmptyException();

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

    /***
     * This function returns the minimum element of generic type of Java hashset. Generic type extends from Number class.
     * If set is empty or set size is zero, function throws a JEfSetIsNullException exception
     * @param set
     * @param <T>
     * @return
     */
    public static <T> T minHashSet(HashSet<T> set) throws JEfSetIsNullException{

        if ( set == null || set.size() == 0 ) throw new JEfSetIsNullException();

        Set<T> tempSet = set;

        T min = tempSet.iterator().next();

        for(T key : tempSet) {
            if (comparison((Number)key, (Number)min)) {
                min = key;
            }
        }
        return min;
    }

    /***
     * This function returns the minimum element of generic type of Java HashMap according to values. Generic type extends from Number class.
     * If map is empty or map size is zero, function throws a JEfMapIsNullException exception
     * @param map
     * @param <K>
     * @param <T>
     * @return
     */
    public static <K,T> T minHashMapByValue(HashMap<K,T> map)  throws JEfMapIsNullException {

        if( map.size() == 0 ) throw new JEfMapIsNullException();

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

    /***
     * This function returns the minimum element of generic type of Java HashMap according to Keys. Generic type extends from Number class.
     * If map is empty or map size is zero, function throws a JEfMapIsNullException exception
     * @param map
     * @param <K>
     * @param <T>
     * @return
     */
    public static <K,T> K minHashMapByKey(HashMap<K,T> map) throws JEfMapIsNullException{

        if( map.size() == 0 ) throw new JEfMapIsNullException();

        K min = map.keySet().stream().findFirst().get();

        for (Map.Entry<K,T> entry : map.entrySet()) {
            K key = entry.getKey();
            if (comparison((Number)key, (Number)min)) {
                min = key;
            }
        }
        return min;
    }

    /***
     * This function returns the minimum element of generic type of Java HashTable according to Values. Generic type extends from Number class.
     * If HashTable is empty or map size is zero, function throws a JEfHashTableIsNullException exception
     * @param hashTable
     * @param <K>
     * @param <T>
     * @return
     */
    public static <K, T> T minHashTableByValue(Hashtable<K, T> hashTable) throws JEfHashTableIsNullException{

        if( hashTable.size() == 0 ) throw new JEfHashTableIsNullException();

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

    /***
     * This function returns the minimum element of generic type of Java HashTable according to Keys. Generic type extends from Number class.
     * If HashTable is empty or map size is zero, function throws a JEfHashTableIsNullException exception
     * @param hashTable
     * @param <K>
     * @param <T>
     * @return
     */
    public static <K, T> K minHashTableByKey(Hashtable<K, T> hashTable) throws JEfHashTableIsNullException{

        if( hashTable.size() == 0 ) throw new JEfHashTableIsNullException();

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
