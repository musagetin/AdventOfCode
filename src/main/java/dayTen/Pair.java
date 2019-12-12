package dayTen;

import java.util.Objects;

public class Pair {
    private double d;
    private int i;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Double.compare(pair.d, d) == 0 &&
                i == pair.i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(d, i);
    }

    public Pair(double d, int i) {
        this.d = d;
        this.i = i;
    }
}
