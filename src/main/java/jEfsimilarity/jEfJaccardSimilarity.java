package jEfsimilarity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class jEfJaccardSimilarity {

    public static double jaccardSimilarity(int[] a, int[] b) {

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

    public static double jaccardSimilarityForList(List<Integer> a, List<Integer> b) {

        Set<Integer> s1 = new HashSet<>();
        for (int i = 0; i < a.size(); i++) {
            s1.add(a[i]);
        }
        Set<Integer> s2 = new HashSet<>();
        for (int i = 0; i < b.size(); i++) {
            s2.add(b[i]);
        }

        final int sa = s1.size();
        final int sb = s2.size();
        s1.retainAll(s2);
        final int intersection = s1.size();
        return 1d / (sa + sb - intersection) * intersection;
    }
}
