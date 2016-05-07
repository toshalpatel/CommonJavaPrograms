import java.util.Scanner;

class ZombieEscape {
	public static void main(String[] args){
		long p=0;
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++){
			int N = in.nextInt();//number of zombies 
			int K = in.nextInt();//possible no of colors
			//parent and child should not have same color of cars
			// to maximize the number of possiblities, each one of the zombie has a parent child relation, or in other words, one parent cannot have more than one child.
			p=p+(K-1)*(N-1)+K;
			System.out.println(p);
		}
	}
}
