package com.github.gorkemgenc.jEfTransform;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class JEfMinTest {

    @Test
    public void minListIntegerTest() {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(12,10,9,3,12,15,3));
        Integer result = JEfMin.minList(list);
        Integer expectedResult = 3;
        Assert.assertEquals(result,expectedResult);
    }

    @Test
    public void minListIntegerOneElementTest() {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(12));
        Integer result = JEfMin.minList(list);
        Integer expectedResult = 12;
        Assert.assertEquals(result,expectedResult);
    }

    @Test
    public void minArrayIntegerTest() {
        Integer[] array = new Integer[]{12,10,9,3,12,3,15};
        Integer result = JEfMin.minArray(array);
        Integer expectedResult = 3;
        Assert.assertEquals(result,expectedResult);
    }

    @Test
    public void minQueueTest() {
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(12,10,9,3,12,3,15));
        Integer result = JEfMin.minQueue(queue);
        Integer expectedResult = 3;
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void minQueueOneElementTest() {
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(12));
        Integer result = JEfMin.minQueue(queue);
        Integer expectedResult = 12;
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void minHashSetTest() {
        HashSet<Integer> set = new HashSet<>();
        set.addAll(Arrays.asList(12,10,9,3,12,3,15));
        Integer result = JEfMin.minHashSet(set);
        Integer expectedResult = 3;
        Assert.assertEquals(result,expectedResult);
    }

    @Test
    public void minHashMapByValueTest() {
        HashMap<Integer, Double> map = new HashMap<>();
        map.put(1,10d);
        map.put(2,20d);
        map.put(3,15d);

        Double min = JEfMin.minHashMapByValue(map);
        Double expectedResult = 10d;
        Assert.assertEquals(min, expectedResult);
    }

    @Test
    public void minHashMapByValueOneElementTest() {
        HashMap<Integer, Double> map = new HashMap<>();
        map.put(1,10d);


        Double min = JEfMin.minHashMapByValue(map);
        Double expectedResult = 10d;
        Assert.assertEquals(min, expectedResult);
    }

    @Test
    public void minHashMapByKeyTest() {
        HashMap<Integer, Double> map = new HashMap<>();
        map.put(10,10d);
        map.put(2,20d);
        map.put(32,15d);

        Integer min = JEfMin.minHashMapByKey(map);
        Integer expectedResult = 2;
        Assert.assertEquals(min, expectedResult);
    }

    @Test
    public void minHashMapByKeyOneElementTest() {
        HashMap<Integer, Double> map = new HashMap<>();
        map.put(10,10d);

        Integer min = JEfMin.minHashMapByKey(map);
        Integer expectedResult = 10;
        Assert.assertEquals(min, expectedResult);
    }

    @Test
    public void minHashTableByValueTest() {
        Hashtable<Integer, Double> table = new Hashtable<>();
        table.put(1,10d);
        table.put(2,20d);
        table.put(3,15d);

        Double min = JEfMin.minHashTableByValue(table);
        Double expectedResult = 10d;
        Assert.assertEquals(min, expectedResult);
    }

    @Test
    public void minHashTableByValueOneElementTest() {
        Hashtable<Integer, Double> table = new Hashtable<>();
        table.put(1,10d);

        Double min = JEfMin.minHashTableByValue(table);
        Double expectedResult = 10d;
        Assert.assertEquals(min, expectedResult);
    }

    @Test
    public void minHashTableByKeyTest() {
        Hashtable<Integer, Double> table = new Hashtable<>();
        table.put(10,10d);
        table.put(2,20d);
        table.put(32,15d);

        Integer min = JEfMin.minHashTableByKey(table);
        Integer expectedResult = 2;
        Assert.assertEquals(min, expectedResult);
    }

    @Test
    public void minHashTableByKeyOneElementTest() {
        Hashtable<Integer, Double> table = new Hashtable<>();
        table.put(10,10d);

        Integer min = JEfMin.minHashTableByKey(table);
        Integer expectedResult = 10;
        Assert.assertEquals(min, expectedResult);
    }
}