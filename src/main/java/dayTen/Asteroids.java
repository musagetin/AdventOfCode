package dayTen;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Asteroids {

    public static void main (String[] args) throws URISyntaxException, IOException {
        List<String> lines = Files.readAllLines(Paths.get(Asteroids.class.getResource("/input1001").toURI()), Charset.defaultCharset());
        int width = lines.get(0).length();
        int length = lines.size();
        System.out.println(width + " x " + length);
        Integer[][] aster = new Integer[width][length];
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (Character.toString(lines.get(i).charAt(j)).equals("#")) {
                    aster[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (aster[i][j] != null) {
                    output.add(getAngleAndQuarter(aster, i, j).stream().distinct().collect(Collectors.toList()).size());
                }
            }
        }

        System.out.println(Collections.max(output) - 1);

    }

    private static double getAngle(double x1, double y1, double x2, double y2) {
        return ((y2 - y1))/(x2 - x1);
    }

    private static int getQuarter(double x1, double y1, double x2, double y2) {
        if ((x2 - x1 >= 0) & (y2 - y1 >= 0)) {
            return 1;
        }
        if ((x2 - x1 < 0) & (y2 - y1 >= 0)) {
            return 4;
        }
        if ((x2 - x1 >= 0) & (y2 - y1 < 0)) {
            return 2;
        }
        if ((x2 - x1 < 0) & (y2 - y1 < 0)) {
            return 3;
        }
        return 0;
    }

    private static List<Pair> getAngleAndQuarter(Integer[][] matrix, int x, int y) {
        List<Pair> output = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != null) {
                    output.add(new Pair(getAngle(x, y, i, j), getQuarter(x, y, i, j)));
                }
            }
        }
        return output;
    }

}
