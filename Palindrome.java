import java.util.Scanner;

public class Palindrome {
    int[] x;
    int[][] L;
    int n;
    
             
     Palindrome(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of sequence:");
        n = in.nextInt();
        System.out.println("Enter the sequence:");
        for(int i=0;i<n;i++)
            x[i] = in.nextInt();
        L = new int[n+1][n+1];
    }
    
    int palindromeSubsequence(){
        for(int i=1; i<=n;i++)
            L[i][i] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<n;j++){
                int s = j+i;
                L[j][s] = computeCost(j,s);
                L[s][j] = computeCost(s,j);
            }
        }
        return L[1][n];
    }
    
    int computeCost(int i, int j){
        if(i==j)
            return L[i][j];
        else{
            if(x[i]!=x[j])
                return max(L[i+1][j], L[i][j-1]);
            else{
                if (j==i+1)
                    return 2;
                else
                    return L[i+1][j-1]+2;
            }
        }
    }
    
    int max(int a, int b){
        if (a>b)
            return a;
        else 
            return b;
    }
    
    public static void main(String[] args){
        Palindrome p = new Palindrome();
        int l = p.palindromeSubsequence();
        System.out.println("The longest common subsequence is: "+l);
    }
}
