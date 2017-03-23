package daa;

import java.util.Scanner;


public class graph {
    static int n;
    static int r=0;
    static int m;
    static int X[] = new int[20];
    static int G[][] = new int[20][20];
    
    public static void main(String args[])
    {
        int i,j;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number of nodes : ");
        n=scanner.nextInt();
        System.out.println("\nEnter the matrix : ");
           for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
            {
                G[i][j]=scanner.nextInt();
            }
        }
        System.out.println("\nEnter the number of colors : ");
        m=scanner.nextInt();
        mcolor(1);
        System.out.println("\nNumber of possible solutions : "+r);
        if(r==0)
             System.out.println("No solution exists");
            
    }
    static void mcolor(int k)
    {
        do
        {
            nextvalue(k);
            if(X[k]==0)
            {
                return;
            }
            if(k==n)
            {
                System.out.println("SOLUTION : ");
                r++;
                for(int i=1;i<=n;i++)
                {
                    System.out.print(" "+X[i]);
                }
                System.out.println("");
            }
            else
            {
                mcolor(k+1);
            }
        }while(true);
    }
     static void nextvalue(int k)
    {
        int j;
        do
        {
            X[k]=(X[k]+1)%(m+1);
            if(X[k]==0)
            {
                return;
            }
            for(j=1;j<=n;j++)
            {
                if((G[k][j]!=0) && (X[j]==X[k]))
                {
                    break;
                }
            }
            if(j==n+1)
            {
                return;
            }        
        }while(true);
    }
}
