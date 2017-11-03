import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BullyAlgorithm {

    public static void main(String[] args) {
        int i, st, pr, z, j;
        
        Scanner in = new Scanner(System.in);
        ArrayList<Process> p = new ArrayList<>();
        
        System.out.print("Enter number of processes: ");
        int n = in.nextInt();
        
        for (i = 0; i < n; i++) {
            System.out.println();
            System.out.print("Enter status of process " + (i+1) + ": ");
            st = in.nextInt();
            
            System.out.print("Enter priority of process " + (i+1) + ": ");
            pr = in.nextInt();
            
            p.add(new Process(i+1, st, pr, n));
            p.sort(Process.pri);
        }
        
        System.out.print("\nEnter the initiator: ");
        int start=in.nextInt();
        System.out.println();
        
        for(j = start - 1; j < p.size(); j++)
        { 
            for(i = start - 1; i < p.size(); i++)
            {
                if(p.get(j).status != 0) {
                    if (p.get(i).priority > p.get(j).priority) 
                    {
                        System.out.println("Message sent by " + (j + 1) + " to " + (i + 1));
                    }
                }
            }
            System.out.println();
            for (i = j + 1; i < n; i++)
            {
                if (p.get(i).status!=0) 
                {
                    System.out.println("Alive reply received by " + (j + 1) + " from " + (i + 1));
                    p.get(j).reply[i] = 1;
                }
            }
            System.out.println();
             
            z=0;
            for(i = 0; i < n; i++)
            {
                if(p.get(j).reply[i] == 0)
                    z++;
            }
            if(z == n)
            {
                System.out.println("\nProcess " + (j + 1) +" is the coordinator!");
                break;
            }  
        }
    }
}

class Process {
    int id, status, priority, reply[];

    public Process(int id, int status, int priority, int no) {
        this.id = id;
        this.status = status;
        this.priority = priority;
        this.reply = new int[no];
    }
    
    public static Comparator<Process> pri = (Process t, Process t1) -> {
        int pr1 = t.priority;
        int pr2 = t1.priority;
        
        return pr1-pr2;
    };
}
