package daySix;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Orbit {

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("src/input0601"));

        Map<String, List<String>> orbits = new HashMap<>();

        for (String line : lines) {
            String[] orb = line.split("\\)");
            String a = orb[0];
            String orbitA = orb[1];
            List<String> test = orbits.computeIfAbsent(a, key -> new ArrayList<>());
            test.add(orbitA);
        }
        System.out.println(getAmountOrbits(orbits, "COM", 0)); //Part 1
        List<String> path = new ArrayList<>();
        List<String> pathToMe = searchOrbit(orbits, "COM", "YOU", path);
        List<String> pathToSanta = searchOrbit(orbits, "COM", "SAN", path);
        path.clear();
        for (String elem : pathToMe) {
            if (!pathToSanta.contains(elem)) {
                path.add(elem);
            }
        }
        for (String elem : pathToSanta) {
            if (!pathToMe.contains(elem)) {
                path.add(elem);
            }
        }
        System.out.println(path.size());


    }

    static int getAmountOrbits(Map<String, List<String>> orbits, String orbit, int amount) {
        int newAmount = amount;
        List<String> children = orbits.computeIfAbsent(orbit, key -> new ArrayList<>());
        if (!children.isEmpty()) {
            for (String child : children) {
                newAmount += getAmountOrbits(orbits, child, amount + 1);
            }
        }
        return newAmount;
    }

    static List<String> searchOrbit(Map<String, List<String>> orbits, String current, String orbit, List<String> path) {
        List<String> currentPath = new ArrayList<>(path);
        if (current.equals(orbit)) {
            return path;
        } else {
            currentPath.add(current);
            List<String> children = orbits.computeIfAbsent(current, key -> new ArrayList<>());
            if (!children.isEmpty()) {
                for (String child : children) {
                    List<String> tempPath = searchOrbit(orbits, child, orbit, currentPath);
                    if(!tempPath.isEmpty()) {
                        return tempPath;
                    }
                }
            }
        }
        return new ArrayList<>();
    }

}
