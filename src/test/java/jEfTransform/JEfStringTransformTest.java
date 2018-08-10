package jEfTransform;

import org.junit.Assert;
import org.junit.Test;

public class JEfStringTransformTest {

    @Test
    public void deduplication() {
        String str = "testtestestabtestaa";
        String expectedResult = "tesab";
        String result = JEfStringTransform.deduplication(str);
        Assert.assertEquals(expectedResult,result);
    }
}