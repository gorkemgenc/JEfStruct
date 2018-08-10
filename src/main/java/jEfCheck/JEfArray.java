package jEfCheck;


import jEfExceptions.JEfArrayNullException;
import jEfExceptions.JEfListNullException;
import jEfHelper.JEfWrapper;

import java.util.*;

public class JEfArray<T> {

    /***
     * This function determines whether array (Type T) is unique or not. If it is unique, it returns true otherwise it returns false.
     * If array is null, function throw an JEfArrayLengthNotEqualException exceptions which extends from RuntimeException
     * If array size is zero, then function returns true
     * Type T is a generic type, you can give any type for input
     * @param array
     * @param <T>
     * @return boolean
     */
    public static <T> boolean unique(T[] array) throws JEfArrayNullException {

        if(array == null) throw  new JEfArrayNullException();
        else if(array.length == 0) return true;

        if(JEfWrapper.isWrapperType(array[0].getClass())){
            return getUniqueForPrimitiveType(array);
        }

        return getUniqueForObjectType(array);
    }

    /***
     * Given a List of object arrays with generic Type T, this function determines whether these arrays are totally same or not
     * If same it returns true, otherwise it returns false
     * If list is null it throws JEfListNullException exceptions which extends from RuntimeException
     * If list size is zero then return true
     * @param list
     * @param <T>
     * @return boolean
     */
    public static <T> boolean same(List<T[]> list) throws JEfListNullException {

        if(list == null) throw  new JEfListNullException();
        else if(list.size() == 0) return true;

        Hashtable<T, Integer> table = createHashTable(list);

        for(int i=1; i<list.size(); i++){
            if(!checkListForUniqueness(list.get(i),table)) return false;
        }
        return true;

    }

    /***
     * This function serves all permutation of array elements in list.
     * If array is null then it throws JEfArrayNullException and if array length is zero then function returns null
     * @param array
     * @param <T>
     * @return List<List<T>>
     */
    public static <T> List<List<T>> permute(T[] array) throws JEfArrayNullException {

        if(array == null) throw new JEfArrayNullException();
        else if(array.length == 0)  return null;

        List<List<T>> result = new ArrayList<>();
        permuteHelper(array, 0, result);

        return result;
    }

    private static <T> boolean getUniqueForPrimitiveType(T[] array){

        HashSet<T> set = new HashSet<>();

        for(T temp : array){
            if(set.contains(temp)) return false;
            set.add(temp);
        }
        return true;
    }

    private static <T> boolean getUniqueForObjectType(T[] array){

        for(int i=0; i<array.length; i++){
            for(int j=i+1; j<array.length; j++){
                if(JEfType.isSameByValue(array[i], array[j])) return false;
            }
        }
        return true;
    }

    private static <T> Hashtable<T, Integer> createHashTable(List<T[]> list){

        Hashtable<T, Integer> table = new Hashtable<>();

        for(T temp : list.get(0)){
            if(table.containsKey(temp)){
                table.put(temp, table.get(temp) + 1);
            }
            else{
                table.put(temp, 1);
            }
        }
        return table;
    }

    private static <T> boolean checkListForUniqueness(T[] array, Hashtable<T, Integer> hashTable){

        Hashtable<T, Integer> tempTable = new Hashtable<>();
        tempTable.putAll(hashTable);

        for(T element : array){
            if(!tempTable.containsKey(element)){
                return false;
            }
            tempTable.put(element, tempTable.get(element) - 1);
        }
        for(Integer temp : tempTable.values()){
            if(temp!= 0) return  false;
        }
        return true;
    }

    private static <T> void changeResultWithIndexCheck(T[] array, List<List<T>> result){
        List<T> temp = new ArrayList<>();
        for(int i = 0; i < array.length - 1; i++){
            temp.add(array[i]);
        }
        if(array.length > 0)
            temp.add(array[array.length-1]);

        result.add(temp);
    }

    private static <T> void permuteHelper(T[] array, int index, List<List<T>> result){

        if(index >= array.length - 1){
            changeResultWithIndexCheck(array,result);
            return;
        }

        for(int i = index; i < array.length; i++){

            T t = array[index];
            array[index] = array[i];
            array[i] = t;

            permuteHelper(array, index+1, result);

            t = array[index];
            array[index] = array[i];
            array[i] = t;
        }
    }
}
