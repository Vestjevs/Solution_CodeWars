
import javax.print.DocFlavor;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class FindTheCheapestPath {

    private static final String UP = "up";
    private static final String RIGHT = "right";
    private static final String DOWN = "down";
    private static final String LEFT = "left";

    public static List<String> cheapestPath(int[][] field, Point start, Point finish) {
        if (start.x == finish.x && start.y == finish.y) {
            return new ArrayList<>();
        }
        List<String> path = new ArrayList<>();
        boolean[][] visited = new boolean[field.length][field.length];
        int pathLength = field[start.x][start.y];
        int x = start.x;
        int y = start.y;
        visited[x][y] = true;
        while (x != finish.x || y != finish.y) {
            if (x > 0 && x < field.length - 1 && y > 0 && y < field.length - 1) {
                int min = Math.min(Math.min(field[x - 1][y], field[x + 1][y]), Math.min(field[x][y - 1], field[x][y + 1]));
                if (min == Math.min(field[x - 1][y], field[x + 1][y])) {
                    if (min == field[x - 1][y] && !visited[x - 1][y]) {
                        visited[x - 1][y] = true;
                        pathLength += min;
                        path.add(UP);
                        x--;
                    } else {
                        visited[x + 1][y] = true;
                        pathLength += min;
                        path.add(DOWN);
                        x++;
                    }
                } else {
                    if (min == field[x][y - 1] && !visited[x][y - 1]) {
                        visited[x][y] = true;
                        path.add(LEFT);
                        y--;
                        pathLength += min;
                    } else {
                        visited[x][y + 1] = true;
                        pathLength += min;
                        path.add(RIGHT);
                        y++;
                    }
                }
            } else if (x == 0 && y > 0 && y < field.length - 1) {
                int min = Math.min(field[x][y - 1], Math.min(field[x + 1][y], field[x][y + 1]));
                if (min == field[x][y - 1] && !visited[x][y - 1]) {
                    visited[x][y - 1] = true;
                    pathLength += min;
                    path.add(LEFT);
                    y--;
                } else if (min == field[x + 1][y] && !visited[x + 1][y]) {
                    visited[x + 1][y] = true;
                    pathLength += min;
                    path.add(DOWN);
                    x++;
                } else {
                    visited[x][y + 1] = true;
                    pathLength += min;
                    path.add(RIGHT);
                    y++;
                }
            } else if (x == 0 && y == field.length - 1) {
                int min = Math.min(field[x][y - 1], field[x + 1][y]);
                if (min == field[x][y - 1] && !visited[x][y - 1]) {
                    visited[x][y - 1] = true;
                    pathLength += min;
                    path.add(LEFT);
                    y--;
                } else {
                    visited[x + 1][y] = true;
                    pathLength += min;
                    path.add(DOWN);
                    x++;
                }

            } else if (x > 0 && x < field.length - 1 && y == field.length - 1) {
                int min = Math.min(field[x - 1][y], Math.min(field[x][y - 1], field[x + 1][y]));
                if (min == field[x - 1][y] && !visited[x - 1][y]) {
                    visited[x - 1][y] = true;
                    pathLength += min;
                    path.add(UP);
                    x--;
                } else if (min == field[x][y - 1] && !visited[x][y - 1]) {
                    visited[x][y - 1] = true;
                    pathLength += min;
                    path.add(LEFT);
                    y--;
                } else {
                    visited[x + 1][y] = true;
                    pathLength += min;
                    path.add(DOWN);
                    x++;
                }
            } else if (x == field.length - 1 && y == field.length - 1) {
                int min = Math.min(field[x - 1][y], field[x][y - 1]);
                if (min == field[x - 1][y] && !visited[x - 1][y]) {
                    visited[x - 1][y] = true;
                    pathLength += min;
                    path.add(UP);
                    x--;
                } else {
                    visited[x][y - 1] = true;
                    pathLength += min;
                    path.add(LEFT);
                    y--;
                }
            } else if (x == field.length - 1 && y > 0 && y < field.length - 1) {
                int min = Math.min(field[x][y + 1], Math.min(field[x - 1][y], field[x][y - 1]));
                if (min == field[x][y + 1] && !visited[x][y + 1]) {
                    visited[x][y + 1] = true;
                    pathLength += min;
                    path.add(RIGHT);
                    y++;
                } else if (min == field[x - 1][y] && !visited[x - 1][y]) {
                    visited[x - 1][y] = true;
                    pathLength += min;
                    path.add(UP);
                    x--;
                } else {
                    visited[x][y - 1] = true;
                    pathLength += min;
                    path.add(LEFT);
                    y--;
                }

            } else if (x == field.length - 1 && y == 0) {
                int min = Math.min(field[x - 1][y], field[x][y + 1]);
                if (min == field[x - 1][y] && !visited[x - 1][y]) {
                    visited[x - 1][y] = true;
                    pathLength += min;
                    path.add(UP);
                    x--;
                } else {
                    visited[x][y + 1] = true;
                    pathLength += min;
                    path.add(RIGHT);
                    y++;
                }

            } else if (x > 0 && x < field.length - 1 && y == 0) {
                int min = Math.min(field[x - 1][y], Math.min(field[x][y + 1], field[x + 1][y]));
                if (min == field[x - 1][y] && !visited[x - 1][y]) {
                    visited[x - 1][y] = true;
                    pathLength += min;
                    path.add(UP);
                    x--;
                } else if (min == field[x][y + 1] && !visited[x][y + 1]) {
                    visited[x][y + 1] = true;
                    pathLength += min;
                    path.add(RIGHT);
                    y++;
                } else {
                    visited[x + 1][y] = true;
                    pathLength += min;
                    path.add(DOWN);
                    x++;
                }
            } else if (x == 0 && y == 0) {
                int min = Math.min(field[x + 1][y], field[x][y + 1]);
                if (min == field[x + 1][y] && !visited[x + 1][y]) {
                    visited[x + 1][y] = true;
                    pathLength += min;
                    path.add(DOWN);
                    x++;
                } else {
                    visited[x][y + 1] = true;
                    pathLength += min;
                    path.add(RIGHT);
                    y++;
                }

            }

        }
        return path;

    }

    public static void main(String[] args) {
        int[][] field = {{1, 4, 1},
                         {1, 9, 1},
                         {1, 1, 1}};
        Point start = new Point(0, 0), finish = new Point(0, 2);
        System.out.println(cheapestPath(field, start, finish));
    }


}
