//min no of ways to kind k same color balloons
import java.util.Scanner;
class Balloons {
	static int R, G, B, K;
	
	public static int fact(int k) {
		if (k==1)
			return 1;
		else
			return k*fact(k-1);
	}
	
	public static int getMinBalloons() {
		int t;
		if (K==1)
			return 1;
		else
		{
			t= fact(R)/(fact(R-K)*fact(K)) + fact(G)/(fact(G-K)*fact(K)) + fact(B)/(fact(B-K)*fact(K));
			return t;
		}
	}
	
	public static void main(String[]args) {
		Scanner in =new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0;i<T;i++) {
			R = in.nextInt();
			G = in.nextInt();
			B = in.nextInt();
			K = in.nextInt();
			System.out.println(getMinBalloons());
		}
	}
}
