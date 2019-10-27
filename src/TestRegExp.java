import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegExp {

    public static boolean ValidIP(String ip){
        return ip.matches("[\\d]{1,3}\\.[\\d]{1,3}\\.[\\d]{1,3}\\.[\\d]{1,3}");
    }

    public static String alphabetWar(String battlefield) {
        String NuclearPoint = "(#*[a-z]*#*[a-z]*#*[a-z]*(\\[[a-z]*])*[a-z]*(#)*[a-z]*(#)*(\\[[a-z]*])*(#)*[a-z]*#*)*";
        String point = "[a-z]*(\\[[a-z]*])*[a-z]{2,}(\\[[a-z]*])*[a-z]{2,}(\\[[a-z]*])*[a-z]";
        Pattern pattern = Pattern.compile(point);
        Matcher matcher = pattern.matcher(battlefield);
        return "oops";
    }

    public static void main(String[] args) {
        String regExp = "[\\w]";
        String whitespace ="[\\s]";
        String rebBackspace ="[\b]";
        String formfeed = "[\f]";
        String linefeed = "[\\n]";
        String carriageReturn = "[\r]";
        String tab ="[\t]";
        String verticaltab = "[\\v]";
        String regExp2 = "[\\d]";
        String forEmpty ="^$";
        String ex = "(-)?[1-9]";
        String text = "<b>asd</b> asdjaldnalksnclkancoid <B>asdas</B>";
        String text2 = "We don't + know. We";

        Pattern pattern = Pattern.compile(ex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
