import java.util.Arrays;

public class SpiralClockWise {

    public static int[][] createSpiral(int N) {
        int[][] spiral;
        if (N < 1) {
            return new int[0][0];
        } else {
            spiral = new int[N][N];
            int w = 0;
            int h = 0;
            int k = 1;
            int size = N - 1;
            int count = 2 * N - 1;
            while (h + w < count) {
                for (int i = w / 2; i < size - w / 2; i++) {
                    spiral[h / 2][i] = k++;
                }
                h++;
                for (int i = h / 2; i < size - h / 2; i++) {
                    spiral[i][size - w / 2] = k++;
                }
                w++;
                for (int i = size - w / 2; i >= w / 2; i--) {
                    spiral[size - h / 2][i] = k++;
                }
                h++;
                for (int i = size - h / 2; i >= h / 2; i--) {
                    spiral[i][w / 2] = k++;
                }
                w++;
            }
        }
        return spiral;
    }

    public static void main(String[] args) {
        for (int[] arr: createSpiral(5)) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
