package jEfSort;

import jEfEnums.JEfOrderType;
import jEfExceptions.JEfArrayIndexOutOfRangeException;
import jEfExceptions.JEfArrayLengthNotEqualException;
import java.lang.reflect.Field;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;


public class JEfArray<T> {

    /***
     * This function sorts Integer array with descending order
     * If array is null, function does nothing
     * @param array
     */
    public static void descendingOrder(Integer[] array){

        if(array == null) return;
        Arrays.sort(array, DescendingOrder);
    }

    /***
     * This function sorts Integer array with ascending order
     * If array is null function, does nothing
     * @param array
     */
    public static void ascendingOrder(Integer[] array){

        if(array == null) return;
        Arrays.sort(array);
    }

    /***
     * This function sorts given string array related to length of array elements (ascending order)
     * If array is null, function does nothing
     * @param array
     */
    public static void sortByLengthAsc(String[] array) {

        if(array == null) return;
        Arrays.sort(array, SortByLengthAsc);
    }

    /***
     * This function sorts given string array related to length of array elements (descending order)
     * If array is null, function does nothing
     * @param array
     */
    public static void sortByLengthDesc(String[] array) {

        if(array == null) return;
        Arrays.sort(array, SortByLengthDesc);
    }

    /***
     * This function sorts given Character array (ascending order)
     * If array is null, function does nothing
     * @param array
     */
    public static void alphabeticalCharOrder(Character[] array){

        if(array == null) return;
        Arrays.sort(array);
    }

    /***
     * This function sorts given string array related to alphabetical order
     * If array is null, function does nothing
     * @param array
     */
    public static void alphabeticalStringOrder(String[] array){

        if(array == null) return;
        Arrays.sort(array);
    }

    /***
     * This function sorts given Character array related to alphabetical order (descending order)
     * If array is null, function does nothing
     * @param array
     */
    public static void reverseAlphabeticalOrder(Character[] array){

        if(array == null) return;
        Arrays.sort(array, DescendingOrderChar);
    }

    /***
     * This function sorts given String array related to alphabetical order (descending order)
     * If array is null, function does nothing
     * @param array
     */
    public static void reverseAlphabeticalOrder(String[] array){

        if(array == null) return;
        Arrays.sort(array, ReverseAlphabeticalOrder);
    }

    /***
     * This function sorts given generic type of array with given fieldName. FieldName should be given as a String
     * If array is null or fieldName is null or fieldName is zero, function does nothing
     * If fieldName is not in object class, function throws a NoSuchFieldException
     * You can use this function for inner classes
     * @param array
     * @param fieldName
     * @param <T>
     */
    public static <T> void orderBySpecial(T[] array, String fieldName, JEfOrderType orderType){

        if(array == null || fieldName == null || fieldName.trim().length() == 0) return;

        Arrays.sort(array,new Comparator<T>() {
            @Override
            public int compare(T s1, T s2) {
                int returnValue = 0;
                Field[] fields= s1.getClass().getDeclaredFields() ;
                for (Field fd : fields) {
                    if(!fd.getName().equals(fieldName))  continue;

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
                if (orderType == JEfOrderType.DESC)
                {
                    if (returnValue > 0) return -1;
                    else if (returnValue < 0) return 1;
                }

                return returnValue;
            }
        });
    }

    /***
     * This function sorts given generic type of array with given list of fieldNames. Function checks every field consequently. FieldName should be given as a String
     * If array is null or fieldName is null or fieldName is zero, function does nothing
     * If fieldName is not in object class, function throws a NoSuchFieldException
     * You can use this function for inner classes
     * @param array
     * @param fieldName
     * @param <T>
     */
    public static <T> void orderBySpecials(T[] array, List<String> fieldName, JEfOrderType orderType){

        if(array == null || array.length == 0) return;
        if(fieldName == null || fieldName.size() == 0) return;

        Arrays.sort(array,new Comparator<T>() {
            @Override
            public int compare(T s1, T s2) {
                int returnValue = 0;
                Field[] fields= s1.getClass().getDeclaredFields() ;
                for(String areaname : fieldName){
                    areaname = areaname.trim();
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

                if (orderType == JEfOrderType.DESC)
                {
                    if (returnValue > 0) return -1;
                    else if (returnValue < 0) return 1;
                }

                return returnValue;
            }
        });
    }

    /***
     * This function orders String array with comparing their substrings. For use this function, you should give start and end indexes.
     * If one of element from array face with IndexOutOfRange problem, function throws JEfArrayIndexOutOfRangeException
     * @param array
     * @param start
     * @param end
     */
    public static void alphabeticalOrderWithSubString(String[] array, int start, int end){

        Arrays.sort(array, new Comparator<String>() {

            public int compare(String str1, String str2) throws JEfArrayLengthNotEqualException{
                if(str1.length() < end || str2.length() < end) throw new JEfArrayIndexOutOfRangeException();
                int res = String.CASE_INSENSITIVE_ORDER.compare(str1.substring(start, end+1), str2.substring(start, end+1));

                if(res == 0) res = str1.compareTo(str2);

                return res;
            }
        });
    }

    /***
     * This function sort array with using bubble sort technique
     * @param array
     */
    public static void bubbleSort(int[] array){

        if(array == null) return;

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

    /***
     * This function sort array with using merge sort technique
     * @param array
     */
    public static void mergeSort(int[] array){

        if(array == null) return;
        mergeSortInner(array, 0, array.length-1);
    }

    /***
     * This function sort array with using quick sort technique
     * @param array
     */
    public static void quickSort(int[] array){

        if(array == null || array.length == 0) return;

        quickSortInner(array, 0, array.length-1);
    }

    /***
     * This function sort array with using insertion sort technique
     * @param array
     */
    public static void insertionSort(int[] array){

        if(array == null || array.length == 0) return;

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

    /***
     * This function sort array with using heap sort techniques
     * @param array
     */
    public static void heapSort(int[] array){

        if(array == null || array.length == 0) return;

        int length = array.length;

        for (int i = length / 2 - 1; i >= 0; i--)
            heapify(array, length, i);

        for (int i=length-1; i>=0; i--)
        {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    private static Comparator<Integer> DescendingOrder = new Comparator<Integer>() {
        @Override
        public int compare(Integer first, Integer second) {
            int result = first > second ? -1 : 1;
            return result;
        }
    };

    private static Comparator<Character> DescendingOrderChar = new Comparator<Character>() {
        @Override
        public int compare(Character first, Character second) {
            int result = first > second ? -1 : 1;
            return result;
        }
    };

    private static Comparator<String> ReverseAlphabeticalOrder = new Comparator<String>() {
        @Override
        public int compare(String first, String second) {
            int firstLength = first.length();
            int secondLength = second.length();
            int length = firstLength > secondLength ? secondLength : firstLength;
            int result = 0;
            for(int i=0; i<length; i++){
                int temp1 = first.charAt(i);
                int temp2 = second.charAt(i);

                result = temp1 > temp2 ? -1 : temp2 > temp1 ? 1 : 0;
            }
            if(result == 0){
                result = firstLength > secondLength ? -1 : 1;
            }

            return result;
        }
    };

    private static Comparator<String> SortByLengthAsc = new Comparator<String>() {
        @Override
        public int compare(String first, String second) {
            int result = first.length() > second.length() ? 1 : -1;
            return result;
        }
    };

    private static Comparator<String> SortByLengthDesc = new Comparator<String>() {
        @Override
        public int compare(String first, String second) {
            int result = first.length() < second.length() ? 1 : -1;
            return result;
        }
    };

    private static String normalizedString(String parameter)
    {
        if (!isNullOrBlank(parameter))
        {
            String nfdNormalizedString = Normalizer. normalize(parameter, Normalizer.Form.NFD );
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(nfdNormalizedString).replaceAll("");
        }
        return "" ;
    }


    private static boolean isNullOrBlank(String value)
    {
        boolean flag = false;
        if (value == null || value.trim().equals("") || value.trim().equals("null" ))
        {
            flag = true;
        }
        return flag;
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

    private static void merge(int array[], int left, int middle, int right)
    {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i=0; i<n1; ++i)
            L[i] = array[left + i];
        for (int j=0; j<n2; ++j)
            R[j] = array[middle + 1+ j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                array[k] = L[i];
                i++;
            }
            else
            {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    private static void quickSortInner(int array[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(array, low, high);

            quickSortInner(array, low, pi-1);
            quickSortInner(array, pi+1, high);
        }
    }

    private static int partition(int array[], int low, int high)
    {
        int pivot = array[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (array[j] <= pivot)
            {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;

        return i+1;
    }

    private static void heapify(int array[], int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && array[l] > array[largest])
            largest = l;

        if (r < n && array[r] > array[largest])
            largest = r;

        if (largest != i)
        {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
        }
    }
}
