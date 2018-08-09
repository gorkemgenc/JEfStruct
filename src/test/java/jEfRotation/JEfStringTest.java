package jEfRotation;

import jEfEnums.JEfDirection;
import jEfExceptions.JEfStringNullException;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class JEfStringTest extends TestCase {

    @Test
    public void testRotate() {
        String first = "abcde";
        String result = JEfString.rotate(first, JEfDirection.LEFT,2);
        Assert.assertEquals(result, "cdeab");

        String second = "abcde";
        result = JEfString.rotate(second, JEfDirection.RIGHT,2);
        Assert.assertEquals(result, "deabc");
    }

    @Test
    public void testRotateIfCountIsZero() {
        String str = "abcde";
        String result = JEfString.rotate(str, JEfDirection.LEFT,0);
        Assert.assertEquals(result, "abcde");
    }

    @Test
    public void testRotateIfCountEqualsLength(){
        String first = "abcde";
        String result = JEfString.rotate(first, JEfDirection.LEFT, first.length());
        Assert.assertEquals(result, "abcde");
    }

    @Test
    public void testRotateIfCountGreaterThenLength(){
        String first = "abcdef";
        String result = JEfString.rotate(first, JEfDirection.LEFT,first.length()+2);
        Assert.assertEquals(result, "cdefab");

        String second = "abcdef";
        result = JEfString.rotate(first, JEfDirection.RIGHT,second.length()+2);
        Assert.assertEquals(result, "efabcd");
    }

    @Test(expected = JEfStringNullException.class)
    public void testArrayNullException(){
        try {
            JEfString.rotate(null, JEfDirection.LEFT,2);
            fail( "String is null" );
        }
        catch (JEfStringNullException expectedException) {
        }
    }
}