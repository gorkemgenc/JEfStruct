package com.github.gorkemgenc.jEfSort;

import com.github.gorkemgenc.jEfEnums.JEfOrderType;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JEfListTest {

    @Test
    public void descendingOrderTest() {

        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1,2,3));
        JEfList.descendingOrder(list);
        List<Integer> result = new ArrayList<>();
        result.addAll(Arrays.asList(3,2,1));

        for(int i=0; i<result.size(); i++){
            Assert.assertEquals(result.get(i), list.get(i));
        }
    }

    @Test
    public void ascendingOrderTest() {

        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1,2,3));
        JEfList.ascendingOrder(list);
        List<Integer> result = new ArrayList<>();
        result.addAll(Arrays.asList(1,2,3));

        for(int i=0; i<result.size(); i++){
            Assert.assertEquals(result.get(i), list.get(i));
        }
    }

    @Test
    public void sortByLengthTest() {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("Test", "TestTestTestTest", "TestTestTest", "Test"));

        JEfList.sortByLength(list);

        List<String> result = new ArrayList<>();
        result.addAll(Arrays.asList("Test", "Test", "TestTestTest", "TestTestTestTest"));

        for(int i=0; i<result.size(); i++){
            Assert.assertEquals(result.get(i), list.get(i));
        }
    }

    @Test
    public void sortByLengthDescTest() {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("Test", "TestTestTestTest", "TestTestTest", "Test"));

        JEfList.sortByLengthDesc(list);

        List<String> result = new ArrayList<>();
        result.addAll(Arrays.asList("TestTestTestTest", "TestTestTest", "Test", "Test"));

        for(int i=0; i<result.size(); i++){
            Assert.assertEquals(result.get(i), list.get(i));
        }
    }

    @Test
    public void alphabeticalCharOrderTest() {

        List<Character> list = new ArrayList<>();
        list.addAll(Arrays.asList('g','a','g','b','c','g'));

        JEfList.alphabeticalCharOrder(list);

        List<Character> result = new ArrayList<>();
        result.addAll(Arrays.asList('a','b','c','g','g','g'));

        for(int i=0; i<result.size(); i++){
            Assert.assertEquals(result.get(i), list.get(i));
        }
    }

    @Test
    public void alphabeticalOrderTest() {

        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("Test","TestTestTestTest", "TestTestTest","Test","Try","ABC"));

        JEfList.alphabeticalOrder(list);

        List<String> result = new ArrayList<>();
        result.addAll(Arrays.asList("ABC","Test","Test","TestTestTest","TestTestTestTest","Try"));

        for(int i=0; i<result.size(); i++){
            Assert.assertEquals(result.get(i), list.get(i));
        }
    }

    @Test
    public void reverseAlphabeticalCharOrderTest() {

        List<Character> list = new ArrayList<>();
        list.addAll(Arrays.asList('g','a','g','b','c','g'));

        JEfList.alphabeticalCharOrder(list);

        List<Character> result = new ArrayList<>();
        result.addAll(Arrays.asList('g','g','g','c','b','a'));

        JEfList.reverseAlphabeticalCharOrder(list);

        for(int i=0; i<result.size(); i++){
            Assert.assertEquals(result.get(i), list.get(i));
        }
    }

    @Test
    public void reverseAlphabeticalOrderTest() {

        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("Test","TestTestTestTest","TestTestTest","Test","Try","ABC"));

        JEfList.reverseAlphabeticalOrder(list);

        List<String> result = new ArrayList<>();
        result.addAll(Arrays.asList("Try","TestTestTestTest","TestTestTest","Test","Test","ABC"));

        for(int i=0; i<result.size(); i++){
            Assert.assertEquals(result.get(i), list.get(i));
        }
    }

    @Test
    public void orderBySpecialTest() {

        TempInner firstInner = new TempInner("BBB","ZZZ",1);
        TempInner secondInner = new TempInner("AAA","EEE",2);
        TempInner thirdInner = new TempInner("CCC","DDD",3);

        Temp firstTemp = new Temp("BBA", "XXX",1,firstInner);
        Temp secondTemp = new Temp("BBZ", "XBX",1,secondInner);
        Temp thirdTemp = new Temp("BBB", "BBX",1,thirdInner);

        List<Temp> list = new ArrayList<>();
        list.addAll(Arrays.asList(firstTemp,secondTemp,thirdTemp));

        List<Temp> result = new ArrayList<>();
        result.addAll(Arrays.asList(firstTemp,thirdTemp,secondTemp));

        JEfList.orderBySpecial(list, "parameter1", JEfOrderType.ASC);
        Assert.assertEquals(list,result);
    }

    @Test
    public void orderBySpecialDescTest() {

        TempInner firstInner = new TempInner("BBB","ZZZ",1);
        TempInner secondInner = new TempInner("AAA","EEE",2);
        TempInner thirdInner = new TempInner("CCC","DDD",3);

        Temp firstTemp = new Temp("BBA", "XXX",1,firstInner);
        Temp secondTemp = new Temp("BBZ", "XBX",1,secondInner);
        Temp thirdTemp = new Temp("BBB", "BBX",1,thirdInner);

        List<Temp> list = new ArrayList<>();
        list.addAll(Arrays.asList(firstTemp,secondTemp,thirdTemp));

        List<Temp> result = new ArrayList<>();
        result.addAll(Arrays.asList(secondTemp, thirdTemp, firstTemp));

        JEfList.orderBySpecial(list, "parameter1", JEfOrderType.DESC);
        Assert.assertEquals(list,result);
    }

    @Test
    public void orderBySpecialsTest() {
        TempInner firstInner = new TempInner("BBB","ZZZ",3);
        TempInner secondInner = new TempInner("AAA","EEE",1);
        TempInner thirdInner = new TempInner("CCC","DDD",2);

        Temp firstTemp = new Temp("BBA", "XXX",3,firstInner);
        Temp secondTemp = new Temp("BBZ", "XBX",1,secondInner);
        Temp thirdTemp = new Temp("BBA", "BBX",1,thirdInner);

        List<Temp> list = new ArrayList<>();
        list.addAll(Arrays.asList(firstTemp,secondTemp,thirdTemp));

        List<Temp> result = new ArrayList<>();
        result.addAll(Arrays.asList(thirdTemp,firstTemp,secondTemp));

        List<String> parameters = new ArrayList<>();
        parameters.add("parameter1");
        parameters.add("parameter3");
        JEfList.orderBySpecials(list, parameters, JEfOrderType.ASC);
        Assert.assertEquals(list,result);
    }

    @Test
    public void alphabeticalOrderWithSubStringTest() {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("Gorkem","Genc","Zarkm"));

        List<String> expectedResult = new ArrayList<>();
        expectedResult.addAll(Arrays.asList("Zarkm","Genc","Gorkem"));

        JEfList.alphabeticalOrderWithSubString(list,1, list.get(1).length()-1);
        Assert.assertEquals(list,expectedResult);
    }

    @Test
    public void bubbleSortTest() {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1,2,3,1));

        List<Integer> result = new ArrayList<>();
        result.addAll(Arrays.asList(1,1,2,3));

        List<Integer> expected = JEfList.bubbleSort(list);
        Assert.assertEquals(result,expected);
    }

    @Test
    public void mergeSortTest() {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1,2,3,1));

        List<Integer> result = new ArrayList<>();
        result.addAll(Arrays.asList(1,1,2,3));

        List<Integer> expected = JEfList.mergeSort(list);
        Assert.assertEquals(result,expected);
    }

    @Test
    public void quickSortTest() {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1,2,3,1));

        List<Integer> result = new ArrayList<>();
        result.addAll(Arrays.asList(1,1,2,3));

        List<Integer> expected = JEfList.quickSort(list);
        Assert.assertEquals(result,expected);
    }

    @Test
    public void insertionSortTest() {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1,2,3,1));

        List<Integer> result = new ArrayList<>();
        result.addAll(Arrays.asList(1,1,2,3));

        List<Integer> expected = JEfList.insertionSort(list);
        Assert.assertEquals(result,expected);
    }

    @Test
    public void heapSortTest() {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1,2,3,1));

        List<Integer> result = new ArrayList<>();
        result.addAll(Arrays.asList(1,1,2,3));

        List<Integer> expected = JEfList.heapSort(list);
        Assert.assertEquals(result,expected);
    }

    private class Temp{
        String parameter1;
        String parameter2;
        int parameter3;
        TempInner parameter4;

        Temp(String parameter1, String parameter2, int parameter3, TempInner parameter4){
            this.parameter1 = parameter1;
            this.parameter2 = parameter2;
            this.parameter3 = parameter3;
            this.parameter4 = parameter4;
        }

    }

    private class TempInner{
        String first;
        String second;
        int third;

        TempInner(String first, String second, int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}