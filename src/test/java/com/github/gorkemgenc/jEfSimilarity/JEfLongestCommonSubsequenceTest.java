package com.github.gorkemgenc.jEfSimilarity;

import com.github.gorkemgenc.jEfExceptions.JEfArrayNullException;
import com.github.gorkemgenc.jEfExceptions.JEfStringNullException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class JEfLongestCommonSubsequenceTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void longestCommonSubsequenceStringFirstTest() {
        String str1 = "ABCDGH";
        String str2 = "AEDFHR";
        Assert.assertEquals(JEfLongestCommonSubsequence.longestCommonSubsequenceString(str1,str2), 3);
    }

    @Test
    public void longestCommonSubsequenceStringSecondTest() {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        Assert.assertEquals(JEfLongestCommonSubsequence.longestCommonSubsequenceString(str1,str2), 4);
    }

    @Test
    public void longestCommonSubsequenceFirstTest() {
        String[] array1 = new String[]{"Gorkem", "Genc", "Try"};
        String[] array2 = new String[]{"Gorkem", "Try"};
        Assert.assertEquals(JEfLongestCommonSubsequence.longestCommonSubsequence(array1,array2), 2);
    }

    @Test
    public void cosineSimilarityThrowStringExceptionTest() throws JEfStringNullException {

        expectedEx.expect(JEfStringNullException.class);
        expectedEx.expectMessage("String should not be null");
        JEfLongestCommonSubsequence.longestCommonSubsequenceString(null,null);
    }

    @Test
    public void cosineSimilarityThrowArrayExceptionTest() throws JEfArrayNullException {

        expectedEx.expect(JEfArrayNullException.class);
        expectedEx.expectMessage("Array should not be null.");
        JEfLongestCommonSubsequence.longestCommonSubsequence(null,null);
    }
}