import java.util.Scanner;

public class LamportClock{
    
    static Scanner in;
    static int n;
    static Process[] P;
    
    public class Process{
        int ne;
        int[] e,c;
        int[] visited;
        public void getEvents(){
            System.out.println("Enter the number of events in process:");
            ne = in.nextInt();
            
            c = new int[ne];
            e = new int[ne];
            System.out.println("Enter the event matrix:");
            for(int j=0; j<ne; j++){
                e[j] = in.nextInt();
            }
        }
        
        public void initializeEvent(int limit){;
            e[0]=0;
            visited = new int[ne];
            for(int i=0; i<limit; i++){
                c[i]=0;
                visited[i] = 0;
            }
        }
    }
    
    static void getClock(Process Q){
        for (int j=1; j<Q.ne; j++){
            
            if(Q.e[j]==0 && Q.visited[j] == 0){
                Q.c[j] = Q.e[j-1] + 1;
                Q.visited[j] = 1;
            }
            else{
                if (Q.visited[j] == 0){
                    int l,k;
                    l = Q.e[j] % 10;
                    k = Q.e[j] / 10;
                    if(P[k-1].c[l-1] == 0 && k!=0)
                        getClock(P[k-1]);
                    else{
                        if(P[k-1].c[l-1] > Q.c[j-1]){
                            Q.c[j] = P[k-1].e[l-1] + 1;
                            Q.visited[j] = 1;
                        }
                        else{
                            Q.c[j] = Q.e[j] + 1;
                            Q.visited[j] = 1;
                        }
                    }
                }
            }
        }
    }
    
    public static void main(String[] args){
    	LamportClock lc = new LamportClock();
        System.out.println("Enter the number of processes:");
        in = new Scanner(System.in);
        n = in.nextInt();
        P = new Process[n];
        for(int i=0; i<n; i++){
            P[i] = lc.new Process();
            P[i].getEvents();
            P[i].initializeEvent(P[i].ne);
        }
        
        P[0].c[0] = 1;
        for(int i=0; i<n; i++)
            getClock(P[i]);

        System.out.println("The Lamport Clock results as:");
        for(int i=0; i<n; i++){
            System.out.print("P"+(i+1)+": ");
            for(int j=0; j<P[i].ne; j++)
                System.out.print(P[i].c[j]+" ");
            System.out.println();
        }
    }
}
