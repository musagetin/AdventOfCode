package dayThree;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class PartOne {

    public static void main(String[] args) throws Exception {

        List<String> lines = Files.readAllLines(Paths.get(PartOne.class.getResource("/input0301").toURI()), Charset.defaultCharset());

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

        Wire firstWire = new Wire(new HashSet<>(), 0, 0);
        Wire secondWire = new Wire(new HashSet<>(), 0, 0);

        for (Direction direction : directionsForFirstWire) {
            firstWire.letsGo(direction);
        }

        for (Direction direction : directionsForSecondWire) {
            secondWire.letsGo(direction);
        }

        int distance = Integer.MAX_VALUE;
        for (Pair pair : firstWire.getNode()) {
            if (secondWire.getNode().contains(pair)) {
                int tempDist = Math.abs(pair.getX()) + Math.abs(pair.getY());
                if (tempDist < distance) {
                    distance = tempDist;
                }
            }
        }

        System.out.println(distance);

    }


}
