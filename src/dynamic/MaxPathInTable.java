package dynamic;

import java.util.stream.IntStream;

public class MaxPathInTable {

    public static long getMaxPath(long[][] a) {
        int n = a.length;
        int m = a[0].length;
        long[][] d = new long[n][m];
        d[0][0] = a[0][0];
        IntStream.range(1, m).forEachOrdered(i -> {
            if (a[0][i] != -1) {
                d[0][i] = a[0][i] + d[0][i - 1];
            } else {
                d[0][i] = Long.MIN_VALUE;
            }
        });
        IntStream.range(1, n).forEachOrdered(i -> {
            if (a[i][0] != -1) {
                d[i][0] = a[i][0] + d[i - 1][0];
            } else {
                d[i][0] = Long.MIN_VALUE;
            }
        });
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a[i][j] != -1) {
                    d[i][j] = a[i][j] + Math.max(d[i - 1][j], d[i][j - 1]);
                } else {
                    d[i][j] = Long.MIN_VALUE;
                }
            }
        }

        return d[n - 1][m - 1];


    }
}
