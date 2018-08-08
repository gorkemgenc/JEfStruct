package jEfsort;

import java.lang.reflect.Field;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class ArraySort<T> {
    public static void descendingOrder(Integer[] array){
        Arrays.sort(array, DescendingOrder);
    }

    public static void ascendingOrder(Integer[] array){
        Arrays.sort(array);
    }

    public static void sortByLengthAsc(String[] array) {
        Arrays.sort(array, SortByLengthAsc);
    }

    public static void sortByLengthDesc(String[] array) {
        Arrays.sort(array, SortByLengthDesc);
    }

    public static void alphabeticalCharOrder(Character[] array){
        Arrays.sort(array);
    }

    public static void alphabeticalStringOrder(String[] array){
        Arrays.sort(array);
    }

    public static void reverseAlphabeticalOrder(Character[] array){
        Arrays.sort(array, DescendingOrderChar);
    }

    public static void reverseAlphabeticalOrder(String[] array){
        Arrays.sort(array, ReverseAlphabeticalOrder);
    }

    public static <T> void orderBySpecial(T[] array, String areaName){
        Arrays.sort(array,new Comparator<T>() {
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

    public static <T> void orderBySpecials(T[] array, List<String> areanames){
        Arrays.sort(array,new Comparator<T>() {
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

    public static void alphabeticalOrderWithSubString(String[] array, int start, int end){

        Arrays.sort(array, new Comparator<String>() {

            public int compare(String str1, String str2) {
                int res = String.CASE_INSENSITIVE_ORDER.compare(str1.substring(start, end+1), str2.substring(start, end+1));

                if(res == 0) res = str1.compareTo(str2);

                return res;
            }
        });
    }

    public static void bubbleSort(int[] array){

        int length = array.length;
        for (int i = 0; i < length-1; i++)
            for (int j = 0; j < length-i-1; j++)
                if (array[j] > array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
    }

    public static void mergeSort(int[] array){
        mergeSortInner(array, 0, array.length-1);
    }

    private static void mergeSortInner(int[] array, int start, int end){
        if (start < end)
        {
            int m = (start+end)/2;
            mergeSortInner(array, start, m);
            mergeSortInner(array , m+1, end);
            merge(array, start, m, end);
        }
    }

    private static void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] array){
        quickSortInner(array, 0, array.length-1);
    }

    private static void quickSortInner(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);

            quickSortInner(arr, low, pi-1);
            quickSortInner(arr, pi+1, high);
        }
    }

    private static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    public static void insertionSort(int[] array){
        int n = array.length;
        for (int i=1; i<n; ++i)
        {
            int key = array[i];
            int j = i-1;

            while (j>=0 && array[j] > key)
            {
                array[j+1] = array[j];
                j = j-1;
            }
            array[j+1] = key;
        }
    }

    public static void heapSort(int[] array){
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        for (int i=n-1; i>=0; i--)
        {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private static void heapify(int arr[], int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
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
