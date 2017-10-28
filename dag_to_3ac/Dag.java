package distributed;
import java.util.*;

public class Dag {
    static Node a[] =new Node[10];
    static int k =0 ,R1=0, R2=0;
    public void Heuristic(Node node,Node parent)
    {
        if(node.left == null && node.right== null)
            return;
        if(parent.flag==1)
           System.out.println("node.value "+node.value);
        a[k++] = node;
        node.flag=1;
        Heuristic(node.left,node);
        Heuristic(node.right,node);
    }
   
    public static void main(String args[])
    {
        Node n1 = new Node("a",null,null);
        Node n2 = new Node("b",null,null);
        Node n3 = new Node("add t1",n1,n2); 
        Node n4 = new Node("c",null,null);
        Node n5 = new Node("d",null,null);
        Node n6 = new Node("add t2",n4,n5);
        Node n7 = new Node("e",null,null);
        Node n8 = new Node("sub t3",n6,n7);
        Node n9 = new Node("sub t4",n3,n8);
        
        Dag d = new Dag();
        n9.flag=1;
        d.Heuristic(n9,n9);
        
        for(int i=k-1;i>=0;i--)
        {
           String operand[] =  a[i].value.split(" ");
           if(operand[0].equalsIgnoreCase("add"))
           {
               if(R1 == 0)
               {
                   System.out.println("MOV "+a[i].left.value+" R1");
                   System.out.println("ADD "+a[i].right.value+" R1");
                   a[i].value = "R1";
                   R1 = 1;
               }
               else if(R2 ==0)
               {
                   System.out.println("MOV "+a[i].left.value+" R2");
                   System.out.println("ADD "+a[i].right.value+" R2");
                   a[i].value = "R2";
                   R2 = 1;
               }
           }
           if(operand[0].equalsIgnoreCase("Sub") )
           {
               if(R1 == 0 )
               {
                   System.out.println("MOV "+a[i].right.value+" R1");
                   System.out.println("SUB "+a[i].left.value+" R1");
                   a[i].value = "R1";
                   if(a[i].left.value.equals("R2"))
                       R2=0;
                   R1 = 1;
               }
               else if(R2 ==0)
               {
                   System.out.println("MOV "+a[i].right.value+" R2");
                   System.out.println("SUB "+a[i].left.value+" R2");
                   a[i].value = "R2";
                   R2 = 1;
                   if(a[i].left.value.equals("R1"))
                       R1=0;
               }
               
               else if(  a[i].left.value.equals("R1") && a[i].right.value.equals("R2")  )
               { 
                  
                   System.out.println("SUB "+a[i].left.value+" "+a[i].right.value);
                   
               }}}}}
