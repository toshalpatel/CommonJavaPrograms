import java.util.Scanner;
class Balloons {
	static int R, G, B, K;
	
	public static int combination() {
		int t;
		t = R+G+B;
		return fact(t)/(fact(t-K)*K);
	}
	
	public static int fact(int k) {
		if (k==1)
			return 1;
		else
			return k*fact(k-1);
	}
	
	public static int getMinBalloons() {
		return combination();
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
