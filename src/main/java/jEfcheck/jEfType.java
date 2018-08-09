package jEfcheck;

public class jEfType<T, K> {

    public static <T, K> boolean isFieldsSame(T firstObject, K secondObject){

        return firstObject.getClass().equals(secondObject.getClass());

    }

    public static <T, K> boolean isMethodsSame(T firstObject, K secondObject){

        return firstObject.getClass().equals(secondObject.getClass());

    }

    public static boolean isContainObject(T firstObject, T secondObject){

        return true;
    }

    public static <T> boolean isSameByValue(T object1, T object2){

        return true;
    }
}
