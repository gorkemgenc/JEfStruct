package jEfSort;

import jEfExceptions.JEfArrayIndexOutOfRangeException;
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
    public void descendingOrder() {
        Integer[] array = new Integer[]{1,2,3};
        JEfArray.descendingOrder(array);
        Integer[] result = new Integer[]{3,2,1};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void ascendingOrder() {
        Integer[] array = new Integer[]{1,2,3,1};
        JEfArray.ascendingOrder(array);
        Integer[] result = new Integer[]{1,1,2,3};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void sortByLengthAsc() {
        String[] array = new String[]{"Test", "TestTestTestTest", "TestTestTest", "Test"};
        JEfArray.sortByLengthAsc(array);
        String[] result = new String[]{"Test", "Test", "TestTestTest", "TestTestTestTest"};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void sortByLengthDesc() {
        String[] array = new String[]{"Test", "TestTestTestTest", "TestTestTest", "Test"};
        JEfArray.sortByLengthDesc(array);
        String[] result = new String[]{"TestTestTestTest","TestTestTest","Test", "Test"};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void alphabeticalCharOrder() {
        Character[] array = new Character[]{'g', 'a', 'g', 'b', 'c', 'g'};
        JEfArray.alphabeticalCharOrder(array);
        Character[] result = new Character[]{'a', 'b', 'c', 'g', 'g', 'g'};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void alphabeticalStringOrder() {
        String[] array = new String[]{"Test", "TestTestTestTest", "TestTestTest", "Test", "Try", "ABC"};
        JEfArray.alphabeticalStringOrder(array);
        String[] result = new String[]{"ABC", "Test", "Test", "TestTestTest", "TestTestTestTest", "Try"};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void reverseAlphabeticalOrder() {
        String[] array = new String[]{"Test", "TestTestTestTest", "TestTestTest", "Test", "Try", "ABC"};
        JEfArray.reverseAlphabeticalOrder(array);
        String[] result = new String[]{"Try", "TestTestTestTest", "TestTestTest", "Test", "Test", "ABC"};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void reverseAlphabeticalOrder1() {
        Character[] array = new Character[]{'g', 'a', 'g', 'b', 'c', 'g'};
        JEfArray.reverseAlphabeticalOrder(array);
        Character[] result = new Character[]{'g', 'g', 'g', 'c', 'b', 'a'};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void orderBySpecial() {
        TempInner firstInner = new TempInner("BBB","ZZZ",1);
        TempInner secondInner = new TempInner("AAA","EEE",2);
        TempInner thirdInner = new TempInner("CCC","DDD",3);

        Temp firstTemp = new Temp("BBA", "XXX",1,firstInner);
        Temp secondTemp = new Temp("BBZ", "XBX",1,secondInner);
        Temp thirdTemp = new Temp("BBB", "BBX",1,thirdInner);

        Temp[] array = new Temp[]{firstTemp,secondTemp,thirdTemp};
        Temp[] result = new Temp[]{firstTemp,thirdTemp,secondTemp};
        JEfArray.orderBySpecial(array, "parameter1");
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void orderBySpecial2() {
        TempInner firstInner = new TempInner("BBB","ZZZ",1);
        TempInner secondInner = new TempInner("AAA","EEE",2);
        TempInner thirdInner = new TempInner("CCC","DDD",3);

        Temp firstTemp = new Temp("BBA", "XXX",1,firstInner);
        Temp secondTemp = new Temp("BBZ", "XBX",1,secondInner);
        Temp thirdTemp = new Temp("BBB", "BBX",1,thirdInner);

        Temp[] array = new Temp[]{firstTemp,secondTemp,thirdTemp};
        Temp[] result = new Temp[]{thirdTemp,secondTemp,firstTemp};
        JEfArray.orderBySpecial(array, "parameter2");
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void orderBySpecial3() {
        TempInner firstInner = new TempInner("BBB","ZZZ",3);
        TempInner secondInner = new TempInner("AAA","EEE",1);
        TempInner thirdInner = new TempInner("CCC","DDD",2);

        Temp firstTemp = new Temp("BBA", "XXX",3,firstInner);
        Temp secondTemp = new Temp("BBZ", "XBX",1,secondInner);
        Temp thirdTemp = new Temp("BBB", "BBX",2,thirdInner);

        Temp[] array = new Temp[]{firstTemp,secondTemp,thirdTemp};
        Temp[] result = new Temp[]{secondTemp,thirdTemp,firstTemp};
        JEfArray.orderBySpecial(array, "parameter3");
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void orderBySpecial4() {
        TempInner firstInner = new TempInner("BBB","ZZZ",3);
        TempInner secondInner = new TempInner("AAA","EEE",1);
        TempInner thirdInner = new TempInner("CCC","DDD",2);

        Temp firstTemp = new Temp("BBA", "XXX",3,firstInner);
        Temp secondTemp = new Temp("BBZ", "XBX",1,secondInner);
        Temp thirdTemp = new Temp("BBB", "BBX",1,thirdInner);

        Temp[] array = new Temp[]{firstTemp,secondTemp,thirdTemp};
        Temp[] result = new Temp[]{secondTemp,thirdTemp,firstTemp};
        JEfArray.orderBySpecial(array, "parameter3");
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void orderBySpecial5() {
        TempInner firstInner = new TempInner("BBB","ZZZ",3);
        TempInner secondInner = new TempInner("AAA","EEE",1);
        TempInner thirdInner = new TempInner("CCC","DDD",2);

        Temp firstTemp = new Temp("BBA", "XXX",3,firstInner);
        Temp secondTemp = new Temp("BBZ", "XBX",1,secondInner);
        Temp thirdTemp = new Temp("BBB", "BBX",1,thirdInner);

        Temp[] array = new Temp[]{firstTemp,secondTemp,thirdTemp};
        Temp[] result = new Temp[]{secondTemp,thirdTemp,firstTemp};
        JEfArray.orderBySpecial(array, "parameter4");
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void orderBySpecials() {
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
        JEfArray.orderBySpecials(array, parameters);
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void alphabeticalOrderWithSubString() {
        String[] array = new String[]{"Gorkem", "Genc", "Zarkm"};
        String[] expectedResult = new String[]{"Zarkm", "Genc", "Gorkem"};
        JEfArray.alphabeticalOrderWithSubString(array,1, array[1].length()-1);
        Assert.assertArrayEquals(array,expectedResult);
    }

    @Test
    public void alphabeticalOrderWithSubStringException() throws JEfArrayIndexOutOfRangeException {
        String[] array = new String[]{"Gorkem", "Genc", "Zarkm"};

        expectedEx.expect(JEfArrayIndexOutOfRangeException.class);
        expectedEx.expectMessage("Index out of range when comparing two string");
        JEfArray.alphabeticalOrderWithSubString(array, 1, 5);
    }

    @Test
    public void bubbleSort() {
        int[] array = new int[]{1,2,3,1};
        JEfArray.bubbleSort(array);
        int[] result = new int[]{1,1,2,3};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void mergeSort() {
        int[] array = new int[]{1,2,3,1};
        JEfArray.mergeSort(array);
        int[] result = new int[]{1,1,2,3};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void quickSort() {
        int[] array = new int[]{1,2,3,1};
        JEfArray.quickSort(array);
        int[] result = new int[]{1,1,2,3};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void insertionSort() {
        int[] array = new int[]{1,2,3,1};
        JEfArray.insertionSort(array);
        int[] result = new int[]{1,1,2,3};
        Assert.assertArrayEquals(array,result);
    }

    @Test
    public void heapSort() {
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