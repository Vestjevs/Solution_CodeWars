import java.util.Arrays;
import java.util.stream.IntStream;

public class InterlacedSpiralCipher {


    public static String encode(String s) {
        StringBuilder b = new StringBuilder();

        int size = s.length() / 4 + s.length() % 4;
        char[] chars = s.toCharArray();
        char[][] spiral = new char[size][size];
        IntStream.range(0, size).forEach(j -> IntStream.range(0, size).forEach(i -> spiral[j][i] = '_'));

        int j = 0; // iter for square
        int k = 0; // unknown
        int l = 0; // unknown
        int n = 0; // iter for each row and column

        for (int i = 0; i < chars.length; i += 4) {
            spiral[j][n] = chars[i];
            if (i + 1 < chars.length) {
                spiral[n][size - 1 - j] = chars[i + 1];
            }
            if (i + 2 < chars.length) {
                spiral[size - 1 - j][size - 1 - n] = chars[i + 2];
            }
            if (i + 3 < chars.length) {
                spiral[size - 1 - n][j] = chars[i + 3];
            }
            if (n == size - 2) {
                j++;
                n = j;
            } else {
                n++;
            }


        }
        Arrays.stream(spiral).forEachOrdered(arr -> {
            for (char c : arr) {
                if (c != '_') {
                    b.append(c);
                }
            }
        });

        return b.toString();
    }

    public static String decode(String s) {
        StringBuilder b = new StringBuilder();


        return b.toString();
    }


    public static void main(String[] args) {
        System.out.println(encode("Sic transit gloria mundi"));


    }
}
