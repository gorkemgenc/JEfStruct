package rotation;

import Enums.Direction;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ArrayRotationTest extends TestCase {

    @Test
    public void testRotateForInteger() {
        Integer[] array = new Integer[]{1,2,3,4,5};
        ArrayRotation.rotate(array, Direction.LEFT,2);
        Assert.assertEquals(array, new Integer[]{3,4,5,1,2});
    }

    @Test
    public void testRotateForString() {

    }

    @Test
    public void testRotateForObject() {

    }

    @Test
    public void testRotateIfCountIsZero() {

    }

    @Test
    public void testRotateIfCountEqualsLength(){

    }

    @Test
    public void testRotateIfCountGreaterThenLength(){

    }

    @Test
    public void testRotateThrowException(){

    }
}