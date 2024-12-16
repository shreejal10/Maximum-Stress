package Lab1;

/*
 * Write a program to demonstrate hierarchical inheritance. (two child classes inheriting from one parent class)
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

class Clerk extends Employee {
    private String designation;

    public Clerk(String name, int age, double salary, String designation) {
        super(name, age, salary);
        this.designation = designation;
    }

    public void display() {
        super.display();
        System.out.println("Designation: " + designation);
    }
}

public class Hierarchical {
    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 1 \t Question 5");
        Manager manager = new Manager("John Doe", 30, 50000, "HR");
        System.out.println("Manager:");
        manager.display();

        Clerk clerk = new Clerk("Jane Doe", 25, 30000, "Junior Clerk");
        System.out.println("\nClerk:");
        clerk.display();
    }
}
