import java.util.*;

public class SimulatedAnnealing {
	private final static int N=8;
	int nodesGenerated;
	private Queen[] startState;
	private Node start;
	
	public SimulatedAnnealing(Queen[] s){
		nodesGenerated = 0;
		start = new Node();
		startState = new Queen[N];
		
		for(int i=0; i<N; i++){
			startState[i] = new Queen(s[i].getRow(), s[i].getColumn());
		}
		start.setState(startState);
		start.computeHeuristic();
	}
	
	public void startState(){
		start = new Node();
		startState = new Queen[N];
		Random gen = new Random();
		
		for(int i=0; i<N; i++){
			startState[i] = new Queen(gen.nextInt(N), i);
		}
		start.setState(startState);
		start.computeHeuristic();
	}
	
	public Node simulatedAnneal(double initialTemp, double step){
		Node currentNode = start;
		double temperature = initialTemp;
		double val = step;
		double probability;
		int delta;
		double determine;
		
		Node nextNode = new Node();
		
		while(currentNode.getHeuristic()!=0 && temperature > 0){
			//select a random neighbour from currentNode
			nextNode = currentNode.getRandomNeighbour(currentNode);
			nodesGenerated++;
			
			if(nextNode.getHeuristic()==0)
				return nextNode;
			
			delta = currentNode.getHeuristic() - nextNode.getHeuristic();
			
			if(delta > 0){ //currentNode has a higher heuristic
				currentNode = nextNode;
			}else{ 
				probability = Math.exp(delta/temperature);
				//Do we want to choose nextNode or stick with currentNode?
				determine = Math.random();
				
				if(determine <= probability){ //choose nextNode
					currentNode = nextNode;
				}
			}
			temperature = temperature - val;
		}
		
		return currentNode;
	}
	
	public int getNodesGenerated(){
		return nodesGenerated;
	}
	public Node getStartNode(){
		return start;
	}
}


EightQueens.java

import java.util.*;
import java.text.NumberFormat;

public class EightQueens {
	public EightQueens(){
	}
	
	public static void main(String[] args){
		EightQueens board = new EightQueens();
		int numberOfRuns = 2000;
		int hillClimbNodes=0, randomRestartNodes=0, annealNodes=0;
		int hillClimbSuccesses=0, randomRestartSuccesses=0, annealSuccesses=0;
		
		for(int i=0; i<numberOfRuns; i++){
			Queen[] startBoard = board.generateBoard();

			HillClimbing hillClimber = new HillClimbing(startBoard);
			RandomRestart randomRestart = new RandomRestart(startBoard);
			SimulatedAnnealing anneal = new SimulatedAnnealing(startBoard);			
			Node hillSolved = hillClimber.hillClimbing();
			Node randomSolved = randomRestart.randomRestart();
			Node annealSolved = anneal.simulatedAnneal(28, 0.0001);
			
			if(hillSolved.getHeuristic()==0){
				//System.out.println("Hill Climbing Solved:\n"+hillSolved);
				hillClimbSuccesses++;
			}
			if(randomSolved.getHeuristic()==0){
				//System.out.println("Random Restart Solved:\n"+randomSolved);
				randomRestartSuccesses++;
			}
			if(annealSolved.getHeuristic()==0){
				//System.out.println("Anneal Solved:\n"+annealSolved);
				annealSuccesses++;
			}			
			hillClimbNodes += hillClimber.getNodesGenerated();
			randomRestartNodes += randomRestart.getNodesGenerated();
			annealNodes += anneal.getNodesGenerated();
		}
		
		System.out.println("Hill climb successes: "+hillClimbSuccesses);
		System.out.println("Random restart successes: "+randomRestartSuccesses);
		System.out.println("Simulated Annealing successes: "+annealSuccesses);
		System.out.println();
		
		double hillClimbPercent = (double)hillClimbSuccesses/(double)numberOfRuns;
		System.out.println(hillClimbPercent);
		double randomRestartPercent = (double)(randomRestartSuccesses/numberOfRuns);
		double annealPercent = (double)(annealSuccesses/numberOfRuns);
		NumberFormat fmt = NumberFormat.getPercentInstance();
		
		System.out.println("Hill climbing:\nNodes: "+hillClimbNodes);
		System.out.println("Percent successes: "+fmt.format(hillClimbPercent));
		System.out.println("Random Restart:\nNodes: "+randomRestartNodes);
		System.out.println("Percent successes: "+fmt.format(randomRestartPercent));
		System.out.println("Simulated Annealing:\nNodes: "+annealNodes);
		System.out.println("Percent successes: "+fmt.format(annealPercent));
	}
	
	public Queen[] generateBoard(){
		Queen[] start = new Queen[8];
		Random gen = new Random();
		for(int i=0; i<8; i++){
			start[i] = new Queen(gen.nextInt(8),i);
		}
		return start;
	}
}
