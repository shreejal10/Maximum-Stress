/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NetworkProgramming;
import java.net.*;
import java.io.*;
/**
 *
 * @author ShreejalDhungana
 */
public class TCP_Client {
    private Socket sk;
    private DataInputStream in; //to take data from user
    private DataOutputStream out; //to send data to server
    
    public TCP_Client(String address, int port){
        try {
            sk = new Socket(address, port);
            
            
            System.out.println("Client Ready");
            System.out.println("Send any string and press out to end");
            
            in = new DataInputStream(System.in);
            out = new DataOutputStream(sk.getOutputStream());
            
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(sk.getInputStream()));

            
            //accept input from console and send to server
            String str="";
            while(!str.equals("out")){
                str=in.readLine(); //reading from console
                out.writeUTF(str);
                out.flush();
                
                // Receive and print response from server
                String response = inFromServer.readLine();
                System.out.println("Response from server: " + response);
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
        TCP_Client client = new TCP_Client("localhost", 5000);
    }
}
