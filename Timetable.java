import java.util.Scanner;

public class Timetable {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int[] C = new int[T];
		for(int i=0; i<T; i++){
			int N = in.nextInt();
			int[] Ai = new int[N+1];
			int[] B = new int[N+1];
			int[] A = new int[N+1];
			Ai[0]=0;
			for(int j=1; j<=N; j++){
				Ai[j] = in.nextInt();
				A[j-1] = Ai[j] - Ai[j-1];
			}
			for(int k=0; k<N; k++)
				B[k] = in.nextInt();
			
			int complete=0;
			//check
			for(int m=0;m<N;m++){
				if(A[m] >= B[m])
					complete++;
			}
			C[i] = complete;
		}
		for(int l : C)
		System.out.println(l);
	}
}
