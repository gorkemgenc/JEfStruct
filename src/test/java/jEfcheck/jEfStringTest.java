package jEfcheck;

import jEfexceptions.StringNullException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class jEfStringTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void isUniqueTest() {
        String str = "Gorkem";
        Assert.assertTrue(jEfString.isUnique(str));
    }

    @Test
    public void isNotUniqueTest() {
        String str = "GorkemGorkem";
        Assert.assertFalse(jEfString.isUnique(str));
    }

    @Test
    public void hasUniqueElementThrowException() throws StringNullException {
        expectedEx.expect(StringNullException.class);
        expectedEx.expectMessage("String is null");
        jEfString.isUnique(null);
    }
}