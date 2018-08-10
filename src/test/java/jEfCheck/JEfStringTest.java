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
    public void uniqueTest() {
        String parameter = "Test";
        Assert.assertTrue(JEfString.unique(parameter));
    }

    @Test
    public void notUniqueTest() {
        String parameter = "TestTest";
        Assert.assertFalse(JEfString.unique(parameter));
    }

    @Test
    public void uniqueThrowException() throws JEfStringNullException {
        expectedEx.expect(JEfStringNullException.class);
        expectedEx.expectMessage("String is null");
        JEfString.unique(null);
    }
}