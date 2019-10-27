package championship;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {



            bw.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
