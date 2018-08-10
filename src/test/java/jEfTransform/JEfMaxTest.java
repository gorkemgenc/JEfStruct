package jEfTransform;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

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
        Queue<Integer> queue = new LinkedList<>();
        queue.add(12);
        queue.add(10);
        queue.add(9);
        queue.add(3);
        queue.add(12);
        queue.add(3);
        queue.add(15);

        Integer result = JEfMax.maxQueue(queue);
        Integer expectedResult = 15;
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void maxHashSet() {
        HashSet<Integer> set = new HashSet<>();
        set.add(12);
        set.add(10);
        set.add(9);
        set.add(3);
        set.add(12);
        set.add(3);
        set.add(15);

        Integer result = JEfMax.maxHashSet(set);
        Integer expectedResult = 15;
        Assert.assertEquals(result,expectedResult);
    }

    @Test
    public void maxHashMapByValue() {
        HashMap<Integer, Double> map = new HashMap<>();
        map.put(1,10d);
        map.put(2,20d);
        map.put(3,15d);

        Double max = JEfMax.maxHashMapByValue(map);
        Double expectedResult = 20d;
        Assert.assertEquals(max, expectedResult);
    }

    @Test
    public void maxHashMapByKey() {
        HashMap<Integer, Double> map = new HashMap<>();
        map.put(10,10d);
        map.put(2,20d);
        map.put(32,15d);

        Integer max = JEfMax.maxHashMapByKey(map);
        Integer expectedResult = 32;
        Assert.assertEquals(max, expectedResult);
    }

    @Test
    public void maxHashTableByValue() {
        Hashtable<Integer, Double> table = new Hashtable<>();
        table.put(1,10d);
        table.put(2,20d);
        table.put(3,15d);

        Double max = JEfMax.maxHashTableByValue(table);
        Double expectedResult = 20d;
        Assert.assertEquals(max, expectedResult);
    }

    @Test
    public void maxHashTableByKey() {
        Hashtable<Integer, Double> table = new Hashtable<>();
        table.put(10,10d);
        table.put(2,20d);
        table.put(32,15d);

        Integer max = JEfMax.maxHashTableByKey(table);
        Integer expectedResult = 32;
        Assert.assertEquals(max, expectedResult);
    }
}