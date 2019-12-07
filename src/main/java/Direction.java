class Direction {

    private char direction;
    private int distance;

    @Override
    public String toString() {
        return "Direction{" +
                "direction=" + direction +
                ", distance=" + distance +
                '}';
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    Direction(char direction, int distance) {
        this.direction = direction;
        this.distance = distance;
    }
}
