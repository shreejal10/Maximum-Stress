
package unit5;

/**
 *
 * @author ShreejalDhungana
 * Network programming deals with sending and receiving data from network. In network programming, client is known as socket
 * and server is known as socket server
 * 
 * But in UDP, both server and client is treated as datagram socket and data in UDP is known as datagram (data should be send in byte)
 * 
 * To use network program, java.net package should be imported
 * 
 * STEPS to create TCP connection
 * 1. Create server by registering port and accepting client
 * 2. Create client by invoking address and port of server and request server for services
 * 
 
 */

import java.net.*;
import java.io.*; //in tcp data is transfer as IO

public class PrimeTCPServer {
    private Socket cl; //client to be connected to server
    private ServerSocket server;
    private DataInputStream in; //to accept data from client
    
    //creating constructor with specified port
    public PrimeTCPServer(int port){
        try {
            server = new ServerSocket(port);
            
            //creating connection with client
            
            System.out.println("Server ready to serve");
            System.out.println("Waiting for client");
            
            cl = server.accept();
            
            //provide specific service
            //accept one string reverse it and return it
            
            in = new DataInputStream(new BufferedInputStream(cl.getInputStream()));
            
            String ans ="";
            //accept input until user send out
            while(!ans.equals("out")){
                ans=in.readUTF(); //read string
                System.out.println("Client says "+ans);
                System.out.println("Reverse form of client data: ");
                String rv="";
                for(int i=0; i<ans.length(); i++){
                    rv=ans.charAt(i)+rv;
                }
                System.out.println(rv);
            }
            cl.close(); //close the client
        } catch (IOException e) {
            System.out.println("Error::" + e);
        } 
    }
    
    public static void main(String[] args) {
        PrimeTCPServer pt = new PrimeTCPServer(5000);
    }
    
}
