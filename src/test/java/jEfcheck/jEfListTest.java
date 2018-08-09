package jEfcheck;

import jEfexceptions.ListNullException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class jEfListTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void hasUniqueElementSizeZero() {
        List<Integer> list = new ArrayList<>();
        Assert.assertTrue(jEfList.hasUniqueElement(list));
    }

    @Test
    public void hasUniqueElementSizeOne() {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        Assert.assertTrue(jEfList.hasUniqueElement(list));
    }

    @Test
    public void hasUniqueElementForIntegerReturnTrue() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(10);

        Assert.assertTrue(jEfList.hasUniqueElement(list));
    }

    @Test
    public void hasUniqueElementForIntegerReturnFalse() {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);

        Assert.assertFalse(jEfList.hasUniqueElement(list));
    }

    @Test
    public void hasUniqueElementReturnTrue() {
        class Temp{
            String name;
            int count;

            Temp(String name, int count){
                this.name = name;
                this.count = count;
            }
        }

        List<Temp> tempList = new ArrayList<>();
        tempList.add(new Temp("Gorkem",1));
        tempList.add(new Temp("Genc", 22));
        tempList.add(new Temp("Gorkem", 1));

        Assert.assertFalse(jEfList.hasUniqueElement(tempList));
    }

    @Test
    public void hasUniqueElementReturnFalse() {
        class Temp{
            String name;
            int count;

            Temp(String name, int count){
                this.name = name;
                this.count = count;
            }
        }

        List<Temp> tempList = new ArrayList<>();
        Temp temp1 = new Temp("Gorkem", 1);
        Temp temp2 = new Temp("Genc", 12);
        Temp temp3 = new Temp("Gorkem", 1);


        tempList.add(temp2);
        tempList.add(temp1);
        tempList.add(temp3);

        Assert.assertFalse(jEfList.hasUniqueElement(tempList));
    }

    @Test
    public void hasUniqueElementForObjectReturnTrue() {
        class Temp{
            String name;
            int count;

            Temp(String name, int count){
                this.name = name;
                this.count = count;
            }
        }

        List<Temp> tempList = new ArrayList<>();
        tempList.add(new Temp("Gorkem",1));
        tempList.add(new Temp("Genc", 22));
        tempList.add(new Temp("Temp1", 1));

        Assert.assertTrue(jEfList.hasUniqueElement(tempList));
    }

    @Test
    public void hasUniqueElementThrowException() throws ListNullException {
        expectedEx.expect(ListNullException.class);
        expectedEx.expectMessage("List is null");
        jEfList.hasUniqueElement(null);
    }

    @Test
    public void isArraysSameReturnTrue() {
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        firstList.add(2);
        firstList.add(3);

        List<Integer> secondList = new ArrayList<>();
        secondList.add(1);
        secondList.add(2);
        secondList.add(3);

        List<List<Integer>> list = new ArrayList<>();
        list.add(firstList);
        list.add(secondList);

        Assert.assertTrue(jEfList.isListsSame(list));
    }

    @Test
    public void isArraysSameReturnMoreThanArrayTrue() {

        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        firstList.add(2);
        firstList.add(3);

        List<Integer> secondList = new ArrayList<>();
        secondList.add(1);
        secondList.add(2);
        secondList.add(3);

        List<Integer> thirdList = new ArrayList<>();
        thirdList.add(1);
        thirdList.add(2);
        thirdList.add(3);

        List<List<Integer>> list = new ArrayList<>();
        list.add(firstList);
        list.add(secondList);
        list.add(secondList);

        Assert.assertTrue(jEfList.isListsSame(list));
    }

    @Test
    public void isArraysSameReturnFalseArray() {

        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        firstList.add(2);
        firstList.add(3);

        List<Integer> secondList = new ArrayList<>();
        secondList.add(1);
        secondList.add(2);
        secondList.add(3);
        secondList.add(4);

        List<Integer> thirdList = new ArrayList<>();
        thirdList.add(1);
        thirdList.add(2);

        List<List<Integer>> list = new ArrayList<>();
        list.add(firstList);
        list.add(secondList);
        list.add(secondList);

        Assert.assertFalse(jEfList.isListsSame(list));
    }

    @Test
    public void isArraysSameReturnTrueForOneList() {
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        firstList.add(2);
        firstList.add(3);
        List<List<Integer>> test = new ArrayList<>();
        test.add(firstList);

        Assert.assertTrue(jEfList.isListsSame(test));
    }

    @Test
    public void permuteThrowException() throws ListNullException {
        expectedEx.expect(ListNullException.class);
        expectedEx.expectMessage("List is null");
        jEfList.permute(null);
    }

    @Test
    public void permuteForOneElement() {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> expectedResult = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        expectedResult.add(temp);

        result = jEfList.permute(list);

        for(int i=0; i<result.size(); i++){
            for(int j=0; j<result.get(i).size(); j++){
                Assert.assertEquals(result.get(i).get(j), expectedResult.get(i).get(j));
            }
        }
    }

    @Test
    public void permuteForMoreThanOneElement() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> expectedResult = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        expectedResult.add(temp);
        temp = new ArrayList<>();
        temp.add(2);
        temp.add(1);
        expectedResult.add(temp);
        result = jEfList.permute(list);

        for(int i=0; i<result.size(); i++){
            for(int j=0; j<result.get(i).size(); j++){
                Assert.assertEquals(result.get(i).get(j), expectedResult.get(i).get(j));
            }
        }
    }
}