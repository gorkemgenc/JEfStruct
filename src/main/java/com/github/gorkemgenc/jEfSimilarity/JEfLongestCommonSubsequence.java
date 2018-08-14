package com.github.gorkemgenc.jEfSimilarity;

import com.github.gorkemgenc.jEfExceptions.JEfArrayNullException;
import com.github.gorkemgenc.jEfExceptions.JEfStringNullException;

public class JEfLongestCommonSubsequence<T> {

    /***
     * This function calculates and returns the longest common subsequence with given two string
     * If first string or second string is null function throws a JEfStringNullException
     * @param first
     * @param second
     * @return
     * @throws JEfArrayNullException
     */
    public static int longestCommonSubsequenceString(String first, String second) throws JEfArrayNullException
    {
        if(first == null || second == null ) throw  new JEfStringNullException();
        else if(first.length() == 0) return second.length();
        else if(second.length() == 0) return first.length();

        int firstLength = first.length();
        int secondLength = second.length();

        int dynamicArray[][] = createDynamicArray(first, second, firstLength, secondLength);

        return dynamicArray[firstLength][secondLength];
    }

    /***
     * This function calculates and returns the longest common subsequence with given two generic type of different list
     * If first string or second string is null function throws a JEfStringNullException
     * @param first
     * @param second
     * @param <T>
     * @return
     * @throws JEfArrayNullException
     */
    public static <T> int longestCommonSubsequence( T[] first, T[] second) throws JEfArrayNullException
    {
        if(first == null || second == null ) throw  new JEfArrayNullException();
        else if(first.length == 0) return second.length;
        else if(second.length == 0) return first.length;

        int firstLength = first.length;
        int secondLength = second.length;

        int dynamicArray[][] = createDynamicArrayForArray(first, second, firstLength, secondLength);
        return dynamicArray[firstLength][secondLength];
    }

    private static int[][] createDynamicArray(String first, String second, int firstLength, int secondLength){

        int dynamicArray[][] = new int[firstLength+1][secondLength+1];

        for (int i=0; i<=firstLength; i++)
        {
            for (int j=0; j<=secondLength; j++)
            {
                if (i == 0 || j == 0)
                    dynamicArray[i][j] = 0;
                else if (first.charAt(i-1) == second.charAt(j-1))
                    dynamicArray[i][j] = dynamicArray[i-1][j-1] + 1;
                else
                    dynamicArray[i][j] = max(dynamicArray[i-1][j], dynamicArray[i][j-1]);
            }
        }
        return dynamicArray;
    }

    private static <T> int[][] createDynamicArrayForArray(T[] first, T[] second, int firstLength, int secondLength){

        int[][] dynamicArray = new int[firstLength+1][secondLength+1];

        for (int i=0; i<=firstLength; i++)
        {
            for (int j=0; j<=secondLength; j++)
            {
                if (i == 0 || j == 0)
                    dynamicArray[i][j] = 0;
                else if (first[i-1].equals(second[j-1]))
                    dynamicArray[i][j] = dynamicArray[i-1][j-1] + 1;
                else
                    dynamicArray[i][j] = max(dynamicArray[i-1][j], dynamicArray[i][j-1]);
            }
        }
        return dynamicArray;
    }

    private static int max(int first, int second)
    {
        return first > second ? first : second;
    }
}
