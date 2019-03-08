import java.text.MessageFormat;
import java.util.Scanner;

public class Sample1 {


//    public static String to4Norris(String str) {
//        StringBuilder result = new StringBuilder();
//
//        int k = 0;
//        while (k < str.length()) {
//            if (str.charAt(k) == '1') {
//                if (result.toString().length() == 0) {
//                    result.append("0 ");
//                } else {
//                    result.append(" 0 ");
//                }
//                int j = 0; //for count 0
//                while (str.charAt(k) == '1') {
//                    k++;
//                    j++;
//                    if (k >= str.length()) {
//                        break;
//                    }
//                }
//                for (int p = 0; p < j; p++) {
//                    result.append("0");
//                }
//
//            } else if (str.charAt(k) == '0') {
//                if (result.toString().length() == 0) {
//                    result.append("00 ");
//                } else {
//                    result.append(" 00 ");
//                }
//                int j = 0;
//                while (str.charAt(k) == '0') {
//                    k++;
//                    j++;
//                    if (k >= str.length()) {
//                        break;
//                    }
//                }
//                for (int p = 0; p < j; p++) {
//                    result.append("0");
//                }
//            }
//        }
//        return result.toString();
//    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String msg = in.nextLine();
        StringBuilder result;
        StringBuilder string = new StringBuilder();

        for (int i = 0; i < msg.length(); i++) {
            int aux = msg.charAt(i);
            String str = Integer.toBinaryString(aux);
            int k = 0;
            result = new StringBuilder("");

            while (k < str.length()) {
                if (str.charAt(k) == '1') {
                    if (result.toString().length() == 0) {
                        result.append("0 ");
                    } else {
                        result.append(" 0 ");
                    }
                    int j = 0; //for count 0
                    while (str.charAt(k) == '1') {
                        k++;
                        j++;
                        if (k >= str.length()) {
                            break;
                        }
                    }
                    for (int p = 0; p < j; p++) {
                        result.append("0");
                    }

                } else if (str.charAt(k) == '0') {
                    if (result.toString().length() == 0) {
                        result.append("00 ");
                    } else {
                        result.append(" 00 ");
                    }
                    int j = 0;
                    while (str.charAt(k) == '0') {
                        k++;
                        j++;
                        if (k >= str.length()) {
                            break;
                        }
                    }
                    for (int p = 0; p < j; p++) {
                        result.append("0");
                    }
                }
            }
            string.append(result.toString());
        }

        System.out.println(string.toString());
    }
}
