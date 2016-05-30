import java.util.Scanner;

public class PlantingTrees {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0;i<T;i++){
			if(T<=40000 && T>=1){
				int flag;//size of the array
				int N;
				
				do {
					N = in.nextInt();
					if(N>=2 && N<=100000){
						flag=0;
						continue;
					}
					else {
						System.out.println("Number of trees can be any value from 2 to 100000.\nPlease reenter the value:");
						flag=1;
					}
				}while(flag==1);
				
				int[] A = new int[N];//(A[i],A[j]) gives the coordinates of trees
				int sum=0;
				for(int j=0;j<N;j++){
					A[j]=in.nextInt();
					sum++;
					if(sum<=200000)
						continue;
					else {
						System.out.println("The total co-ordinates should sum upto 200,000.\nPlease reenter the values:");
						j=0;
						for(int k=0;k<=j;k++)
							A[k]=0;
						continue;
					}
				}
				
			}
		}
	}
}
