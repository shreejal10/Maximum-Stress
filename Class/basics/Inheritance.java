package basics;

/*Types of inheritance
1. Single Level A->B
2. Multi level A->B->C
3. Multiple : not possible using java. possible with interface
*/

//single level
class Vehicle {
    private int reg;
    private String name;
    private String brand;

    public void setVehicle(int reg, String name, String brand) {
        this.reg = reg;
        this.name = name;
        this.brand = brand;
    }

    public void displayVehicle() {
        System.out.println("Reg is:" + reg);
        System.out.println("Name is:" + name);
        System.out.println("Brand is:" + brand);
    }
}

class Bike extends Vehicle {
    private int milege;

    public void setBike(int milege) {
        this.milege = milege;
    }

    public void displayBike() {
        System.out.println("Milege is: " + milege);
    }
}

class ElecticBike extends Bike {
    private int battery;

    public void setElectricBike(int battery) {
        this.battery = battery;
    }

    public void displayElectricBike() {
        System.out.println("Battery is: " + battery);
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Bike bike1 = new Bike();
        bike1.setVehicle(123, "NS", "Pulsar");
        bike1.displayVehicle();

        bike1.setBike(30);
        bike1.displayBike();

        ElecticBike ebike1 = new ElecticBike();
        ebike1.setVehicle(124, "P-20", "Yatri");
        ebike1.displayVehicle();

        ebike1.setBike(40);
        ebike1.displayBike();

        ebike1.setElectricBike(100);
        ebike1.displayElectricBike();
    }
}
