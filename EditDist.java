import java.util.Scanner;

public class EditDist {
    public static void main(String[] args) {
        
        System.out.print("Enter string A: ");
        Scanner in = new Scanner(System.in);
        String A = in.next();
        
        System.out.print("Enter string B: ");
        String B = in.next();
        
        int m = A.length();
        int n = B.length();
        int[][] cost;
        int k;
        if (m > n ){
            cost = new int[m+1][m+1];
            k = m+1;
        }
        else{
            k=n+1;
            cost = new int[n+1][n+1];
        }
        //calculating the cost matrix
        for(int i=1; i<k; i++) {
            cost[0][i] = i;
            cost[i][0] = i;
        }
        int c;
        for(int i=1; i<k; i++){
            for(int j=1; j<k; j++){
                int dc = 1 + cost[j-1][i];
                int ic = 1 + cost[j][i-1];
                int uc = 1 + cost[j-1][i-1];
                if(dc>=ic){
                    if(ic>uc) cost[i][j]=uc;
                    else cost[i][j] = uc;
                }
                else {
                    if(dc>uc) cost[i][j]=uc;
                    else cost[i][j] = uc;
                }
            }
        }
        
        for(int v=0; v<k; v++) {
            for(int u=0; u<k; u++)
                System.out.print(cost[v][u]+"\t");
            System.out.print("\n");
        }
    }
}
