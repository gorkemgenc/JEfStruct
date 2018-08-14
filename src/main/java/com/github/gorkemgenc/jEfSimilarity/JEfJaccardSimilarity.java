package com.github.gorkemgenc.jEfSimilarity;

import com.github.gorkemgenc.jEfExceptions.JEfArrayNullException;
import com.github.gorkemgenc.jEfExceptions.JEfListNullException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JEfJaccardSimilarity {

    /***
     * This function calculates and retuns the jaccard similarity with given two int array
     * If one of two array is null, function throw a JEfArrayNullException
     * If one of two array length is zero, function returns 0
     * @param parameter1
     * @param parameter2
     * @return
     * @throws JEfArrayNullException
     */
    public static double jaccardSimilarity(int[] parameter1, int[] parameter2) throws JEfArrayNullException{

        if(parameter1 == null || parameter2 == null) throw new JEfArrayNullException();
        if(parameter1.length == 0 || parameter2.length == 0) return 0d;

        Set<Integer> setOne = createHashSetForArray(parameter1);
        Set<Integer> setTwo = createHashSetForArray(parameter2);

        return calculateJaccardSimilarityInner(setOne,setTwo);
    }

    /***
     * This function calculates and retuns the jaccard similarity with given two Integer List
     * If one of two list is null, function throw a JEfArrayNullException
     * If one of two list size is zero, function returns 0
     * @param parameter1
     * @param parameter2
     * @return
     * @throws JEfListNullException
     */
    public static double jaccardSimilarityForList(List<Integer> parameter1, List<Integer> parameter2) throws JEfListNullException{

        if(parameter1 == null || parameter2 == null) throw new JEfListNullException();
        if(parameter1.size() == 0 || parameter2.size() == 0) return 0d;

        Set<Integer> setOne = createHashSet(parameter1);
        Set<Integer> setTwo = createHashSet(parameter2);

        return calculateJaccardSimilarityInner(setOne, setTwo);
    }

    /***
     *
     * @param left
     * @param right
     * @return
     */
    public static double jaccardSimilarityForString(final CharSequence left, final CharSequence right) {
        if (left == null || right == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return Math.round(calculateJaccardSimilarity(left, right) * 100d) / 100d;
    }

    private static double calculateJaccardSimilarity(final CharSequence left, final CharSequence right) {
        final Set<String> intersectionSet = new HashSet<>();
        final Set<String> unionSet = new HashSet<>();
        boolean unionFilled = false;
        final int leftLength = left.length();
        final int rightLength = right.length();
        if (leftLength == 0 || rightLength == 0) {
            return 0d;
        }

        for (int leftIndex = 0; leftIndex < leftLength; leftIndex++) {
            unionSet.add(String.valueOf(left.charAt(leftIndex)));
            for (int rightIndex = 0; rightIndex < rightLength; rightIndex++) {
                if (!unionFilled) {
                    unionSet.add(String.valueOf(right.charAt(rightIndex)));
                }
                if (left.charAt(leftIndex) == right.charAt(rightIndex)) {
                    intersectionSet.add(String.valueOf(left.charAt(leftIndex)));
                }
            }
            unionFilled = true;
        }
        return Double.valueOf(intersectionSet.size()) / Double.valueOf(unionSet.size());
    }

    private static Set<Integer> createHashSet(List<Integer> parameter){

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < parameter.size(); i++) {
            set.add(parameter.get(i));
        }
        return set;
    }

    private static Set<Integer> createHashSetForArray(int[] parameter){

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < parameter.length; i++) {
            set.add(parameter[i]);
        }
        return set;
    }

    private static double calculateJaccardSimilarityInner(Set<Integer> firstSet, Set<Integer> secondSet){

        final int sa = firstSet.size();
        final int sb = secondSet.size();
        firstSet.retainAll(secondSet);
        final int intersection = firstSet.size();
        return 1d / (sa + sb - intersection) * intersection;
    }
}
