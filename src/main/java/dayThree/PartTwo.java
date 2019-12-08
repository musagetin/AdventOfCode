package dayThree;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class PartTwo {
    public static void main(String[] args) throws Exception {

        List<String> lines = Files.readAllLines(Paths.get(PartTwo.class.getResource("/input0301").toURI()), Charset.defaultCharset());

        List<Direction> directionsForFirstWire = new ArrayList<>();
        List<Direction> directionsForSecondWire = new ArrayList<>();

        String[] inputForFirstWire = lines.get(0).split(",");
        for (String i : inputForFirstWire) {
            directionsForFirstWire.add(new Direction(i.charAt(0), Integer.parseInt(i.substring(1))));
        }

        String[] inputForSecondWire = lines.get(1).split(",");
        for (String i : inputForSecondWire) {
            directionsForSecondWire.add(new Direction(i.charAt(0), Integer.parseInt(i.substring(1))));
        }

        WireCross firstWire = new WireCross(new HashSet<>(), 0, 0, 0);
        WireCross secondWire = new WireCross(new HashSet<>(), 0, 0, 0);

        for (Direction direction : directionsForFirstWire) {
            firstWire.letsGo(direction);
        }

        for (Direction direction : directionsForSecondWire) {
            secondWire.letsGo(direction);
        }

        Comparator<Triple> comparator = (o1, o2) -> {
            int r = Integer.compare(o1.getX(), o2.getX());
            if (r == 0) {
                return Integer.compare(o1.getY(), o2.getY());
            }
            return r;
        };

        TreeSet<Triple> tempSetFirst = new TreeSet<>(comparator);
        TreeSet<Triple> tempSetSecond = new TreeSet<>(comparator);

        for (Triple triple : firstWire.getNode()) {
            if (secondWire.getNode().contains(triple)) {
                tempSetFirst.add(triple);
            }
        }

        for (Triple triple : secondWire.getNode()) {
            if (tempSetFirst.contains(triple)) {
                tempSetSecond.add(triple);
            }
        }

        Iterator<Triple> valueFirst = tempSetFirst.iterator();
        Iterator<Triple> valueSecond = tempSetSecond.iterator();
        int steps = Integer.MAX_VALUE;

        while (valueFirst.hasNext()) {
            int temp = valueFirst.next().getLength() + valueSecond.next().getLength();
            if (temp < steps) {
                steps = temp;
            }
        }

        System.out.println(steps);


    }


}
