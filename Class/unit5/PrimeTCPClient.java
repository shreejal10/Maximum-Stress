/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unit5;
import java.net.*;
import java.io.*;

/**
 *
 * @author ShreejalDhungana
 * Client accept data from user and send request to server
 */
public class PrimeTCPClient {
    private Socket sk;
    private DataInputStream in; //to take data from user
    private DataOutputStream out; //to send data to server
    
    public PrimeTCPClient(String address, int port){
        try {
            sk = new Socket(address, port);
            
            
            System.out.println("Client Ready");
            System.out.println("Send any string and press out to end");
            
            in = new DataInputStream(System.in);
            out = new DataOutputStream(sk.getOutputStream());
            
            //accept input from console and send to server
            String str="";
            while(!str.equals("out")){
                str=in.readLine(); //reading from console
                out.writeUTF(str);
                out.flush();
            }
            in.close();
            out.close();
            sk.close();
            
            
        } catch(UnknownHostException c){
            //if server not found, port not found
            System.out.println("Errro:: "+ c);
        }
        catch (IOException e) {
            System.out.println("Errro:: "+ e);
        }
    }
    
    public static void main(String[] args) {
        PrimeTCPClient pc = new PrimeTCPClient("localhost", 5000);
    }
}
