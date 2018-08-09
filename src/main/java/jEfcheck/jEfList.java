package jEfcheck;

import jEfexceptions.ListNullException;

import java.util.*;

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

        if(isWrapperType(list.get(0).getClass())) {

            HashSet<T> set = new HashSet<>();

            for(T temp : list){
                if(set.contains(temp)) return false;
                set.add(temp);
            }
            return true;
        }
        else{
            for(int i=0; i<list.size(); i++){
                for(int j=i+1; j<list.size(); j++){
                    if(jEfType.isSameByValue(list.get(i), list.get(j))) return false;
                }
            }
            return true;
        }
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
    public static <T> List<List<T>> permute(List<T> list) throws ListNullException{

        if(list == null) throw new ListNullException("List is null");
        if(list.size() == 0) return null;

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
