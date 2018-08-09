package jEfHelper;

import jEfExceptions.JEfArrayNullException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class JEfModifierTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void intArrayTest() {

        Integer[] parameter = new Integer[]{1,2,3,4};
        int[] expected = new int[]{1,2,3,4};

        int[] result = JEfModifier.intArray(parameter);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void intArrayTestException() throws JEfArrayNullException{

       expectedEx.expect(JEfArrayNullException.class);
       expectedEx.expectMessage("Array is null");
       JEfModifier.intArray(null);
    }

    @Test
    public void doubleArray() {

        Double[] parameter = new Double[]{1.0d,2.0d,3.0d,4.0d};
        double[] expected = new double[]{1.0d,2.0d,3.0d,4.0d};

        double[] result = JEfModifier.doubleArray(parameter);
        for(int i=0; i<expected.length; i++){
            Assert.assertEquals(result[i], expected[i], 0);
        }
    }

    @Test
    public void doubleArrayTestException() throws JEfArrayNullException{

        expectedEx.expect(JEfArrayNullException.class);
        expectedEx.expectMessage("Array is null");
        JEfModifier.doubleArray(null);
    }

    @Test
    public void longArray() {

        Long[] parameter = new Long[]{1l,2l,3l,4l};
        long[] expected = new long[]{1l,2l,3l,4l};
        long[] result = JEfModifier.longArray(parameter);

        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void longArrayTestException() throws JEfArrayNullException{

        expectedEx.expect(JEfArrayNullException.class);
        expectedEx.expectMessage("Array is null");
        JEfModifier.longArray(null);
    }

    @Test
    public void floatArray() {

        Float[] parameter = new Float[]{1f,2f,3f,4f};
        float[] expected = new float[]{1f,2f,3f,4f};
        float[] result = JEfModifier.floatArray(parameter);

        for(int i=0; i<expected.length; i++){
            Assert.assertEquals(result[i], expected[i],0);
        }
    }

    @Test
    public void floatArrayTestException() throws JEfArrayNullException{

        expectedEx.expect(JEfArrayNullException.class);
        expectedEx.expectMessage("Array is null");
        JEfModifier.floatArray(null);
    }
}