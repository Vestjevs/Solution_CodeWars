package dynamic;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class QuantityPathInTable {

    // get quantity from (0, 0) -> (n, m); only down and right

    public static int getQuantity(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] d = new int[n][m];
        d[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (grid[0][i] != 0) {
                d[0][i] += d[0][i - 1];
            } else {
                d[0][i] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            if (grid[i][0] != 0) {
                d[i][0] += d[i - 1][0];
            } else {
                d[i][0] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (grid[i][j] != 0) {
                    d[i][j] = d[i - 1][j] + d[i][j - 1];
                } else {
                    d[i][j] = 0;
                }
            }
        }

        return d[n - 1][m - 1];
    }

    public static boolean pathFinder(String maze) {
        String[] path = maze.split("\n");
        for (int i = 1; i < path.length; i++) {
            if (path[i].length() != path[0].length()) {
                return false;
            }
        }
        int[][] d = new int[path.length][path[0].length()];
        d[0][0] = 1;
        int bound = path.length;
        IntStream.range(1, path.length).filter(i11 -> path[0].toCharArray()[i11] != 'W').forEachOrdered(i11 -> d[0][i11] += d[0][i11 - 1]);
        IntStream.range(1, path[0].length()).filter(i1 -> path[i1].toCharArray()[0] != 'W').forEachOrdered(i1 -> d[i1][0] += d[i1 - 1][0]);
        for (int i = 1; i < path.length; i++) {
            for (int j = 1; j < path[0].length(); j++) {
                if (path[i].toCharArray()[j] != 'W') {
                    d[i][j] = d[i - 1][j] + d[i][j - 1];
                }
            }
        }

        return d[path.length - 1][path[0].length() - 1] != 0;
    }


    public static void main(String[] args) {
//        System.out.println(getQuantity(new int[][]{{1, 1, 0}, {1, 0, 1}, {1, 1, 1}}));
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        long l;
        for (int j = 0; j < 10000; j++) {
            for (int i = 0; i < 10000; i++) {
                l = random.nextInt(10000);
                if (l < 2000) {
                    builder.append("W");
                } else {
                    builder.append(".");
                }
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
        System.out.println(pathFinder(builder.toString()));
    }

}
