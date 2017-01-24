package hw1;

import java.io.FileWriter;
import java.io.IOException;

public class RuntimeAnalyzer {

	public static void main(String[] args) throws IOException {
		FileWriter writer = new FileWriter("/home/jmf/workspace/hw1/test.csv");

//		Integer[] ens = {10000,25000000,50000000,65000000,80000000,90000000,105000000,110000000,125000000,140000000,150000000};
		Integer[] ens = {16000,32000,64000,98000,128000,164000};
		
		for (Integer n : ens){
			double t1 = System.currentTimeMillis();
			funcToAnalyze(n);
			double t2 = System.currentTimeMillis();
			double nsquared = Math.pow(n,2);
			String st = n.toString()+','+(t2-t1)+','+nsquared;
			System.out.println(st);
			writer.append(st+'\n');
		}
		writer.close();
	}

	private static void funcToAnalyze(Integer n) {
		double[] a = new double[n];
		double[] b = new double[n];
		double[] c = new double[n];
		double s = 0;	
		
		for (int d=0; d<n; d++){
			a[d] = Math.random()*100;
			b[d] = Math.random()*100;
			c[d] = Math.random()*100;
		}
		
		for (int i=1; i<n; i++){
			for (int j=i; j<n; j++){
				for (int k=j; k<n; k++){
					s += a[i]*b[j]*c[k];
				}
				if (gcd(j,i) == 1){
					j=n;
				}
			}
		}
	}

	private static int gcd(int i, int j) {
		// TODO Auto-generated method stub
		int t;
		while (j != 0){
			t = j;
			j = i % j;
			i = t;
		}
		return i;
	}
}
