package jEfTransform;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class JEfArrayTransformTest {

    @Test
    public void toBigIntArrayTest() {
        String[] array = new String[]{"123", "12312312312321312311231"};
        BigInteger[] result = JEfArrayTransform.toBigIntArray(array);
        BigInteger[] expectedResult = new BigInteger[2];
        expectedResult[0] = new BigInteger("123");
        expectedResult[1] = new BigInteger("12312312312321312311231");
        Assert.assertArrayEquals(expectedResult,result);
    }

    @Test
    public void toIntArrayTest() {
        String[] array = new String[]{"123", "11"};
        int[] result = JEfArrayTransform.toIntArray(array);
        int[] expectedResult = new int[2];
        expectedResult[0] = 123;
        expectedResult[1] = 11;
        Assert.assertArrayEquals(expectedResult,result);
    }

    @Test
    public void toStringArrayTest() {
        int[] array = new int[]{123,11};
        String[] result = JEfArrayTransform.toStringArray(array);
        String[] expectedResult = new String[]{"123", "11"};
        Assert.assertArrayEquals(expectedResult,result);
    }
}