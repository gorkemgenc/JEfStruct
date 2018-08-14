package com.github.gorkemgenc.jEfModify;

import com.github.gorkemgenc.jEfEnums.JEfDirection;
import com.github.gorkemgenc.jEfExceptions.JEfArrayNullException;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class JEfArrayTest extends TestCase {

    @Test
    public void testRotateForInteger() {
        Integer[] arrayLeft = new Integer[]{1,2,3,4,5};
        JEfArray.rotate(arrayLeft, JEfDirection.LEFT,2);
        Assert.assertArrayEquals(arrayLeft, new Integer[]{3,4,5,1,2});

        Integer[] arrayRight = new Integer[]{1,2,3,4,5};
        JEfArray.rotate(arrayRight, JEfDirection.RIGHT,2);
        Assert.assertArrayEquals(arrayRight, new Integer[]{4,5,1,2,3});
    }

    @Test
    public void testRotateForString() {
        String[] arrayLeft = new String[]{"11","12","13","14","15"};
        JEfArray.rotate(arrayLeft, JEfDirection.LEFT,2);
        Assert.assertArrayEquals(arrayLeft, new String[]{"13","14","15","11","12"});

        String[] arrayRight = new String[]{"11","12","13","14","15"};
        JEfArray.rotate(arrayRight, JEfDirection.RIGHT,2);
        Assert.assertArrayEquals(arrayRight, new String[]{"14","15","11","12","13"});
    }

    @Test
    public void testRotateForObject() {

        Temp[] objects = new Temp[4];
        objects[0] = new Temp("Test1", 21);
        objects[1] = new Temp("Test2", 22);
        objects[2] = new Temp("Test3", 23);
        objects[3] = new Temp("Test4", 24);

        Temp[] result = new Temp[4];
        result[0] = new Temp("Test3", 23);
        result[1] = new Temp("Test4", 24);
        result[2] = new Temp("Test1", 21);
        result[3] = new Temp("Test2", 22);

        JEfArray.rotate(objects, JEfDirection.LEFT,2);
        for(int i=0; i<objects.length; i++){
            Assert.assertEquals(objects[i].get_name(), result[i].get_name());
            Assert.assertEquals(objects[i].get_age(), result[i].get_age());
        }
    }

    @Test
    public void testRotateIfCountIsZero() {
        Integer[] arrayLeft = new Integer[]{1,2,3,4,5};
        JEfArray.rotate(arrayLeft, JEfDirection.LEFT,0);
        Assert.assertArrayEquals(arrayLeft, new Integer[]{1,2,3,4,5});

        Integer[] arrayRight = new Integer[]{1,2,3,4,5};
        JEfArray.rotate(arrayRight, JEfDirection.RIGHT,0);
        Assert.assertArrayEquals(arrayRight, new Integer[]{1,2,3,4,5});
    }

    @Test
    public void testRotateIfCountEqualsLength(){
        String[] arrayLeft = new String[]{"11","12","13","14","15"};
        JEfArray.rotate(arrayLeft, JEfDirection.LEFT, arrayLeft.length);
        Assert.assertArrayEquals(arrayLeft, new String[]{"11","12","13","14","15"});
    }

    @Test
    public void testRotateIfCountGreaterThenLength(){
        String[] arrayLeft = new String[]{"11","12","13","14","15"};
        JEfArray.rotate(arrayLeft, JEfDirection.LEFT,arrayLeft.length+2);
        Assert.assertArrayEquals(arrayLeft, new String[]{"13","14","15","11","12"});

        String[] arrayRight = new String[]{"11","12","13","14","15"};
        JEfArray.rotate(arrayRight, JEfDirection.RIGHT,arrayRight.length+2);
        Assert.assertArrayEquals(arrayRight, new String[]{"14","15","11","12","13"});
    }

    @Test(expected = JEfArrayNullException.class)
    public void testArrayNullException(){
        try {
            JEfArray.rotate(null, JEfDirection.LEFT,2);
            fail( "Array is null" );
        }
        catch (JEfArrayNullException expectedException) {
        }
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