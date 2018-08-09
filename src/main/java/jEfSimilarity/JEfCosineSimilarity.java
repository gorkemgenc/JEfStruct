package jEfSimilarity;

import jEfExceptions.JEfArrayLengthNotEqualException;
import jEfExceptions.JEfArrayNullException;
import jEfExceptions.JEfListNullException;
import jEfExceptions.JEfListSizeNotEqualException;

import java.util.List;

public class JEfCosineSimilarity {

    public static double cosineSimilarity(double[] vectorA, double[] vectorB) throws JEfArrayNullException, JEfArrayLengthNotEqualException{

        if(vectorA == null || vectorB == null) throw new JEfArrayNullException("Array is null");
        if(vectorA.length != vectorB.length) throw new JEfArrayLengthNotEqualException("Array lengths should be equal");

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

    public static double cosineSimilarityForList(List<Double> vectorA, List<Double> vectorB) throws JEfListNullException, JEfListSizeNotEqualException{

        if(vectorA == null || vectorB == null) throw new JEfListNullException("List is null");
        if(vectorA.size() != vectorB.size()) throw new JEfListSizeNotEqualException("Lists size should be equal");

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
