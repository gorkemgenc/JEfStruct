package jEfCheck;

import jEfExceptions.JEfListNullException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JEfListTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void uniqueSizeZeroTest() {
        List<Integer> list = new ArrayList<>();
        Assert.assertTrue(JEfList.unique(list));
    }

    @Test
    public void uniqueSizeOneTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        Assert.assertTrue(JEfList.unique(list));
    }

    @Test
    public void uniqueForIntegerReturnTrueTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(10);

        Assert.assertTrue(JEfList.unique(list));
    }

    @Test
    public void uniqueForIntegerReturnFalseTest() {

        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1,2,3,2,5,4));
        Assert.assertFalse(JEfList.unique(list));
    }

    @Test
    public void uniqueReturnTrueTest() {
        class Temp{
            String name;
            int count;

            Temp(String name, int count){
                this.name = name;
                this.count = count;
            }
        }

        List<Temp> tempList = new ArrayList<>();
        tempList.add(new Temp("Test",1));
        tempList.add(new Temp("Try", 22));
        tempList.add(new Temp("Test", 1));

        Assert.assertFalse(JEfList.unique(tempList));
    }

    @Test
    public void uniqueReturnFalseTest() {

        List<Temp> tempList = new ArrayList<>();
        Temp temp1 = new Temp("Test", 1);
        Temp temp2 = new Temp("Try", 12);
        Temp temp3 = new Temp("Test", 1);
        tempList.addAll(Arrays.asList(temp2, temp1, temp3));

        Assert.assertFalse(JEfList.unique(tempList));
    }

    @Test
    public void uniqueForObjectReturnTrueTest() {

        List<Temp> tempList = new ArrayList<>();
        tempList.add(new Temp("Test",1));
        tempList.add(new Temp("Try", 22));
        tempList.add(new Temp("Temp", 1));

        Assert.assertTrue(JEfList.unique(tempList));
    }

    @Test
    public void uniqueThrowExceptionTest() throws JEfListNullException {
        expectedEx.expect(JEfListNullException.class);
        expectedEx.expectMessage("List is null");
        JEfList.unique(null);
    }

    @Test
    public void sameReturnTrueTest() {
        List<Integer> firstList = new ArrayList<>();
        firstList.addAll(Arrays.asList(1,2,3));

        List<Integer> secondList = new ArrayList<>();
        secondList.addAll(Arrays.asList(1,2,3));

        List<List<Integer>> list = new ArrayList<>();
        list.addAll(Arrays.asList(firstList,secondList));

        Assert.assertTrue(JEfList.same(list));
    }

    @Test
    public void sameReturnMoreThanArrayTrueTest() {

        List<Integer> firstList = new ArrayList<>();
        firstList.addAll(Arrays.asList(1,2,3));

        List<Integer> secondList = new ArrayList<>();
        secondList.addAll(Arrays.asList(1,2,3));

        List<Integer> thirdList = new ArrayList<>();
        thirdList.addAll(Arrays.asList(1,2,3));

        List<List<Integer>> list = new ArrayList<>();
        list.addAll(Arrays.asList(firstList,secondList,thirdList));

        Assert.assertTrue(JEfList.same(list));
    }

    @Test
    public void sameReturnFalseArrayTest() {

        List<Integer> firstList = new ArrayList<>();
        firstList.addAll(Arrays.asList(1,2,3));

        List<Integer> secondList = new ArrayList<>();
        secondList.addAll(Arrays.asList(1,2,3,4));

        List<Integer> thirdList = new ArrayList<>();
        thirdList.addAll(Arrays.asList(1,2));

        List<List<Integer>> list = new ArrayList<>();
        list.addAll(Arrays.asList(firstList,secondList,thirdList));

        Assert.assertFalse(JEfList.same(list));
    }

    @Test
    public void sameReturnTrueForOneListTest() {
        List<Integer> firstList = new ArrayList<>();
        firstList.addAll(Arrays.asList(1,2,3));
        List<List<Integer>> test = new ArrayList<>();
        test.add(firstList);

        Assert.assertTrue(JEfList.same(test));
    }

    @Test
    public void permuteThrowExceptionTest() throws JEfListNullException {
        expectedEx.expect(JEfListNullException.class);
        expectedEx.expectMessage("List is null");
        JEfList.permute(null);
    }

    @Test
    public void permuteForOneElementTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        List<List<Integer>> result = JEfList.permute(list);
        List<List<Integer>> expectedResult = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        expectedResult.add(temp);

        JEfHelper.checkElementByElement(result,expectedResult);
    }

    @Test
    public void permuteForMoreThanOneElementTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        List<List<Integer>> result = JEfList.permute(list);
        List<List<Integer>> expectedResult = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        expectedResult.add(temp);
        temp = new ArrayList<>();
        temp.add(2);
        temp.add(1);
        expectedResult.add(temp);

        JEfHelper.checkElementByElement(result,expectedResult);
    }

    class Temp{
        String name;
        int count;

        Temp(String name, int count){
            this.name = name;
            this.count = count;
        }
    }
}