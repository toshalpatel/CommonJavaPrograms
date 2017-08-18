
package rmiop;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {

    public void Conversion(String text) throws RemoteException;

}
