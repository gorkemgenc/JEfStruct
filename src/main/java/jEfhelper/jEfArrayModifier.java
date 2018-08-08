package jEfhelper;

import exceptions.ArrayNullException;

import java.util.Arrays;
import java.util.Collections;

public class jEfArrayModifier {

    public static int[] intArray(Integer[] array) throws ArrayNullException {

        if(array == null) throw new ArrayNullException("Array is null");

        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
    }

    public static double[] doubleArray(Double[] array) throws ArrayNullException {

        if(array == null) throw new ArrayNullException("Array is null");

        return Arrays.stream(array).mapToDouble(Double::doubleValue).toArray();
    }

    public static long[] longArray(Long[] array) throws ArrayNullException {

        if(array == null) throw new ArrayNullException("Array is null");

        return Arrays.stream(array).mapToLong(Long::longValue).toArray();
    }

    public static float[] floatArray(Float[] array) throws ArrayNullException {

        if(array == null) throw new ArrayNullException("Array is null");

        float[] floatArray = new float[array.length];

        for(int i = 0; i < array.length; i++){
            floatArray[i] = (float)array[i];
        }

        return floatArray;
    }
}
