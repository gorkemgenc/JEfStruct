# JEfficient

This source is released for providing an efficient Java collection library to parse and manipulate with efficient process. 

## Packages

There are eight different functional packages which are grouped according to their responsibilities. These are;

* jEfCheck
* jEfHelper
* jEfModify
* jEfSimilarity
* jEfSort
* jEfTransform
* jEfEnums
* jEfExceptions

You can find and explore the detail usage of each functionalities below.

### JEfCheck

JEfCheck contains 4 different class which are JEfArray, JEfList, JEfString and JEfType.  

##### Usage of JEfArray<T> - unique(T[] array):

<i>This function determines whether array (Type T) is unique or not. If it is unique, it returns true otherwise it returns false. If array is null, function throw an JEfArrayLengthNotEqualException exceptions which extends from RuntimeException. If array size is zero, then function returns true. Type T is a generic type, you can give any type for input.</i>

```
Integer[] array = new Integer[]{1,2,3,2,5,4};
boolean isUnique = JEfArray.unique(array);
```
```
Temp[] tempList = new Temp[3];
tempList[0] = new Temp("Test",1);
tempList[1] = new Temp("Try", 22);
tempList[2] = new Temp("Temp", 23);
boolean isUnique = JEfArray.unique(tempList);
```

##### Usage of JEfArray<T> - same(List<T[]> list):

<i>Given a List of object arrays with generic Type T, this function determines whether these arrays are totally same or not. If same it returns true, otherwise it returns false. If list is null it throws JEfListNullException exceptions which extends from RuntimeException. If list size is zero then return true.</i>

```
Integer[] firstList = new Integer[]{1,2,3,3};
Integer[] secondList = new Integer[]{1,3,3,2};
Integer[] thirdList = new Integer[]{1,2,3,3};
List<Integer[]> list = new ArrayList<>();
list.addAll(Arrays.asList(firstList,secondList,thirdList));

boolean isUnique = JEfArray.same(list);
```

##### Usage of JEfArray<T> - permute(T[] array):

<i>This function serves all permutation of array elements in list. If array is null then it throws JEfArrayNullException and if array length is zero then function returns null.</i>

```
Integer[] array = new Integer[]{1,2,3,4};
List<List<Integer>> result = JEfArray.permute(array);
```

##### Usage of JEfList<T> - unique(List<T> list):

<i>This function defines whether List (Type T) is unique or not based on its elements. If list is null, function throws ListNullExceptionError. If list size equals to then function returns true. Type T is a generic type, you can give any type for input.</i>

```
List<Integer> list = new ArrayList<>();
list.addAll(Arrays.asList(1,2,3,2,5,4));
boolean isUnique = JEfList.unique(list);
```

```
List<Temp> tempList = new ArrayList<>();
tempList.add(new Temp("Test",1));
tempList.add(new Temp("Try", 22));
tempList.add(new Temp("Test", 1));
boolean isUnique = JEfList.unique(tempList);
```

##### Usage of JEfList<T> - same(List<List<T>> list):

<i></i>

```
List<Integer> firstList = new ArrayList<>();
firstList.addAll(Arrays.asList(1,2,3));

List<Integer> secondList = new ArrayList<>();
secondList.addAll(Arrays.asList(1,2,3));

List<List<Integer>> list = new ArrayList<>();
list.addAll(Arrays.asList(firstList,secondList));

boolean isUnique = JEfArray.same(list);
```

##### Usage of JEfList<T> - permute(List<T> list):

<i>This function serves all permutation of List elements in list. If array is null then it throws JEfArrayLengthNotEqualException and if array length is zero then function returns null. </i>

```
List<Integer> list = new ArrayList<>();
list.addAll
list.add(1);
list.add(2);
List<List<Integer>> result = JEfList.permute(list);
```

##### Usage of JEfString - unique(String parameter):

<i>This function defines whether string has unique elements or not. If elements are unique function returns false. Otherwise function return false. If string is null function throws an JEfStringNullException exception. If string length is zero then function returns true.</i>

```
String parameter = "TestTest";
boolean isUnique = JEfString.unique(parameter);
```

```
// It will throw an JEfStringNullException exception.
JEfString.unique(null); 
```

##### Usage of JEfType<T, K> - same(T first, K second):

<i>This function determines whether type of first parameter and type of second parameter are same or not. If same, function returns true. Otherwise function returns false.</i>

```
Temp temp = new Temp("Test", 1);
Other other = new Other("Test", 2);
boolean isSame = JEfType.same(temp,other);
```

##### Usage of JEfType<T, K>  - inner(T first, K second):

<i>This function determines whether first parameter is instance of second parameter. If first parameter is instance of second, function returns true. Otherwise function returns false.</i>

```
Temp temp = new Temp("Test", 1);
TempInner tempInner = new TempInner("TestTemp", 2, 2);
boolean isInner = JEfType.inner(temp,tempInner);
```

```
Temp tempFirst = new Temp("Test", 1);
Temp tempSecond = new Temp("Test1", 1);
ComplexClassOne classOne = new ComplexClassOne("field2","field2", tempSecond);
classOne.list.add(1);
boolean isInner = JEfType.inner(tempFirst, tempSecond);
```

##### Usage of JEfType<T, K>  - sameByValue(T first, T second):

<i>This function determines whether first and second parameters have same declared fields or not, If true, function returns true. Otherwise function returns false. You can use this function for an object which has another object (inner class of other class).</i>

```
Temp tempFirst = new Temp("Test1", 1);
Temp tempSecond = new Temp("Test1", 1);
ComplexClassOne classOne = new ComplexClassOne("field2","field2", tempFirst);
ComplexClassOne classTwo = new ComplexClassOne("field2","field2", tempSecond);
boolean isSameByValue = JEfType.sameByValue(classOne, classTwo);
```

### JEfHelper

JEfHelper contains 2 different class which are JEfModifier and JEfWrapper 

##### Usage of JEfModifier - intArray(Integer[] array):

<i>This function converts Integer[] array to int[] array. If array is null function throws a JEfArrayNullException.</i>

```
Integer[] parameter = new Integer[]{1,2,3,4};
int[] result = JEfModifier.intArray(parameter);
```

##### Usage of JEfModifier - doubleArray(Double[] array):

<i>This function converts Double[] array to double[] array. If array is null function throws a JEfArrayNullException.</i>

```
Double[] parameter = new Double[]{1.0d,2.0d,3.0d,4.0d};
double[] result = JEfModifier.doubleArray(parameter);
```

##### Usage of JEfModifier - longArray(Long[] array):

<i>This function converts Long[] array to long[] array. If array is null function throws a JEfArrayNullException.</i>

```
Long[] parameter = new Long[]{1l,2l,3l,4l};
long[] result = JEfModifier.longArray(parameter);
```

##### Usage of JEfModifier - floatArray(Float[] array):

<i>This function converts Float[] array to float[] array. If array is null function throws a JEfArrayNullException.</i>

```
Float[] parameter = new Float[]{1f,2f,3f,4f};
float[] result = JEfModifier.floatArray(parameter);
```

##### Usage of JEfWrapper - isWrapperType(Class<?> clazz):

<i>This function returns if class type is Boolean, Character, Byte, Short, Integer, Long, Float, Double, Void or String.</i>

```
JEfWrapper.isWrapperType(list.get(0).getClass());
```

##### Usage of JEfWrapper - isWrapperTypeForType(Class<?> clazz):

<i>This function returns if class type is Boolean, Character, Byte, Short, Integer, Long, Float, Double, Void or String, List, Set, Map.</i>

```
JEfWrapper.isWrapperTypeForType(fields[i].getType());
```

### JEfSort

JEfSort contains 2 different class which are JEfArray and JEfList.  

##### Usage of JEfArray<T> - orderBySpecial(T[] array, String fieldName, JEfOrderType orderType):

<i>This function sorts given generic type of array with given fieldName. FieldName should be given as a String. If array is null or fieldName is null or fieldName is zero, function does nothing. If fieldName is not in object class, function throws a NoSuchFieldException. You can use this function for inner classes.</i>

```
TempInner firstInner = new TempInner("BBB","ZZZ",1);
TempInner secondInner = new TempInner("AAA","EEE",2);
TempInner thirdInner = new TempInner("CCC","DDD",3);

Temp firstTemp = new Temp("BBA", "XXX",1,firstInner);
Temp secondTemp = new Temp("BBZ", "XBX",1,secondInner);
Temp thirdTemp = new Temp("BBB", "BBX",1,thirdInner);

Temp[] array = new Temp[]{firstTemp,secondTemp,thirdTemp};
Temp[] result = new Temp[]{thirdTemp,secondTemp,firstTemp};
JEfArray.orderBySpecial(array, "parameter2", JEfOrderType.ASC);
```

##### Usage of JEfArray<T> - descendingOrder(Integer[] array):

<i></i>

```
Integer[] array = new Integer[]{1,2,3};
JEfArray.descendingOrder(array);
```

##### Usage of JEfArray<T> - ascendingOrder(Integer[] array):

<i>This function sorts Integer array with descending order.</i>

```
Integer[] array = new Integer[]{1,2,3,1};
JEfArray.ascendingOrder(array);
```

##### Usage of JEfArray<T> - sortByLengthAsc(String[] array):

<i>This function sorts Integer array with ascending order.</i>

```
String[] array = new String[]{"Test", "TestTestTestTest", "TestTestTest", "Test"};
JEfArray.sortByLengthAsc(array);
```

##### Usage of JEfArray<T> - sortByLengthDesc(String[] array):

<i>This function sorts given string array related to length of array elements (ascending order).</i>

```
String[] array = new String[]{"Test", "TestTestTestTest", "TestTestTest", "Test"};
JEfArray.sortByLengthDesc(array);
```

##### Usage of JEfArray<T> - alphabeticalCharOrder(Character[] array):

<i>This function sorts given string array related to length of array elements (descending order).</i>

```
Character[] array = new Character[]{'g', 'a', 'g', 'b', 'c', 'g'};
JEfArray.alphabeticalCharOrder(array);
```

##### Usage of JEfArray<T> - alphabeticalStringOrder(String[] array):

<i>This function sorts given Character array (ascending order).</i>

```
String[] array = new String[]{"Test", "TestTestTestTest", "TestTestTest", "Test", "Try", "ABC"};
JEfArray.alphabeticalStringOrder(array);
```

##### Usage of JEfArray<T> - reverseAlphabeticalOrder(Character[] array):

<i>This function sorts given string array related to alphabetical order.</i>

```
Character[] array = new Character[]{'g', 'a', 'g', 'b', 'c', 'g'};
JEfArray.reverseAlphabeticalOrder(array);
```

##### Usage of JEfArray<T> - reverseAlphabeticalOrder(String[] array):

<i>This function sorts given Character array related to alphabetical order (descending order).</i>

```
String[] array = new String[]{"Test", "TestTestTestTest", "TestTestTest", "Test", "Try", "ABC"};
JEfArray.reverseAlphabeticalOrder(array);
```


##### Usage of JEfArray<T> - orderBySpecials(T[] array, List<String> fieldName, JEfOrderType orderType):

<i>This function sorts given generic type of array with given list of fieldNames. Function checks every field consequently. FieldName should be given as a String. If array is null or fieldName is null or fieldName is zero, function does nothing. If fieldName is not in object class, function throws a NoSuchFieldException. You can use this function for inner classes.</i>

```
TempInner firstInner = new TempInner("BBB","ZZZ",1);
TempInner secondInner = new TempInner("AAA","EEE",2);
TempInner thirdInner = new TempInner("CCC","DDD",3);

Temp firstTemp = new Temp("BBA", "XXX",1,firstInner);
Temp secondTemp = new Temp("BBZ", "XBX",1,secondInner);
Temp thirdTemp = new Temp("BBB", "BBX",1,thirdInner);

Temp[] array = new Temp[]{firstTemp,secondTemp,thirdTemp};
Temp[] result = new Temp[]{firstTemp,thirdTemp,secondTemp};
JEfArray.orderBySpecial(array, "parameter1", JEfOrderType.ASC);
```

```
TempInner firstInner = new TempInner("BBB","ZZZ",1);
TempInner secondInner = new TempInner("AAA","EEE",2);
TempInner thirdInner = new TempInner("CCC","DDD",3);

Temp firstTemp = new Temp("BBA", "XXX",1,firstInner);
Temp secondTemp = new Temp("BBZ", "XBX",1,secondInner);
Temp thirdTemp = new Temp("BBB", "BBX",1,thirdInner);

Temp[] array = new Temp[]{firstTemp,secondTemp,thirdTemp};
Temp[] result = new Temp[]{secondTemp, thirdTemp,firstTemp};
JEfArray.orderBySpecial(array, "parameter1", JEfOrderType.DESC);
```

##### Usage of JEfArray<T> - alphabeticalOrderWithSubString(String[] array, int start, int end):

<i>This function orders String array with comparing their substrings. For use this function, you should give start and end indexes. If one of element from array face with IndexOutOfRange problem, function throws JEfArrayIndexOutOfRangeException</i>

```
String[] array = new String[]{"Gorkem", "Genc", "Zarkm"};
JEfArray.alphabeticalOrderWithSubString(array,1, array[1].length()-1);
```

##### Usage of JEfArray<T> - bubbleSort(int[] array):

<i>This function sort array with using bubble sort technique.</i>

```
int[] array = new int[]{1,2,3,1};
JEfArray.bubbleSort(array);
```

##### Usage of JEfArray<T> - mergeSort(int[] array):

<i>This function sort array with using merge sort technique.</i>

```
int[] array = new int[]{1,2,3,1};
JEfArray.mergeSort(array);
```

##### Usage of JEfArray<T> - quickSort(int[] array):

<i>This function sort array with using quick sort technique.</i>

```
int[] array = new int[]{1,2,3,1};
JEfArray.quickSort(array);
```

##### Usage of JEfArray<T> - insertionSort(int[] array):

<i>This function sort array with using insertion sort technique.</i>

```
int[] array = new int[]{1,2,3,1};
JEfArray.insertionSort(array);
```

##### Usage of JEfArray<T> - heapSort(int[] array):

<i>This function sort array with using heap sort techniques.</i>

```
int[] array = new int[]{1,2,3,1};
JEfArray.heapSort(array);
```

** Above functions were implemented for list parameter. You can reach the details of usage with using this library!.

### JEfSimilarity

JEfSimilarity contains 4 different class which are JEfCosineSimilarity, JEfEditDistanceSimilarity, JEfJaccardSimilarity and JEfLongetCommonSubsequence.  

##### Usage of JEfCosineSimilarity - cosineSimilarity(double[] vectorA, double[] vectorB):

<i>This function returns cosine similarity with given two different double array. If one of two vectors is null function throws a JEfArrayNullException. If vectors size are not equal, function throws a JEfArrayLengthNotEqualException.</i>

```
double[] first = new double[]{1,0.5};
double[] second = new double[]{0.5,1};
JEfCosineSimilarity.cosineSimilarity(first,second);
```

##### Usage of JEfCosineSimilarity - cosineSimilarityForList(List<Double> vectorA, List<Double> vectorB):

<i> This function returns cosine similarity with given two different Double list. If one of two vectors is null function throws a JEfArrayNullException. If vectors size are not equal, function throws a JEfArrayLengthNotEqualException.</i>

```
 List<Double> first = new ArrayList<>();
first.add(1.0);
first.add(0.5);

List<Double> second = new ArrayList<>();
second.add(0.5);
second.add(1.0);
double result = JEfCosineSimilarity.cosineSimilarityForList(first,second);
```

##### Usage of JEfJaccardSimilarity - cosineSimilarityForList(List<Double> vectorA, List<Double> vectorB):

<i> This function calculates and retuns the jaccard similarity with given two int array. If one of two array is null, function throw a JEfArrayNullException. If one of two array length is zero, function returns 0</i>

```
int[] first = new int[]{1,1,0,1};
int[] second = new int[]{2,0,1,1};
double result = JEfJaccardSimilarity.jaccardSimilarity(first,second);
```

##### Usage of JEfLongestCommonSubsequence - cosineSimilarityForList(List<Double> vectorA, List<Double> vectorB):

<i>This function calculates and returns the longest common subsequence with given two string. If first string or second string is null function throws a JEfStringNullException</i>

```
String str1 = "ABCDGH";
String str2 = "AEDFHR";
int result = JEfLongestCommonSubsequence.longestCommonSubsequenceString(str1,str2);
```

##### Usage of JEfEditDistanceSimilarity - cosineSimilarityForList(List<Double> vectorA, List<Double> vectorB):

<i>This function returns edit distance with given two different string. If one of two string is null, function throws a JEfStringNullException. Usage of an example:: JEfEditDistanceSimilarity.editDistance("sunday","saturday") return 3</i>

```
String str1 = "sunday";
String str2 = "saturday";
int result = JEfEditDistanceSimilarity.editDistance(str1,str2);

```

### JEfModify

JEfModify contains 4 different class which are JEfArray, JEfList, JEfMatrixRotation, JEfString

##### Usage of JEfArray - rotate(T[] array, JEfDirection JEfDirection, int rotateCount):

<i>This function rotates generic type array with given rotateCount. You can rotate array to right or left with given a rotatecount.If array is null, function throws a JEfArrayNullException. If array length is zero or rotateCount equals to array length function does nothing.</i>

```
Integer[] arrayLeft = new Integer[]{1,2,3,4,5};
JEfArray.rotate(arrayLeft, JEfDirection.LEFT,2);
```

##### Usage of JEfList - rotate(List<T> list, JEfDirection JEfDirection, int rotateCount):

<i>This function rotates generic type list with given rotateCount. You can rotate list to right or left with given a rotatecount.If list is null, function throws a JEfListNullException. If list size is zero or rotateCount equals to list size function does nothing.</i>

```
Integer[] array = new Integer[]{1,2,3,4,5};
List<Integer> listLeft = addToList(array);
JEfList.rotate(listLeft, JEfDirection.LEFT,2);
```

##### Usage of JEfMatrixRotation - rotateMatrix(T matrix[][], JEfDirection JEfDirection):

<i>This function rotates matrix with given direction. Function returns matrix to left or right 90 degree.If matrix is null function throw a JEfMatrixNullException</i>

```
Integer[][] matrix = new Integer[][]{{1,2,3},{4,5,6},{7,8,9}};
Object[][] result = JEfMatrixRotation.rotateMatrix(matrix, JEfDirection.LEFT);
```

##### Usage of JEfMatrixRotation - transpose(T[][] matrix):

<i>This function creates transpose of given generic type of matrix. If matrix is null, function throw a JEfMatrixNullException. You can give different rows and columns count matrix.</i>

```
Integer[][] matrix = new Integer[][]{{1,2,3},{4,5,6}};
Object[][] result = JEfMatrixRotation.transpose(matrix);
```

##### Usage of JEfString - rotate(String str, JEfDirection JEfDirection, int rotateCount):

<i>This function rotates given string with given rotateCount. You can rotate string to right or left with given a rotatecount.If string is null, function throws a JEfStringNullException.If string length is zero or rotateCount equals to list size function does nothing.</i>

```
String first = "abcde";
String result = JEfString.rotate(first, JEfDirection.LEFT,2);
```

### JEfTransform

JEfTransform contains 5 different class which are JEfArrayTransform, JEfListTransform, JEfMax, JEfMin, JEfStringTransform

##### Usage of JEfArrayTransform<T> - toBigIntArray(String[] array):

<i>This function transforms String array to BıgInteger array. If array is null function throws JEfArrayNullException exception. If array length is zero function returns null. If there is an invalid element function throws a RuntimeException exception</i>

```
String[] array = new String[]{"123", "12312312312321312311231"};
BigInteger[] result = JEfArrayTransform.toBigIntArray(array);
```

##### Usage of JEfArrayTransform<T> - toIntArray(String[] array):

<i>This function transforms String array to int array. If array is null function throws JEfArrayNullException exception. If array length is zero function returns null. If there is an invalid element function throws a RuntimeException exception. </i>

```
String[] array = new String[]{"123", "11"};
int[] result = JEfArrayTransform.toIntArray(array);
```

##### Usage of JEfArrayTransform<T> - toStringArray(int[] array):

<i>This function transforms int array to String array. If array is null function throws JEfArrayNullException exception. If array length is zero function returns null</i>

```
int[] array = new int[]{123,11};
String[] result = JEfArrayTransform.toStringArray(array);
```

##### Usage of JEfListTransform<T> - toBigIntList(List<String> list):

<i>This function transforms String list to BıgInteger array. If array is null function throws JEfArrayNullException exception. If list size is zero function returns null. If there is an invalid element function throws a RuntimeException exception.</i>

```
List<String> list = new ArrayList<>();
list.add("123");
list.add("12312312312321312311231");
BigInteger[] result = JEfListTransform.toBigIntList(list);
```

##### Usage of JEfListTransform<T> - toIntList(List<Integer> list):

<i>This function transforms Integer list to int array. If list is null function throws JEfListNullException exception. If array length is zero function returns null.</i>

```
List<Integer> list = new ArrayList<>();
list.add(123);
list.add(11);
int[] result = JEfListTransform.toIntList(list);
```

##### Usage of JEfListTransform<T> - toStringList(List<String> list):

<i>This function transforms String list to String array. If list is null function throws JEfListNullException exception. If array length is zero function returns null. </i>

```
List<String> list = new ArrayList<>();
list.add("123");
list.add("12312312312321312311231");
String[] result = JEfListTransform.toStringList(list);
```

##### Usage of JEfMax<T extends Number, K extends Number> - maxList(List<T> list):

<i>This function returns the maximum element of generic type of list. Generic type extends from Number class. If list is null or list size is zero, function throws a JEfListNullException exception.</i>

```
List<Integer> list = new ArrayList<>();
list.addAll(Arrays.asList(12,10,9,3,12,15,3));
Integer result = JEfMax.maxList(list);
```

##### Usage of JEfMax<T extends Number, K extends Number> - maxArray(T[] array):

<i>This function returns the maximum element of generic type of array. Generic type extends from Number class. If array is null or array length is zero, function throws a JEfArrayNullException exception.</i>

```
Integer[] array = new Integer[]{12,10,9,3,12,3,15};
Integer result = JEfMax.maxArray(array);
```

##### Usage of JEfMax<T extends Number, K extends Number> - maxQueue(Queue<T> queue):

<i>This function returns the maximum element of generic type of Java Queue. Generic type extends from Number class. If Queue is empty or Queue size is zero, function throws a JEfQueueEmptyException exception.</i>

```
Queue<Integer> queue = new LinkedList<>();
queue.addAll(Arrays.asList(12,10,9,3,12,3,15));
Integer result = JEfMax.maxQueue(queue);
```

##### Usage of JEfMax<T extends Number, K extends Number> - maxHashSet(HashSet<T> set):

<i>This function returns the maximum element of generic type of Java hashset. Generic type extends from Number class. If set is empty or set size is zero, function throws a JEfSetIsNullException exception.</i>

```
HashSet<Integer> set = new HashSet<>();
set.addAll(Arrays.asList(12,10,9,3,12,3,15));
Integer result = JEfMax.maxHashSet(set);
```

##### Usage of JEfMax<T extends Number, K extends Number> - maxHashMapByValue(HashMap<K,T> map):

<i>This function returns the maximum element of generic type of Java HashMap according to values. Generic type extends from Number class. If map is empty or map size is zero, function throws a JEfMapIsNullException exception.</i>

```
HashMap<Integer, Double> map = new HashMap<>();
map.put(1,10d);
map.put(2,20d);
Double max = JEfMax.maxHashMapByValue(map);
```

##### Usage of JEfMax<T extends Number, K extends Number> -  maxHashMapByKey(HashMap<K,T> map):

<i>This function returns the maximum element of generic type of Java HashMap according to Keys. Generic type extends from Number class. If map is empty or map size is zero, function throws a JEfMapIsNullException exception.</i>

```
HashMap<Integer, Double> map = new HashMap<>();
map.put(10,10d);
map.put(2,20d);
Integer max = JEfMax.maxHashMapByKey(map);
```
##### Usage of JEfMax<T extends Number, K extends Number> - maxHashTableByValue(Hashtable<K, T> hashTable):

<i>This function returns the maximum element of generic type of Java HashTable according to Values. Generic type extends from Number class. If HashTable is empty or map size is zero, function throws a JEfHashTableIsNullException exception.</i>

```
Hashtable<Integer, Double> table = new Hashtable<>();
table.put(1,10d);
table.put(2,20d);
Double max = JEfMax.maxHashTableByValue(table);
```

##### Usage of JEfMax<T extends Number, K extends Number> - maxHashTableByKey(Hashtable<K, T> hashTable):

<i>This function returns the maximum element of generic type of Java HashTable according to Keys. Generic type extends from Number class. If HashTable is empty or map size is zero, function throws a JEfHashTableIsNullException exception.</i>

```
Hashtable<Integer, Double> table = new Hashtable<>();
table.put(10,10d);
table.put(2,20d);
Integer max = JEfMax.maxHashTableByKey(table);

```

##### Usage of JEfStringTransform - deduplication(String str, Character ignoreCharacter):

<i>This function return String with creating unique element string from given string.If string is null, function returns null. If you give ignoreCharacter function does not control this character.If you give null value to ignore character, function does not trace any character</i>

```
String str = "testtestestabtestaa";
String expectedResult = "testtttabtt";
String result = JEfStringTransform.deduplication(str,'t');
```

##### Usage of JEfMin<T extends Number, K extends Number> - minList(List<T> list):

<i>This function returns the minimum element of generic type of list. Generic type extends from Number class.If list is null or list size is zero, function throws a JEfListNullException exception.</i>

```
List<Integer> list = new ArrayList<>();
list.addAll(Arrays.asList(12,10,9,3,12,15,3));
Integer result = JEfMin.minList(list);
```

##### Usage of JEfMin<T extends Number, K extends Number> - minArray(T[] array):

<i>This function returns the minimum element of generic type of array. Generic type extends from Number class.If array is null or array length is zero, function throws a JEfArrayNullException exception.</i>

```
Integer[] array = new Integer[]{12,10,9,3,12,3,15};
Integer result = JEfMin.minArray(array);
```

##### Usage of JEfMin<T extends Number, K extends Number> - minQueue(Queue<T> queue):

<i>This function returns the minimum element of generic type of Java Queue. Generic type extends from Number class.If Queue is empty or Queue size is zero, function throws a JEfQueueEmptyException exception.</i>

```
Queue<Integer> queue = new LinkedList<>();
queue.addAll(Arrays.asList(12,10,9,3,12,3,15));
Integer result = JEfMin.minQueue(queue);
```

##### Usage of JEfMin<T extends Number, K extends Number> - minHashSet(HashSet<T> set):

<i>This function returns the minimum element of generic type of Java hashset. Generic type extends from Number class.If set is empty or set size is zero, function throws a JEfSetIsNullException exception.</i>

```
HashSet<Integer> set = new HashSet<>();
set.addAll(Arrays.asList(12,10,9,3,12,3,15));
Integer result = JEfMin.minHashSet(set);
```

##### Usage of JEfMin<T extends Number, K extends Number> - minHashMapByValue(HashMap<K,T> map):

<i>This function returns the minimum element of generic type of Java HashMap according to values. Generic type extends from Number class.If map is empty or map size is zero, function throws a JEfMapIsNullException exception.</i>

```
HashMap<Integer, Double> map = new HashMap<>();
map.put(1,10d);
map.put(2,20d);
Double min = JEfMin.minHashMapByValue(map);
```

##### Usage of JEfMin<T extends Number, K extends Number> -  minHashMapByKey(HashMap<K,T> map):

<i>This function returns the minimum element of generic type of Java HashMap according to Keys. Generic type extends from Number class.If map is empty or map size is zero, function throws a JEfMapIsNullException exception.</i>

```
HashMap<Integer, Double> map = new HashMap<>();
map.put(10,10d);
map.put(2,20d);
Integer min = JEfMin.minHashMapByKey(map);
```

##### Usage of JEfMin<T extends Number, K extends Number> - minHashTableByValue(Hashtable<K, T> hashTable):

<i>This function returns the minimum element of generic type of Java HashTable according to Values. Generic type extends from Number class.If HashTable is empty or map size is zero, function throws a JEfHashTableIsNullException exception.</i>

```
 Hashtable<Integer, Double> table = new Hashtable<>();
table.put(1,10d);
table.put(2,20d);
Double min = JEfMin.minHashTableByValue(table);
```

##### Usage of JEfMax<T extends Number, K extends Number> - minHashTableByKey(Hashtable<K, T> hashTable):

<i>This function returns the minimum element of generic type of Java HashTable according to Keys. Generic type extends from Number class.f HashTable is empty or map size is zero, function throws a JEfHashTableIsNullException exception.</i>

```
Hashtable<Integer, Double> table = new Hashtable<>();
table.put(10,10d);
table.put(2,20d);
Integer min = JEfMin.minHashTableByKey(table);
```

### JEfEnums

JEfEnums package contains contains 3 different enum according to this library. You can use JEfDirection and JEfOrderType enums inside functions. 

### JEfExceptions

JEfExceptions package contains 12 different exception according to this package errors. You can check and explore the details of exceptions with using JEfficient library. 


You can use more functionalities includes complex structure with this library. 

