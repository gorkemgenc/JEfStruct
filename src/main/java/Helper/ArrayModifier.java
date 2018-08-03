package Helper;

import exceptions.ArrayNullException;

import java.util.Arrays;

public class ArrayModifier {

    public static void intArray(Integer[] array) throws ArrayNullException {

        if(array == null) throw new ArrayNullException("Array is null");

        Arrays.stream(array).mapToInt(Integer::intValue).toArray();
    }

    public static void doubleArray(Double[] array) throws ArrayNullException {

        if(array == null) throw new ArrayNullException("Array is null");

        Arrays.stream(array).mapToDouble(Double::doubleValue).toArray();
    }

    public static void longArray(Long[] array) throws ArrayNullException {

        if(array == null) throw new ArrayNullException("Array is null");

        Arrays.stream(array).mapToLong(Long::longValue).toArray();
    }
}
