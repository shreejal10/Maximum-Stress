package Lab1;

/*
 * Write a program to demonstrate single level, multi-level inheritance
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

class Car extends
        Vehicle {
    private String model;

    public Car(String color, int speed, String model) {
        super(color, speed);
        this.model = model;
    }

    public void display() {
        super.display();
        System.out.println("Model: " + model);
    }

    public void start() {
        System.out.println("Car started");
    }

    public void stop() {
        System.out.println("Car stopped");
    }
}

// class Bike extends
// Vehicle {
// private String type;

// public Bike(String color, int speed, String type) {
// super(color, speed);
// this.type = type;
// }

// public void display() {
// super.display();
// System.out.println("Type: " + type);
// }

// public void start() {
// System.out.println("Bike started");
// }

// public void stop() {
// System.out.println("Bike stopped");
// }
// }

class ElectricCar extends Car {
    private int batteryCapacity;

    public ElectricCar(String color, int speed, String model, int batteryCapacity) {
        super(color, speed, model);
        this.batteryCapacity = batteryCapacity;
    }

    public void display() {
        super.display();
        System.out.println("Battery Capacity: " + batteryCapacity);
    }

    public void start() {
        System.out.println("Electric Car started");
    }

    public void stop() {
        System.out.println("Electric Car stopped");
    }
}

public class Inheritance {

    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 1 \t Question 4");
        Car car = new Car("Red", 100, "Sedan");
        // Bike bike = new Bike("Black", 60, "Sports");

        ElectricCar electricCar = new ElectricCar("Blue", 120, "SUV", 100);

        System.out.println("Car details:");
        car.display();
        // car.start();
        // car.stop();

        System.out.println("\nElectric Car details:");
        // bike.display();
        // bike.start();
        // bike.stop();
        electricCar.display();
    }

}
