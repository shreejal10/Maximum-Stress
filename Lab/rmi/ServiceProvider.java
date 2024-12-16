/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rmi;
import java.rmi.*;

/**
 *
 * @author ShreejalDhungana
 */
public interface ServiceProvider extends Remote {
    int findSP(int CP, int discount) throws Exception;
}