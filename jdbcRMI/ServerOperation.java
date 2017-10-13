package javaapplication;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;


public class ServerOperation extends UnicastRemoteObject implements RMIInterface
{
    
    protected ServerOperation() throws RemoteException {

        super();

    }
    static Connection con ;
    public static void main(String[] args) 
    {

        try
        {
          RMIInterface rmi = new ServerOperation();
          LocateRegistry.createRegistry(5000);
           Registry registry =  LocateRegistry.getRegistry(); 
          Naming.rebind("//172.16.160.175:5000/PC029",rmi); //khud ka ip //172.16.161.175:1099/PC029
        }
        catch(Exception e)
        {
            System.out.println(e);
        }      
        
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver Found...");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
            System.out.println("Connection established...");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int Query(String sql, int choice) throws RemoteException
    {
        int i=0;
        if(choice==1)
        {
            System.out.println("client req insert");
            Statement s;
            try {
                s = con.createStatement();
                System.out.println("stmt inserted = "+s.executeUpdate(sql));
                i=s.executeUpdate(sql);
            } catch (SQLException ex) {
                ex.printStackTrace();
                       
            }
            
        }
        if(choice==2)
        {
             System.out.println("client req delete");
            Statement s;
            try {
                s = con.createStatement();
                System.out.println("stmt deleted = "+s.executeUpdate(sql));
                 i=s.executeUpdate(sql);
            } catch (SQLException ex) {
                ex.printStackTrace();
                       
            }
        }
       if(choice==3)
        {
             System.out.println("client req update");
            Statement s;
            try {
                s = con.createStatement();
                System.out.println("stmt updated = "+s.executeUpdate(sql));
                 i=s.executeUpdate(sql);
            } catch (SQLException ex) {
                ex.printStackTrace();
                       
            }
        }
        return i;
        }


    @Override
    public String[] Display(String sql, int choice) throws RemoteException 
    {
        Map<Integer,String> m = null;
        String array[]=new String[50];
        int k=0;
        ResultSet rs = null;
       System.out.println("client req disp");
            Statement s;
            try {
                s = con.createStatement();
                System.out.println(sql);
                rs=s.executeQuery(sql);
                
                while(rs.next())
                {
                    //System.out.println(rs.getInt(1)+" "+rs.getString(2));
                    array[k]=rs.getInt(1)+"";
                    k++;
                    array[k]=rs.getString(2);
                    k++;
                    //m.put(rs.getInt(1),rs.getString(2));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                       
            }
            
            return array;
    }

}

