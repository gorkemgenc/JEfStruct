package jEfCheck;

import jEfExceptions.JEfListNullException;
import jEfHelper.JEfWrapper;
import java.util.*;

public class JEfList {

    /***
     * This function defines whether List (Type T) is unique or not based on its elements. If list is null, function throws ListNullExceptionError
     * If list size equals to then function returns true
     * Type T is a generic type, you can give any type for input
     * @param list
     * @param <T>
     * @return boolean
     * @throws JEfListNullException
     */
    public static <T> boolean unique(List<T> list) throws JEfListNullException {

        if(list == null) throw  new JEfListNullException();
        else if(list.size() == 0) return true;

        if(JEfWrapper.isWrapperType(list.get(0).getClass())) {
            return getUniqueForPrimitiveType(list);
        }
        return getUniqueForObjectType(list);
    }



    /***
     * This function looks whole elements of list to determine whether each of them equals or not. If each of list element (Generic type T) is same, function returns true
     * Otherwise function returns false
     * If List is null then function throws JEfListNullException
     * If List size is zero then function returns true
     * @param list
     * @param <T>
     * @return boolean
     * @throws JEfListNullException
     */
    public static <T> boolean same(List<List<T>> list) throws JEfListNullException {

        if(list == null) throw  new JEfListNullException();
        else if(list.size() == 0) return true;

        Hashtable<T, Integer> table = createHashTable(list);

        for(int i=1; i<list.size(); i++){
            if(!checkListForUniqueness(list.get(i),table)) return false;
        }

        return true;
    }

    /***
     * This function serves all permutation of List elements in list.
     * If array is null then it throws JEfArrayLengthNotEqualException and if array length is zero then function returns null
     * @param list
     * @param <T>
     * @return List<List<T>>
     */
    public static <T> List<List<T>> permute(List<T> list) throws JEfListNullException {

        if(list == null) throw new JEfListNullException();
        else if(list.size() == 0) return null;

        List<List<T>> result = new ArrayList<>();
        permuteHelper(list, 0, result);
        return result;
    }

    private static <T> boolean getUniqueForPrimitiveType(List<T> list){

        HashSet<T> set = new HashSet<>();

        for(T temp : list){
            if(set.contains(temp)) return false;
            set.add(temp);
        }
        return true;
    }

    private static <T> boolean getUniqueForObjectType(List<T> list){

        int size = list.size();

        for(int i=0; i<size; i++){
            for(int j=i+1; j<size; j++){
                if(JEfType.isSameByValue(list.get(i), list.get(j))) return false;
            }
        }
        return true;
    }

    private static <T> Hashtable<T, Integer> createHashTable(List<List<T>> list){

        Hashtable<T, Integer> table = new Hashtable<>();

        for(T temp : list.get(0))
            if (table.containsKey(temp)) {
                table.put(temp, table.get(temp) + 1);
            } else {
                table.put(temp, 1);
            }
        return table;
    }

    private static <T> boolean checkListForUniqueness(List<T> list, Hashtable<T, Integer> hashTable){

        Hashtable<T, Integer> tempTable = new Hashtable<>();
        tempTable.putAll(hashTable);

        for(T element : list){
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

    private static <T> void changeResultWithIndexCheck(List<T> list, List<List<T>> result){

        int size = list.size();
        List<T> temp = new ArrayList<>();

        for(int i = 0; i < size - 1; i++){
            temp.add(list.get(i));
        }

        if(size > 0)
            temp.add(list.get(size-1));

        result.add(temp);
    }

    private static <T> void permuteHelper(List<T> list, int index, List<List<T>> result){

        if(index >= list.size() - 1){
            changeResultWithIndexCheck(list, result);
            return;
        }

        for(int i = index; i < list.size(); i++){

            T t = list.get(index);
            list.set(index, list.get(i));
            list.set(i,t);

            permuteHelper(list, index+1, result);

            t = list.get(index);
            list.set(index, list.get(i));
            list.set(i, t);
        }
    }
}
