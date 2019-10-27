package dynamic;

import java.util.stream.IntStream;

public class MaxSquare {

    public static long getMax(long[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        long[][] d = new long[n][m];

        d[0][0] = arr[0][0];

        IntStream.range(1, m).forEachOrdered(i -> {
            if (arr[0][i] != 0) {
                d[0][i] = 1;
            } else {
                d[0][i] = 0;
            }
        });
        IntStream.range(1, n).forEachOrdered(i -> {
            if (arr[i][0] != 0) {
                d[i][0] = 1;
            } else {
                d[i][0] = 0;
            }
        });

        IntStream.range(1, n).forEachOrdered(i -> {
            IntStream.range(1, m).forEachOrdered(j -> {
                if (arr[i][j] != 0) {
                    d[i][j] = 1 + Math.min(Math.min(d[i - 1][j], d[i][j - 1]), d[i - 1][j - 1]);
                } else {
                    d[i][j] = 0;
                }
            });
        });

        return (long) Math.pow(d[n - 1][m - 1], 2);
    }

    public static void main(String[] args) {
        System.out.println("\\(1-9)");
    }
}
