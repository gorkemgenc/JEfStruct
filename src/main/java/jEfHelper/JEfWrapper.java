package jEfHelper;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JEfWrapper {

    private static final Set<Class<?>> WRAPPER_TYPES = getWrapperTypes();
    private static final Set<Class<?>> WRAPPER_TYPES_FOR_TYPE_CHECK = getWrapperTypesForType();

    public static boolean isWrapperType(Class<?> clazz) {

        return WRAPPER_TYPES.contains(clazz);
    }

    public static boolean isWrapperTypeForType(Class<?> clazz)
    {
        return WRAPPER_TYPES_FOR_TYPE_CHECK.contains(clazz);
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
        return ret;
    }

    private static Set<Class<?>> getWrapperTypesForType()
    {
        Set<Class<?>> ret = new HashSet<>();
        ret.addAll(WRAPPER_TYPES);
        ret.add(List.class);
        ret.add(Set.class);
        ret.add(Map.class);
        return ret;
    }
}
