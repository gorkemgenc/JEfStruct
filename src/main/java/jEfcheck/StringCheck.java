package jEfcheck;

import java.util.HashSet;

public class StringCheck {
    private static boolean isUnique(String str){
        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i<str.length(); i++){
            if(set.contains(str.charAt(i))) return false;
            set.add(str.charAt(i));
        }
        return true;
    }
}
