import java.io.*;
import java.util.Arrays;

public class MovingClusters {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {

            String line = br.readLine();
            int n = Integer.parseInt(line.split(" ")[0]);
            int m = Integer.parseInt(line.split(" ")[1]);
            int q = Integer.parseInt(line.split(" ")[2]);
            String lineServers = br.readLine();
            int[] servers = Arrays.stream(lineServers.split(" ")).mapToInt(Integer::parseInt).toArray();

            while (br.ready()) {
                String request = br.readLine();
                int a = Integer.parseInt(request.split(" ")[0]);
                int b = Integer.parseInt(request.split(" ")[1]);
                int l = Integer.parseInt(request.split(" ")[2]);
                int r = Integer.parseInt(request.split(" ")[3]);

                boolean isIt = true;
                for (int i = l - 1; i < r; i++) {
                    if (servers[i] != a) {
                        isIt = false;
                    }
                }
                if (isIt) {
                    servers[l - 1] = b;
                    bw.write(49);
                } else {
                    bw.write(48);
                }
                bw.newLine();

            }


            bw.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
