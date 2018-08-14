package com.github.gorkemgenc.jEfSimilarity;

import com.github.gorkemgenc.jEfExceptions.JEfStringNullException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class JEfEditDistanceSimilarityTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void editDistanceTest() {
        String str1 = "sunday";
        String str2 = "saturday";

        Assert.assertEquals(JEfEditDistanceSimilarity.editDistance(str1,str2),3);
    }

    @Test
    public void edisDistanceWhenFirstLengthIsZeroTest(){
        String str1 = "abcds";
        String str2 = "";

        Assert.assertEquals(JEfEditDistanceSimilarity.editDistance(str1,str2), str1.length());
    }

    @Test
    public void editDistanceThrowExceptionTest() {
        expectedEx.expect(JEfStringNullException.class);
        expectedEx.expectMessage("String should not be null");
        JEfEditDistanceSimilarity.editDistance(null,null);
    }
}