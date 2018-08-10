package jEfCheck;

import jEfExceptions.JEfArrayNullException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JEfArrayTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void uniqueSizeZeroTest() {
        Integer[] array = new Integer[0];
        Assert.assertTrue(JEfArray.unique(array));
    }

    @Test
    public void uniqueSizeOneTest() {
        Integer[] array = new Integer[]{1};
        Assert.assertTrue(JEfArray.unique(array));
    }

    @Test
    public void uniqueForIntegerReturnTrueTest() {
        Integer[] array = new Integer[]{1,2,3,10};
        Assert.assertTrue(JEfArray.unique(array));
    }

    @Test
    public void uniqueForIntegerReturnFalseTest() {
        Integer[] array = new Integer[]{1,2,3,2,5,4};
        Assert.assertFalse(JEfArray.unique(array));
    }

    @Test
    public void uniqueForObjectReturnTrueTest() {

        Temp[] tempList = new Temp[3];
        tempList[0] = new Temp("Gorkem",1);
        tempList[1] = new Temp("Genc", 22);
        tempList[2] = new Temp("Temp", 23);

        Assert.assertTrue(JEfArray.unique(tempList));
    }

    @Test
    public void uniqueForObjectReturnFalseTest() {

        Temp[] tempList = new Temp[3];
        tempList[0] = new Temp("Gorkem",1);
        tempList[1] = new Temp("Genc", 22);
        tempList[2] = new Temp("Gorkem", 1);

        Assert.assertFalse(JEfArray.unique(tempList));
    }

    @Test
    public void uniqueThrowExceptionTest() throws JEfArrayNullException {
        expectedEx.expect(JEfArrayNullException.class);
        expectedEx.expectMessage("Array null exception.");
        JEfArray.unique(null);
    }

    @Test
    public void isArraysSameReturnTrueTest() {

        Integer[] firstList = new Integer[]{1,2,3};
        Integer[] secondList = new Integer[]{1,2,3};
        Integer[] thirdList = new Integer[]{1,2,3};
        List<Integer[]> list = new ArrayList<>();
        list.addAll(Arrays.asList(firstList,secondList,thirdList));

        Assert.assertTrue(JEfArray.same(list));
    }

    @Test
    public void isArraysSameReturnMoreThanArrayTrueTest() {
        Integer[] firstList = new Integer[]{1,2,3,3};
        Integer[] secondList = new Integer[]{1,3,3,2};
        Integer[] thirdList = new Integer[]{1,2,3,3};
        List<Integer[]> list = new ArrayList<>();
        list.addAll(Arrays.asList(firstList,secondList,thirdList));

        Assert.assertTrue(JEfArray.same(list));
    }

    @Test
    public void isArraysSameReturnFalseArrayTest() {
        Integer[] firstList = new Integer[]{1,2,3,4};
        Integer[] secondList = new Integer[]{1,2,3,4};
        Integer[] thirdList = new Integer[]{1,2,3};
        List<Integer[]> list = new ArrayList<>();
        list.addAll(Arrays.asList(firstList,secondList,thirdList));

        Assert.assertFalse(JEfArray.same(list));
    }

    @Test
    public void isArraysSameReturnTrueForOneListTest() {
        Integer[] firstList = new Integer[]{1,2,3};
        List<Integer[]> list = new ArrayList<>();
        list.add(firstList);

        Assert.assertTrue(JEfArray.same(list));
    }

    @Test
    public void isArraysSameReturnFalseTest() {
        Integer[] firstList = new Integer[]{1,2,3};
        Integer[] secondList = new Integer[]{4,5,6};
        Integer[] thirdList = new Integer[]{1,2,3};
        List<Integer[]> list = new ArrayList<>();
        list.addAll(Arrays.asList(firstList,secondList,thirdList));

        Assert.assertFalse(JEfArray.same(list));
    }

    @Test
    public void permuteThrowExceptionTest() throws JEfArrayNullException {
        expectedEx.expect(JEfArrayNullException.class);
        expectedEx.expectMessage("Array null exception.");
        JEfArray.permute(null);
    }

    @Test
    public void permuteForOneElementTest() {
        Integer[] array = new Integer[]{1};
        List<List<Integer>> result = JEfArray.permute(array);
        List<List<Integer>> expectedResult = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        expectedResult.add(temp);

        JEfHelper.checkElementByElement(result,expectedResult);
    }

    @Test
    public void permuteForMoreThanOneElementTest() {
        Integer[] array = new Integer[]{1,2};
        List<List<Integer>> result = JEfArray.permute(array);
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

    private class Temp{
        String name;
        int count;

        Temp(String name, int count){
            this.name = name;
            this.count = count;
        }
    }
}