package rotation;

import enums.Direction;
import exceptions.StringNullException;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class StringRotationTest extends TestCase {

    @Test
    public void testRotate() {
        String first = "abcde";
        String result = StringRotation.rotate(first, Direction.LEFT,2);
        Assert.assertEquals(result, "cdeab");

        String second = "abcde";
        result = StringRotation.rotate(second, Direction.RIGHT,2);
        Assert.assertEquals(result, "deabc");
    }

    @Test
    public void testRotateIfCountIsZero() {
        String str = "abcde";
        String result = StringRotation.rotate(str, Direction.LEFT,0);
        Assert.assertEquals(result, "abcde");
    }

    @Test
    public void testRotateIfCountEqualsLength(){
        String first = "abcde";
        String result = StringRotation.rotate(first, Direction.LEFT, first.length());
        Assert.assertEquals(result, "abcde");
    }

    @Test
    public void testRotateIfCountGreaterThenLength(){
        String first = "abcdef";
        String result = StringRotation.rotate(first, Direction.LEFT,first.length()+2);
        Assert.assertEquals(result, "cdefab");

        String second = "abcdef";
        result = StringRotation.rotate(first, Direction.RIGHT,second.length()+2);
        Assert.assertEquals(result, "efabcd");
    }

    @Test(expected = StringNullException.class)
    public void testArrayNullException(){
        try {
            StringRotation.rotate(null, Direction.LEFT,2);
            fail( "String is null" );
        }
        catch (StringNullException expectedException) {
        }
    }
}