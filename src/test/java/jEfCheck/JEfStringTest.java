package jEfCheck;

import jEfExceptions.JEfStringNullException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class JEfStringTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void isUniqueTest() {
        String str = "Gorkem";
        Assert.assertTrue(JEfString.isUnique(str));
    }

    @Test
    public void isNotUniqueTest() {
        String str = "GorkemGorkem";
        Assert.assertFalse(JEfString.isUnique(str));
    }

    @Test
    public void hasUniqueElementThrowException() throws JEfStringNullException {
        expectedEx.expect(JEfStringNullException.class);
        expectedEx.expectMessage("String is null");
        JEfString.isUnique(null);
    }
}