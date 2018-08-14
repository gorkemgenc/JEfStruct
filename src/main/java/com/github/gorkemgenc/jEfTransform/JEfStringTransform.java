package com.github.gorkemgenc.jEfTransform;

import java.util.HashSet;

public class JEfStringTransform {

    /***
     * This function return String with creating unique element string from given string.
     * If string is null, function returns null. If you give ignoreCharacter function does not control this character
     * If you give null value to ignore character, function does not trace any character
     * @param str
     * @return
     */
    public static String deduplication(String str, Character ignoreCharacter){

        if(str == null) return null;

        int length = str.length();
        HashSet<Character> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        for(int i=0; i<length; i++){
            Character c = str.charAt(i);
            if(ignoreCharacter != null && c.equals(ignoreCharacter)){
                builder.append(c);
            }
            else if(!set.contains(c)){
                builder.append(c);
                set.add(c);
            }
        }
        return builder.toString();
    }
}
