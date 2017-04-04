
import java.util.*;

public class Node implements Comparable<Node>{
	private static final int N=8; //8 queens
	public Queen[] state; //the node's state
	private ArrayList<Node> neighbours;
	private int hn; //heuristic score
	
	public Node(){
		state = new Queen[N]; //empty state
		neighbours = new ArrayList<Node>(); //empty neighbour list
	} 
	
	public Node(Node n){
		state = new Queen[N];
		neighbours = new ArrayList<Node>();
		for(int i=0; i<N; i++)
			state[i] = new Queen(n.state[i].getRow(), n.state[i].getColumn());
		hn=0;
	}
	
	public ArrayList<Node> generateNeighbours(Node startState){
		int count=0;
		
		if(startState==null)
			System.out.println("warning");
		
		for(int i=0; i<N; i++){
			for(int j=1; j<N; j++){
				neighbours.add(count, new Node(startState));
				neighbours.get(count).state[i].moveDown(j);
				//make sure to compute its hn value
				neighbours.get(count).computeHeuristic();
				
				count++;
			}
		}
		
		return neighbours;
	}
	
	public Node getRandomNeighbour(Node startState){
		Random gen = new Random();
		
		int col = gen.nextInt(N);
		int d = gen.nextInt(N-1)+1;
		
		Node neighbour = new Node(startState);
		neighbour.state[col].moveDown(d);
		neighbour.computeHeuristic();
		
		return neighbour;
	}
	
	/**
	 * computes the heuristic, which is the number of 
	 * pieces that can attack each other
	 * @return int
	 */
	public int computeHeuristic(){
	
		for(int i=0; i<N-1; i++){
			for(int j=i+1; j<N; j++){
				if(state[i].canAttack(state[j])){
						hn++;
				}
			}
		}
		
		return hn;
	}
	

	public int getHeuristic(){
		return hn;
	}
	
	public int compareTo(Node n){
		if(this.hn < n.getHeuristic())
			return -1;
		else if(this.hn > n.getHeuristic())
			return 1;
		else 
			return 0;
	}
	
	/**
	 * state setter
	 * @param s
	 */
	public void setState(Queen[] s){
		for(int i=0; i<N; i++){
			state[i]= new Queen(s[i].getRow(), s[i].getColumn());
		}
	}
	
	public Queen[] getState(){
		return state;
	}
	
	public String toString(){
		String result="";
		String[][] board = new String[N][N];
		
		//initialise board with X's to indicate empty spaces
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				board[i][j]="X ";
		
		//place the queens on the board
		for(int i=0; i<N; i++){
			board[state[i].getRow()][state[i].getColumn()]="Q ";
		}
		
		//feed values into the result string
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				result+=board[i][j];
			}
			result+="\n";
		}
		
		return result;
	}
}
