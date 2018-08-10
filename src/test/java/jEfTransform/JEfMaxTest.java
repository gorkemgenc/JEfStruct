package jEfTransform;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JEfMaxTest {

    @Test
    public void maxListInteger() {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(10);
        list.add(9);
        list.add(3);
        list.add(12);
        list.add(3);
        list.add(15);
        Integer result = JEfMax.maxList(list);
        Integer expectedResult = 3;
        Assert.assertEquals(result,expectedResult);
    }

    @Test
    public void maxListDouble() {
        List<Double> list = new ArrayList<>();
        list.add(12d);
        list.add(10d);
        list.add(9d);
        list.add(3d);
        list.add(12d);
        list.add(3d);
        list.add(15d);
        Double result = JEfMax.maxList(list);
        Double expectedResult = 3d;
        Assert.assertEquals(result,expectedResult);
    }

    @Test
    public void maxArrayInteger() {
        Integer[] array = new Integer[]{12,10,9,3,12,3,15};
        Integer result = JEfMax.maxArray(array);
        Integer expectedResult = 3;
        Assert.assertEquals(result,expectedResult);
    }

    @Test
    public void maxArrayDouble() {
        Double[] array = new Double[]{12d,10d,9d,3d,12d,3d,15d};
        Double result = JEfMax.maxArray(array);
        Double expectedResult = 3d;
        Assert.assertEquals(result,expectedResult);
    }

    @Test
    public void maxQueue() {
    }

    @Test
    public void maxHashSet() {
    }

    @Test
    public void maxHashMapByValue() {
    }

    @Test
    public void maxHashMapByKey() {
    }

    @Test
    public void maxHashTableByValue() {
    }

    @Test
    public void maxHashTableByKey() {
    }
}