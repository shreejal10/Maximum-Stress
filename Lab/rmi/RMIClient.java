/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;
import java.rmi.registry.*;
import java.util.*;


/**
 *
 * @author ShreejalDhungana
 */
public class RMIClient {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry(5000);
        ServiceProvider serviceProvider = (ServiceProvider) registry.lookup("Server");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the cost price: ");
        int CP = scanner.nextInt();
        System.out.print("Enter the discount: ");
        int discount = scanner.nextInt();

        int SP = serviceProvider.findSP(CP, discount);
        System.out.println("The selling price is: " + SP);
    }
}
