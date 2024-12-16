/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rmi3;
import java.rmi.*;

public interface ServiceProvider extends Remote {
    String reverse(String text) throws Exception;
    String findPrime(int num) throws Exception;
}