package Lab1;

/*
 * Provide an example on how constructor of super class is called
 */

class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    private String department;

    public Manager(String name, int age, double salary, String department) {
        super(name, age, salary);
        this.department = department;
    }

    public void display() {
        super.display();
        System.out.println("Department: " + department);
    }
}

public class Super {
    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 1 \t Question 6");
        Manager manager = new Manager("John Doe", 30, 50000, "HR");
        System.out.println("Manager:");
        manager.display();
    }
}
