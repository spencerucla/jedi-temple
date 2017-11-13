public class rotateImage {
    public static void main(String[] args) {
        int[][] a = new int[7][7];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = j+1;
            }
        }
        rotateImage(a);
        System.out.println(print(a));
    }

    private static String print(int[][] a) {
        String s = "";
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                s += String.format("%03d", a[i][j]);
            }
            s += "\n";
        }
        return s;
    }

    private static int[][] rotateImage(int[][] a) {
        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n-1-(2*i); j++) {
                System.out.println("i=" + i + " j=" + j);
                int tmp = a[i][j];
                a[i][j] = a[i][n-j];
                a[i][n-j] = a[n-i][n-j];
                a[n-i][n-j] = a[n-i][j];
                a[n-i][j] = tmp;
            }
        }
        return a;
    }
}
