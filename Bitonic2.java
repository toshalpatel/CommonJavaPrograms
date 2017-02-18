import java.util.Scanner;

public class Bitonic2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of the sequence: ");
        int n = in.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        for (int v:b)
            b[v] = 99999;
        int bn;
        System.out.println("Enter sequence: ");
        int flag=0;
        int i,j;
        for(i=0; i<n; i++)
            a[i] = in.nextInt();
        i=0; 
        
        while (i!=n+1){
        j=0;
        while(a[i+1]>a[i]){
            i++;
            b[j] = a[i];
            j++;
        }
        j++;
        bn = b[j] = a[i];
        while(bn!=0 && a[i+1]<a[i]){
            b[j]=a[i];
            i++; j++;
        }
        for(int v:b)
            if(b[v]!=99999)
                System.out.print(b[v]+"\t");
        System.out.println("The Bitonic number is: "+bn);
        }
    }
}
