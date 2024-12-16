/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi2;

import java.rmi.registry.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry(5000);
        ServiceProvider serviceProvider = (ServiceProvider) registry.lookup("Server");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int x = sc.nextInt();
        System.out.print("Enter second number: ");
        int y = sc.nextInt();

        int mul = serviceProvider.product(x, y);
        System.out.println("The product is: " + mul);
    }
}