import java.io.*;

public class SeparatingGraph {


    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            int max = 0;
            int count = Integer.parseInt(br.readLine().split(" ")[1]);
            int i = 0;
            while (br.ready()) {
                max = Math.max(max, Integer.parseInt(br.readLine().split(" ")[2]));
                i++;
            }
            System.out.println(max);

            bw.write(String.valueOf(max));
            bw.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}


