package dayEight;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BiosPass {

    public static void main (String[] args) throws IOException, URISyntaxException {
        List<String> lines = Files.readAllLines(Paths.get(BiosPass.class.getResource("/input0801").toURI()), Charset.defaultCharset());
        String pix = lines.get(0);
        List<String> layers = new ArrayList<>();
        int widthLayer = 25;
        int heightLayer = 6;
        int sizeLayer = widthLayer * heightLayer;
        for (int i = 0; i <= pix.length() - sizeLayer;) {
            layers.add(pix.substring(i, i + sizeLayer));
            i += sizeLayer;
        }
        int[][] amountZeroOneTwo = new int[layers.size()][3];
        for (int i = 0; i < layers.size(); i++) {
            for (int j = 0; j < sizeLayer; j++) {
                switch (layers.get(i).charAt(j)) {
                    case '0':
                        amountZeroOneTwo[i][0]++;
                        break;
                    case '1':
                        amountZeroOneTwo[i][1]++;
                        break;
                    case '2':
                        amountZeroOneTwo[i][2]++;
                        break;
                }
            }
        }

        int layerWithMinAmountOfZeros = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < amountZeroOneTwo.length; i++) {
            if (amountZeroOneTwo[i][0] < layerWithMinAmountOfZeros) {
                layerWithMinAmountOfZeros = amountZeroOneTwo[i][0];
                index = i;
            }
        }
        System.out.println("Answer: " + amountZeroOneTwo[index][1] * amountZeroOneTwo[index][2]);
    }
}
