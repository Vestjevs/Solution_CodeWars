import java.io.*;

public class ClosedKey {

    public static long gcd(long x, long y) {
        return y == 0 ? x : gcd(y, x % y);
    }


    public static long lcm(long x, long y) {
        return x / gcd(x, y) * y;
    }


    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            int count = 0;

            String line = br.readLine();
            long x = Long.parseLong(line.split(" ")[0]);
            long y = Long.parseLong(line.split(" ")[1]);
            if (x == 1) {
                count++;
            } else {
                long m = x * y;
                for (long i = x; i < m / 2; i++) {
                    long d = m / i;
                    if (m % i == 0) {
                        long p = gcd(i, d);
                        long q = lcm(i, d);
                        if (p == x && q == y) {
                            count++;
                        }
                    }
                }
            }

            bw.write(String.valueOf(count));

            bw.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }


}
