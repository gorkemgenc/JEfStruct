package jEfTransform;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JEfListTransformTest {

    @Test
    public void toBigIntListTest() {
        String[] array = new String[]{"123", "12312312312321312311231"};
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("12312312312321312311231");

        BigInteger[] result = JEfListTransform.toBigIntList(list);
        BigInteger[] expectedResult = new BigInteger[2];
        expectedResult[0] = new BigInteger("123");
        expectedResult[1] = new BigInteger("12312312312321312311231");
        Assert.assertArrayEquals(expectedResult,result);
    }

    @Test
    public void toIntListTest() {
        List<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(11);

        int[] result = JEfListTransform.toIntList(list);
        int[] expectedResult = new int[2];
        expectedResult[0] = 123;
        expectedResult[1] = 11;
        Assert.assertArrayEquals(expectedResult,result);
    }

    @Test
    public void toStringListTest() {
        String[] expectedResult = new String[]{"123", "12312312312321312311231"};
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("12312312312321312311231");
        String[] result = JEfListTransform.toStringList(list);
        Assert.assertArrayEquals(expectedResult,result);

    }
}