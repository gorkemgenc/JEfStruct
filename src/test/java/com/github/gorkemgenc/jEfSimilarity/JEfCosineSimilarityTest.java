package com.github.gorkemgenc.jEfSimilarity;

import com.github.gorkemgenc.jEfExceptions.JEfArrayLengthNotEqualException;
import com.github.gorkemgenc.jEfExceptions.JEfArrayNullException;
import com.github.gorkemgenc.jEfExceptions.JEfListNullException;
import com.github.gorkemgenc.jEfExceptions.JEfListSizeNotEqualException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.ArrayList;
import java.util.List;

public class JEfCosineSimilarityTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void cosineSimilarityTest() {
        double[] first = new double[]{1,0.5};
        double[] second = new double[]{0.5,1};
        double expected = 0.7999999999999998;
        Assert.assertEquals(expected, JEfCosineSimilarity.cosineSimilarity(first,second), 0);
    }

    @Test
    public void cosineSimilarityThrowExceptionTest() throws JEfArrayNullException{
        expectedEx.expect(JEfArrayNullException.class);
        expectedEx.expectMessage("Array should not be null.");
        JEfCosineSimilarity.cosineSimilarity(null, null);
    }

    @Test
    public void cosineSimilarityLengthNotEqualThrowExceptionTest() throws JEfArrayLengthNotEqualException{
        double[] first = new double[]{1,2};
        double[] second = new double[]{1};

        expectedEx.expect(JEfArrayLengthNotEqualException.class);
        expectedEx.expectMessage("Index out of range. ArrayLengthNotEqual Exception when comparing two array");
        JEfCosineSimilarity.cosineSimilarity(first, second);
    }

    @Test
    public void cosineSimilarityForListTest() {
        List<Double> first = new ArrayList<>();
        first.add(1.0);
        first.add(0.5);

        List<Double> second = new ArrayList<>();
        second.add(0.5);
        second.add(1.0);

        double expected = 0.7999999999999998;
        Assert.assertEquals(expected, JEfCosineSimilarity.cosineSimilarityForList(first,second),0);
    }

    @Test
    public void cosineSimilarityForListExceptionTest() throws JEfListNullException{
        expectedEx.expect(JEfListNullException.class);
        expectedEx.expectMessage("List should not be null");
        JEfCosineSimilarity.cosineSimilarityForList(null, null);
    }

    @Test
    public void cosineSimilarityForListNotSizeEqualExceptionTest() throws JEfListSizeNotEqualException{
        List<Double> listFirst = new ArrayList<>();
        listFirst.add(1.0d);
        listFirst.add(2.0d);
        List<Double> secondList = new ArrayList<>();
        secondList.add(1.0d);

        expectedEx.expect(JEfListSizeNotEqualException.class);
        expectedEx.expectMessage("Index out of range. ListSizeNotEqual Exception when comparing two different list");
        JEfCosineSimilarity.cosineSimilarityForList(listFirst, secondList);
    }
}