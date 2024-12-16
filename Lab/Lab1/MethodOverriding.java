package Lab1;

/*
 * Write a program to demonstrate method overriding. using override annotation
 */

class Vehicle {
    private String color;
    private int speed;

    public Vehicle(String color, int speed) {
        this.color = color;
        this.speed = speed;
    }

    public void display() {
        System.out.println("Color: " + color);
        System.out.println("Speed: " + speed);
    }

    public void start() {
        System.out.println("Vehicle started");
    }

    public void stop() {
        System.out.println("Vehicle stopped");
    }
}

class Car extends Vehicle {
    private String model;

    public Car(String color, int speed, String model) {
        super(color, speed);
        this.model = model;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Model: " + model);
    }

    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 1 \t Question 7");

        Car car = new Car("Red", 100, "Tesla");
        System.out.println("Car:");
        car.display();
        car.start();
        car.stop();
    }

}
