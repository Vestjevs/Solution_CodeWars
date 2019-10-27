import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;

public class PreparingForInterview {

    public static void main(String[] args) {
        StringJoiner stringJoiner = new StringJoiner(" ");


        Random random = new Random();
        char c = 64;
        while (c < 74) {
            c++;
            stringJoiner.add(String.valueOf(c));
        }
        IntSummaryStatistics stat;
        List<Integer> numbersList = Arrays.asList(1, 2, 5, 6, 7);
        List<String> strList = Arrays.asList("acb", "as", "", "", "asd", "", "asd");
//        System.out.println(Arrays.toString(numbersList.stream().map(i -> i * i).distinct().toArray()));
//        System.out.println(Arrays.toString(numbersList.stream().filter(integer -> integer < 5).distinct().toArray()));
//        System.out.println(strList.stream().filter(String::isEmpty).count());
//        random.ints().limit(10).sorted().forEach(System.out::println);
//        System.out.println(numbersList.stream().mapToInt(x -> x).summaryStatistics().getAverage());
        System.out.println();
    }

}
