package daySix;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrbitTest {

    @Test
    void testCountOrbits() {
        Map<String, List<String>> input = new HashMap<>();
        input.put("COM", new ArrayList<>());
        assertEquals(0, Orbit.getAmountOrbits(input, "COM", 0));
    }
}