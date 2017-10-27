package twopcp;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface TwoPCProtocolInterface extends Remote {
    public String sendRequest() throws RemoteException;
    
    public void sendReply(String reply) throws RemoteException;
    
    public void setCount() throws RemoteException;
    
    public int getCount() throws RemoteException;
    
    public ArrayList<String> getAck() throws RemoteException;
    
    public ArrayList<String> getReplies() throws RemoteException;
    
    public String getDecision() throws RemoteException;
    
    public void printCoordinatorLog() throws RemoteException;
        
    public void sendAck(String ack) throws RemoteException;
}
