import java.util.Scanner;

public class Color {
	public static void main(String[]args) {
		int R=0,G=0,B=0;
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int j=0;j<T;j++) {
			int N = in.nextInt();
			String S = in.next();
			String[] c = new String[N];
			for(int i=0; i<N; i++)
				c[i] = S.substring(i,i+1);
			for(String c1 : c) {
				if(c1.equalsIgnoreCase("R"))
					R++;
				if(c1.equalsIgnoreCase("G"))
					G++;
				if(c1.equalsIgnoreCase("B"))
					B++;
			}
			if(R>G && R>B)
				System.out.println(G+B);
			if(G>B && G>R)
				System.out.println(R+B);
			if(B>G && B>R)
				System.out.println(R+G);
			if(R==G && R==B && B==G)
				System.out.println(0);
		}
	}
}
