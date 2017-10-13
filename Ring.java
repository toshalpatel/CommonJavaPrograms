/* Implementation of Ring Election Algorithm */

import java.util.Scanner;

public class Ring {
    
    public static int Coordinate(int a[][],int start)
    {   
        int k=1,t=0;
        int elect[] = new int [10];
        elect[0]=a[start][0];
        int s =(start+1)%a.length;
        for(int i=s;i!=start;)
        {
            if(a[i][1]==1)
               elect[k++] = a[i][0]; 
            i = (i+1)%a.length;
        }
        for(int i=0;i<k;i++)
        {
            if(elect[i] > t)
                t=elect[i];
        }
        
        return t;
        
    }
  
    public static void main(String[] args) {
        System.out.println("Enter nos of process");
        Scanner in = new Scanner (System.in);
        int n = in.nextInt();
        System.out.println("Enter the Process id and its state (Up = 1 & down =0)");
        int a[][]= new int[n][2];
        for(int i=0;i<n;i++)
        {   a[i][0] = in.nextInt();
            a[i][1]= in .nextInt();
        } 
        System.out.println("Enter the process that wants to initiates");
        int start = in.nextInt();
        for(int i=0;i<a.length;i++)
        {
            if(a[i][0]==start)
             start =i;
        }
        
        System.out.println("Now the Cordinator is "+Coordinate(a,start));
        
        
    }
        
}
