package jEfcheck;


import jEfexceptions.ArrayNullException;
import jEfexceptions.ListNullException;

import java.util.*;

public class JeFArray<T> {

    /***
     * This function determines whether array (Type T) is unique or not. If it is unique, it returns true otherwise it returns false.
     * If array is null, function throw an ArrayNullException exceptions which extends from RuntimeException
     * If array size is zero, then function returns true
     * Type T is a generic type, you can give any type for input
     * @param array
     * @param <T>
     * @return boolean
     */
    public static <T> boolean hasUniqueElement(T[] array) throws ArrayNullException{

        if(array == null) throw  new ArrayNullException("Array is null");
        else if(array.length == 0) return true;

        if(isWrapperType(array[0].getClass())){
            HashSet<T> set = new HashSet<>();

            for(T temp : array){
                if(set.contains(temp)) return false;
                set.add(temp);
            }
            return true;
        }
        else{
            for(int i=0; i<array.length; i++){
                for(int j=i+1; j<array.length; j++){
                    if(jEfType.isSameByValue(array[i], array[j])) return false;
                }
            }
            return true;
        }

    }

    /***
     * Given a List of object arrays with generic Type T, this function determines whether these arrays are totally same or not
     * If same it returns true, otherwise it returns false
     * If list is null it throws ListNullException exceptions which extends from RuntimeException
     * If list size is zero then return true
     * @param list
     * @param <T>
     * @return boolean
     */
    public static <T> boolean isArraysSame(List<T[]> list) throws ListNullException{

        if(list == null) throw  new ListNullException("List is null");
        if(list.size() == 0) return true;

        Hashtable<T, Integer> table = new Hashtable<>();

        for(T temp : list.get(0)){
            if(table.containsKey(temp)){
                table.put(temp, table.get(temp) + 1);
            }
            else{
                table.put(temp, 1);
            }
        }

        for(int i=1; i<list.size(); i++){
            Hashtable<T, Integer> tempTable = new Hashtable<>();
            tempTable.putAll(table);

            for(T element : list.get(i)){
                if(!tempTable.containsKey(element)){
                    return false;
                }
                tempTable.put(element, tempTable.get(element) - 1);
            }
            for(Integer temp : tempTable.values()){
                if(temp!= 0) return  false;
            }
        }
        return true;

    }

    /***
     * This function serves all permutation of array elements in list.
     * If array is null then it throws ArrayNullException and if array length is zero then function returns null
     * @param array
     * @param <T>
     * @return List<List<T>>
     */
    public static <T> List<List<T>> permute(T[] array) throws ArrayNullException{

        if(array == null) throw new ArrayNullException("Array is null");
        if(array.length == 0)  return null;

        List<List<T>> result = new ArrayList<>();
        permuteHelper(array, 0, result);
        return result;
    }

    private static <T> void permuteHelper(T[] array, int index, List<List<T>> result){

        if(index >= array.length - 1){
            List<T> temp = new ArrayList<>();
            for(int i = 0; i < array.length - 1; i++){
                temp.add(array[i]);
            }
            if(array.length > 0)
                temp.add(array[array.length-1]);

            result.add(temp);
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

    private static final Set<Class<?>> WRAPPER_TYPES = getWrapperTypes();

    private static boolean isWrapperType(Class<?> clazz)
    {
        return WRAPPER_TYPES.contains(clazz);
    }

    private static Set<Class<?>> getWrapperTypes()
    {
        Set<Class<?>> ret = new HashSet<>();
        ret.add(Boolean.class);
        ret.add(Character.class);
        ret.add(Byte.class);
        ret.add(Short.class);
        ret.add(Integer.class);
        ret.add(Long.class);
        ret.add(Float.class);
        ret.add(Double.class);
        ret.add(Void.class);
        ret.add(String.class);
        return ret;
    }
}
