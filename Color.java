import java.util.Scanner;

public class Color {
	public static void main(String[]args) {
		int R=0,G=0,B=0;
		Scanner in = new Scanner(System.in);
		int T = in.nextInt(); // number of test cases
		for(int j=0;j<T;j++) {
			int N = in.nextInt(); //number of rooms to be colored by RGB such that each room is of same color such that min number of rooms are painted
			int N = in.nextInt();
			if(N==0)
				System.out.println("no rooms?!");
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
			if(c.length==R || c.length==B || c.length==G)
				System.out.println(0);
			else if(R>G || R>B)
				System.out.println(G+B);
			else if(G>B || G>R)
				System.out.println(R+B);
			else if(B>G || B>R)
				System.out.println(R+G);
			else if(R==G && R==B && B==G)
				System.out.println(2*R);
		}
	}
}
