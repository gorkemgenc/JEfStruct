package jEfcheck;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class jEfList {

    public static <T> boolean isUnique(List<T> list){

        HashSet<T> set = new HashSet<>();

        for(T temp : list){
            if(set.contains(temp)) return false;
            set.add(temp);
        }
        return true;
    }

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
