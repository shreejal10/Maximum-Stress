package Lab1;
/*
 * Write a program to demonstrate multithreading using both thread class and runnable interface.
 */

class Calculate1 extends Thread {
    // it contains run method which should be compulsary used and overriden
    @Override
    public void run() {
        // displaying odd num from 1 to 20 in interva of 1 sec
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
                System.out.println("Calculate1: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }
}

class Calculate2 implements Runnable {
    // it contains run method which should be compulsary used and overriden
    @Override
    public void run() {
        // displaying even num from 1 to 20 in interva of 1 sec
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println("Calculate2: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }
}

public class MultiThreading {
    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 1 \t Question 11");
        Calculate1 c1 = new Calculate1();
        Calculate2 c2 = new Calculate2();

        // starting thread using thread class
        c1.start();

        // starting thread using runnable interface
        Thread t = new Thread(c2);
        t.start();
    }

}
