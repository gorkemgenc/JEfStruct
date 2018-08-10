package jEfHelper;

import jEfExceptions.JEfArrayNullException;
import java.util.Arrays;

public class JEfModifier {

    /***
     * This function converts Integer[] array to int[] array. If array is null function throws a JEfArrayNullException
     * @param array
     * @return
     * @throws JEfArrayNullException
     */
    public static int[] intArray(Integer[] array) throws JEfArrayNullException {

        if(array == null) throw new JEfArrayNullException();

        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
    }

    /***
     * This function converts Double[] array to double[] array. If array is null function throws a JEfArrayNullException
     * @param array
     * @return
     * @throws JEfArrayNullException
     */
    public static double[] doubleArray(Double[] array) throws JEfArrayNullException {

        if(array == null) throw new JEfArrayNullException();

        return Arrays.stream(array).mapToDouble(Double::doubleValue).toArray();
    }

    /***
     * This function converts Long[] array to long[] array. If array is null function throws a JEfArrayNullException
     * @param array
     * @return
     * @throws JEfArrayNullException
     */
    public static long[] longArray(Long[] array) throws JEfArrayNullException {

        if(array == null) throw new JEfArrayNullException();

        return Arrays.stream(array).mapToLong(Long::longValue).toArray();
    }

    /***
     * This function converts Float[] array to float[] array. If array is null function throws a JEfArrayNullException
     * @param array
     * @return
     * @throws JEfArrayNullException
     */
    public static float[] floatArray(Float[] array) throws JEfArrayNullException {

        if(array == null) throw new JEfArrayNullException();

        float[] floatArray = new float[array.length];

        for(int i = 0; i < array.length; i++){
            floatArray[i] = array[i];
        }

        return floatArray;
    }
}
