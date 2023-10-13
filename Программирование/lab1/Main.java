public class Main { 
    public static void main(String[] args) { 
    
	long[] a = new long[10];
	for(int i = 0, k = 2; i < 10; i++){
	    a[i] = k;
	    k += 2;
	}

	double[] x = new double[18];
	for(int i = 0; i <  18; i++) {
            x[i] = Math.random()*20 - 15;
        }

	double[][] c = new double[10][18];
	for(int i = 0; i <  10; i++) {
	    for(int j = 0; j <  18; j++) {
		if (a[i] == 13) {
		    c[i][j] = Math.pow(Math.cos(Math.sin(x[j])), (2 * Math.atan((x[j] - 5) / 2) * Math.E + 1));
		} else if (a[i] == 7 || a[i] == 9 || a[i] == 11 || a[i] == 15 || a[i] == 17) {
		    c[i][j] = Math.atan(1 / (Math.pow(Math.E, Math.sqrt(Math.pow(Math.tan(x[j]), 2)))));
		} else {
		    c[i][j] = Math.asin(Math.pow(1 / (Math.pow(Math.E, Math.acos(Math.sin(x[j])))), 2));
		}
	    }
	
        }
	for(int i = 0; i <  10; i++) {
	    for(int j = 0; j <  18; j++) {
		String str = String.format("%7.4f ", c[i][j]);
		System.out.print(str);
	    }
	    System.out.println();
	}
	
    } 
}
