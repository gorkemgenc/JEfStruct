package jEfSort;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JEfListTest {

    @Test
    public void descendingOrder() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        JEfList.descendingOrder(list);
        List<Integer> result = new ArrayList<>();
        result.add(3);
        result.add(2);
        result.add(1);
        for(int i=0; i<result.size(); i++){
            Assert.assertEquals(result.get(i), list.get(i));
        }
    }

    @Test
    public void ascendingOrder() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        JEfList.ascendingOrder(list);
        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(2);
        result.add(3);
        for(int i=0; i<result.size(); i++){
            Assert.assertEquals(result.get(i), list.get(i));
        }
    }

    @Test
    public void sortByLength() {
        List<String> list = new ArrayList<>();
        list.add("Test");
        list.add("TestTestTestTest");
        list.add("TestTestTest");
        list.add("Test");

        JEfList.sortByLength(list);

        List<String> result = new ArrayList<>();
        result.add("Test");
        result.add("Test");
        result.add("TestTestTest");
        result.add("TestTestTestTest");

        for(int i=0; i<result.size(); i++){
            Assert.assertEquals(result.get(i), list.get(i));
        }
    }

    @Test
    public void sortByLengthDesc() {
        List<String> list = new ArrayList<>();
        list.add("Test");
        list.add("TestTestTestTest");
        list.add("TestTestTest");
        list.add("Test");

        JEfList.sortByLengthDesc(list);

        List<String> result = new ArrayList<>();
        result.add("TestTestTestTest");
        result.add("TestTestTest");
        result.add("Test");
        result.add("Test");

        for(int i=0; i<result.size(); i++){
            Assert.assertEquals(result.get(i), list.get(i));
        }
    }

    @Test
    public void alphabeticalCharOrder() {

        List<Character> list = new ArrayList<>();
        list.add('g');
        list.add('a');
        list.add('g');
        list.add('b');
        list.add('c');
        list.add('g');

        JEfList.alphabeticalCharOrder(list);

        List<Character> result = new ArrayList<>();
        result.add('a');
        result.add('b');
        result.add('c');
        result.add('g');
        result.add('g');
        result.add('g');

        for(int i=0; i<result.size(); i++){
            Assert.assertEquals(result.get(i), list.get(i));
        }
    }

    @Test
    public void alphabeticalOrder() {

        List<String> list = new ArrayList<>();
        list.add("Test");
        list.add("TestTestTestTest");
        list.add("TestTestTest");
        list.add("Test");
        list.add("Try");
        list.add("ABC");

        JEfList.alphabeticalOrder(list);

        List<String> result = new ArrayList<>();
        result.add("ABC");
        result.add("Test");
        result.add("Test");
        result.add("TestTestTest");
        result.add("TestTestTestTest");
        result.add("Try");

        for(int i=0; i<result.size(); i++){
            Assert.assertEquals(result.get(i), list.get(i));
        }
    }

    @Test
    public void reverseAlphabeticalCharOrder() {

        List<Character> list = new ArrayList<>();
        list.add('g');
        list.add('a');
        list.add('g');
        list.add('b');
        list.add('c');
        list.add('g');

        JEfList.alphabeticalCharOrder(list);

        List<Character> result = new ArrayList<>();
        result.add('g');
        result.add('g');
        result.add('g');
        result.add('c');
        result.add('b');
        result.add('a');

        JEfList.reverseAlphabeticalCharOrder(list);

        for(int i=0; i<result.size(); i++){
            Assert.assertEquals(result.get(i), list.get(i));
        }
    }

    @Test
    public void reverseAlphabeticalOrder() {

        List<String> list = new ArrayList<>();
        list.add("Test");
        list.add("TestTestTestTest");
        list.add("TestTestTest");
        list.add("Test");
        list.add("Try");
        list.add("ABC");

        JEfList.reverseAlphabeticalOrder(list);

        List<String> result = new ArrayList<>();
        result.add("Try");
        result.add("TestTestTestTest");
        result.add("TestTestTest");
        result.add("Test");
        result.add("Test");
        result.add("ABC");

        for(int i=0; i<result.size(); i++){
            Assert.assertEquals(result.get(i), list.get(i));
        }

    }

    @Test
    public void orderBySpecial() {

        TempInner firstInner = new TempInner("BBB","ZZZ",1);
        TempInner secondInner = new TempInner("AAA","EEE",2);
        TempInner thirdInner = new TempInner("CCC","DDD",3);

        Temp firstTemp = new Temp("BBA", "XXX",1,firstInner);
        Temp secondTemp = new Temp("BBZ", "XBX",1,secondInner);
        Temp thirdTemp = new Temp("BBB", "BBX",1,thirdInner);

        List<Temp> list = new ArrayList<>();
        list.add(firstTemp);
        list.add(secondTemp);
        list.add(thirdTemp);

        List<Temp> result = new ArrayList<>();
        result.add(firstTemp);
        result.add(thirdTemp);
        result.add(secondTemp);

        JEfList.orderBySpecial(list, "parameter1");
        Assert.assertEquals(list,result);
    }

    @Test
    public void orderBySpecials() {
        TempInner firstInner = new TempInner("BBB","ZZZ",3);
        TempInner secondInner = new TempInner("AAA","EEE",1);
        TempInner thirdInner = new TempInner("CCC","DDD",2);

        Temp firstTemp = new Temp("BBA", "XXX",3,firstInner);
        Temp secondTemp = new Temp("BBZ", "XBX",1,secondInner);
        Temp thirdTemp = new Temp("BBA", "BBX",1,thirdInner);

        List<Temp> list = new ArrayList<>();
        list.add(firstTemp);
        list.add(secondTemp);
        list.add(thirdTemp);

        List<Temp> result = new ArrayList<>();
        result.add(thirdTemp);
        result.add(firstTemp);
        result.add(secondTemp);

        List<String> parameters = new ArrayList<>();
        parameters.add("parameter1");
        parameters.add("parameter3");
        JEfList.orderBySpecials(list, parameters);
        Assert.assertEquals(list,result);
    }

    @Test
    public void alphabeticalOrderWithSubString() {
        List<String> list = new ArrayList<>();
        list.add("Gorkem");
        list.add("Genc");
        list.add("Zarkm");

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("Zarkm");
        expectedResult.add("Genc");
        expectedResult.add("Gorkem");

        JEfList.alphabeticalOrderWithSubString(list,1, list.get(1).length()-1);
        Assert.assertEquals(list,expectedResult);
    }

    @Test
    public void bubbleSort() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);

        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(1);
        result.add(2);
        result.add(3);

        List<Integer> expected = JEfList.bubbleSort(list);
        Assert.assertEquals(result,expected);
    }

    @Test
    public void mergeSort() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);

        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(1);
        result.add(2);
        result.add(3);

        List<Integer> expected = JEfList.mergeSort(list);
        Assert.assertEquals(result,expected);
    }

    @Test
    public void quickSort() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);

        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(1);
        result.add(2);
        result.add(3);

        List<Integer> expected = JEfList.quickSort(list);
        Assert.assertEquals(result,expected);
    }

    @Test
    public void insertionSort() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);

        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(1);
        result.add(2);
        result.add(3);

        List<Integer> expected = JEfList.insertionSort(list);
        Assert.assertEquals(result,expected);
    }

    @Test
    public void heapSort() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);

        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(1);
        result.add(2);
        result.add(3);

        List<Integer> expected = JEfList.bubbleSort(list);
        Assert.assertEquals(result,expected);
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