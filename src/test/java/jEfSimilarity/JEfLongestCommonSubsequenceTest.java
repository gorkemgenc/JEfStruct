package jEfSimilarity;

import jEfExceptions.JEfArrayNullException;
import jEfExceptions.JEfStringNullException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class JEfLongestCommonSubsequenceTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void longestCommonSubsequenceStringFirst() {
        String str1 = "ABCDGH";
        String str2 = "AEDFHR";
        Assert.assertEquals(JEfLongestCommonSubsequence.longestCommonSubsequenceString(str1,str2), 3);
    }

    @Test
    public void longestCommonSubsequenceStringSecond() {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        Assert.assertEquals(JEfLongestCommonSubsequence.longestCommonSubsequenceString(str1,str2), 4);
    }

    @Test
    public void longestCommonSubsequenceFirst() {
        String[] array1 = new String[]{"Gorkem", "Genc", "Try"};
        String[] array2 = new String[]{"Gorkem", "Try"};
        Assert.assertEquals(JEfLongestCommonSubsequence.longestCommonSubsequence(array1,array2), 2);
    }

    @Test
    public void cosineSimilarityThrowStringException() throws JEfStringNullException {

        expectedEx.expect(JEfStringNullException.class);
        expectedEx.expectMessage("String is null");
        JEfLongestCommonSubsequence.longestCommonSubsequenceString(null,null);
    }

    @Test
    public void cosineSimilarityThrowArrayException() throws JEfArrayNullException {

        expectedEx.expect(JEfArrayNullException.class);
        expectedEx.expectMessage("Array is null");
        JEfLongestCommonSubsequence.longestCommonSubsequence(null,null);
    }
}