/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
/**
 *
 * @author ShreejalDhungana
 */
public class RMIServer extends UnicastRemoteObject implements ServiceProvider  {
    public RMIServer() throws RemoteException {}

    @Override
    public int findSP(int CP, int discount) throws Exception {
        return CP - discount;
    }

    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 5 \t Question 5");
        try {
            Registry registry = LocateRegistry.createRegistry(5000);
            registry.rebind("Server", new RMIServer());
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
    }
}
