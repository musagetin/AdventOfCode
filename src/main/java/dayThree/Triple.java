package dayThree;

import java.util.Objects;

public class Triple {
    private int x;
    private int y;
    private int length;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triple triple = (Triple) o;
        return x == triple.x &&
                y == triple.y;
    }

    @Override
    public String toString() {
        return "dayTree.Triple{" +
                "x=" + x +
                ", y=" + y +
                ", length=" + length +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Triple(int x, int y, int length) {
        this.x = x;
        this.y = y;
        this.length = length;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLength() {
        return length;
    }

}
