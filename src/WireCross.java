import java.util.HashSet;

public class WireCross {
    private HashSet<Triple> node;
    private int endX;
    private int endY;
    private int endZ;

    HashSet<Triple> getNode() {
        return node;
    }

    private int getEndX() {
        return endX;
    }

    private int getEndY() {
        return endY;
    }


    @Override
    public String toString() {
        return "WireCross{" +
                "node=" + node +
                ", endX=" + endX +
                ", endY=" + endY +
                ", endZ=" + endZ +
                '}';
    }

    public int getEndZ() {
        return endZ;
    }

    public void setEndZ(int endZ) {
        this.endZ = endZ;
    }

    WireCross(HashSet<Triple> node, int endX, int endY, int endZ) {
        this.node = node;
        this.endX = endX;
        this.endY = endY;
        this.endZ = endZ;
    }

    void letsGo(Direction direction) {
        switch (direction.getDirection()) {
            case 'R':
                this.goRight(direction.getDistance());
                break;
            case 'L':
                this.goLeft(direction.getDistance());
                break;
            case 'U':
                this.goUp(direction.getDistance());
                break;
            case 'D':
                this.goDown(direction.getDistance());
                break;
        }
        //this.endZ += direction.getDistance();
    }

    private void goRight(int distance) {
        HashSet<Triple> node = this.getNode();
        for (int i = 1; i <= distance; i++) {
            node.add(new Triple(this.getEndX() + i, this.getEndY(), this.getEndZ() + i));
        }
        this.endX += distance;
        this.endZ += distance;
    }

    private void goLeft(int distance) {
        HashSet<Triple> node = this.getNode();
        for (int i = 1; i <= distance; i++) {
            node.add(new Triple(this.getEndX() - i, this.getEndY(), this.getEndZ() + i));
        }
        this.endX -= distance;
        this.endZ += distance;
    }

    private void goUp(int distance) {
        HashSet<Triple> node = this.getNode();
        for (int i = 1; i <= distance; i++) {
            node.add(new Triple(this.getEndX(), this.getEndY() + i, this.getEndZ() + i));
        }
        this.endY += distance;
        this.endZ += distance;
    }

    private void goDown(int distance) {
        HashSet<Triple> node = this.getNode();
        for (int i = 1; i <= distance; i++) {
            node.add(new Triple(this.getEndX(), this.getEndY() - i, this.getEndZ() + i));
        }
        this.endY -= distance;
        this.endZ += distance;
    }
}
