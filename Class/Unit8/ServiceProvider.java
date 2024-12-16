/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Unit8;

/**
 *
 * @author ShreejalDhungana
 * Type of service that needs to be given by server is register in this interface
 */
import java.rmi.*;


public interface ServiceProvider extends Remote{
    //find sum of two number and return result
    int findSum(int x, int y) throws RemoteException;
    
    //find reverse of given string and return result
    String findReverse(String data) throws RemoteException;
}
