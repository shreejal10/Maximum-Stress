package basics;

// In inheritance, constructor of super class cannot be called by subclass object and also iof the method in super class and sub class are same then supper keyword should be used
// to call overriden method of super class 
// usages of super keyword
//1. to call superclass constructor
//2. to call overriden method of superclass from subclass. If both super class and subclass have same method and its definition, then such condition is method overriding. it is a method of dynamic polymorphism.

class Vehicles {
    private int reg;
    private String name;
    private String brand;

    public Vehicles() {
        System.out.println("Vehicles class constructor. Default constructor of super class");
    }

    public Vehicles(int reg, String name, String brand) {
        this.reg = reg;
        this.name = name;
        this.brand = brand;
        System.out.println("Vehicles class constructor with 3 parameters");

    }

    public void display() {
        System.out.println("Vehicle class display method");
        System.out.println("Registration: " + reg);
        System.out.println("Name: " + name);
        System.out.println("Brand: " + brand);
    }
}

class Car extends Vehicles {
    private String price;

    public Car() {
        super(); // calling super class constructor
        System.out.println("Car class constructor. Default constructor of sub class");
    }

    public Car(int reg, String name, String brand, String price) {
        super(reg, name, brand); // calling super class constructor
        this.price = price;
        System.out.println("Car class constructor with 3 parameters");
    }

    public void display() {
        super.display(); // calling super class method
        System.out.println("Car class display method");
        System.out.println("Price: " + price);
    }
}

public class SuperKeyword {

    public static void main(String[] args) {
        Car car = new Car();

        Car car1 = new Car(1234, "Swift", "Maruti", "10L");
        car1.display();
    }

}
