import java.util.Scanner;

public class Proc extends Thread {

    static int[] cs,request,ts;
    static int n,time;
    int id;
    //boolean cs;
    @Override
    public synchronized void run() {
            if(cs[id] == 1){
                ts[id]=time;
                time++;
            }
        if(cs[id] == 1)
            System.out.println("Process " + id + " sent a request to all.");
        for(int i=0;i<n;i++)
        {
            if(ts[i]<ts[id])
            {
                request[i]++;
             //   System.out.println("Request[" + i + "] = " + request[i]);
                System.out.println("Process " + id + " sent a reply to " + i);
                if(request[i] == n-1)
                    System.out.println("Process " + i + " executing cs");
               
            }
             System.out.println("Timestamp of process  "+i+" is "+ts[i]);
        }
    }

    public Proc(int id) {
        this.id = id;
    }
}

public class RicartAgrawalaNew {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter the total number of processes");
        
        Proc.n = in.nextInt();
        
        Proc.cs = new int[Proc.n];
        Proc[] ps = new Proc[Proc.n];
        Proc.ts=new int[Proc.n];
        Proc.request = new int[Proc.n];
        Proc.time=0;
        
        for(int i=0;i<Proc.n;i++)
        {
            ps[i] = new Proc(i);
            System.out.println("Process " + i + " You want to enter cs");
            int x = in.nextInt();
            System.out.println("");
            
            if(x == 1)
                Proc.cs[i] = 1;
            else
                Proc.cs[i] = 0;
            
            Proc.request[i] = 0;
            Proc.ts[i]=999;
        }
        
        // now lets start them ell.
        
        for(int i=0;i<Proc.n;i++)
        {
            ps[i].start();
        }
        
    }
}


/*
Output:-

Enter the total number of processes
3
Process 0 You want to enter cs
1

Process 1 You want to enter cs
0

Process 2 You want to enter cs
1

Process 0 sent a request to all.
Timestamp of process  0 is 0
Timestamp of process  1 is 999
Timestamp of process  2 is 999
Process 1 sent a reply to 0
Timestamp of process  0 is 0
Timestamp of process  1 is 999
Timestamp of process  2 is 999
Process 2 sent a request to all.
Process 2 sent a reply to 0
Process 0 executing cs
Timestamp of process  0 is 0
Timestamp of process  1 is 999
Timestamp of process  2 is 1
BUILD SUCCESSFUL (total time: 3 seconds)
*/
