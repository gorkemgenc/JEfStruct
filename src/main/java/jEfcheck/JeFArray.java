package jEfcheck;

import exceptions.ArrayNullException;

import java.util.*;

public class JeFArray<T> {

    public static <T> boolean hasUniqueElement(T[] array){

        if(array == null) throw  new ArrayNullException("Array is null");
        else if(array.length == 0) return true;

        HashSet<T> set = new HashSet<>();

        for(T temp : array){
            if(set.contains(temp)) return false;
            set.add(temp);
        }
        return true;
    }

    public static <T> boolean isArraysSame(List<T[]> list){

        if(list == null) throw  new exceptions.ListNullException("List is null");
        else if(list.size() == 0) return true;

        Hashtable<T, Integer> table = new Hashtable<>();

        for(T temp : list.get(0)){
            if(table.contains(temp)){
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
                if(!tempTable.contains(element))    return false;
                tempTable.put(element, tempTable.get(element) - 1);
            }
            for(Integer temp : tempTable.values()){
                if(temp!= 0) return  false;
            }
        }
        return true;

    }

    public static <T> List<List<T>> permute(T[] array){

        if(array == null) throw new ArrayNullException("Array is null");

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
}
