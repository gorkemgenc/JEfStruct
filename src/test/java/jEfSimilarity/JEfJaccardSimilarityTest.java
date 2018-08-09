package jEfSimilarity;

import jEfExceptions.JEfArrayNullException;
import jEfExceptions.JEfListNullException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;


public class JEfJaccardSimilarityTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void jaccardSimilarity() {
        int[] first = new int[]{1,1,0,1};
        int[] second = new int[]{2,0,1,1};

        double result = JEfJaccardSimilarity.jaccardSimilarity(first,second);
        double expectedResult = 0.6666666666666666;

        Assert.assertEquals(result,expectedResult,0);
    }

    @Test
    public void cosineSimilarityThrowException() throws JEfArrayNullException {

        expectedEx.expect(JEfArrayNullException.class);
        expectedEx.expectMessage("Array is null");
        JEfJaccardSimilarity.jaccardSimilarity(null, null);
    }

    @Test
    public void jaccardSimilarityForList() {

        List<Integer> first = new ArrayList<>();
        first.add(1);
        first.add(1);
        first.add(0);
        first.add(1);

        List<Integer> second = new ArrayList<>();
        second.add(2);
        second.add(0);
        second.add(1);
        second.add(1);

        double result = JEfJaccardSimilarity.jaccardSimilarityForList(first,second);
        double expectedResult = 0.6666666666666666;

        Assert.assertEquals(result,expectedResult,0);
    }

    @Test
    public void cosineSimilarityForListException() throws JEfListNullException {

        expectedEx.expect(JEfListNullException.class);
        expectedEx.expectMessage("List is null");
        JEfJaccardSimilarity.jaccardSimilarityForList(null, null);
    }
}