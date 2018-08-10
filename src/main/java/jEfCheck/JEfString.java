package jEfCheck;

import jEfExceptions.JEfStringNullException;

import java.util.HashSet;

public class JEfString {

    /***
     * This function defines whether string has unique elements or not. If elements are unique function returns false
     * Otherwise function return false
     * If string is null function throws an JEfStringNullException exception
     * If string length is zero then function returns true
     * @param str
     * @return
     * @throws JEfStringNullException
     */
    public static boolean unique(String parameter) throws JEfStringNullException {

        if(parameter == null) throw new JEfStringNullException();
        else if(parameter.length() == 0) return true;

        return getUniqueInner(parameter);
    }

    private static boolean getUniqueInner(String parameter){

        HashSet<Character> set = new HashSet<>();

        for(int i=0; i<parameter.length(); i++){
            Character temp = parameter.charAt(i);
            if(set.contains(temp)) return false;
            set.add(temp);
        }
        return true;
    }
}
