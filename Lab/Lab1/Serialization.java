package Lab1;
/*
 * Write a program to demonstrate serialization and deserialization
 */

import java.io.*;

class Rectangle implements Serializable {
    private int length;
    private int breadth;

    public void setRectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public void calcArea() {
        int area = this.length * this.breadth;
        System.out.println("Area is: " + area);
    }
}

public class Serialization {
    public static void main(String[] args) {
        try {
            File f1 = new File("obj.txt");
            f1.createNewFile();
            System.out.println("--Writing object to file--");

            // open file for write
            FileOutputStream fos = new FileOutputStream(f1);

            // creating object of class
            Rectangle r1 = new Rectangle();
            r1.setRectangle(100, 200);

            // to write object
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(r1);

            System.out.println("Object written into file");

            System.out.println("--Reading object from file--");

            // open file in read mode
            FileInputStream fis = new FileInputStream(f1);

            // to read object
            ObjectInputStream ois = new ObjectInputStream(fis);

            Rectangle r2 = (Rectangle) ois.readObject();
            r2.calcArea();

            // setting properties of r2
            r2.setRectangle(200, 200);
            r2.calcArea();
        } catch (IOException e) {
            // if file is not found
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            // if class whose object is to be write is not found
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
