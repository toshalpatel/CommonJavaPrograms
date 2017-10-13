package javaapplication;


import java.rmi.*;
import java.sql.ResultSet;
import java.util.Map;

public interface RMIInterface extends Remote
{
  public int Query(String sql,int choice) throws RemoteException;  
  public String[] Display(String sql,int choice) throws RemoteException; 
}
