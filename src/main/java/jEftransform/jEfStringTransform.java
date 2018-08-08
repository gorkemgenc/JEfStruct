package jEftransform;

import java.util.HashSet;

public class jEfStringTransform {

    private static String deduplication(String str){
        if(str == null) return null;

        int length = str.length();
        HashSet<Character> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        for(int i=0; i<length; i++){
            Character c = str.charAt(i);

            if(!set.contains(c)){
                builder.append(c);
                set.add(c);
            }
        }
        return builder.toString();
    }
}
