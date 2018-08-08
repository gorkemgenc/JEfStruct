package jEfrotation;

import jEfenums.Direction;
import jEfexceptions.StringNullException;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class jEfStringTest extends TestCase {

    @Test
    public void testRotate() {
        String first = "abcde";
        String result = jEfString.rotate(first, Direction.LEFT,2);
        Assert.assertEquals(result, "cdeab");

        String second = "abcde";
        result = jEfString.rotate(second, Direction.RIGHT,2);
        Assert.assertEquals(result, "deabc");
    }

    @Test
    public void testRotateIfCountIsZero() {
        String str = "abcde";
        String result = jEfString.rotate(str, Direction.LEFT,0);
        Assert.assertEquals(result, "abcde");
    }

    @Test
    public void testRotateIfCountEqualsLength(){
        String first = "abcde";
        String result = jEfString.rotate(first, Direction.LEFT, first.length());
        Assert.assertEquals(result, "abcde");
    }

    @Test
    public void testRotateIfCountGreaterThenLength(){
        String first = "abcdef";
        String result = jEfString.rotate(first, Direction.LEFT,first.length()+2);
        Assert.assertEquals(result, "cdefab");

        String second = "abcdef";
        result = jEfString.rotate(first, Direction.RIGHT,second.length()+2);
        Assert.assertEquals(result, "efabcd");
    }

    @Test(expected = StringNullException.class)
    public void testArrayNullException(){
        try {
            jEfString.rotate(null, Direction.LEFT,2);
            fail( "String is null" );
        }
        catch (StringNullException expectedException) {
        }
    }
}