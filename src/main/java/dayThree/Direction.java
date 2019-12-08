package dayThree;

class Direction {

    private char direction;
    private int distance;

    @Override
    public String toString() {
        return "dayTree.Direction{" +
                "direction=" + direction +
                ", distance=" + distance +
                '}';
    }

    public char getDirection() {
        return direction;
    }

    public int getDistance() {
        return distance;
    }

    Direction(char direction, int distance) {
        this.direction = direction;
        this.distance = distance;
    }
}
