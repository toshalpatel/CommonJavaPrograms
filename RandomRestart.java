RandomRestart.java

public class RandomRestart {
	private HillClimbing hillClimber;
	private int nodesGenerated;
	private Node start;
	
	public RandomRestart(Queen[] startBoard){
		hillClimber = new HillClimbing(startBoard);
		nodesGenerated = 0;
	}
	
	public Node randomRestart(){
		Node currentNode = hillClimber.getStartNode();
		setStartNode(currentNode);
		int heuristic = currentNode.getHeuristic();
				
		while(heuristic!=0){
			Node nextNode = hillClimber.hillClimbing();
			nodesGenerated+=hillClimber.getNodesGenerated();
			heuristic = nextNode.getHeuristic();
			
			if(heuristic!=0){ //restart
				hillClimber = new HillClimbing();
			}else
				currentNode = nextNode;
		}
		return currentNode;
	}
	
	public void setStartNode(Node n){
		start = n;
	}
	
	public Node getStartNode(){
		return start;
	}
	
	public int getNodesGenerated(){
		return nodesGenerated;
	}
}
