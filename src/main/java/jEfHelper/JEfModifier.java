package jEfHelper;

import jEfExceptions.JEfArrayNullException;
import java.util.Arrays;

public class JEfModifier {

    public static int[] intArray(Integer[] array) throws JEfArrayNullException {

        if(array == null) throw new JEfArrayNullException();

        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
    }

    public static double[] doubleArray(Double[] array) throws JEfArrayNullException {

        if(array == null) throw new JEfArrayNullException();

        return Arrays.stream(array).mapToDouble(Double::doubleValue).toArray();
    }

    public static long[] longArray(Long[] array) throws JEfArrayNullException {

        if(array == null) throw new JEfArrayNullException();

        return Arrays.stream(array).mapToLong(Long::longValue).toArray();
    }

    public static float[] floatArray(Float[] array) throws JEfArrayNullException {

        if(array == null) throw new JEfArrayNullException();

        float[] floatArray = new float[array.length];

        for(int i = 0; i < array.length; i++){
            floatArray[i] = array[i];
        }

        return floatArray;
    }
}
