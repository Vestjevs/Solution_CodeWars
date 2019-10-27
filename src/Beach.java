import java.io.*;

public class Beach {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            int min;

            int countTests = Integer.parseInt(br.readLine());
            int i = 0;
            while (i < countTests) {
                min = Integer.MAX_VALUE;

                int n = Integer.parseInt(br.readLine());
                String str = br.readLine();
                String[] elements = str.split(" ");
                int j = 0;
                while (j < elements.length) {
                    int k = j + 1;
                    while (k < elements.length) {
                        min = Math.min(min, (Integer.parseInt(elements[j]) ^ Integer.parseInt(elements[k])));
                        k++;
                    }
                    j++;
                }
                bw.write(String.valueOf(min));
                bw.newLine();
                i++;
            }


            bw.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }


    }
}
