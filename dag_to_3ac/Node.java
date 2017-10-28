package distributed;

public class Node {
    
    public String value;
    public Node left , right;
    public int flag ;

    public Node(String value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.flag=0;
    }
    
    public String toString() {
        return "Node{" + "value=" + value + "} ";
    }
    
}
