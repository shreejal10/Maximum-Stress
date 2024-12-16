
package unit5;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

//here in udp client is also refer as datagramSocket
public class PrimeUDPClient {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);
       //creating socket for carrying data
       DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost();
        byte buff[]=null;
        //accept input till out is type
        System.out.println("Enter any thing you want to send");
        System.out.println("enter out to end ");
        while(true){
            String str = sc.nextLine();
            buff=str.getBytes();//extracting byte from string value
            //create packet for sending data
            DatagramPacket pkt = new DatagramPacket(buff,buff.length,ip,1234);
            //sending data using send()
            ds.send(pkt);
            if(str.equals("out")){
                break;
            }
        }
        }catch(UnknownHostException e){
            System.out.println(e);
        }catch (IOException c) {
            System.out.println("Errro:: "+ c);
        }
    }
}
