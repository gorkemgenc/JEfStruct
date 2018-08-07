package control;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ArrayCheck<T> {

    public static <T> boolean isUnique(T[] array){

        HashSet<T> set = new HashSet<>();

        for(T temp : array){
            if(set.contains(temp)) return false;
            set.add(temp);
        }
        return true;
    }

    public static <T> List<List<T>> permutations(T[] array){
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
