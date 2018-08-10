package jEfTransform;

import org.junit.Assert;
import org.junit.Test;

public class JEfStringTransformTest {

    @Test
    public void deduplicationTest() {
        String str = "testtestestabtestaa";
        String expectedResult = "tesab";
        String result = JEfStringTransform.deduplication(str, null);
        Assert.assertEquals(expectedResult,result);
    }

    @Test
    public void deduplicationIgnoreWithNullTest() {
        String str = "test tes testabtes taa";
        String expectedResult = "tes  ab ";
        String result = JEfStringTransform.deduplication(str,' ');
        Assert.assertEquals(expectedResult,result);
    }

    @Test
    public void deduplicationIgnoreWithCharTest() {
        String str = "testtestestabtestaa";
        String expectedResult = "testtttabtt";
        String result = JEfStringTransform.deduplication(str,'t');
        Assert.assertEquals(expectedResult,result);
    }
}