import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class Main {

    public static String[] trafficLights(String road, int n) {

        String[] states = new String[n + 1];
        char[] chars = road.toCharArray();

        states[0] = road;
        StringBuilder roadBuilder = new StringBuilder();
        for (int k = 1; k < n + 1; k++) {
            for (int i = 0; i < road.length(); i++) {
                if (road.charAt(i) == '.') {
                    roadBuilder.append('.');
                } else if (road.charAt(i) == 'C') {
                    int j = i;
                    while ((road.charAt(j) != '.' && chars[j] != 'R' && chars[j] != 'G' && chars[j] != 'O')) {
                        j++;
                    }
                    if (road.charAt(j) == '.' && chars[j] == '.') {
                        roadBuilder.append('.');
                        IntStream.range(0, j - i).mapToObj(b -> "C").forEach(roadBuilder::append);
                        i = j;
                    } else if (chars[j] == 'G' && road.charAt(j) != 'C') {
                        roadBuilder.append('.');
                        IntStream.range(0, j - i).mapToObj(b -> "C").forEach(roadBuilder::append);
                        i = j;
                    } else if (chars[j] == 'G' && road.charAt(j) == 'C') {
                        roadBuilder.append('.');
                        IntStream.range(0, j - i - 1).mapToObj(b -> "C").forEach(roadBuilder::append);
                        roadBuilder.append("G");
                        roadBuilder.append("C");
                    }
                } else if (chars[i] == 'R') {
                    if (i % 5 == 0 && i >= 5) {
                        chars[i] = 'G';
                        roadBuilder.append("G");
                    }
                    roadBuilder.append("R");

                } else if (road.charAt(i) == 'G') {
                    if (i % 5 == 0 && i >= 5) {
                        chars[i] = 'R';
                        roadBuilder.append("R");
                    }
                    roadBuilder.append("G");
                } else if (road.charAt(i) == 'O') {
                    roadBuilder.append("R");
                }


            }
            states[k] = roadBuilder.toString();
            road = roadBuilder.toString();
            roadBuilder = new StringBuilder();

        }
        return states;
    }

    private static int[] considerRoadWhereLight(String road) {
        int[] carPosition = IntStream.range(0, road.length()).map(i -> 0).toArray();
        char[] array = road.toCharArray();
        IntStream.range(0, road.length()).filter(i -> array[i] == 'C').forEach(i -> carPosition[i]++);
        return carPosition;
    }

    private static int[] considerRoadWhereCar(String road) {
        int[] lightPosition = IntStream.range(0, road.length()).map(i -> 0).toArray();
        char[] array = road.toCharArray();
        IntStream.range(0, road.length()).filter(i -> array[i] != '.' && array[i] != 'C').forEach(i -> lightPosition[i]++);
        return lightPosition;
    }

    public static boolean allAlone(char[][] house) {
        for (int height = 0; height < house.length; height++) {
            for (int width = 0; width < house[0].length; width++) {
                if (house[height][width] == 'X') {
                    return check(house, height, width);

                }
            }

        }
        return true;
    }

    private static boolean check(char[][] house, int height, int width) {
        if (check(house, height, width)) {
            if (house[height][width] == '#') {
                return true;
            } else if (house[height][width] == 'o') {
                return false;
            }
        }
        return check(house, height + 1, width) &&
                check(house, height, width + 1) &&
                check(house, height - 1, width) &&
                check(house, height, width - 1) &&
                check(house, height + 1, width - 1) &&
                check(house, height + 1, width + 1) &&
                check(house, height - 1, width + 1) &&
                check(house, height - 1, width - 1);
    }

    private static boolean checkBorder(char[][] house, int height, int width) {
        if (height >= 0 && height < house.length && width > 0 && width < house[0].length) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isItInsideHouse(char[][] house, int height, int width) {
        boolean b1 = false;
        boolean b2 = false;
        boolean b3 = false;
        boolean b4 = false;
        int k = height;
        while (k >= 0) {
            if (house[k][width] == '#') {
                b1 = true;
            }
            k--;
        }
        k = height;
        while (k < house.length) {
            if (house[k][width] == '#') {
                b2 = true;
            }
            k++;
        }

        k = width;
        while (k >= 0) {
            if (house[height][k] == '#') {
                b3 = true;
            }
            k--;
        }

        k = width;
        while (k < house[0].length) {
            if (house[height][k] == '#') {
                b4 = true;
            }
            k++;
        }
        return b1 && b2 && b3 && b4;
    }


    public static void main(String[] args) {

        char[][] house = {
                "######".toCharArray(),
                "#  X #".toCharArray(),
                "######".toCharArray()
        };


        System.out.println(allAlone(house));


    }
}

