package jEfSimilarity;

import jEfExceptions.JEfStringNullException;

public class JEfEditDistanceSimilarity {

    /***
     * This function returns edit distance with given two different string.
     * If one of two string is null, function throws a JEfStringNullException
     * Usage of an example:: JEfEditDistanceSimilarity.editDistance("sunday","saturday") return 3
     * @param parameter1
     * @param parameter2
     * @return
     * @throws JEfStringNullException
     */
    public static int editDistance(String parameter1, String parameter2) throws JEfStringNullException{

        if(parameter1 == null || parameter2 == null) throw new JEfStringNullException();
        else if(parameter1.length() == 0) return parameter2.length();
        else if(parameter2.length() == 0) return parameter1.length();

        return editDistanceInner(parameter1, parameter2, parameter1.length(), parameter2.length());
    }

    private static int editDistanceInner(String parameter1, String parameter2, int firstLength, int secondLength)
    {
        int dynamicArray[][] = new int[firstLength+1][secondLength+1];

        for (int i=0; i<=firstLength; i++)
        {
            for (int j=0; j<=secondLength; j++)
            {
                if (i==0)
                    dynamicArray[i][j] = j;

                else if (j==0)
                    dynamicArray[i][j] = i;

                else if (parameter1.charAt(i-1) == parameter2.charAt(j-1))
                    dynamicArray[i][j] = dynamicArray[i-1][j-1];

                else
                    dynamicArray[i][j] = 1 + min(dynamicArray[i][j-1],dynamicArray[i-1][j],dynamicArray[i-1][j-1]);
            }
        }

        return dynamicArray[firstLength][secondLength];
    }

    private static int min(int first,int second,int third)
    {
        if (first <= second && first <= third) return first;
        else if (second <= first && second <= third) return second;
        else return third;
    }

}
