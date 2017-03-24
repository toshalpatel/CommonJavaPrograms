import java.util.Scanner;

public class edit {
    public static void main(String args[])
    {
        String operation[][]= new String[100][100];
        Scanner sc = new Scanner(System.in);
        String s,t;
        int n,m,i,j;
        char a[]=new char[100];
        char b[]=new char[100];
        int cost[][]=new int[50][50];
        
        System.out.println("Enter the source string:");
        s=sc.next();
        System.out.println("Enter the target string:");
        t=sc.next();
        n=s.length();
        m=t.length();
        a=s.toCharArray();
        b=t.toCharArray();
        for(i=0;i<=n;i++)
        {
            cost[i][0]=i;
        }
        for(j=0;j<=m;j++)
        {
           cost[0][j]=j;
        }
        for(i=0;i<=n;i++)
        {
            for(j=0;j<=m;j++)
            {
               if((i==j)&&(j==0))
                   cost[i][j]=0;
                 else if(i>0 && j==0)
                {
                    cost[i][j]=cost[i-1][j]+D(a[i-1]);
                    operation[i][j]="Delete";
                }
                else if(i==0 && j>0)
                {
                    cost[i][j]=cost[0][j-1]+I(b[j-1]);
                    operation[i][j]="Insert";
                }
                else if(i>0 && j>0)
                {
                    cost[i][j]=min((cost[i-1][j]+D(a[i-1])),(cost[i-1][j-1]+C(a[i-1],b[j-1])),(cost[i][j-1]+I(b[j-1])));
                    if((cost[i][j]==cost[i-1][j-1]+C(a[i-1],b[j-1])) && C(a[i-1],b[j-1])==2)
                            operation[i][j]="Change";
                    else if((cost[i][j]==cost[i-1][j-1]+C(a[i-1],b[j-1])) && C(a[i-1],b[j-1])==0)
                        operation[i][j]="No Change";
                    else if(cost[i][j]==cost[i-1][j]+D(a[i-1]))
                        operation[i][j]="Delete";
                    else if(cost[i][j]==cost[i][j-1]+I(b[j-1]))
                        operation[i][j]="Insert";
                }
            }
        }
        System.out.println("Cost matrix:");
        for(i=0;i<=n;i++)
        {
            for(j=0;j<=m;j++)
            {
                System.out.print(cost[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("Edit Distance= "+cost[n][m]);
        System.out.println("\nOperations:\n");
        operations(operation,n,m);
    }
    static void operations(String operation[][],int m,int n)
    {
        if(m==0 && n==0)
            return;
        else if(operation[m][n].equals("Change") || operation[m][n].equals("No Change"))
        {
            operations(operation,m-1,n-1);
            System.out.println(operation[m][n]);  
        }
        else if(operation[m][n].equals("Insert"))
        {
            operations(operation,m,n-1);
            System.out.println(operation[m][n]);
        }
        else
        {
            operations(operation,m-1,n);
            System.out.println(operation[m][n]);
        }    
    }
      static int D(char x)
    {
        return 1;
    }
    static int min(int x,int y,int z)
    { 
        if(x<y && x<z)
        {
            return x;
        }
        else if(y<x && y<z)
        {
            return y;
        }
        else if(x==y && y==z)
        {
            return y;
        }
        else if(x==z && x<y)
        {
            return x;
        }
        else if(x==y && x<z)
        {
            return y;
        }
        else
        {
            return z;
        }
    }
    static int C(char x,char y)
    {
        if(x==y)
            return 0;
        else
            return 2;
    }
    static int I(char x)
    {
        return 1;
    }
}
