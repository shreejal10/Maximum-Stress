package basics;

/*
 * Abstract class is such class decalred using abstract keyword and cannot be instantiated (object cannot be created)
 *  Rules of abstract class
 * 1. Its object cannot be created 
 * 2. It can have constructor, instance variable and normal method
 * 3. It can have abstract method, decalred using abstract method and do not have any body part
 * 4. Normal class have to inherit abstract class and implement all the abstract method of abstract class
*/

abstract class NewCar {

    private String model;
    private String color;

    // Abstract method
    public abstract void display();

    // Normal method
    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

class RacingCar extends NewCar {

    @Override
    public void display() {
        System.out.println("Overriden display method of abstract class");
    }

    public void getRacingCar() {
        System.out.println("Racing car method");
    }
}

public class AbstractClassDemo {

    public static void main(String[] args) {
        RacingCar car = new RacingCar();
        car.setModel("Audi");
        car.setColor("Black");
        System.out.println("Car model: " + car.getModel());
        System.out.println("Car color: " + car.getColor());
        car.display();
        car.getRacingCar();
    }
}
