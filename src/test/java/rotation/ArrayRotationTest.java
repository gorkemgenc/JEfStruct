package rotation;

import Enums.Direction;
import exceptions.ArrayNullException;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ArrayRotationTest extends TestCase {

    @Test
    public void testRotateForInteger() {
        Integer[] arrayLeft = new Integer[]{1,2,3,4,5};
        ArrayRotation.rotate(arrayLeft, Direction.LEFT,2);
        Assert.assertArrayEquals(arrayLeft, new Integer[]{3,4,5,1,2});

        Integer[] arrayRight = new Integer[]{1,2,3,4,5};
        ArrayRotation.rotate(arrayRight, Direction.RIGHT,2);
        Assert.assertArrayEquals(arrayRight, new Integer[]{4,5,1,2,3});
    }

    @Test
    public void testRotateForString() {
        String[] arrayLeft = new String[]{"11","12","13","14","15"};
        ArrayRotation.rotate(arrayLeft, Direction.LEFT,2);
        Assert.assertArrayEquals(arrayLeft, new String[]{"13","14","15","11","12"});

        String[] arrayRight = new String[]{"11","12","13","14","15"};
        ArrayRotation.rotate(arrayRight, Direction.RIGHT,2);
        Assert.assertArrayEquals(arrayRight, new String[]{"14","15","11","12","13"});
    }

    @Test
    public void testRotateForObject() {

        Temp[] objects = new Temp[4];
        objects[0] = new Temp("Gorkem1", 21);
        objects[1] = new Temp("Gorkem2", 22);
        objects[2] = new Temp("Gorkem3", 23);
        objects[3] = new Temp("Gorkem4", 24);

        Temp[] result = new Temp[4];
        result[0] = new Temp("Gorkem3", 23);
        result[1] = new Temp("Gorkem4", 24);
        result[2] = new Temp("Gorkem1", 21);
        result[3] = new Temp("Gorkem2", 22);

        ArrayRotation.rotate(objects, Direction.LEFT,2);
        for(int i=0; i<objects.length; i++){
            Assert.assertEquals(objects[i].get_name(), result[i].get_name());
            Assert.assertEquals(objects[i].get_age(), result[i].get_age());
        }
    }

    @Test
    public void testRotateIfCountIsZero() {
        Integer[] arrayLeft = new Integer[]{1,2,3,4,5};
        ArrayRotation.rotate(arrayLeft, Direction.LEFT,0);
        Assert.assertArrayEquals(arrayLeft, new Integer[]{1,2,3,4,5});

        Integer[] arrayRight = new Integer[]{1,2,3,4,5};
        ArrayRotation.rotate(arrayRight, Direction.RIGHT,0);
        Assert.assertArrayEquals(arrayRight, new Integer[]{1,2,3,4,5});
    }

    @Test
    public void testRotateIfCountEqualsLength(){
        String[] arrayLeft = new String[]{"11","12","13","14","15"};
        ArrayRotation.rotate(arrayLeft, Direction.LEFT, arrayLeft.length);
        Assert.assertArrayEquals(arrayLeft, new String[]{"11","12","13","14","15"});
    }

    @Test
    public void testRotateIfCountGreaterThenLength(){
        String[] arrayLeft = new String[]{"11","12","13","14","15"};
        ArrayRotation.rotate(arrayLeft, Direction.LEFT,arrayLeft.length+2);
        Assert.assertArrayEquals(arrayLeft, new String[]{"13","14","15","11","12"});

        String[] arrayRight = new String[]{"11","12","13","14","15"};
        ArrayRotation.rotate(arrayRight, Direction.RIGHT,arrayRight.length+2);
        Assert.assertArrayEquals(arrayRight, new String[]{"14","15","11","12","13"});
    }

    @Test(expected = ArrayNullException.class)
    public void testArrayNullException(){
        try {
            ArrayRotation.rotate(null, Direction.LEFT,2);
            fail( "Array is null" );
        }
        catch (ArrayNullException expectedException) {
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