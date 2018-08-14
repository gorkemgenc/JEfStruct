package com.github.gorkemgenc.jEfCheck;

import com.github.gorkemgenc.jEfHelper.JEfWrapper;
import java.lang.reflect.Field;

class JEfType <T, K> {

    private static boolean result = true;

    /***
     * This function determines whether type of first parameter and type of second parameter are same or not. If same, function returns true
     * Otherwise function returns false
     * @param first
     * @param second
     * @param <T>
     * @param <K>
     * @return
     */
    public static <T, K> boolean same(T first, K second){

        return first.getClass().equals(second.getClass());
    }

    /***
     * This function determines whether first parameter is instance of second parameter. If first parameter is instance of second, function returns true
     * Otherwise function returns false
     * @param first
     * @param second
     * @param <T>
     * @param <K>
     * @return
     */
    public static <T, K> boolean inner(T first, K second){

        if(first.getClass().isInstance(second)) return true;
        return false;
    }

    /***
     * This function determines whether first and second parameters have same declared fields or not, If true, function returns true
     * Otherwise function returns false
     * You can use this function for an object which has another object (inner class of other class)
     * @param first
     * @param second
     * @param <T>
     * @return
     */
    public static <T> boolean sameByValue(T first, T second) {

        result = true;

        Field[] fields = first.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (result == false) {
                return false;
            }
            fields[i].setAccessible(true);
            if (JEfWrapper.isWrapperTypeForType(fields[i].getType()) || fields[i].getType().isPrimitive()) {
                try {
                    if(!checkTwoObjectField(fields[i].get(first), fields[i].get(second)))
                    {
                        result = false;
                        return result;
                    }
                } catch (IllegalAccessException e) {
                    result = false;
                    return result;
                }

            } else {
                try {
                    sameByValue(fields[i].get(first), fields[i].get(second));
                } catch (IllegalAccessException e) {
                    result = false;
                    return result;
                }
            }
        }
        return result;
    }

    private static boolean checkTwoObjectField(Object first, Object second){
        return first.equals(second);
    }
}