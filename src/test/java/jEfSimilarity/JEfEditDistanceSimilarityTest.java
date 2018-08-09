package jEfSimilarity;

import jEfExceptions.JEfStringNullException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class JEfEditDistanceSimilarityTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void editDistance() {
        String str1 = "sunday";
        String str2 = "saturday";

        Assert.assertEquals(JEfEditDistanceSimilarity.editDistance(str1,str2),3);
    }

    @Test
    public void edisDistanceWhenFirstLengthIsZero(){
        String str1 = "abcds";
        String str2 = "";

        Assert.assertEquals(JEfEditDistanceSimilarity.editDistance(str1,str2), str1.length());
    }

    @Test
    public void editDistanceThrowException() {
        expectedEx.expect(JEfStringNullException.class);
        expectedEx.expectMessage("String is null");
        JEfEditDistanceSimilarity.editDistance(null,null);
    }
}