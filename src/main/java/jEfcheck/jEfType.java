package jEfCheck;

import jEfHelper.JEfWrapper;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JEfType<T, K> {

    private static boolean result = true;

    /***
     *
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
     *
     * @param firstObject
     * @param secondObject
     * @param <T>
     * @param <K>
     * @return
     */
    public static <T, K> boolean isInner(T firstObject, K secondObject){
        if(firstObject.getClass().isInstance(secondObject)) return true;
        return false;
    }

    /***
     *
     * @param object1
     * @param object2
     * @param <T>
     * @return
     */
    public static <T> boolean sameByValue(T object1, T object2) {

        result = true;

        Field[] fields = object1.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (result == false) {
                return false;
            }
            fields[i].setAccessible(true);
            if (JEfWrapper.isWrapperTypeForType(fields[i].getType()) || fields[i].getType().isPrimitive()) {
                try {
                    Object temp1 = fields[i].get(object1);
                    Object temp2 = fields[i].get(object2);
                    if (!temp1.equals(temp2)) {
                        result = false;
                        return result;
                    }
                } catch (IllegalAccessException e) {
                    result = false;
                    return result;
                }

            } else {
                try {
                    sameByValue(fields[i].get(object1), fields[i].get(object2));
                } catch (IllegalAccessException e) {
                    result = false;
                    return result;
                }
            }
        }
        return result;
    }
}
