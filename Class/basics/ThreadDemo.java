package basics;

/*
 * Multithreading is a mechanism by which one program can do multiple work at the same time.
 * In java multithreading can be achieved using two ways
 * 1. by implementing runnable interface
 * 2. by extending thread class
 * One thread is always running when program is created. This thread is known as main thread.
 * To execeute thread run() method is used
 */

public class ThreadDemo {

    public static void main(String[] args) {
        // main thread
        // extracting current thread
        Thread t1 = Thread.currentThread();
        System.out.println("Current thread: " + t1);

        t1.setName("CSIT Thread");
        System.out.println("After name change: " + t1.getName());

        // default priority 5
        System.out.println("Default priority: " + t1.getPriority());

        // setting priority
        t1.setPriority(2);
        System.out.println("After setting priority: " + t1.getPriority());

        // state
        System.out.println("State: " + t1.getState());

        // suspending thread
        // displaying data 10 times by suspending half sec
        for (int i = 0; i < 10; i++) {
            System.out.println(i);

            // it may throw exception if any intrupted exception occurs
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }

}
