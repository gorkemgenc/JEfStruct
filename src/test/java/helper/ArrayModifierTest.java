package helper;

import exceptions.ArrayNullException;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ArrayModifierTest extends TestCase {

    @Test
    public void testIntArray() {
        Integer[] array = new Integer[]{1,2,3,4,5};
        int[] intArray = ArrayModifier.intArray(array);
        Assert.assertArrayEquals(new int[]{1,2,3,4,5}, intArray);
    }

    @Test
    public void testDoubleArray() {
        Double[] array = new Double[]{1.1,2.2,3.3,4.4,5.5};
        double[] doubleArray = ArrayModifier.doubleArray(array);
        double[] result = new double[]{1.1,2.2,3.3,4.4,5.5};
        for(int i=0; i<result.length; i++){
            Assert.assertEquals(result[i], doubleArray[i], 0);
        }
    }

    @Test
    public void testFloatArray() {
        Float[] array = new Float[]{1.0f,2.0f,3.0f,4.0f,5.0f};
        float[] floatArray = ArrayModifier.floatArray(array);
        float[] result = new float[]{1.0f,2.0f,3.0f,4.0f,5.0f};
        for(int i=0; i<result.length; i++){
            Assert.assertEquals(result[i], floatArray[i], 0);
        }
    }

    @Test
    public void testLongArray() {
        Long[] array = new Long[]{1L,2L,3L,4L,5L};
        long[] longArray = ArrayModifier.longArray(array);
        long[] result = new long[]{1L,2L,3L,4L,5L};
        for(int i=0; i<result.length; i++){
            Assert.assertEquals(result[i], longArray[i], 0);
        }
    }

    @Test(expected = ArrayNullException.class)
    public void testArrayNullException(){
        try {
            ArrayModifier.intArray(null);
            fail( "Array is null" );
        }
        catch (ArrayNullException expectedException) {
        }
    }
}