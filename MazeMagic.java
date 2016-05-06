/*Chef is stuck in a two dimensional maze having N rows and M columns. He needs to get out of the maze 
as soon as possible and arrive at the kitchen in order to serve his hungry customers.
But, he can get out of the maze only if he is able to successfully find any magical path in the given maze.
A path is defined as magical if it starts from any of the cell (a,b) of the maze and ends at the cell (c,d) 
such that the following conditions are satisfied :-
|a - c| + |b - d| = 1
All the cells in the maze are traversed exactly once.
It is allowed to move only in the four directions - up, down, left and right from the current cell.
Input :
First line of the input contains an integer T denoting the number of different types of scenarios.
Each of the next T lines will contain two integers N, M denoting the dimensions of the maze.
Output :
For each of the T scenarios, output a single line containing "Yes" or "No" (without quotes) denoting whether the Chef can get out of the maze or not.*/

import java.util.Scanner;

class MazeMagic {
	public static void main(String[] args) {
		int path[][] = new int[100][100];
		int N,M,T;
		Scanner in = new Scanner(System.in);
		T = in.nextInt();
		
		for(int i=0;i<T;i++){
			N = in.nextInt();
			M = in.nextInt();
			int a,b,c,d,yes=0,no=0;
			for(a=0;a<N;a++){
				for(b=0; b<M; b++){
					for(c=0;c<N; c++){
						for(d=0;d<M; d++) {
							if (b>=d)
								if(a>=c)
									if(((a-c) + (b-d)) == 1)
										yes++;
									else
										no++;
								else
									if(((c-a) + (b-d)) == 1)
										yes++;
									else
										no++;
							else
								if(a>=c)
									if(((a-c) + (d-b)) == 1)
										yes++;
									else
										no++;
								else
									if(((c-a) + (d-b)) == 1)
										yes++;
									else
										no++;
						}
					}
				}
			}
			if(yes>0)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}
