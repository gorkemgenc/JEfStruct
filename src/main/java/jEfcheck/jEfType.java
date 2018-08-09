package jEfcheck;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class jEfType<T, K> {

    private static boolean result = true;
    public static <T, K> boolean isClassesSame(T firstObject, K secondObject){

        return firstObject.getClass().equals(secondObject.getClass());

    }

    public static <T, K> boolean isInnerClass(T firstObject, K secondObject){
        if(firstObject.getClass().isInstance(secondObject)) return true;
        return false;
    }

    public static <T> boolean isSameByValue(T object1, T object2){

        result = true;

        Field[] fields = object1.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if(result == false) {
                return false;
            }
            fields[i].setAccessible(true);
            if(isWrapperType(fields[i].getType()) || fields[i].getType().isPrimitive()){
                try{
                    Object temp1 = fields[i].get(object1);
                    Object temp2 = fields[i].get(object2);
                    if(!temp1.equals(temp2)){
                        result = false;
                        return result;
                    }
                }
                catch (IllegalAccessException e){
                    result = false;
                    return result;
                }

            }
            else{
                try {
                    isSameByValue(fields[i].get(object1), fields[i].get(object2));
                } catch (IllegalAccessException e) {
                    result = false;
                    return result;
                }
            }
        }
        return result;
    }

    private static final Set<Class<?>> WRAPPER_TYPES = getWrapperTypes();

    private static boolean isWrapperType(Class<?> clazz)
    {
        return WRAPPER_TYPES.contains(clazz);
    }

    private static Set<Class<?>> getWrapperTypes()
    {
        Set<Class<?>> ret = new HashSet<>();
        ret.add(Boolean.class);
        ret.add(Character.class);
        ret.add(Byte.class);
        ret.add(Short.class);
        ret.add(Integer.class);
        ret.add(Long.class);
        ret.add(Float.class);
        ret.add(Double.class);
        ret.add(Void.class);
        ret.add(String.class);
        ret.add(List.class);
        ret.add(Set.class);
        ret.add(Map.class);
        return ret;
    }
}
