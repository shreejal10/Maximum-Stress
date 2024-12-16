/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi3;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class Server extends UnicastRemoteObject implements ServiceProvider {
    public Server() throws RemoteException {}

    @Override
    public String reverse(String text) throws Exception {
        String reversed = "";
        for (int i = 0; i < text.length(); i++) {
            reversed = text.charAt(i) + reversed;
        }
        return reversed;
    }

    @Override
    public String findPrime(int num) throws Exception {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) return "Not Prime";
        }
        return "Prime";
    }

    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 5 \t Question 7");
        try {
            Registry registry = LocateRegistry.createRegistry(5000);
            registry.rebind("Server", new Server());
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
    }
}