import java.util.Random;
import java.util.Scanner;

public class Timetable {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for(int i=0; i<T; i++){
			int N = in.nextInt();
			int[] Ai = null;
			int[] B = null;
			int[] A = null;
			Ai[0]=0;
			for(int j=1; j<=N;j++){
				Ai[j] = in.nextInt();
				A[j-1] = Ai[j] - Ai[j-1];
			}
			for(int k=0; k<N;k++)
				B[k] = in.nextInt();
			
			//check
			for(int m=0;m<N;m++){
				if(A[m] == B[m]);
			}
			
		}
	}
}
