import java.util.Scanner;

public class FibonacciQueries {
	static long f;
	static int[] A;
	static int N;
	
	public static long fibonacci(long k){
		long a=0,b=1;
		for(int i=0;i<k;i++){
			f=a+(b);
			a=b;
			b=f;
		}
		return f;
	}
	
	public static long sum(long[] b){
		long s=0;
		for(int i=0;i<b.length;i++)
			s=s+b[i];
		return s;
	}
	
	public static long F(int i, int j){
		long[] si = new long[j-i];
		int a=0;
		long s,fi,fs=0;
		for(int c=i;c<j-i;c++){
			si[a] = A[c];
			a++;
		}
		s=sum(si);
		for(int c=0; c<s ; c++) {
			fi=fibonacci(s);
			fs=fs+fi;
		}
		return (fs%000000007);
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
