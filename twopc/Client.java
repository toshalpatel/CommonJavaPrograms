package twopcp;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ServerNotActiveException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Client {
    static ArrayList<String> log = new ArrayList<>();
    public static void main(String[] args) throws RemoteException, NotBoundException, ServerNotActiveException {
        Registry r = LocateRegistry.getRegistry();//1099 is the port number
        TwoPCProtocolInterface lookUp = (TwoPCProtocolInterface) r.lookup("//localhost/TwoPCProtocol");
                
        Scanner in = new Scanner(System.in);
        
        String req, rep, coorDecision, ack;
               
        while (true) {
//            if (lookUp.getCount() == lookUp.getAck().size() && lookUp.getAck().size() > 0) {
//                break;
//            }
            req = lookUp.sendRequest();
            log.add("Phase 1: Received " + req + " from Coordinator");
            
            System.out.print("Enter reply for commit request sent by Coordinator: ");
            rep = in.next();
            lookUp.sendReply(rep);
            log.add("Phase 1: Reply to Commit Request - " + rep);
            System.out.println();
            
            coorDecision = lookUp.getDecision();

            lookUp.setCount();
            ack = "Acknowledged successful " + coorDecision;
            log.add("Phase 2: " + coorDecision + " Transaction");
            log.add("Phase 2: " + ack);
            lookUp.sendAck(ack);
            
            System.out.println(Arrays.toString(log.toArray()));
        }
    }
}
