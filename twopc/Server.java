package twopcp;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import static java.rmi.server.RemoteServer.getClientHost;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;

public class Server extends UnicastRemoteObject implements TwoPCProtocolInterface {
    ArrayList<String> reply, ack, log;
    static int count;
    String req, decision;

    public Server() throws RemoteException {
        super();
        count = 0;
        req = "C_R";
        reply = new ArrayList<>();
        log = new ArrayList<>();
        ack = new ArrayList<>();
        log.add("Phase 1: Sent C_R to all Cohorts");
    }
    
    @Override
    public String sendRequest() throws RemoteException {
        count++;
//        System.out.println(count);
        return req;        
    }
    
    @Override
    public void sendReply(String reply) throws RemoteException {
        try {
            System.out.println("Reply of " + getClientHost() + ": " + reply);
        } catch (ServerNotActiveException ex) {
            ex.printStackTrace();
        }
        this.reply.add(reply);
        log.add("Phase 1: Received replies from all Cohorts!");
    }
    
    @Override
    public String getDecision() throws RemoteException {
        while (count != reply.size()) {
            System.out.print("");
        }
        
        if (reply.contains("Abort")) {
            log.add("Phase 2: Decision to Abort sent to all Cohorts");
            decision = "Abort";
        } else {
            log.add("Phase 2: Decision to Commit sent to all Cohorts");
            decision = "Commit";
        }
        
        return decision;
    }

    @Override
    public void sendAck(String ack) throws RemoteException {
        count++;
        this.ack.add(ack);
        
        if (this.ack.size() == count) {
            log.add("Received Acknowlledgement from all Cohorts");
            printCoordinatorLog();
        }
    }
    
    @Override
    public void printCoordinatorLog() throws RemoteException {
        System.out.println(Arrays.toString(log.toArray()));
    }

    @Override
    public ArrayList<String> getReplies() throws RemoteException {
        return reply;
    }

    @Override
    public void setCount() throws RemoteException {
        count = 0;
    }
    
    public static void main(String[] args) throws RemoteException {
        while (true) {            
            TwoPCProtocolInterface tpc = new Server();
            Registry r = LocateRegistry.createRegistry(1099);
            r.rebind("//localhost/TwoPCProtocol", tpc);
            System.out.println("Implementing 2 Phase Commit Protocol");
        }
    }

    @Override
    public int getCount() throws RemoteException {
        return count;
    }

    @Override
    public ArrayList<String> getAck() throws RemoteException {
        return ack;
    }
    
}
