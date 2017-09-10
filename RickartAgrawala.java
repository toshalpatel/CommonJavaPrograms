import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Process{
    
    int pid, ts, requests = 0, replies =0;
    ArrayList<Integer> R = new ArrayList<>();
    ArrayList<Integer> Reply = new ArrayList<>();
    ArrayList<Integer> Deferred = new ArrayList<>();
    boolean req;
    
    public Process(int pid){
        this.pid = pid;
    }
    
    void addReply(int pid){
        Reply.add(pid);
        replies++;
    }
    
    void addRequest(int pid){
        R.add(pid);
        requests++;
    }
    
}

public class RickartAgrawala {
    
    static int n;
    static Process[] p = null;
    
    static void initRA(int cspid, int rpid){
        System.out.println("Process P" + cspid + " is in CS");
        System.out.println("Process P"+rpid+ " is requesting CS");
        
        int ts = request(p[rpid-1], rpid);
        
        for(int i=0; i<n; i++){
            if((ts < p[cspid-1].ts) || (p[i].pid != cspid || p[i].req == false)){
                System.out.println("REPLY from P"+(i+1)+" to P"+rpid);
                p[rpid-1].addReply(i+1);
            }
            else{
                System.out.println("REQUEST deferred from P"+(i+1));
                p[rpid-1].Deferred.add(i);
            }
        }
        
        if(p[cspid].replies == (n-1))
            executeCS(rpid);
        
        for (int i=0; i<p[rpid-1].Deferred.size(); i++)
            System.out.println("REPLY from P"+rpid+" to P"+p[rpid-1].Deferred.get(i));
    }
    
    static void executeCS(int pid){
        System.out.println("P"+pid+" enters CS");
    }
    
    static int request(Process P, int rpid){
        
        Random r = new Random();
        int ts = r.nextInt(8);
        System.out.println("REQUEST("+ts+","+rpid+")");
        p[rpid-1].req = true;
        for (int i=0; i<n && i!=(rpid-1); i++){
            p[i].addRequest(rpid);
        }
        
        return ts;
    }
    
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        n = in.nextInt();
        
        for(int i=0; i<n ; i++){
            p[i] = new Process(i+1);
        }
        
        System.out.print("Enter the process id of process in critical section: ");
        int cspid = in.nextInt() - 1;
        System.out.print("Enter its timestamp: ");
        p[cspid-1].ts = in.nextInt();
        
        System.out.print("Enter the requestng process: ");
        int rpid = in.nextInt() - 1;
        
        System.out.println("Rickart - Agrawala DMX Algo...\n");
        initRA(cspid,rpid);
    }
}
