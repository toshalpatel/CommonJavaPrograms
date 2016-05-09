/*In a parallel world of zombies, there are N zombies. There are infinite number of unused cars,
each of same model only differentiated by the their colors. The cars are of K colors.
A zombie parent can give birth to any number of zombie-children (possibly zero),
i.e. each zombie will have its parent except the head zombie which was born in the winters by combination of ice and fire.
Now, zombies are having great difficulties to commute to their offices without cars,
so they decided to use the cars available. Every zombie will need only one car.
Head zombie called a meeting regarding this, in which he will allow each zombie to select a car for him.
Out of all the cars, the head zombie chose one of cars for him. Now, he called his children to choose the cars for them.
After that they called their children and so on till each of the zombie had a car. Head zombie knew that it won't
be a good idea to allow children to have cars of same color as that of parent, as they might mistakenly use that.
So, he enforced this rule during the selection of cars.
Professor James Moriarty is a criminal mastermind and has trapped Watson again in the zombie world.
Sherlock somehow manages to go there and met the head zombie. Head zombie told Sherlock that they will let
Watson free if and only if Sherlock manages to tell him the maximum number of ways in which the cars can be
selected by N Zombies among all possible hierarchies. A hierarchy represents parent-child relationships among the N zombies.
Since the answer may be large, output the answer modulo 109 + 7. Sherlock can not compute big numbers, so he confides you
to solve this for him.*/

import java.util.Scanner;

class ZombieEscape {
	public static void main(String[] args){
		long p;
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; i++){
			int N = in.nextInt();//number of zombies 
			int K = in.nextInt();//possible no of colors
			//parent and child should not have same color of cars
			/* to maximize the number of possiblities, each one of the zombie has a parent child relation, 
			or in other words, one parent cannot have more than one child.*/
			p=K;
			for(int j=0;j<N-1;j++)
				p=p*(K-1);
			System.out.println(p);
		}
	}
}
