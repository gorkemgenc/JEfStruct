package jEfSimilarity;

import jEfExceptions.JEfArrayNullException;
import jEfExceptions.JEfStringNullException;

public class JEfLongestCommonSubsequence<T> {

    public static int longestCommonSubsequenceString( String first, String second) throws JEfArrayNullException
    {
        if(first == null || second == null ) throw  new JEfStringNullException("String is null");
        if(first.length() == 0) return second.length();
        else if(second.length() == 0) return first.length();

        int firstLength = first.length();
        int secondLength = second.length();

        int L[][] = new int[firstLength+1][secondLength+1];

        for (int i=0; i<=firstLength; i++)
        {
            for (int j=0; j<=secondLength; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (first.charAt(i-1) == second.charAt(j-1))
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = max(L[i-1][j], L[i][j-1]);
            }
        }
        return L[firstLength][secondLength];
    }

    public static <T> int longestCommonSubsequence( T[] first, T[] second) throws JEfArrayNullException
    {
        if(first == null || second == null ) throw  new JEfArrayNullException("Array is null");
        if(first.length == 0) return second.length;
        else if(second.length == 0) return first.length;

        int firstLength = first.length;
        int secondLength = second.length;

        int L[][] = new int[firstLength+1][secondLength+1];

        for (int i=0; i<=firstLength; i++)
        {
            for (int j=0; j<=secondLength; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (first[i-1] == second[j-1])
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = max(L[i-1][j], L[i][j-1]);
            }
        }
        return L[firstLength][secondLength];
    }

    private static int max(int a, int b)
    {
        return a > b ? a : b;
    }
}
