import java.util.Scanner;

public class FibonacciQueries {
	static long f;
	static int[] A;
	static int N;
	
	public static long fibonacci(int k){
		long a=0,b=1;
		for(int i=0;i<k;i++){
			f=a+(b);
			a=b;
			b=f;
		}
		return f;
	}
	
	public static long sum(int[] b){
		long s=0;
		for(int i=0;i<b.length;i++)
			s=s+b[i];
		return s;
	}
	
	public static void F(int i, int j){
		// F function
	}
	
	public static void executeQuery(char Q, int i, int j){
		if (Q=='Q')
			F(i,j);
		else
			A[i]=j;
	}
	
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		char Q;
		int i,j;
		int M = in.nextInt();//no of queries to be performed
		A = new int[N];
		for(int l=0;l<N;l++)
			A[l]=in.nextInt();
		for(int k=0; k<M; k++){
			Q = in.next().charAt(0);
			i = in.nextInt();
			j = in.nextInt();
			executeQuery(Q,i,j);
		}
	}
}
