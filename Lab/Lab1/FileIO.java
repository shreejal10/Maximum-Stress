package Lab1;

import java.io.*;
/*
 * Write a program to demonstrate reading and writing data in file
 */

public class FileIO {
    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 1 \t Question 13");
        try {

            File f1 = new File("Lab1.txt");
            if (f1.exists()) {
                System.out.println("File already exists");
            } else {
                try {
                    f1.createNewFile();
                    System.out.println("File created successfully");
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
            System.out.println("File name: " + f1.getName());
            System.out.println("Path: " + f1.getPath());
            System.out.println("Absolute path: " + f1.getAbsolutePath());
            System.out.println("File size: " + f1.getFreeSpace());

            // check for directory
            if (f1.isDirectory()) {
                System.out.println("It is a directory");
            } else {
                System.out.println("It is a file");
            }

            System.out.println("--reading and writing to file using byte stream --");

            // write to file using byte stream
            FileOutputStream fout = new FileOutputStream(f1);
            String s = "Hello World";
            // change into byte
            byte b[] = s.getBytes();
            fout.write(b);
            fout.close();
            System.out.println("Data written to file");

            // reading from file using byte stream
            FileInputStream fin = new FileInputStream(f1);
            int i = 0;
            while ((i = fin.read()) != -1) {
                System.out.print((char) i);
            }
            fin.close();
            System.out.println("\nData read from file");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
