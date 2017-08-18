package rmiop;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

import java.util.Scanner;
import rmiop.RMIInterface;

public class ClientOperation {

	public static void main(String[] args)
		throws MalformedURLException, RemoteException, NotBoundException {
            try{
                System.setSecurityManager(new RMISecurityManager());
                RMIInterface rmi;
                Scanner in = new Scanner(System.in);
		rmi = (RMIInterface) Naming.lookup("//172.16.161.58:4080/PC029");
		System.out.println("Enter the string:");
                String text = in.nextLine();
                rmi.Conversion(text);
            }
            catch(Exception e){
                System.out.println(e);
            }
	}

}
