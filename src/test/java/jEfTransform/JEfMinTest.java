package jEfTransform;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class JEfMinTest {

    @Test
    public void minListInteger() {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(10);
        list.add(9);
        list.add(3);
        list.add(12);
        list.add(15);
        list.add(3);
        Integer result = JEfMin.minList(list);
        Integer expectedResult = 3;
        Assert.assertEquals(result,expectedResult);
    }

    @Test
    public void minArrayInteger() {
        Integer[] array = new Integer[]{12,10,9,3,12,3,15};
        Integer result = JEfMin.minArray(array);
        Integer expectedResult = 3;
        Assert.assertEquals(result,expectedResult);
    }

    @Test
    public void minQueue() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(12);
        queue.add(10);
        queue.add(9);
        queue.add(3);
        queue.add(12);
        queue.add(3);
        queue.add(15);

        Integer result = JEfMin.minQueue(queue);
        Integer expectedResult = 3;
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void minHashSet() {
        HashSet<Integer> set = new HashSet<>();
        set.add(12);
        set.add(10);
        set.add(9);
        set.add(3);
        set.add(12);
        set.add(3);
        set.add(15);

        Integer result = JEfMin.minHashSet(set);
        Integer expectedResult = 3;
        Assert.assertEquals(result,expectedResult);
    }

    @Test
    public void minHashMapByValue() {
        HashMap<Integer, Double> map = new HashMap<>();
        map.put(1,10d);
        map.put(2,20d);
        map.put(3,15d);

        Double min = JEfMin.minHashMapByValue(map);
        Double expectedResult = 10d;
        Assert.assertEquals(min, expectedResult);
    }

    @Test
    public void minHashMapByKey() {
        HashMap<Integer, Double> map = new HashMap<>();
        map.put(10,10d);
        map.put(2,20d);
        map.put(32,15d);

        Integer min = JEfMin.minHashMapByKey(map);
        Integer expectedResult = 2;
        Assert.assertEquals(min, expectedResult);
    }

    @Test
    public void minHashTableByValue() {
        Hashtable<Integer, Double> table = new Hashtable<>();
        table.put(1,10d);
        table.put(2,20d);
        table.put(3,15d);

        Double min = JEfMin.minHashTableByValue(table);
        Double expectedResult = 10d;
        Assert.assertEquals(min, expectedResult);
    }

    @Test
    public void minHashTableByKey() {
        Hashtable<Integer, Double> table = new Hashtable<>();
        table.put(10,10d);
        table.put(2,20d);
        table.put(32,15d);

        Integer min = JEfMin.minHashTableByKey(table);
        Integer expectedResult = 2;
        Assert.assertEquals(min, expectedResult);
    }
}