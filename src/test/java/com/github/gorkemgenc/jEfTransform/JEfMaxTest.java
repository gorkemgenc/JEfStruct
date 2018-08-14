package com.github.gorkemgenc.jEfTransform;

import org.junit.Assert;
import org.junit.Test;
import java.util.*;

public class JEfMaxTest {

    @Test
    public void maxListIntegerTest() {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(12,10,9,3,12,15,3));
        Integer result = JEfMax.maxList(list);
        Integer expectedResult = 15;
        Assert.assertEquals(result,expectedResult);
    }

    @Test
    public void maxListIntegerOneElementTest() {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(12));
        Integer result = JEfMax.maxList(list);
        Integer expectedResult = 12;
        Assert.assertEquals(result,expectedResult);
    }

    @Test
    public void maxListDoubleTest() {
        List<Double> list = new ArrayList<>();
        list.addAll(Arrays.asList(12d,10d,9d,3d,12d,3d,15d));
        Double result = JEfMax.maxList(list);
        Double expectedResult = 15d;
        Assert.assertEquals(result,expectedResult);
    }

    @Test
    public void maxListDoubleOneElementTest() {
        List<Double> list = new ArrayList<>();
        list.addAll(Arrays.asList(12d));
        Double result = JEfMax.maxList(list);
        Double expectedResult = 12d;
        Assert.assertEquals(result,expectedResult);
    }


    @Test
    public void maxArrayIntegerTest() {
        Integer[] array = new Integer[]{12,10,9,3,12,3,15};
        Integer result = JEfMax.maxArray(array);
        Integer expectedResult = 15;
        Assert.assertEquals(result,expectedResult);
    }

    @Test
    public void maxArrayIntegerOneElementTest() {
        Integer[] array = new Integer[]{12};
        Integer result = JEfMax.maxArray(array);
        Integer expectedResult = 12;
        Assert.assertEquals(result,expectedResult);
    }

    @Test
    public void maxArrayDoubleTest() {
        Double[] array = new Double[]{12d,10d,9d,3d,12d,15d,3d};
        Double result = JEfMax.maxArray(array);
        Double expectedResult = 15d;
        Assert.assertEquals(result,expectedResult);
    }

    @Test
    public void maxArrayDoubleOneElementTest() {
        Double[] array = new Double[]{12d};
        Double result = JEfMax.maxArray(array);
        Double expectedResult = 12d;
        Assert.assertEquals(result,expectedResult);
    }

    @Test
    public void maxQueueTest() {
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(12,10,9,3,12,3,15));

        Integer result = JEfMax.maxQueue(queue);
        Integer expectedResult = 15;
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void maxQueueOneElementTest() {
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(12));

        Integer result = JEfMax.maxQueue(queue);
        Integer expectedResult = 12;
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void maxHashSetTest() {
        HashSet<Integer> set = new HashSet<>();
        set.addAll(Arrays.asList(12,10,9,3,12,3,15));

        Integer result = JEfMax.maxHashSet(set);
        Integer expectedResult = 15;
        Assert.assertEquals(result,expectedResult);
    }

    @Test
    public void maxHashSetOneElementTest() {
        HashSet<Integer> set = new HashSet<>();
        set.addAll(Arrays.asList(12));

        Integer result = JEfMax.maxHashSet(set);
        Integer expectedResult = 12;
        Assert.assertEquals(result,expectedResult);
    }

    @Test
    public void maxHashMapByValueTest() {
        HashMap<Integer, Double> map = new HashMap<>();
        map.put(1,10d);
        map.put(2,20d);
        map.put(3,15d);

        Double max = JEfMax.maxHashMapByValue(map);
        Double expectedResult = 20d;
        Assert.assertEquals(max, expectedResult);
    }

    @Test
    public void maxHashMapByValueOneElementTest() {
        HashMap<Integer, Double> map = new HashMap<>();
        map.put(2,20d);

        Double max = JEfMax.maxHashMapByValue(map);
        Double expectedResult = 20d;
        Assert.assertEquals(max, expectedResult);
    }

    @Test
    public void maxHashMapByKeyTest() {
        HashMap<Integer, Double> map = new HashMap<>();
        map.put(10,10d);
        map.put(2,20d);
        map.put(32,15d);

        Integer max = JEfMax.maxHashMapByKey(map);
        Integer expectedResult = 32;
        Assert.assertEquals(max, expectedResult);
    }

    @Test
    public void maxHashMapByKeyOneElementTest() {
        HashMap<Integer, Double> map = new HashMap<>();
        map.put(2,20d);

        Integer max = JEfMax.maxHashMapByKey(map);
        Integer expectedResult = 2;
        Assert.assertEquals(max, expectedResult);
    }

    @Test
    public void maxHashTableByValueTest() {
        Hashtable<Integer, Double> table = new Hashtable<>();
        table.put(1,10d);
        table.put(2,20d);
        table.put(3,15d);

        Double max = JEfMax.maxHashTableByValue(table);
        Double expectedResult = 20d;
        Assert.assertEquals(max, expectedResult);
    }

    @Test
    public void maxHashTableByValueOneElementTest() {
        Hashtable<Integer, Double> table = new Hashtable<>();
        table.put(2,20d);

        Double max = JEfMax.maxHashTableByValue(table);
        Double expectedResult = 20d;
        Assert.assertEquals(max, expectedResult);
    }

    @Test
    public void maxHashTableByKeyTest() {
        Hashtable<Integer, Double> table = new Hashtable<>();
        table.put(10,10d);
        table.put(2,20d);
        table.put(32,15d);

        Integer max = JEfMax.maxHashTableByKey(table);
        Integer expectedResult = 32;
        Assert.assertEquals(max, expectedResult);
    }

    @Test
    public void maxHashTableByKeyOneElementTest() {
        Hashtable<Integer, Double> table = new Hashtable<>();
        table.put(2,20d);

        Integer max = JEfMax.maxHashTableByKey(table);
        Integer expectedResult = 2;
        Assert.assertEquals(max, expectedResult);
    }
}