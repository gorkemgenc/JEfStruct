package jEfSimilarity;

import jEfExceptions.JEfArrayLengthNotEqualException;
import jEfExceptions.JEfArrayNullException;
import jEfExceptions.JEfListNullException;
import jEfExceptions.JEfListSizeNotEqualException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JEfCosineSimilarityTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void cosineSimilarity() {
        double[] first = new double[]{1,0.5};
        double[] second = new double[]{0.5,1};
        double expected = 0.7999999999999998;
        Assert.assertEquals(expected, JEfCosineSimilarity.cosineSimilarity(first,second), 0);
    }

    @Test
    public void cosineSimilarityThrowException() throws JEfArrayNullException{
        expectedEx.expect(JEfArrayNullException.class);
        expectedEx.expectMessage("Array is null");
        JEfCosineSimilarity.cosineSimilarity(null, null);
    }

    @Test
    public void cosineSimilarityLengthNotEqualThrowException() throws JEfArrayLengthNotEqualException{
        double[] first = new double[]{1,2};
        double[] second = new double[]{1};

        expectedEx.expect(JEfArrayLengthNotEqualException.class);
        expectedEx.expectMessage("Array lengths should be equal");
        JEfCosineSimilarity.cosineSimilarity(first, second);
    }

    @Test
    public void cosineSimilarityForList() {
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
    public void cosineSimilarityForListException() throws JEfListNullException{
        expectedEx.expect(JEfListNullException.class);
        expectedEx.expectMessage("List is null");
        JEfCosineSimilarity.cosineSimilarityForList(null, null);
    }

    @Test
    public void cosineSimilarityForListNotSizeEqualException() throws JEfListSizeNotEqualException{
        List<Double> listFirst = new ArrayList<>();
        listFirst.add(1.0d);
        listFirst.add(2.0d);
        List<Double> secondList = new ArrayList<>();
        secondList.add(1.0d);

        expectedEx.expect(JEfListSizeNotEqualException.class);
        expectedEx.expectMessage("Lists size should be equal");
        JEfCosineSimilarity.cosineSimilarityForList(listFirst, secondList);
    }
}