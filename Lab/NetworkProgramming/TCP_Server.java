/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NetworkProgramming;

/**
 *
 * @author ShreejalDhungana
 */
import java.net.*;
import java.io.*; //in tcp data is transfer as IO
public class TCP_Server {
    private Socket cl; //client to be connected to server
    private ServerSocket server;
    private DataInputStream in; //to acc
    
    public TCP_Server(int port){
        try {
            server = new ServerSocket(port);
            
            //creating connection with client
            System.out.println("Name: Shreejal Dhungana \t Section: A");
            System.out.println("LAB 5 \t Question 1");
            System.out.println("Server ready to serve");
            System.out.println("Waiting for client");
            
            cl = server.accept();
            
            //provide specific service
            //accept one string reverse it and return it
            
            in = new DataInputStream(new BufferedInputStream(cl.getInputStream()));
            DataOutputStream out = new DataOutputStream(cl.getOutputStream());
            String ans ="";
            //accept input until user send out
            while(!ans.equals("out")){
                ans=in.readUTF(); //read string
                System.out.println("Client says "+ans);
                
                if(!ans.equals("Hello")){
                   out.writeBytes("Error in input\n");
                }else{
                    out.writeBytes("Welcome\n");
                }
            }
            cl.close(); //close the client
        } catch (IOException e) {
            System.out.println("Error::" + e);
        }
    }
    
    public static void main(String[] args) {
        TCP_Server server = new TCP_Server(5000);
    }
}
