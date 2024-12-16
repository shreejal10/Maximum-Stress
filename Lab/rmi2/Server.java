/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi2;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class Server extends UnicastRemoteObject implements ServiceProvider{
    public Server() throws RemoteException {}

    @Override
    public int product(int x, int y) throws Exception{
        return x * y;
    }

    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 5 \t Question 6");
        try{
            Registry registry = LocateRegistry.createRegistry(5000);
            registry.rebind("Server", new Server());
        }catch(RemoteException e){
            System.out.println(e.getMessage());
        }
    }
}
