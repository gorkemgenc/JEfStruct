package jEfModify;

import jEfEnums.JEfDirection;
import jEfExceptions.JEfListNullException;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class JEfListTest extends TestCase {

    @Test
    public void testRotateForInteger() {
        Integer[] array = new Integer[]{1,2,3,4,5};
        List<Integer> listLeft = addToList(array);

        Integer[] arrayResult = new Integer[]{3,4,5,1,2};
        List<Integer> listLeftResult = addToList(arrayResult);

        JEfList.rotate(listLeft, JEfDirection.LEFT,2);
        Assert.assertTrue(listLeft.equals(listLeftResult));

        Integer[] arrayRight = new Integer[]{1,2,3,4,5};
        List<Integer> listRight = addToList(arrayRight);

        arrayResult = new Integer[]{4,5,1,2,3};
        List<Integer> listRightResult = addToList(arrayResult);

        JEfList.rotate(listRight, JEfDirection.RIGHT,2);
        Assert.assertTrue(listRight.equals(listRightResult));
    }

    @Test
    public void testRotateForString() {
        String[] arrayLeft = new String[]{"11","12","13","14","15"};
        List<String> listLeft = addToList(arrayLeft);

        String[] arrayResult = new String[]{"13","14","15","11","12"};
        List<String> listLeftResult = addToList(arrayResult);

        JEfList.rotate(listLeft, JEfDirection.LEFT,2);
        Assert.assertTrue(listLeft.equals(listLeftResult));

        String[] arrayRight = new String[]{"11","12","13","14","15"};
        List<String> listRight = addToList(arrayRight);

        arrayResult = new String[]{"14","15","11","12","13"};
        List<String> listRightResult = addToList(arrayResult);

        JEfList.rotate(listRight, JEfDirection.RIGHT,2);
        Assert.assertTrue(listRight.equals(listRightResult));
    }

    @Test
    public void testRotateForObject() {

        List<Temp> objects = new ArrayList<>();
        objects.add(new Temp("Test1", 21));
        objects.add(new Temp("Test2", 22));
        objects.add(new Temp("Test3", 23));
        objects.add(new Temp("Test4", 24));

        List<Temp> result = new ArrayList<>();
        result.add(new Temp("Test3", 23));
        result.add(new Temp("Test4", 24));
        result.add(new Temp("Test1", 21));
        result.add(new Temp("Test2", 22));

        JEfList.rotate(objects, JEfDirection.LEFT,2);
        for(int i=0; i<objects.size(); i++){
            Assert.assertEquals(objects.get(i).get_name(), result.get(i).get_name());
            Assert.assertEquals(objects.get(i).get_age(), result.get(i).get_age());
        }
    }

    @Test
    public void testRotateIfCountIsZero() {
        Integer[] arrayLeft = new Integer[]{1,2,3,4,5};
        List<Integer> listLeft = addToList(arrayLeft);

        JEfList.rotate(listLeft, JEfDirection.LEFT,0);
        Integer[] resultArray = new Integer[]{1,2,3,4,5};
        List<Integer> resultList = addToList(resultArray);
        Assert.assertTrue(listLeft.equals(resultList));
    }

    @Test
    public void testRotateIfCountEqualsLength(){
        String[] arrayLeft = new String[]{"11","12","13","14","15"};
        List<String> listLeft = addToList(arrayLeft);

        String[] resultLeft = new String[]{"11","12","13","14","15"};
        List<String> resultListLeft = addToList(resultLeft);

        JEfList.rotate(listLeft, JEfDirection.LEFT, arrayLeft.length);
        Assert.assertTrue(listLeft.equals(resultListLeft));
    }

    @Test
    public void testRotateIfCountGreaterThenLength(){
        String[] arrayLeft = new String[]{"11","12","13","14","15"};
        List<String> listLeft = addToList(arrayLeft);

        String[] resultLeft = new String[]{"13","14","15","11","12"};
        List<String> resultListLeft = addToList(resultLeft);

        JEfList.rotate(listLeft, JEfDirection.LEFT,arrayLeft.length+2);
        Assert.assertTrue(listLeft.equals(resultListLeft));

        String[] arrayRight = new String[]{"11","12","13","14","15"};
        List<String> listRight = addToList(arrayRight);

        String[] resultRight = new String[]{"14","15","11","12","13"};
        List<String> resultListRight = addToList(resultRight);

        JEfList.rotate(listRight, JEfDirection.RIGHT,arrayRight.length+2);
        Assert.assertTrue(listRight.equals(resultListRight));
    }

    @Test(expected = JEfListNullException.class)
    public void testListNullException(){
        try {
            JEfList.rotate(null, JEfDirection.LEFT,2);
            fail( "List is null" );
        }
        catch (JEfListNullException expectedException) {
        }
    }

    private static <T> List<T> addToList(T[] array){
        List<T> result = new ArrayList<T>();
        for(T temp : array){
            result.add(temp);
        }
        return result;
    }

    class Temp{
        private String _name;
        private int _age;

        public Temp(String name, int age){
            _name = name;
            _age = age;
        }

        public String get_name() {
            return _name;
        }

        public int get_age() {
            return _age;
        }
    }
}