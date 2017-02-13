import java.util.Scanner;

public class ProcessSc {
    String process;
    int deadline;
    int execution;
    int pprofit;
    
    public ProcessSc(int n){
        Scanner in = new Scanner(System.in);
            System.out.print("Enter process: ");
            process= in.next();
            System.out.print("Enter process execution time: ");
            execution= in.nextInt();
            System.out.print("Enter process deadline: ");
            deadline= in.nextInt();
            System.out.print("Enter process profit: ");
            pprofit= in.nextInt();
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of processes: ");
        int n = in.nextInt();
        ProcessSc[] C = new ProcessSc[5];
        for (int i=0;i<n;i++){
            C[i] = new ProcessSc(n);
        }
        System.out.println("P\tE\tD\tProfit");
        for(int i=0;i<n;i++){
            System.out.println(C[i].process+"\t"+C[i].execution+"\t"+C[i].deadline+"\t"+C[i].pprofit);
        }
        
        //sorting according to profit
        for(int i=0;i<n-1;i++){
            int s = C[i].pprofit;
            for(int j=i+1;j<n;j++){
                if(s<C[j].pprofit){
                    Class t = C[i];
                    C[i]=C[j];
                    C[j]= t;
                }
            }
        }
        
        System.out.println("\nP\tE\tD\tProfit");
        for(int i=0;i<n;i++){
            System.out.println(C[i].process+"\t"+C[i].execution+"\t"+C[i].deadline+"\t"+C[i].pprofit);
        }
        
        //scheduling
        String[] completed = new String[n];
        for(int i = 0; i<n; i++)
            completed[i] = "#";
        int profit = 0;
        int time = 0;
        
        for (int i=0;i<n; i++){
            if (time <= C[i].deadline) {
                profit = profit + C[i].pprofit;
                time = time + C[i].execution;
                completed[i] = C[i].process;
            }
        }
        System.out.println("Total profit: "+profit);
        System.out.println("Completed processes:");
        for(String v: completed){
            if(v != "#")
                System.out.println(v);
            else 
                System.out.println("Deadline missed, process: " + v);
        }
    }
}
