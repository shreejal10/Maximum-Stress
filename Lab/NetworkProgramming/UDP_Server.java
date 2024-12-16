/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NetworkProgramming;
import java.io.*;
import java.net.*;

/**
 *
 * @author ShreejalDhungana
 */
public class UDP_Server {
    public static void main(String[] args) throws IOException {
        // Create a socket to listen at port 9876
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        System.out.println("Name: Shreejal Dhungana \t Section: A");
            System.out.println("LAB 5 \t Question 2");
        System.out.println("Server is running...");

        while (true) {
            // Receive packet from client
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            // Convert the received data into a string
            String numberString = new String(receivePacket.getData(), 0, receivePacket.getLength());
            
            if(numberString.equalsIgnoreCase("exit")){
                System.out.println("Exit command received. Shutting down the server.");
                    break; 
            }
            try {
            int number = Integer.parseInt(numberString);

            // Determine if the number is even or odd
            String result;
            if (number % 2 == 0) {
                result = "The number " + number + " is Even.";
            } else {
                result = "The number " + number + " is Odd.";
            }

            // Send the result back to the client
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();
            sendData = result.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            serverSocket.send(sendPacket);
            } catch (NumberFormatException e) {
                    // Handle invalid number input
                    String errorMessage = "Invalid input. Please send a valid number.";
                    InetAddress clientAddress = receivePacket.getAddress();
                    int clientPort = receivePacket.getPort();
                    sendData = errorMessage.getBytes();

                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                    serverSocket.send(sendPacket);
                }
        }
    }
}
