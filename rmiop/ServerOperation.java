package rmiop;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import rmiop.RMIInterface;

public class ServerOperation extends UnicastRemoteObject implements RMIInterface{

    private static final long serialVersionUID = 1L;

    public ServerOperation() throws RemoteException{
        super();       
    }
    

    public static void main(String[] args){

        try {
            
            RMIInterface rmi = new ServerOperation();
            LocateRegistry.createRegistry(1099);
            Registry registry = LocateRegistry.getRegistry();
            Naming.rebind("//172.16.161.59:1099/PC027", rmi);

        } catch (Exception e) {

            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();

        }

    }

    public void Conversion(String text) {
        
        System.out.println(text.toUpperCase());
    }

}
