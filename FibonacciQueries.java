import java.util.Scanner;

public class FibonacciQueries {
	long f;
	static int[] A;
	static int N;
	
	public long fibonacci(int k){
		long a=0,b=1;
		for(int i=1;i<k+1;i++){
			f=a+(b);
			a=b;
			b=f;
		}
		return f;
	}
	
	public long sum(int[] b){
		long s=0;
		for(int i=0;i<b.length;i++)
			s=s+b[i];
		return s;
	}
	
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		A = new int[N];
		for(int i=0;i<N;i++)
			A[i]=in.nextInt();
		
	}
}
