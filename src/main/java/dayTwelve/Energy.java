package dayTwelve;

public class Energy {

    public static void main(String[] args) {

        int[] positionsX = {13, 8, -5, 2};
        Moon[] moonsX = makeMoons(positionsX);

        int[] positionsY = {9, 14, 4, -6};
        Moon[] moonsY = makeMoons(positionsY);

        int[] positionsZ = {5, -2, 11, 1};
        Moon[] moonsZ = makeMoons(positionsZ);

        int n = 1000;
        doNStep(moonsX, n);
        doNStep(moonsY, n);
        doNStep(moonsZ, n);

        int len = moonsX.length;
        int sumTotal = 0;
        for (int i = 0; i < len; i++) {
            int pot = Math.abs(moonsX[i].getPosition()) + Math.abs(moonsY[i].getPosition()) + Math.abs(moonsZ[i].getPosition());
            int kin = Math.abs(moonsX[i].getVelocity()) + Math.abs(moonsY[i].getVelocity()) + Math.abs(moonsZ[i].getVelocity());
            int total = pot * kin;
            sumTotal += total;
        }

        System.out.println(sumTotal);
    }

    public static void getVelocities(Moon a, Moon b) {
        if (a.getPosition() > b.getPosition()) {
            a.setVelocity(a.getVelocity() - 1);
            b.setVelocity(b.getVelocity() + 1);
        }
        if (a.getPosition() < b.getPosition()) {
            a.setVelocity(a.getVelocity() + 1);
            b.setVelocity(b.getVelocity() - 1);
        }
    }

    public static void setPositions(Moon a) {
        a.setPosition(a.getPosition() + a.getVelocity());
    }

    public static void doStep(Moon[] moons) {
        for (int i = 0; i < moons.length - 1; i++) {
            for (int j = i + 1; j < moons.length; j++) {
                getVelocities(moons[i], moons[j]);
            }
        }
        for (int i = 0; i < moons.length; i++) {
            setPositions(moons[i]);
        }
    }

    public static void doNStep(Moon[] moons, int n) {
        int i = 0;
        while (i < n) {
            doStep(moons);
            i++;
        }
    }

    public static Moon[] makeMoons(int[] positions) {
        Moon[] moons = new Moon[positions.length];
        for (int i = 0; i < positions.length; i++) {
            moons[i] = new Moon(positions[i]);
        }
        return moons;
    }
}