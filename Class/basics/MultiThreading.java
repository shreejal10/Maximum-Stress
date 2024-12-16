package basics;

//creating thread by using thread class
class Calculate1 extends Thread {
    // it contains run method which should be compulsary used and overriden
    @Override
    public void run() {
        // displaying odd num from 1 to 20 in interva of 1 sec
        for (int i = 1; i <= 20; i++) {
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

class Calculate2 extends Thread {
    @Override
    public void run() {
        // displaying even num from 1 to 20 in interva of 1 sec
        for (int i = 1; i <= 20; i++) {
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
        // creating object of Calculate1
        Calculate1 c1 = new Calculate1();
        // creating object of Calculate2
        Calculate2 c2 = new Calculate2();

        // starting thread
        c1.start();
        c2.start();
    }

}
