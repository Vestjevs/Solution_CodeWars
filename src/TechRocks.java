import java.math.BigInteger;
import java.util.Arrays;

public class TechRocks {

    public static BigInteger findSumOfSquaresOfDigits(BigInteger bi) {
        BigInteger aux = BigInteger.ZERO;
        for (byte b :
                bi.toByteArray()) {
            aux.add(BigInteger.valueOf((long) b));
        }

        return aux;
    }

    public static void main(String[] args) {


    }
}
