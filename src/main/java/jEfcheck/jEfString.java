package jEfcheck;

import jEfexceptions.StringNullException;

import java.util.HashSet;

public class jEfString {

    /***
     * This function defines whether string has unique elements or not. If elements are unique function returns false
     * Otherwise function return false
     * If string is null function throws an StringNullException exception
     * If string length is zero then function returns true
     * @param str
     * @return
     * @throws StringNullException
     */
    public static boolean isUnique(String str) throws StringNullException{

        if(str == null) throw new StringNullException("String is null");
        else if(str.length() == 0) return true;

        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i<str.length(); i++){
            if(set.contains(str.charAt(i))) return false;
            set.add(str.charAt(i));
        }
        return true;
    }
}
