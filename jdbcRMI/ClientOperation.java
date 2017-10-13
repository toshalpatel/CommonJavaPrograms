package javaapplication;
import java.rmi.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ClientOperation 
{
public static void main(String args[]){  
Scanner s  = new Scanner(System.in);
Scanner s1 = new Scanner(System.in);
try{  
    
    RMIInterface stub=(RMIInterface)Naming.lookup("//172.16.160.175:5000/PC029");  
    System.out.println("Enter Choice\n 1.Insertion, 2.Deletion 3.Updation 4.Display");
    int a = s.nextInt();
    System.out.println("Enter Querry String");
    String sql = s1.nextLine();
    if(a==4)
    {
        String[] map = stub.Display(sql, a);
        for(int i=0;i<map.length;i++)
        {  
            if(map[i]!=null){
            System.out.print("  "+map[i]);
            if(i%2!=0)
                System.out.println("");}
        }
     
    }
    else
        System.out.println(" Done "+stub.Query(sql,a));
    
    }
    catch(Exception e){
            System.out.println("Exception Raised shrutika.... "+e);}  
   } 
}
