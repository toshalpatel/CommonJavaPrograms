import java.util.Scanner;

public class LamportClock{
    
    static Scanner in;
    static int n;
    static Process[] P;
    
    public class Process{
        int ne;
        int[] e,c;
    
        public void getEvents(){
            System.out.println("Enter the number of events in process:");
            for(int i=0; i<n; i++){
                System.out.print("P"+(i+1)+": ");
                ne = in.nextInt();
            }
            e = new int[ne];
            System.out.println("Enter the event matrix:");
            for(int j=0; j<ne; j++){
                e[j] = in.nextInt();
            }
        }
        
        public void initializeEvent(){;
            e[0]=0;
            for(int i=0; i<ne; i++)
                c[i]=0;
        }
    }
    
    static void getClock(Process Q){
        for (int i=0;i<n;i++){
            for (int j=1; j<Q.ne; j++){
                if(Q.e[j]==0)
                    Q.c[j] = Q.e[j-1] + 1;
                else{
                    int l,k;
                    l = Q.e[j] % 10;
                    k = Q.e[j] - l*10;
                    if(P[l].c[k] == 0 && k!=0)
                        getClock(P[l]);
                    else{
                        if(P[l].c[k] > Q.c[j-1])
                            Q.c[j] = P[l].e[k] + 1;
                        else
                            Q.c[j] = Q.e[j] + 1;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args){
        in = new Scanner(System.in);
        System.out.println("Enter the number of processes:");
        n = in.nextInt();
        P = new Process[n];
        P[1] = new Process();
        for(int i=0; i<n; i++){
            System.out.println("Process P"+(i+1)+": ");
            P[i].getEvents();
            P[i].initializeEvent();
        }
        for(int i=0; i<n; i++)
            getClock(P[i]);
        for(int i=0; i<n; i++){
            System.out.println("Process "+(i+1));
            for(int j=0; j<P[i].ne; j++){
                System.out.print(P[i].c[j]+"\t");
            }
            System.out.print("\n");
        }
    }
}
