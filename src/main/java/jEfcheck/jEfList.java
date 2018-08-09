package jEfcheck;

import jEfexceptions.ListNullException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

public class jEfList {

    /***
     * This function defines whether List (Type T) is unique or not based on its elements. If list is null, function throws ListNullExceptionError
     * If list size equals to then function returns true
     * Type T is a generic type, you can give any type for input
     * @param list
     * @param <T>
     * @return boolean
     * @throws ListNullException
     */
    public static <T> boolean hasUniqueElement(List<T> list) throws ListNullException{

        if(list == null) throw  new ListNullException("List is null");
        else if(list.size() == 0) return true;

        HashSet<T> set = new HashSet<>();

        for(T temp : list){
            if(set.contains(temp)) return false;
            set.add(temp);
        }
        return true;
    }

    /***
     * This function looks whole elements of list to determine whether each of them equals or not. If each of list element (Generic type T) is same, function returns true
     * Otherwise function returns false
     * If List is null then function throws ListNullException
     * If List size is zero then function returns true
     * @param list
     * @param <T>
     * @return boolean
     * @throws ListNullException
     */
    public static <T> boolean isListsSame(List<List<T>> list) throws ListNullException{

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
     * This function serves all permutation of List elements in list.
     * If array is null then it throws ArrayNullException and if array length is zero then function returns null
     * @param list
     * @param <T>
     * @return List<List<T>>
     */
    public static <T> List<List<T>> permutations(List<T> list){
        List<List<T>> result = new ArrayList<>();
        permuteHelper(list, 0, result);
        return result;
    }

    private static <T> void permuteHelper(List<T> list, int index, List<List<T>> result){

        if(index >= list.size() - 1){
            List<T> temp = new ArrayList<>();
            for(int i = 0; i < list.size() - 1; i++){
                temp.add(list.get(i));
            }
            if(list.size() > 0)
                temp.add(list.get(list.size()-1));
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
