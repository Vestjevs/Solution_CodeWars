
import java.awt.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.*;
import java.math.*;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.stream.*;

import static java.lang.String.format;
import static java.lang.String.valueOf;

public class MainTest {
    public static long findNextSquare(long sq) {
        if ((sq % Math.sqrt(sq)) == 0) return (long) Math.pow((Math.sqrt(sq) + 1), 2);
        else
            return -1;
    }

    public static int rowSumOddNumbers(int n) {
        return n * (n * (n - 1) + 1) + n * (n - 1);
    }

    public static int duplicateCount(String text) {
        int count = 0;
        char ch = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.indexOf(Character.toLowerCase(text.charAt(i))) != i && ch != Character.toLowerCase(text.charAt(i))) {
                count++;
                ch = Character.toLowerCase(text.charAt(i));
            }
        }
        return count;
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        if (elements.length == 0 || maxOccurrences >= elements.length || maxOccurrences < 0)
            return elements;

        int[] helpElement = new int[elements.length];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            list.add(elements[i]);

            for (int j = 0; j < i; j++) {
                if (elements[i] == elements[j])
                    helpElement[i]++;
            }
        }
        for (int i = 0; i < elements.length; i++) {
            if (helpElement[i] >= maxOccurrences && i < list.size()) {
                list.remove(i);
            }
        }
        elements = new int[list.size()];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = list.get(i);
        }
        return elements;
    }

    public static String Tickets(int[] peopleInLine) {
        int cash25 = 0;
        int cash50 = 0;

        for (int pays : peopleInLine) {
            if (pays == 25) {
                cash25++;
            } else if (pays == 50) {
                cash25--;
                cash50++;
            } else if (pays == 100) {
                if (cash50 > 0) {
                    cash25--;
                    cash50--;
                } else cash25 -= 3;
            }
            if (cash25 < 0 || cash50 < 0) {
                return "NO";
            }
        }

        return "YES";
    }

    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        String strAns = "";
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return strAns;
        }
        int[] sum1 = new int[lstOf1stLetter.length];

        Arrays.stream(lstOfArt).forEach(aLstOfArt -> IntStream.range(0, lstOf1stLetter.length).filter(j -> aLstOfArt.indexOf(lstOf1stLetter[j]) == 0).forEach(j -> sum1[j] += Integer.parseInt(aLstOfArt.split(" ")[1])));

        StringBuilder strAnsBuilder = new StringBuilder();
        for (int i = 0; i < lstOf1stLetter.length; i++) {
            if (i == lstOf1stLetter.length - 1) {
                strAnsBuilder.append("(").append(lstOf1stLetter[i]).append(" : ").append(sum1[i]).append(")");
            } else
                strAnsBuilder.append("(").append(lstOf1stLetter[i]).append(" : ").append(sum1[i]).append(")").append(" - ");
        }
        strAns = strAnsBuilder.toString();

        return strAns;
    }

    public static boolean comp(int[] a, int[] b) {
        if (a.length == 0 || b.length == 0 || a.length != b.length) {
            return false;
        }

        int[] c = Arrays.stream(a).map(i -> (int) Math.pow(i, 2)).toArray();
        Arrays.sort(c);
        Arrays.sort(b);
        return Arrays.equals(b, c);
    }

    public static int getLengthOfMissingArray(Object[][] arrayOfArrays) {

        if (arrayOfArrays == null || arrayOfArrays.length == 0) return 0;
        int[] a = new int[arrayOfArrays.length];

        for (int i = 0; i < arrayOfArrays.length; i++) {
            if (arrayOfArrays[i] == null || arrayOfArrays[i].length == 0) return 0;
            a[i] = arrayOfArrays[i].length;
        }
        Arrays.sort(a);
        for (int i = 0; i < a.length - 1; i++)
            if (a[i + 1] - a[i] - 1 != 0) {
                return a[i] + 1;
            }
        return 0;
    }

    public static String order(String words) {
        return Arrays.stream(words.split(" "))
                .sorted(Comparator.comparing(a -> a.replaceAll("\\D+", ""))).collect(Collectors.joining(" "));
    }

    public String abbreviate(String string) {
        String[] words = string.split("[^a-zA-Z]+");
        String[] separators = string.split("[a-zA-Z]+");
        StringBuilder result = new StringBuilder();

        int i = 1;
        for (String word : words) {
            result.append(word.length() < 4 ? word : "" + word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1));
            if (i < separators.length) result.append(separators[i++]);
        }
        return result.toString();
    }

    private String processWord(String word) {
        if (word.length() < 4) return word;
        int n = word.length() - 2;
        return "" + word.charAt(0) + n + word.charAt(word.length() - 1);
    }

    public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves) {
        String[] result = new String[moves.length];
        int index0 = position[0], index1 = position[1];
        for (int i = 0; i < moves.length; i++) {
            if (moves[i].equals("right")) {
                if (index1 == fighters[0].length - 1) index1 = 0;
                else
                    index1++;
                result[i] = fighters[index0][index1];
            }
            if (moves[i].equals("left")) {
                if (index1 == 0) index1 = fighters[0].length - 1;
                else
                    index1--;
                result[i] = fighters[index0][index1];
            }
            if (moves[i].equals("down")) {
                if (index0 == 1) result[i] = fighters[index0][index1];
                if (index0 == 0) {
                    index0++;
                    result[i] = fighters[index0][index1];
                }
            }
            if (moves[i].equals("up")) {
                if (index0 == 0) result[i] = fighters[index0][index1];
                if (index0 == 1) {
                    index0--;
                    result[i] = fighters[index0][index1];
                }
            }
        }
        return result;
    }

    public static String createPhoneNumber(int[] numbers) {
        return MessageFormat.format("({0}{1}{2}) {3}{4}{5}-{6}{7}{8}{9}", numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5], numbers[6], numbers[7], numbers[8], numbers[9]);
    }

    public static String formatDuration(int seconds) {
        return null;
    }

    public static String orderWeight(String strng) {
        String[] str = strng.split(" ");
        int[] sum = new int[str.length];
        String str1 = "";

        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length(); j++) {
                sum[i] += Integer.parseInt(valueOf(str[i].charAt(j)));
            }
        }
        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < str.length; i++) {
            map.put(str[i], sum[i]);
        }

        Map<String, Integer> result = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEach(e -> result.put(e.getKey(), e.getValue()));
        str = result.keySet().toArray(new String[0]);
        for (String aStr : str) {
            if (str1.length() == 0) {
                str1 += aStr;
            } else
                str1 = str1 + " " + aStr;
        }
        return str1;

    }

//    public static <K, V extends Comparable<? super V>> Map<K, V>
//    sortByValue(Map<K, V> map) {
//        Map<K, V> result = new LinkedHashMap<>();
//        Stream<Map.Entry<K, V>> st = (Stream<Map.Entry<K, V>>) map.entrySet().stream();
//
//        st.sorted(Comparator.comparing(Map.Entry::getValue))
//                .forEach(e -> result.put(e.getKey(), e.getValue()));
//
//        return result;
//    }

    public static String listSquared(long m, long n) {
        long var;
        LinkedList<Long> list = new LinkedList<>();
        for (long i = m; i <= n; i++) {
            var = i * i;
            for (long j = 1; j <= i / 2; j++)
                if (i % j == 0) var += j * j;
            if (var % (long) Math.sqrt(var) == 0 && var / (long) Math.sqrt(var) == (long) Math.sqrt(var)) {
                list.add(i);
                list.add(var);
            }
        }

        long[][] C = new long[list.size() / 2][2];
        int k = 0;
        for (int i = 0; i < list.size() / 2; i++)
            for (int j = 0; j < 2; j++) C[i][j] = list.get(k++);
        return Arrays.deepToString(C);
    }

    public static long countOddPentaFib(long n) {
        long[] arr = new long[Math.toIntExact(n + 1)];
        int score = 1;
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 2;
        arr[4] = 4;
        for (int i = 5; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3] + arr[i - 4] + arr[i - 5];
            if (arr[i] % 2 != 0) score++;
        }
        return score;
    }

    public static int computeDepth(int n) {
        LinkedList<Character> list = new LinkedList<>();
        int index = 1;
        int iRes = 0;
        String result;
        while (list.size() != 10) {
            result = valueOf(n * index);
            for (int i = 0; i < result.length(); i++) {
                if (!list.contains(result.charAt(i))) {
                    list.add(result.charAt(i));
                }
            }
            index++;
            iRes++;
        }

        return iRes;
    }

//    public static BigInteger fib(BigInteger n) {
//        String str = n.toString();
//        BigInteger[][] result = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
//
//        for (int i = 0; i < Integer.parseInt(str); i++) {
//            result = pow(result);
//        }
//        if (Integer.parseInt(str) == 0) {
//            return BigInteger.ZERO;
//        }
//        return result[1][1];
//    }


    private static BigInteger[][] pow(BigInteger[][] a) {
        BigInteger[][] result = {{BigInteger.ZERO, BigInteger.ZERO}, {BigInteger.ZERO, BigInteger.ZERO}};
        BigInteger[][] result1 = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};

        BigInteger[] thatColum = new BigInteger[2];

        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 2; k++) {
                thatColum[k] = result1[k][j];
            }

            for (int i = 0; i < 2; i++) {
                BigInteger[] thisRow = a[i];
                BigInteger summand = BigInteger.ZERO;
                for (int k = 0; k < 2; k++) {
                    summand = summand.add(thisRow[k].multiply(thatColum[k]));
                }
                result[i][j] = summand;
            }
        }
        return result;
    }

    public static String expand(String expr) {
        String[] result = new String[1 + Integer.parseInt(expr.split("")[expr.length() - 1])];

        String[] helpArr = expr.split("");
//        int n = Integer.parseInt(helpArr[helpArr.length - 1]);
//        int a = Integer.parseInt(helpArr[1]);
//        int b = Integer.parseInt(helpArr[4]);
//        String x = helpArr[2];
        for (int i = 0; i < result.length; i++) {
//            result[i] = Double.toString(Math.pow(a, n - i) * Math.pow(b, i) * factorial(n) / (factorial(n - i) * factorial(i))) + x + "^" + Double.toString(n - i);

        }
        return Arrays.toString(result);
    }


//    public static int sumIntervals(int[][] a) {
//        if (a == null || a.length == 0) {
//            return 0;
//        }
//        int size = a.length;
//        int index = 0;
//        int sum = 0;
//        for (int i = 0; i < size; i++) {
//            for (int j = i; j < size; j++) {
//                if ((a[i][0] > a[j][0] && a[i][0] < a[j][1]) && (a[i][1] > a[j][0] && a[i][1] < a[j][1])) {
//                    sum
//                }
//            }
//        }
//        return -1;
//    }

    public static int parseInt(String numStr) {
        String[] strings2 = new String[]{"one", "two",
                "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
                "seventeen", "eighteen", "nineteen", "twenty", "thirty",
                "forty", "fifty", "sixty", "seventy", "eighty", "ninety", "hundred",
                "thousand", "million"
        };

        String[] strings1 = numStr.split(" ");

        return -1;
    }

    public static String stripComments(String text, String[] commentSymbols) {
        if (text == null) {
            return "";
        }
        if (commentSymbols.length == 0) {
            return text;
        }
        StringBuilder auxStr1 = new StringBuilder();
        StringBuilder auxStr2 = new StringBuilder();
        for (int i = 0; i < commentSymbols.length; i++) {
            if (text.contains(commentSymbols[i])) {
                auxStr1.append(text, 0, text.indexOf(commentSymbols[i]) - 1);
                auxStr2.append(text, text.indexOf(commentSymbols[i]), text.length() - 1);
            }
            if (auxStr2.toString().contains("\n")) {
                auxStr1.append(auxStr2.toString(), auxStr2.toString().indexOf("\n"), auxStr2.toString().length() - 1);
            }
        }

        return auxStr1.toString();
    }

    public static int rep(long n) {
        String str = valueOf(n);
        int k = 0;
        long res = 1;
        while (str.length() != 1) {
            for (int i = 0; i < str.length(); i++) {
                res *= Long.valueOf(str.split("")[i]);
            }
            k++;
            str = valueOf(res);
            res = 1;
        }

        return k;
    }

    /**
     * ###Lyrics... Pyramids are amazing! Both in architectural and mathematical sense.
     * If you have a computer, you can mess with pyramids even if you are not in Egypt at the time.
     * For example, let's consider the following problem. Imagine that you have a plane pyramid built of numbers, like this one here:
     * <p>
     * /3/
     * \7\ 4
     * 2 \4\ 6
     * 8 5 \9\ 3
     * <p>
     * Here comes the task...
     * <p>
     * Let's say that the 'slide down' is a sum of consecutive numbers from the top to the bottom of the pyramid.
     * As you can see, the longest 'slide down' is 3 + 7 + 4 + 9 = 23
     * <p>
     * Your task is to write a function longestSlideDown (in ruby: longest_slide_down)
     * that takes a pyramid representation as argument and returns its' longest 'slide down'. For example,
     * <p>
     * longestSlideDown [[3], [7, 4], [2, 4, 6], [8, 5, 9, 3]]
     * // => 23
     * <p>
     * ###By the way... My tests include some extraordinarily high pyramides so as you can guess,
     * brute-force method is a bad idea unless you have a few centuries to waste. You must come up with something more clever than that.
     */
    public static int longestSlideDown(int[][] pyramid) {
        int k = 0;
        for (int i = 1; i < pyramid.length; i++) {
            if (Math.max(pyramid[i][k], pyramid[i][k + 1]) == pyramid[i][k]) {
                pyramid[0][0] += pyramid[i][k];
            } else {
                pyramid[0][0] += pyramid[i][k + 1];
                k++;
            }
        }
        return pyramid[0][0];
    }

    /**
     * You have a positive number n consisting of digits.
     * You can do at most one operation:
     * Choosing the index of a digit in the number, remove this digit at that index and insert it back to another place in the number.
     * <p>
     * Doing so, find the smallest number you can get.
     * <p>
     * #Task: Return an array or a tuple or a string depending on the language (see "Sample Tests") with
     * <p>
     * 1) the smallest number you got
     * 2) the index i of the digit d you took, i as small as possible
     * 3) the index j (as small as possible) where you insert this digit d to have the smallest number.
     * <p>
     * Example:
     * <p>
     * smallest(261235) --> [126235, 2, 0] or (126235, 2, 0) or "126235, 2, 0"
     * <p>
     * 126235 is the smallest number gotten by taking 1 at index 2 and putting it at index 0
     * <p>
     * smallest(209917) --> [29917, 0, 1] or ...
     * <p>
     * [29917, 1, 0] could be a solution too but index `i` in [29917, 1, 0] is greater than
     * index `i` in [29917, 0, 1].
     * <p>
     * 29917 is the smallest number gotten by taking 2 at index 0 and putting it at index 1 which gave 029917 which is the number 29917.
     * <p>
     * smallest(1000000) --> [1, 0, 6] or ...
     * <p>
     * Note
     * <p>
     * Have a look at "Sample Tests" to see the input and output in each language
     */
    public static long[] smallest(long n) {
        // your code
        return null;
    }

    /**
     * Task
     * <p>
     * Your task is to create a Funnel data structure. It consists of three basic methods: fill(), drip() and toString()/to_s/__str__. Its maximum capacity is 15 data.
     * <p>
     * Data should be arranged in an inverted triangle, like this:
     * <p>
     * \1 2 3 4 5/
     * \7 8 9 0/
     * \4 5 6/
     * \2 3/
     * \1/
     * <p>
     * The string method should return a multi-line string to display current funnel data arrangement:
     * <p>
     * Funnel funnel = new Funnel();
     * System.out.println(funnel);
     * \         /
     * \       /
     * \     /
     * \   /
     * \ /
     * <p>
     * The method fill() should accept one or more arguments to fill in the funnel:
     * <p>
     * Funnel funnel = new Funnel();
     * funnel.fill(1);
     * System.out.println(funnel);
     * \         /
     * \       /
     * \     /
     * \   /
     * \1/
     * funnel.fill(2);
     * System.out.println(funnel);
     * \         /
     * \       /
     * \     /
     * \2  /
     * \1/
     * funnel.fill(3);
     * System.out.println(funnel);
     * \         /
     * \       /
     * \     /
     * \2 3/
     * \1/
     * funnel.fill(4,5);
     * System.out.println(funnel);
     * \         /
     * \       /
     * \4 5  /
     * \2 3/
     * \1/
     * funnel.fill(6,7,8,9);
     * System.out.println(funnel);
     * \         /
     * \7 8 9  /
     * \4 5 6/
     * \2 3/
     * \1/
     * <p>
     * In each row, fill() always fill data from left to right.
     * <p>
     * The method drip() should drip the bottom value out of funnel and returns this value:
     * <p>
     * // (continue the example above)
     * Character v = funnel.drip();
     * System.out.println(v);
     * 1
     * System.out.println(funnel);
     * \         /
     * \  8 9  /
     * \7 5 6/
     * \4 3/
     * \2/
     * <p>
     * As you can see, the bottom 1 was dripping out. The number above it will fill it's place. The rules to fill are: Select one of the two numbers above it, which bear the "weight" of relatively large. In other words, there are more numbers on this number. Is this a bit hard to understand? Please see the following:
     * <p>
     * In the example above, before the execution of drip(), funnel is:
     * \         /
     * \7 8 9  /
     * \4 5 6/
     * \2 3/
     * \1/
     * <p>
     * After drip(), 1 will be dripped out.
     * We should choose a number between 2 and 3 to fill the place of 1.
     * 2 has 5 numbers on it(4,5,7,8,9). 3 has 4 numbers on it(5,6,8,9)
     * So we choose 2 to fill the place of 1
     * And now, the place of 2 is empty.
     * We also need choose a number between 4 and 5 to fill the place of 2.
     * 4 has 2 numbers on it(7,8). 5 has 2 numbers on it too(8,9)
     * There are same "weight" on 4 and 5,
     * In this case, we choose the number on the left
     * So we choose 4 to fill the place of 2
     * And then choose 7 to fill the place of 4
     * <p>
     * Let us continue to drip():
     * <p>
     * funnel.drip();
     * System.out.println(funnel);
     * \         /
     * \    9  /
     * \7 8 6/
     * \5 3/
     * \4/
     * <p>
     * funnel.drip();
     * System.out.println(funnel);
     * \         /
     * \       /
     * \7 9 6/
     * \8 3/
     * \5/
     * <p>
     * funnel.drip();
     * System.out.println(funnel);
     * \         /
     * \       /
     * \  9 6/
     * \7 3/
     * \8/
     * <p>
     * funnel.drip();
     * System.out.println(funnel);
     * \         /
     * \       /
     * \    6/
     * \7 9/
     * \3/
     * <p>
     * funnel.drip();
     * System.out.println(funnel);
     * \         /
     * \       /
     * \     /
     * \7 6/
     * \9/
     * <p>
     * funnel.drip();
     * System.out.println(funnel);
     * \         /
     * \       /
     * \     /
     * \  6/
     * \7/
     * <p>
     * funnel.drip();
     * System.out.println(funnel);
     * \         /
     * \       /
     * \     /
     * \   /
     * \6/
     * <p>
     * funnel.drip();
     * System.out.println(funnel);
     * \         /
     * \       /
     * \     /
     * \   /
     * \ /
     * <p>
     * When the funnel is empty, drip() will return null/nil/None
     * <p>
     * System.out.println(funnel.drip());
     * null
     * System.out.println(funnel);
     * \         /
     * \       /
     * \     /
     * \   /
     * \ /
     * <p>
     * Another edge case is: When funnel is full, fill() will not change the funnel.
     * <p>
     * A bit complex...
     */
    static class Funnel {
        private char[] chars;
        private int cons;


        public Funnel() {
            chars = new char[15];
            cons = 0;
        }

        public void fill(char... args) {
            System.arraycopy(args, 0, chars, 0, args.length);
            IntStream.range(args.length, chars.length).forEach(i -> chars[i] = ' ');
            cons = args.length;
        }

        public Character drip() {

            return null;
        }

        @Override
        public String toString() {
            return String.format("\\%s %s %s %s %s/\n\\%s %s %s %s/\n\\%s %s %s/\n\\%s %s/\n\\%s/", chars[10], chars[11], chars[12], chars[13], chars[14], chars[6], chars[7], chars[8], chars[9], chars[3], chars[4], chars[5], chars[1], chars[2], chars[0]);
        }

    }

    /**
     * Problem
     * <p>
     * Let us write down the infinite consecutive positive integers in a sequence in one line without any space. And then write their squares in the second line. This will generate two different long numbers, now we want to calculate the sum of these two numbers.
     * <p>
     * Of course, the result of the calculation will be a infinite sequence too. The calculation of the first 30 digits is just as below:
     * <p>
     * 123456789101112131415161718192...
     * + 149162536496481100121144169196...
     * = 272619325597593231536305887388...
     * <p>
     * As you can see, the first digit of the result is 2, the second digit is 7, and the third is 2 and so on.
     * <p>
     * Can you find out the nth digit of this infinite sequence?
     * Task
     * <p>
     * You are given an integer n, you should output the digit at position n in the resulting infinite sequence.
     * <p>
     * Note that n is 0-based.
     * <p>
     * Still don't understand the problem? Look at the following examples:
     * Examples
     * <p>
     * For n = 1, the output should be 7.
     * <p>
     * 272619325597593231536305887388...
     * ^
     * 1st digit
     * <p>
     * For n = 5, the output should be 9.
     * <p>
     * 272619325597593231536305887388...
     * ^
     * 5th digit
     * <p>
     * For n = 29, the output should be 8.
     * <p>
     * 272619325597593231536305887388...
     * ^
     * 29th digit
     * <p>
     * Note
     * <p>
     * 0 <= n < 2^31
     * <p>
     * In order to avoid timeout, be aware of the code's performance ;-)
     * <p>
     * Something like require("bignumber.js") was disabled.
     * <p>
     * I'm not sure that my solution is absolutely right (perhaps failed in some edge cases?). If so, please give me some feedback. Thanks ;-)
     * <p>
     * Happy Coding ^_^
     */
    public static int findDigit(int n) {
        return 0;
    }

    /**
     * Welcome
     * <p>
     * this is the second in the series of the string iterations kata!
     * <p>
     * Here we go!
     * <p>
     * We have a string s
     * <p>
     * Let's say you start with this: "String"
     * <p>
     * The first thing you do is reverse it: "gnirtS"
     * <p>
     * Then you will take the string from the 1st position and reverse it again: "gStrin"
     * <p>
     * Then you will take the string from the 2nd position and reverse it again: "gSnirt"
     * <p>
     * Then you will take the string from the 3rd position and reverse it again: "gSntri"
     * <p>
     * Continue this pattern until you have done every single position, and then you will return the string you have created. For this particular string, you would return: "gSntir"
     * <p>
     * now,
     * The Task:
     * <p>
     * In this kata, we also have a number x
     * <p>
     * take that reversal function, and apply it to the string x times.
     * <p>
     * return the result of the string after applying the reversal function to it x times.
     * <p>
     * example where s = "String" and x = 3:
     * <p>
     * after 0 iteration  s = "String"  gnirtS
     * after 1 iteration  s = "gSntir"
     * after 2 iterations s = "rgiStn"
     * after 3 iterations s = "nrtgSi"
     * <p>
     * so you would return "nrtgSi".
     * <p>
     * Note
     * <p>
     * String lengths may exceed 2 million
     * <p>
     * x exceeds a billion
     * <p>
     * be read to optimize
     */
    public static String stringFunc(String str, long n) {

        StringBuilder a = new StringBuilder(str);
        int size = str.length();
        str = "";
        for (long b = (n - 1) >> 1; b >= 0; b--) {
            for (int i = 0; i < size; i++) {
                a.reverse();
                str += a.substring(0, 1);
                a.deleteCharAt(0);
            }
            a = new StringBuilder(str);
            str = "";
        }
        return a.toString();
    }

    public static String stringFunc2(String str, long n) {
        StringBuilder res = new StringBuilder();
        int size = str.length();
        for (long b = (n - 1) >> 1; b >= 0; b--) {
            int k = 0;
            int j = 0;
            for (int i = (size - 1) >> 1; i >= 0; i--) {
                if (i % 2 != 0) {
                    res.append(str.split("")[str.length() - k - 1]);
                    k++;
                } else if (i % 2 == 0) {
                    res.append(str.split("")[j]);
                    j++;
                }
            }
            str = res.toString();
            res = new StringBuilder();
        }
        return str;
    }

    /**
     * In this kata you have to create all permutations of an input string and remove duplicates,
     * if present. This means, you have to shuffle all letters from the input in all possible orders.
     * <p>
     * Examples:
     * <p>
     * Permutations.singlePermutations("a") `shouldBe` ["a"]
     * Permutations.singlePermutations("ab") `shouldBe` ["ab", "ba"]
     * Permutations.singlePermutations("aabb") `shouldBe` ["aabb","abab","abba","baab","baba","bbaa"]
     */
    public static List<String> singlePermutations(String s) {
        LinkedList<String> list = new LinkedList<>();
        list.add(s);
        int a = duplicateCount(s);
        int k;
        if (a == 0) {
            k = Integer.parseInt(factorial(s.length()));
        } else {
            int size = s.length() - a + s.length() - 1;
            k = Integer.parseInt(factorial(size)) / (Integer.parseInt(factorial(s.length())) * Integer.parseInt(factorial(size - s.length())));
        }
        String[] strings = s.split("");
        while (list.size() != k + 1) {
            Collections.shuffle(Arrays.asList(strings));
            if (!list.contains(Arrays.stream(strings, 0, s.length()).collect(Collectors.joining()))) {
                list.add(Arrays.stream(strings, 0, s.length()).collect(Collectors.joining()));
            }

        }

        return list;
    }

    static class stopwatch {
        private long start;

        public stopwatch() {
            start = System.currentTimeMillis();
        }

        public double elapsedtime() {
            long now = System.currentTimeMillis();
            return (now - start) / 1000.0;
        }
    }

    public static BigInteger get(int n) {

        BigInteger big = new BigInteger("7");
        BigInteger mod = new BigInteger("10");
        int length = big.toString().length();
        if (n == 1) {
            return BigInteger.ONE;
        } else if (n == 2) {
            return new BigInteger("5");
        } else if (n == 3) {
            return new BigInteger("6");
        } else {
            int i = 3;
            while (n > i) {
                if (big.toString().length() == length + 1) {
                    length++;
                    mod = mod.multiply(BigInteger.TEN);
                }
                if ((big.pow(2).subtract(big).mod(mod).equals(BigInteger.ZERO))) {
                    i++;
                }
                big = big.add(BigInteger.ONE);
            }
        }
        return big.subtract(BigInteger.ONE);
    }

    public static String toCeasar(String str) {
        StringBuilder builder = new StringBuilder();
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch == 122) {
                ch = 96;
            }
            if (ch == 90) {
                ch = 64;
            }
            builder.append(Character.toChars(++ch)[0]);
        }
        return builder.toString();
    }

    public static String toPassword(int length) {
        if (length < 8 || length > 32) {
            return "Length is not between 8 and 32";
        }
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        while (builder.length() != length) {
            int r = random.nextInt() % 127;
            if (r >= 33) {
                builder.append(Character.toChars(r)[0]);
            }
        }

        return builder.toString();
    }

    public static String VigenereCipher(String key, String word) {
        if (word.length() % key.length() != 0) {
            return "the length of word must exceed an integer number of time";
        }
        StringBuilder encrypted = new StringBuilder();
        int k = 0, i = 0;
        int code;
        while (k != word.length()) {
            if (i == key.length()) {
                i = 0;
            }
            code = key.charAt(i) + word.charAt(k) - 97;
            if (code >= 123) {
                code -= 26;
            }
            encrypted.append(Character.toChars(code));
            k++;
            i++;
        }
        return encrypted.toString();
    }

    public static double Det(double[][] m) {
        double det = 1;
        double[] aux = new double[m.length];
        for (int i = 0; i < m.length; i++) {
            int k = i;
            for (int j = i + 1; j < m.length; j++) if (Math.abs(m[j][i]) > Math.abs(m[k][i])) k = j;
            if (Math.abs(m[k][i]) < Double.MIN_VALUE) {
                det = 0;
                break;
            }
            System.arraycopy(m[i], 0, aux, 0, m.length);
            System.arraycopy(m[k], 0, m[i], 0, m.length);
            System.arraycopy(aux, 0, m[k], 0, m.length);
            if (i != k) det = -det;
            det *= m[i][i];
            for (int j = i + 1; j < m.length; j++) {
                m[i][j] /= m[i][i];
            }
            for (int j = 0; j < m.length; j++) {
                if (j != i && Math.abs(m[j][i]) > Double.MIN_VALUE)
                    for (int l = i + 1; l < m.length; l++) {
                        m[j][l] -= m[i][l] * m[j][i];
                    }
            }

        }

        return det;
    }

    public static int Gauss(double[][] arr, double[] arg) {

        int n = arr.length;
        int m = arr[0].length - 1;
        int[] index = new int[m];
        Arrays.fill(index, -1);
        for (int column = 0, row = 0; column < m && row < n; column++) {
            int aux = row;
            for (int i = row; i < n; i++) {
                if (Math.abs(arr[i][column]) > Math.abs(arr[aux][column])) aux = i;
            }
            if (Math.abs(arr[aux][column]) < Double.MIN_VALUE) continue;
            double h;
            for (int i = column; i <= m; i++) {
                h = arr[aux][i];
                arr[aux][i] = arr[row][i];
                arr[row][i] = h;
            }
            index[column] = row;
            for (int i = 0; i < n; i++) {
                if (i != row) {
                    double c = arr[i][column] / arr[row][column];
                    for (int j = column; j <= m; j++) {
                        arr[i][j] -= arr[row][j] * c;
                    }
                }
            }
            row++;
        }

        IntStream.range(0, m).filter(i -> index[i] != -1).forEachOrdered(i -> arg[i] = arr[index[i]][m] / arr[index[i]][i]);
        for (double[] anArr : arr) {
            double sum = IntStream.range(0, m).mapToDouble(j -> arg[j] * anArr[j]).sum();
            if (Math.abs(sum - anArr[m]) > Double.MIN_VALUE) {
                Arrays.fill(arg, 0);
                return Integer.MAX_VALUE;
            }
        }

        return 1;
    }

    public static String infixToPostix(String str) {
        StringBuilder strB = new StringBuilder();
        Stack<Double> stackD = new Stack<>();
        Stack<String> stackS = new Stack<>();
        IntStream.range(0, str.split(" ").length).forEach(i -> {
            if (str.split(" ")[i].equals("+")) {
                stackS.push(str.split(" ")[i]);
            } else if (str.split(" ")[i].equals("-")) {
                stackS.push(str.split(" ")[i]);
            } else if (str.split(" ")[i].equals("/")) {
                stackS.push(str.split(" ")[i]);
            } else if (str.split(" ")[i].equals("*")) {
                stackS.push(str.split(" ")[i]);
            } else if (stackD.size() == 2) {
                if (stackS.peek().equals("+")) {
                    stackD.push(stackD.pop() + stackD.pop());
                    stackS.pop();
                } else if (stackS.peek().equals("-")) {
                    stackD.push(stackD.pop() - stackD.pop());
                    stackS.pop();
                } else if (stackS.peek().equals("*")) {
                    stackD.push(stackD.pop() * stackD.pop());
                    stackS.pop();
                } else if (stackS.peek().equals("/")) {
                    stackD.push(stackD.pop() / stackD.pop());
                    stackS.pop();
                }
            } else {
                stackD.push(Double.parseDouble(str.split(" ")[i]));
            }
        });

        return stackD.pop().toString();
    }

    public static boolean NameValidation(String str) {
        int l = str.length() - 1;
        String reg = "[a-zA-Z0-9_]*";
        return str.matches("[^0-9]" + reg);
    }

    public static BigDecimal fibMethod(int k) {
        BigDecimal sqrt5 = BigDecimal.valueOf(Math.sqrt(5.0));
        BigDecimal numerator = (new BigDecimal(1).add(sqrt5));
        BigDecimal phi = numerator.divide(new BigDecimal(2), RoundingMode.CEILING);
        BigDecimal res = phi.pow(k);

        return res.divide(sqrt5, RoundingMode.CEILING).setScale(0, RoundingMode.CEILING);
    }


    public static Function<Integer, Integer> getIterator(Function<Integer, Integer> func, int times) {
        if (times < 2) {
            return func;
        } else {
            return func.andThen(getIterator(func, times - 1));
        }

    }

    public static List<String> balancedParens(int n) {
        List<String> list = new ArrayList<>();
        return list;
    }

//    public static char[][] getVariations(char[] chars, int length) {
//        int srcLength = chars.length;
//        int permutations = (int) Math.pow(srcLength, length);
//
//        char[][] variation = new char[permutations][length];
//
//        for (int i = 0; i < length; i++) {
//            int t2 = (int) Math.pow(srcLength, i);
//            for (int p1 = 0; p1 < permutations; ) {
//                for (char aChar : chars) {
//                    for (int p2 = 0; p2 < t2; p2++) {
//                        variation[p1][i] = aChar;
//                        p1++;
//                    }
//                }
//            }
//        }
//
//        return variation;
//    }

    private static boolean check(String str) {
        return str.matches("(\\)\\)\\(\\()+");
    }


    public static String factorial(int n) {
        return valueOf(LongStream.range(1, n + 1).reduce(1, (a, b) -> a * b));
    }

    public static void main(String[] args) {
//        char[] chars = {'(', '(', '(', ')', ')', ')'};
//        char[] ob = {'(', ')'};
//        StringBuilder str = new StringBuilder();
//        List<String> list = new ArrayList<>();
//        for (char[] s : getVariations(ob, 4)) {
//            str.append("(");
//            for (char charS : s) {
//                str.append(charS);
//            }
//            str.append(")");
//            list.add(str.toString());
//            str = new StringBuilder();
//        }
//        List<String> res = new ArrayList<>();
//        for (String s : list) {
//            int l = 0;
//            int r = 0;
//            for (int i = 0; i < s.split("").length; i++) {
//                if (s.split("")[i].equals("(")) {
//                    l++;
//                } else {
//                    r++;
//                }
//            }
//            if(l == r && !s.matches("[()]*(\\)\\)\\(\\()[()]*")){
//                res.add(s);
//                System.out.println(s);
//            }
//        }


    }
}
