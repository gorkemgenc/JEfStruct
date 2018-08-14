package com.github.gorkemgenc.jEfSort;

import com.github.gorkemgenc.jEfEnums.JEfOrderType;
import com.github.gorkemgenc.jEfExceptions.JEfArrayIndexOutOfRangeException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.ArrayList;
import java.util.List;

public class JEfArrayTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void descendingOrderTest() {
        Integer[] array = new Integer[]{1,2,3};
        JEfArray.descendingOrder(array);
        Integer[] result = new Integer[]{3,2,1};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void ascendingOrderTest() {
        Integer[] array = new Integer[]{1,2,3,1};
        JEfArray.ascendingOrder(array);
        Integer[] result = new Integer[]{1,1,2,3};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void sortByLengthAscTest() {
        String[] array = new String[]{"Test", "TestTestTestTest", "TestTestTest", "Test"};
        JEfArray.sortByLengthAsc(array);
        String[] result = new String[]{"Test", "Test", "TestTestTest", "TestTestTestTest"};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void sortByLengthDescTest() {
        String[] array = new String[]{"Test", "TestTestTestTest", "TestTestTest", "Test"};
        JEfArray.sortByLengthDesc(array);
        String[] result = new String[]{"TestTestTestTest","TestTestTest","Test", "Test"};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void alphabeticalCharOrderTest() {
        Character[] array = new Character[]{'g', 'a', 'g', 'b', 'c', 'g'};
        JEfArray.alphabeticalCharOrder(array);
        Character[] result = new Character[]{'a', 'b', 'c', 'g', 'g', 'g'};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void alphabeticalStringOrderTest() {
        String[] array = new String[]{"Test", "TestTestTestTest", "TestTestTest", "Test", "Try", "ABC"};
        JEfArray.alphabeticalStringOrder(array);
        String[] result = new String[]{"ABC", "Test", "Test", "TestTestTest", "TestTestTestTest", "Try"};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void reverseAlphabeticalOrderTest() {
        String[] array = new String[]{"Test", "TestTestTestTest", "TestTestTest", "Test", "Try", "ABC"};
        JEfArray.reverseAlphabeticalOrder(array);
        String[] result = new String[]{"Try", "TestTestTestTest", "TestTestTest", "Test", "Test", "ABC"};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void reverseAlphabeticalOrder1Test() {
        Character[] array = new Character[]{'g', 'a', 'g', 'b', 'c', 'g'};
        JEfArray.reverseAlphabeticalOrder(array);
        Character[] result = new Character[]{'g', 'g', 'g', 'c', 'b', 'a'};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void orderBySpecialTest() {
        TempInner firstInner = new TempInner("BBB","ZZZ",1);
        TempInner secondInner = new TempInner("AAA","EEE",2);
        TempInner thirdInner = new TempInner("CCC","DDD",3);

        Temp firstTemp = new Temp("BBA", "XXX",1,firstInner);
        Temp secondTemp = new Temp("BBZ", "XBX",1,secondInner);
        Temp thirdTemp = new Temp("BBB", "BBX",1,thirdInner);

        Temp[] array = new Temp[]{firstTemp,secondTemp,thirdTemp};
        Temp[] result = new Temp[]{firstTemp,thirdTemp,secondTemp};
        JEfArray.orderBySpecial(array, "parameter1", JEfOrderType.ASC);
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void orderBySpecialDescTest() {
        TempInner firstInner = new TempInner("BBB","ZZZ",1);
        TempInner secondInner = new TempInner("AAA","EEE",2);
        TempInner thirdInner = new TempInner("CCC","DDD",3);

        Temp firstTemp = new Temp("BBA", "XXX",1,firstInner);
        Temp secondTemp = new Temp("BBZ", "XBX",1,secondInner);
        Temp thirdTemp = new Temp("BBB", "BBX",1,thirdInner);

        Temp[] array = new Temp[]{firstTemp,secondTemp,thirdTemp};
        Temp[] result = new Temp[]{secondTemp, thirdTemp,firstTemp};
        JEfArray.orderBySpecial(array, "parameter1", JEfOrderType.DESC);
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void orderBySpecial2Test() {
        TempInner firstInner = new TempInner("BBB","ZZZ",1);
        TempInner secondInner = new TempInner("AAA","EEE",2);
        TempInner thirdInner = new TempInner("CCC","DDD",3);

        Temp firstTemp = new Temp("BBA", "XXX",1,firstInner);
        Temp secondTemp = new Temp("BBZ", "XBX",1,secondInner);
        Temp thirdTemp = new Temp("BBB", "BBX",1,thirdInner);

        Temp[] array = new Temp[]{firstTemp,secondTemp,thirdTemp};
        Temp[] result = new Temp[]{thirdTemp,secondTemp,firstTemp};
        JEfArray.orderBySpecial(array, "parameter2", JEfOrderType.ASC);
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void orderBySpecial3Test() {
        TempInner firstInner = new TempInner("BBB","ZZZ",3);
        TempInner secondInner = new TempInner("AAA","EEE",1);
        TempInner thirdInner = new TempInner("CCC","DDD",2);

        Temp firstTemp = new Temp("BBA", "XXX",3,firstInner);
        Temp secondTemp = new Temp("BBZ", "XBX",1,secondInner);
        Temp thirdTemp = new Temp("BBB", "BBX",2,thirdInner);

        Temp[] array = new Temp[]{firstTemp,secondTemp,thirdTemp};
        Temp[] result = new Temp[]{secondTemp,thirdTemp,firstTemp};
        JEfArray.orderBySpecial(array, "parameter3", JEfOrderType.ASC);
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void orderBySpecial4Test() {
        TempInner firstInner = new TempInner("BBB","ZZZ",3);
        TempInner secondInner = new TempInner("AAA","EEE",1);
        TempInner thirdInner = new TempInner("CCC","DDD",2);

        Temp firstTemp = new Temp("BBA", "XXX",3,firstInner);
        Temp secondTemp = new Temp("BBZ", "XBX",1,secondInner);
        Temp thirdTemp = new Temp("BBB", "BBX",1,thirdInner);

        Temp[] array = new Temp[]{firstTemp,secondTemp,thirdTemp};
        Temp[] result = new Temp[]{secondTemp,thirdTemp,firstTemp};
        JEfArray.orderBySpecial(array, "parameter3", JEfOrderType.ASC);
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void orderBySpecial5Test() {
        TempInner firstInner = new TempInner("BBB","ZZZ",3);
        TempInner secondInner = new TempInner("AAA","EEE",1);
        TempInner thirdInner = new TempInner("CCC","DDD",2);

        Temp firstTemp = new Temp("BBA", "XXX",3,firstInner);
        Temp secondTemp = new Temp("BBZ", "XBX",1,secondInner);
        Temp thirdTemp = new Temp("BBB", "BBX",1,thirdInner);

        Temp[] array = new Temp[]{firstTemp,secondTemp,thirdTemp};
        Temp[] result = new Temp[]{firstTemp,secondTemp, thirdTemp};
        JEfArray.orderBySpecial(array, "parameter4", JEfOrderType.ASC);
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void orderBySpecialsTest() {
        TempInner firstInner = new TempInner("BBB","ZZZ",3);
        TempInner secondInner = new TempInner("AAA","EEE",1);
        TempInner thirdInner = new TempInner("CCC","DDD",2);

        Temp firstTemp = new Temp("BBA", "XXX",3,firstInner);
        Temp secondTemp = new Temp("BBZ", "XBX",1,secondInner);
        Temp thirdTemp = new Temp("BBA", "BBX",1,thirdInner);

        Temp[] array = new Temp[]{firstTemp,secondTemp,thirdTemp};
        Temp[] result = new Temp[]{thirdTemp,firstTemp,secondTemp};
        List<String> parameters = new ArrayList<>();
        parameters.add("parameter1");
        parameters.add("parameter3");
        JEfArray.orderBySpecials(array, parameters, JEfOrderType.ASC);
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void alphabeticalOrderWithSubStringTest() {
        String[] array = new String[]{"Gorkem", "Genc", "Zarkm"};
        String[] expectedResult = new String[]{"Zarkm", "Genc", "Gorkem"};
        JEfArray.alphabeticalOrderWithSubString(array,1, array[1].length()-1);
        Assert.assertArrayEquals(array,expectedResult);
    }

    @Test
    public void alphabeticalOrderWithSubStringExceptionTest() throws JEfArrayIndexOutOfRangeException {
        String[] array = new String[]{"Gorkem", "Genc", "Zarkm"};

        expectedEx.expect(JEfArrayIndexOutOfRangeException.class);
        expectedEx.expectMessage("IndexOutOfRange Exception when comparing two string");
        JEfArray.alphabeticalOrderWithSubString(array, 1, 5);
    }

    @Test
    public void bubbleSortTest() {
        int[] array = new int[]{1,2,3,1};
        JEfArray.bubbleSort(array);
        int[] result = new int[]{1,1,2,3};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void mergeSortTest() {
        int[] array = new int[]{1,2,3,1};
        JEfArray.mergeSort(array);
        int[] result = new int[]{1,1,2,3};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void quickSortTest() {
        int[] array = new int[]{1,2,3,1};
        JEfArray.quickSort(array);
        int[] result = new int[]{1,1,2,3};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void insertionSortTest() {
        int[] array = new int[]{1,2,3,1};
        JEfArray.insertionSort(array);
        int[] result = new int[]{1,1,2,3};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void heapSortTest() {
        int[] array = new int[]{1,2,3,1};
        JEfArray.heapSort(array);
        int[] result = new int[]{1,1,2,3};
        Assert.assertArrayEquals(array,result);
    }

    class Temp{
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

    class TempInner{
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