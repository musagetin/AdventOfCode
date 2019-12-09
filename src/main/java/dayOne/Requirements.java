package dayOne;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Requirements {

    public static void main (String[] args) throws URISyntaxException, IOException {
        List<String> lines = Files.readAllLines(Paths.get(Requirements.class.getResource("/input0101").toURI()), Charset.defaultCharset());
        int[] masses = new int[lines.size()];
        int sum = 0;
        for (int i = 0; i < lines.size(); i++) {
            masses[i] = Integer.parseInt(lines.get(i));
            sum += masses[i]/3 - 2;
        }
        System.out.println("The sum of the fuel requirements is: " + sum);
    }


}
