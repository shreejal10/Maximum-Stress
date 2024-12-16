/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NetworkProgramming;
import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author ShreejalDhungana
 */
public class UDP_Client {
    public static void main(String[] args) throws IOException {
        try {
            // Create a socket for communication
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName("localhost");

            // Prepare input and output buffers
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];

            // Get user input in a loop
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter a number (or type 'exit' to quit): ");
                String number = scanner.nextLine();

                // Check if the user wants to exit
                if (number.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting the client.");
                    break;
                }

                // Send the number to the server
                sendData = number.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
                clientSocket.send(sendPacket);

                // Receive the server's response
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);

                // Print the server's response
                String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Server Response: " + serverResponse);
            }

            // Close the socket
            clientSocket.close();
        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException c) {
            System.out.println("Error: " + c);
        }
    }
}
