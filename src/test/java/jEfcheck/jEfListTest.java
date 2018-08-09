package jEfcheck;

import jEfexceptions.ArrayNullException;
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

        Assert.assertTrue(jEfList.hasUniqueElement(tempList));
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
    public void hasUniqueElementThrowException() throws ArrayNullException {
        expectedEx.expect(ArrayNullException.class);
        expectedEx.expectMessage("Array is null");
        JeFArray.hasUniqueElement(null);
    }

    @Test
    public void isArraysSameReturnTrue() {
        Integer[] firstList = new Integer[]{1,2,3};
        Integer[] secondList = new Integer[]{1,2,3};
        Integer[] thirdList = new Integer[]{1,2,3};
        List<Integer[]> list = new ArrayList<>();
        list.add(firstList);
        list.add(secondList);
        list.add(thirdList);

        Assert.assertTrue(JeFArray.isArraysSame(list));
    }

    @Test
    public void isArraysSameReturnMoreThanArrayTrue() {
        Integer[] firstList = new Integer[]{1,2,3,3};
        Integer[] secondList = new Integer[]{1,3,3,2};
        Integer[] thirdList = new Integer[]{1,2,3,3};

        List<Integer[]> list = new ArrayList<>();
        list.add(firstList);
        list.add(secondList);
        list.add(thirdList);

        Assert.assertTrue(JeFArray.isArraysSame(list));
    }

    @Test
    public void isArraysSameReturnFalseArray() {
        Integer[] firstList = new Integer[]{1,2,3,4};
        Integer[] secondList = new Integer[]{1,2,3,4};
        Integer[] thirdList = new Integer[]{1,2,3};
        List<Integer[]> list = new ArrayList<>();
        list.add(firstList);
        list.add(secondList);
        list.add(thirdList);

        Assert.assertFalse(JeFArray.isArraysSame(list));
    }

    @Test
    public void isArraysSameReturnTrueForOneList() {
        Integer[] firstList = new Integer[]{1,2,3};
        List<Integer[]> list = new ArrayList<>();
        list.add(firstList);

        Assert.assertTrue(JeFArray.isArraysSame(list));
    }

    @Test
    public void isArraysSameReturnFalse() {
        Integer[] firstList = new Integer[]{1,2,3};
        Integer[] secondList = new Integer[]{4,5,6};
        Integer[] thirdList = new Integer[]{1,2,3};
        List<Integer[]> list = new ArrayList<>();
        list.add(firstList);
        list.add(secondList);
        list.add(thirdList);

        Assert.assertFalse(JeFArray.isArraysSame(list));
    }

    @Test
    public void permuteThrowException() throws ArrayNullException {
        expectedEx.expect(ArrayNullException.class);
        expectedEx.expectMessage("Array is null");
        JeFArray.permute(null);
    }

    @Test
    public void permuteForOneElement() {
        Integer[] array = new Integer[]{1};
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> expectedResult = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        expectedResult.add(temp);

        result = JeFArray.permute(array);

        for(int i=0; i<result.size(); i++){
            for(int j=0; j<result.get(i).size(); j++){
                Assert.assertEquals(result.get(i).get(j), expectedResult.get(i).get(j));
            }
        }
    }

    @Test
    public void permuteForMoreThanOneElement() {
        Integer[] array = new Integer[]{1,2};
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
        result = JeFArray.permute(array);

        for(int i=0; i<result.size(); i++){
            for(int j=0; j<result.get(i).size(); j++){
                Assert.assertEquals(result.get(i).get(j), expectedResult.get(i).get(j));
            }
        }
    }
}