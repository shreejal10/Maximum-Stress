package Lab1;

/*
 * Write a program to demonstrate inter thread communication
 */

class Data {
    private int value;
    private boolean available = false;

    public synchronized void put(int value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.value = value;
        available = true;
        System.out.println("Put: " + value);
        notify();
    }

    public synchronized int get() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        available = false;
        System.out.println("Got: " + value);
        notify();
        return value;
    }
}

class Producer extends Thread {
    private final Data data;

    Producer(Data data) {
        this.data = data;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            data.put(i);
        }
    }
}

class Consumer extends Thread {
    private final Data data;

    Consumer(Data data) {
        this.data = data;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            data.get();
        }
    }
}

public class InterThreadCommunication {
    public static void main(String[] args) {
        System.out.println("LAB 1 \t Question 12");

        Data data = new Data();
        Producer producer = new Producer(data);
        Consumer consumer = new Consumer(data);
        producer.start();
        consumer.start();
    }
}
