public class NumberSpiralDiagonals {
    private static final int NORTH = 0;
    private static final int EAST = 1;
    private static final int SOUTH = 2;
    private static final int WEST = 3;

    private int[][] arr;
    private int dir;
    private int i;
    private int j;
    private int k;
    private int n;

    public NumberSpiralDiagonals(int n) {
        arr = new int[n][n];
        dir = NORTH;
        int start = n / 2;
        i = start;
        j = start;
        k = 1;
        this.n = n;
    }

    // x = 1 for right, -1 for left
    private void turn(int x) {
        if (dir == 0 && x == -1)
            dir = 3;
        else dir = (dir + x) % 4;
    }

    // x = 1 for forward, -1 for backward
    private void go(int x) {
        switch (dir) {
            case NORTH:
                i -= x;
                break;
            case EAST:
                j += x;
                break;
            case SOUTH:
                i += x;
                break;
            case WEST:
                j -= x;
                break;
        }
    }

    private boolean rightTurnAllowed() {
        turn(1);
        go(1);
        boolean allowed = (arr[i][j] == 0);
        go(-1);
        turn(-1);
        return allowed;
    }

    public void run() {
        for (int l = 0; l < n * n; l++) {
            arr[i][j] = k++;
            if (rightTurnAllowed()) {
                turn(1);
            }
            go(1);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        sb.append("i=" + i);
        sb.append("j=" + j);
        sb.append("dir=" + dir);
        return sb.toString();
    }

    public static void main(String[] args) {
        NumberSpiralDiagonals nsd = new NumberSpiralDiagonals(5);
        nsd.run();
        System.out.println(nsd);
    }
}
