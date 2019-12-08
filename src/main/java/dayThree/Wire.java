package dayThree;

import java.util.HashSet;

public class Wire {
    private HashSet<Pair> node;
    private int endX;
    private int endY;

    @Override
    public String toString() {
        return "dayTree.Wire{" +
                "node=" + node +
                ", endX=" + endX +
                ", endY=" + endY +
                '}';
    }

    HashSet<Pair> getNode() {
        return node;
    }

    private int getEndX() {
        return endX;
    }

    private int getEndY() {
        return endY;
    }


    Wire(HashSet<Pair> node, int endX, int endY) {
        this.node = node;
        this.endX = endX;
        this.endY = endY;
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
    }

    private void goRight(int distance) {
        HashSet<Pair> node = this.getNode();
        for (int i = 1; i <= distance; i++) {
            node.add(new Pair(this.getEndX() + i, this.getEndY()));
        }
        this.endX += distance;
    }

    private void goLeft(int distance) {
        HashSet<Pair> node = this.getNode();
        for (int i = 1; i <= distance; i++) {
            node.add(new Pair(this.getEndX() - i, this.getEndY()));
        }
        this.endX -= distance;
    }

    private void goUp(int distance) {
        HashSet<Pair> node = this.getNode();
        for (int i = 1; i <= distance; i++) {
            node.add(new Pair(this.getEndX(), this.getEndY() + i));
        }
        this.endY += distance;
    }

    private void goDown(int distance) {
        HashSet<Pair> node = this.getNode();
        for (int i = 1; i <= distance; i++) {
            node.add(new Pair(this.getEndX(), this.getEndY() - i));
        }
        this.endY -= distance;
    }
}
