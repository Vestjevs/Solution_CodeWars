import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class RoboScript {

    public static String highlight(String code) {
        StringBuilder builder = new StringBuilder();
        code += "H";
        char[] chars = code.toCharArray();
        if (chars.length - 1 == 1) {
            builder.append(wrapIt(String.valueOf(chars[0]), chars[0]));
        } else if (chars.length > 1) {
            int i = 0;
            int k = 1;
            int h = 1;
            StringBuilder str = new StringBuilder();
            while (i < chars.length - 1) {
                if (chars[i] == '(' || chars[i] == ')') {
                    builder.append(chars[i]);
                } else if (chars[i] >= 48 && chars[i] <= 57) {
                    str.append(chars[i]);
                    if (chars[i + 1] < 48 || chars[i + 1] > 57) {
                        builder.append(wrapIt(str.toString(), '0'));
                        str = new StringBuilder();
                    }
                } else {
                    if (chars[i] != chars[i + 1]) {
                        for (int j = 0; j < k; j++) {
                            str.append(chars[i]);
                        }
                        builder.append(wrapIt(str.toString(), chars[i]));
                        str = new StringBuilder();
                        k = 1;
                    } else {
                        k++;
                    }
                }
                i++;
            }
            if (chars[i - 1] != chars[i] && chars[i] != 'H') {
                builder.append(wrapIt(String.valueOf(chars[i]), chars[i]));
            }
        }

        return builder.toString();
    }

    private static String wrapIt(String that, char c) {
        String color;
        if (c == 'F') {
            color = "pink";
        } else if (c == 'L') {
            color = "red";
        } else if (c == 'R') {
            color = "green";
        } else {
            color = "orange";
        }
        return String.format("<span style=\"color: %s\">%s</span>", color, that);
    }


    public static void main(String[] args) {

//        Pattern p = Pattern.compile("((L|R*)((F+)|([F]\\d+)))|(((F+)|([F]\\d+))(L|R*))");


//        IntStream.range(1, 4).boxed().forEach(builder::append);
//        System.out.println(builder.toString());
    }
}
