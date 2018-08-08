package control;

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

    private static String deduplication(String str){
        if(str == null) return null;

        int length = str.length();
        HashSet<Character> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        for(int i=0; i<str.length(); i++){
            Character c = str.charAt(i);

            if(!set.contains(c)){
                builder.append(c);
                set.add(c);
            }
        }
        return builder.toString();
    }
}
