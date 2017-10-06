/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twopc;

import java.rmi.*;

public interface RMIIn extends Remote {

    public void messageco(String s) throws RemoteException;
    public void messagec(String s) throws RemoteException;
}
