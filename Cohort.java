/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twopc;

import java.rmi.*;
import java.util.Scanner;

public class Cohort implements RMIIn {
    
    static RMIIn stub;
            
    public void messageco(String s) {
    }
    
    
    public void messagec(String s) throws RemoteException {
        System.out.println(s);
        if(s.equalsIgnoreCase("connect request")){
            System.out.println("AGREE");
            stub.messageco("AGREE");
        }
        else if(s.equalsIgnoreCase("commit")){
            System.out.println("COMMITED");
            stub.messageco("COMMITED");
        }
        else if (s.equalsIgnoreCase("abort")){
            System.out.println("ABORTED");
            stub.messageco("ABORTED");
        }
    }
    
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        try {
            stub = (RMIIn) Naming.lookup("//localhost/PC049");
            System.out.println("Enter the string: ");
            String in = s.next();
            System.out.println("");
            stub.messageco(in);
        } catch (Exception e) {
        }
    }
}
