public class Main {
    public static void main(String[] args) {
        long[] c = new long[7];
        double[] x = new double[14];
        double[][] y = new double[7][14];

        for (int i = 0; i < 7; i++) {
            c[i] = (long) (4 + 2 * i);
        }

        for (int i = 0; i < 14; i++) {
            x[i] = Math.random() * 28 - 14;
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 14; j++) {
                if (c[i] == 10) {
                    y[i][j] = Math.pow(Math.log(Math.pow((Math.PI / 2) / Math.abs(x[j]), x[j])), (Math.cbrt(Math.log(Math.abs(x[j]))) / 2));
                }
                else if (c[i] == 4 || c[i] == 6 || c[i] == 14) {
                    y[i][j] = Math.atan(Math.pow(Math.E, Math.cbrt(-1 * Math.pow(-1 * Math.tan(x[j]), 2))));
                }
                else {
                    y[i][j] = Math.cos(Math.sin(Math.sin(Math.pow(Math.E, x[j]))));
                }
            }
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 14; j++) {
                System.out.printf("%8.5f", y[i][j]);
                System.out.print(' ');
            }
            System.out.print('\n');
        }
    }
}
