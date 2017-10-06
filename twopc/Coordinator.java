/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twopc;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;

public class Coordinator extends UnicastRemoteObject implements RMIIn {

    static RMIIn stub;
    
    protected Coordinator() throws RemoteException {
        super();
    }

    public void messageco(String s) throws RemoteException {
        System.out.println(s);
        if(s.equalsIgnoreCase("abort")){
            System.out.println("ABORT");
            stub.messagec("ABORT");
        }
        else if(s.equalsIgnoreCase("agree")){
            System.out.println("COMMIT");
            stub.messagec("COMMIT");
        }
        else if (s.equalsIgnoreCase("commited") || s.equalsIgnoreCase("aborted")){
            System.out.println("COMPLETE");
        }
    }

    public static void main(String args[]) {
        try {
            RMIIn rmi = new Coordinator();
//System.setProperty("java.rmi.server.hostname", "192.168.43.202");
//System.out.println("Upper Case : " + stub.convert("abcd"));
            LocateRegistry.createRegistry(1099);
            Registry registry = LocateRegistry.getRegistry();
//Naming.rebind("rmi://localhost:5000/client",stub);  
//Naming.rebind("rmi://192.168.43.200:5000/client",stub); 
            System.out.println("Connect-request to all processes.");
            stub = (RMIIn) Naming.lookup("//localhost/PC049");
            stub.messagec("Connect Request");
            Naming.rebind("//localhost/PC049", rmi);
            System.out.println("bye");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void messagec(String s) throws RemoteException {
        
    }

}
