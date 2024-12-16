
package unit5;

/**
 *
 * @author ShreejalDhungana
 */
import java.net.*;
import java.io.*;
public class PrimeUDPServer {
//    public static void main(String[] args) {
//        // creating socket to listen on port 1234;
//        
//        try {
//            DatagramSocket sc = new DatagramSocket(1234);
//            //in udp data should be sent in form of byte
//            byte[] rcv = new byte[6000];
//            
//            System.out.println("Server started");
//            System.out.println("Waiting for client");
//            
//            while(true){
//                //creating packet to receive data
//                rc = new DatagramPacket(rcv, rcv.length);
//                //receiving data
//                sc.receive(rc);
//                
//                //rcv is sent as parameter to method data which will convert byte to string
//                System.out.println("Client: "+ data(rcv));
//                
//                if(data(rcv).toString())
//            }
//        } catch (IOException e) {
//            System.out.println("Error::" + e);
//        } 
//    }
    public static void main(String[] args) {
        //creating socket to listen on port 1234
     try{
        DatagramSocket sc = new DatagramSocket(1234);
        //in UDP data should should be sent in form of byte
        byte[]rcv = new byte[6000];
        //datagram packet: packet for UDP
        DatagramPacket rc = null;
        System.out.println("server started");
        System.out.println("waiting for client......");
        while(true){
            //creating packet to receive data
            rc=new DatagramPacket(rcv,rcv.length);
            //receiving data
            sc.receive(rc);
            //rcv is sent as parameter 
            //to method data which will convert
            //byte to string
            System.out.println("Client: "+data(rcv));
            //exit server if out is received
            if(data(rcv).toString().equals("out")){
                System.out.println("client sent out so exiting server");
                break;
            }
            //clearing buffer
            rcv=new byte[6000];
        }
     }catch(IOException e){
         System.out.println(e);
     }
    }
    //converting byte array to string
    public static StringBuilder data(byte[]a){
        if(a==null){
            return null;
            
        } 
        StringBuilder bld = new StringBuilder();
        int i=0;
        while(a[i]!=0){
            bld.append((char)a[i]);
            i++;
        }
        return bld;
    }
}
