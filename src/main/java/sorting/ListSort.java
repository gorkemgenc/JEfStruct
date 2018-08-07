package sorting;

import java.lang.reflect.Field;
import java.text.Normalizer;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ListSort<T> {
    public static void descendingOrder(List<Integer> list){
        Collections.sort(list, DescendingOrder);
    }

    public static void ascendingOrder(List<Integer> list){
        Collections.sort(list);
    }

    public static void sortByLength(List<String> list) {
        Collections.sort(list, SortByLengthAsc);
    }

    public static void sortByLengthDesc(List<String> list) {
        Collections.sort(list, SortByLengthDesc);
    }

    public static void alphabeticalCharOrder(List<Character> list){
        Collections.sort(list);
    }

    public static void alphabeticalOrder(List<String> list){
        Collections.sort(list);
    }

    public static void reverseAlphabeticalCharOrder(List<Character> list){
        Collections.sort(list, DescendingOrderChar);
    }

    public static void reverseAlphabeticalOrder(List<String> list){
        Collections.sort(list, ReverseAlphabeticalOrder);
    }

    public static <T> void orderBySpecial(List<T> list, String areaName){
        Collections.sort(list,new Comparator<T>() {
            @Override
            public int compare(T s1, T s2) {
                int returnValue = 0;
                Field[] fields= s1.getClass().getDeclaredFields() ;
                for (Field fd : fields) {
                    if(!fd.getName().equals(areaName))  continue;

                    boolean accessible = fd.isAccessible();
                    fd.setAccessible(true);
                    try {
                        Object temp1 = fd.get(s1);
                        Object temp2 = fd.get(s2);

                        if (temp1 instanceof Number)
                        {
                            if ((temp1 != null && temp2 != null)
                                    && (temp1 instanceof Integer || temp1 instanceof Long || temp1 instanceof Byte))
                            {
                                returnValue = Long.valueOf(temp1 + "").compareTo(Long. valueOf(temp2 + ""));
                            }
                            else if ((temp1 != null && temp2 != null) && (temp1 instanceof Double || temp1 instanceof Float))
                            {

                                returnValue = Double.valueOf(temp1 + "").compareTo(Double. valueOf(temp2 + ""));

                            }
                        }
                        else if (temp1 instanceof String || temp1 instanceof Character)
                        {
                            if ((temp1 != null) && temp2 != null)
                            {
                                returnValue = normalizedString(String.valueOf(temp1)).compareToIgnoreCase(
                                        normalizedString(String.valueOf(temp2)));
                            }
                        }
                        fd.setAccessible(accessible);

                    } catch (IllegalAccessException e) {
                        try {
                            throw new NoSuchFieldException("There is no such field");
                        } catch (NoSuchFieldException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
                boolean isDesc = true;
                if (isDesc)
                {
                    if (returnValue > 0)
                    {
                        return -1;
                    }
                    else if (returnValue < 0)
                    {
                        return 1;
                    }
                }
                return returnValue;
            }
        });
    }

    public static String normalizedString(String str)
    {
        if (!isNullOrBlank(str))
        {
            String nfdNormalizedString = Normalizer. normalize(str, Normalizer.Form.NFD );
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(nfdNormalizedString).replaceAll("");
        }
        else
        {
            return "" ;
        }
    }

    /**
     * This function checks that the value is blank or null.
     *
     * @param value
     *            value to be checked
     * @return true if value is blank or null
     */
    public static boolean isNullOrBlank(String value)
    {
        boolean retFlag = false;
        if (value == null || value.trim().equals("") || value.trim().equals("null" ))
        {
            retFlag = true;
        }
        return retFlag;
    }


    public static <T> void orderBySpecials(List<T> list, List<String> areanames){
        Collections.sort(list,new Comparator<T>() {
            @Override
            public int compare(T s1, T s2) {
                int returnValue = 0;
                Field[] fields= s1.getClass().getDeclaredFields() ;
                for(String areaname : areanames){
                    if(returnValue != 0){
                        break;
                    }
                    for (Field fd : fields) {
                        if(!areaname.equals(fd.getName())) continue;
                        boolean accessible = fd.isAccessible();
                        fd.setAccessible(true);
                        try {
                            Object temp1 = fd.get(s1);
                            Object temp2 = fd.get(s2);

                            if (temp1 instanceof Number)
                            {
                                if ((temp1 != null && temp2 != null)
                                        && (temp1 instanceof Integer || temp1 instanceof Long || temp1 instanceof Byte))
                                {
                                    returnValue = Long.valueOf(temp1 + "").compareTo(Long. valueOf(temp2 + ""));
                                }
                                else if ((temp1 != null && temp2 != null) && (temp1 instanceof Double || temp1 instanceof Float))
                                {

                                    returnValue = Double.valueOf(temp1 + "").compareTo(Double. valueOf(temp2 + ""));

                                }
                            }
                            else if (temp1 instanceof String || temp1 instanceof Character)
                            {
                                if ((temp1 != null) && temp2 != null)
                                {
                                    returnValue = normalizedString(String.valueOf(temp1)).compareToIgnoreCase(
                                            normalizedString(String.valueOf(temp2)));
                                }
                            }
                            fd.setAccessible(accessible);
                        } catch (IllegalAccessException e) {
                            try {
                                throw new NoSuchFieldException("There is no such field");
                            } catch (NoSuchFieldException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
                boolean isDesc = true;
                if (isDesc)
                {
                    if (returnValue > 0)
                    {
                        return -1;
                    }
                    else if (returnValue < 0)
                    {
                        return 1;
                    }
                }
                return returnValue;
            }
        });
    }

    public static void alphabeticalOrderWithSubString(List<String> list, int start, int end){
        Collections.sort(list, new Comparator<String>() {

            public int compare(String str1, String str2) {
                int res = String.CASE_INSENSITIVE_ORDER.compare(str1.substring(start, end+1), str2.substring(start, end+1));

                if(res == 0) res = str1.compareTo(str2);

                return res;
            }
        });
    }

    public static List<Integer> bubbleSort(List<Integer> list){

        int[] array = list.stream().mapToInt(i->i).toArray();
        ArraySort.bubbleSort(array);
        return Arrays.stream(array).boxed().collect(Collectors.toList());

    }

    public static List<Integer> mergeSort(List<Integer> list){
        int[] array = list.stream().mapToInt(i->i).toArray();
        ArraySort.mergeSort(array);
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }

    public static List<Integer> quickSort(List<Integer> list){
        int[] array = list.stream().mapToInt(i->i).toArray();
        ArraySort.quickSort(array);
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }

    public static List<Integer> insertionSort(List<Integer> list){
        int[] array = list.stream().mapToInt(i->i).toArray();
        ArraySort.insertionSort(array);
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }

    public static List<Integer> heapSort(List<Integer> list){
        int[] array = list.stream().mapToInt(i->i).toArray();
        ArraySort.heapSort(array);
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }

    private static Comparator<Integer> DescendingOrder = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            int result = o1 > o2 ? 1 : -1;
            return result;
        }
    };

    private static Comparator<Character> DescendingOrderChar = new Comparator<Character>() {
        @Override
        public int compare(Character o1, Character o2) {
            int result = o1 > o2 ? -1 : 1;
            return result;
        }
    };

    private static Comparator<String> ReverseAlphabeticalOrder = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            int firstLength = o1.length();
            int secondLength = o2.length();
            int length = firstLength > secondLength ? secondLength : firstLength;
            int result = 0;
            for(int i=0; i<length; i++){
                int temp1 = o1.charAt(i);
                int temp2 = o2.charAt(i);

                result = temp1 > temp2 ? -1 : temp2 > temp1 ? 1 : 0;
            }
            if(result == 0){
                result = firstLength > secondLength ? 1 : -1;
            }

            return result;
        }
    };

    private static Comparator<String> SortByLengthAsc = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            int result = o1.length() > o2.length() ? 1 : -1;
            return result;
        }
    };

    private static Comparator<String> SortByLengthDesc = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            int result = o1.length() < o2.length() ? 1 : -1;
            return result;
        }
    };
}
