import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        int a[] = new int[10];
        int b[] = new int[10];
        System.out.println("Enter sequence:");
        Scanner in = new Scanner(System.in);
        int flag=0;
        int i;
        for(i=0; i<10; i++)
            a[i] = in.nextInt();
        int j=0;
        int bi=0;
        
        for(i=1; i<8; i++)
        {
            if((a[i]<a[i+1] && a[i-1]<a[i]) && (a[i+1]<a[i+2] && a[i]<a[i+1]))
                flag=1; //increasing
            else if((a[i-1]<a[i] && a[i]>a[i+1]) && (a[i+1]<a[i+2] && a[i]<a[i+1]))
            {
                bi=a[i+1];
                flag=1;
            }
            else if((a[i-1]<a[i] && a[i]>a[i+1]) && (a[i+1]>a[i+2] && a[i+1]>a[i+2]))
            {
                bi=a[i];
                flag=1;
            }
            else if((a[i]>a[i+1] && a[i]>a[i+1])&& (a[i+1]>a[i+2] && a[i+1]>a[i+2]))
                flag=1;
            else flag=2;
            
            if(flag==1)
            {
                b[j]=a[i-1];
                b[j+1]=a[i];
                b[j+2]=a[i+1];
                j++;
            }
        }
        
        if(flag==1)
        {
            System.out.println("The bitonic sequence is ");
            System.out.println(b);
            System.out.println("The bitonic number is: "+bi);
        }
        else System.out.println("No bitonic sequence found");
    }
}
