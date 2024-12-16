/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rmi2;

import java.rmi.*;

public interface ServiceProvider extends Remote{
    int product(int x, int y) throws Exception;
}