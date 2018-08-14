package com.github.gorkemgenc.jEfSimilarity;

import com.github.gorkemgenc.jEfExceptions.JEfArrayLengthNotEqualException;
import com.github.gorkemgenc.jEfExceptions.JEfArrayNullException;
import com.github.gorkemgenc.jEfExceptions.JEfListNullException;
import com.github.gorkemgenc.jEfExceptions.JEfListSizeNotEqualException;
import java.util.List;

public class JEfCosineSimilarity {

    /***
     * This function returns cosine similarity with given two different double array
     * If one of two vectors is null function throws a JEfArrayNullException
     * If vectors size are not equal, function throws a JEfArrayLengthNotEqualException
     * @param vectorA
     * @param vectorB
     * @return
     * @throws JEfArrayNullException
     * @throws JEfArrayLengthNotEqualException
     */
    public static double cosineSimilarity(double[] vectorA, double[] vectorB) throws JEfArrayNullException, JEfArrayLengthNotEqualException{

        if(vectorA == null || vectorB == null) throw new JEfArrayNullException();
        if(vectorA.length != vectorB.length) throw new JEfArrayLengthNotEqualException();

        return calculateCosineSimilarityForArray(vectorA,vectorB);
    }

    /***
     * This function returns cosine similarity with given two different Double list
     * If one of two vectors is null function throws a JEfArrayNullException
     * If vectors size are not equal, function throws a JEfArrayLengthNotEqualException
     * @param vectorA
     * @param vectorB
     * @return
     * @throws JEfListNullException
     * @throws JEfListSizeNotEqualException
     */
    public static double cosineSimilarityForList(List<Double> vectorA, List<Double> vectorB) throws JEfListNullException, JEfListSizeNotEqualException{

        if(vectorA == null || vectorB == null) throw new JEfListNullException();
        if(vectorA.size() != vectorB.size()) throw new JEfListSizeNotEqualException();

        return calculateCosineSimilarityForList(vectorA,vectorB);
    }

    private static double calculateCosineSimilarityForArray(double[] vectorA, double[] vectorB){

        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        for (int i = 0; i < vectorA.length; i++) {
            dotProduct += vectorA[i] * vectorB[i];
            normA += Math.pow(vectorA[i], 2);
            normB += Math.pow(vectorB[i], 2);
        }
        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }

    private static double calculateCosineSimilarityForList(List<Double> vectorA, List<Double> vectorB){

        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        for (int i = 0; i < vectorA.size(); i++) {
            dotProduct += vectorA.get(i) * vectorB.get(i);
            normA += Math.pow(vectorA.get(i), 2);
            normB += Math.pow(vectorB.get(i), 2);
        }
        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }
}
