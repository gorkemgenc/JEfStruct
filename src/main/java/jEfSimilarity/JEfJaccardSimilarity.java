package jEfSimilarity;

import jEfExceptions.JEfArrayNullException;
import jEfExceptions.JEfListNullException;
import jEfTransform.JEfListTransform;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JEfJaccardSimilarity {

    public static double jaccardSimilarity(int[] a, int[] b) throws JEfArrayNullException{

        if(a == null || b == null) throw new JEfArrayNullException();
        if(a.length == 0 || b.length == 0) return 0d;

        Set<Integer> s1 = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            s1.add(a[i]);
        }
        Set<Integer> s2 = new HashSet<>();
        for (int i = 0; i < b.length; i++) {
            s2.add(b[i]);
        }

        final int sa = s1.size();
        final int sb = s2.size();
        s1.retainAll(s2);
        final int intersection = s1.size();
        return 1d / (sa + sb - intersection) * intersection;
    }

    public static double jaccardSimilarityForList(List<Integer> a, List<Integer> b) throws JEfListNullException{

        if(a == null || b == null) throw new JEfListNullException();
        if(a.size() == 0 || b.size() == 0) return 0d;

        Set<Integer> s1 = new HashSet<>();
        for (int i = 0; i < a.size(); i++) {
            s1.add(a.get(i));
        }
        Set<Integer> s2 = new HashSet<>();
        for (int i = 0; i < b.size(); i++) {
            s2.add(b.get(i));
        }

        final int sa = s1.size();
        final int sb = s2.size();
        s1.retainAll(s2);
        final int intersection = s1.size();
        return 1d / (sa + sb - intersection) * intersection;
    }

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
}
