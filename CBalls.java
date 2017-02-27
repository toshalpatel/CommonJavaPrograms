import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class CBalls {
	
	static int getEndRandomNumber(int N){
		double sum=1;
		for (int o=1; o<=N; o++)
			sum = sum + Math.pow(2, o);
		Double d = new Double(sum);
		int sumi = d.intValue();
		return sumi;
	}
	
	static int[] stringToBinary(String[] A, int limit){
		int[] B = new int[limit];
		for(int i=1; i<=limit; i++){
			if(A[i].equalsIgnoreCase("B")){
				B[i] = 0;
			}
			if(A[i].equalsIgnoreCase("W")){
				B[i] = 1;
			}
		}
		return B;
	}
	
	static int hammingDistance(int[] A){
		int HD = 0;
		return HD;
	}
	
	
	static int[] numberToBinary(int A, int N){
		int[] B = new int[N];
		int[] BT = new int[N];
		int C = A;
		int T;
		for(int i=1; i<=N; i++){
			T = C;
			BT[i] = T%2;
			C = T/2;
		}
		for (int i=1; i<=N; i++)
			B[i] = BT[N];
		return B;
	}
	
	static int hammingDistance(int[] a, int[] b){
		int d=0;
		for(int i=1; i<=a.length; i++)
			if(a[i]!=b[i])
				d++;
		return d;
	}
	
	static int getHammingDistance(int[] x, int[] y, int[] z){
		return hammingDistance(x, z) + hammingDistance(y,z);
	}
	
	static String getString(int[][] A, int index, int N){
		String Z;
		String[] B = new String[index];
		for(int i=1; i<=N; i++){
			if(A[index][i] == 1)
				B[i] = "W";
			else if(A[index][i] == 0)
				B[i] = "B";
		}
		Z = B.toString();
		return Z;
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		
		int T = in.nextInt();
		for(int i=0; i<T; i++){
			String X = in.next();
			String Y = in.next();
			int N = X.length();
			int hd, kx=0, ky=0;
			String[] x = new String[N];
			String[] y = new String[N];
			for(int j=1; j<=N; j++){
				x[kx++] = X.substring(j, j+1);
				y[ky++] = Y.substring(j, j+1);
			}
			int[] xb;
			int[] yb;
			int[] zb;
			xb = stringToBinary(x, N);
			yb = stringToBinary(y, N);
			
			int[] dist = new int[N];
			int[][] z= new int[N][N];
			
			//loop for random values of Z
			for(int j=1; j<=N; j++){
				int zn = r.nextInt(getEndRandomNumber(N));//nextInt returns 0(inclusive) to N(exclusive)
				zb = numberToBinary(zn, N);
				dist[j] = getHammingDistance(xb,yb,zb);
				//store each z in an array
				for(int b:zb)
				z[j][N] = b;
			}
			
			int index=0;
			//finding greatest hamming distance
			for(int k=1; k<N; k++){
				int s=0;
				if(s<dist[k]){
					s=dist[k];
					index = k;
				}
			}
			
			String Z = getString(z, index, N);
			System.out.println(Z);
		}
	}
}
