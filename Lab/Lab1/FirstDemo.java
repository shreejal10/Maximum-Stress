package Lab1;

/*
 * Write a program to create a class, instance variable, constructor and method. After this create a class FirstDemo with main method and access the method of the previous class.
 */

class Demo {
    int a;

    Demo(int a) {
        this.a = a;
    }

    void display() {
        System.out.println("Value of a: " + a);
    }
}

public class FirstDemo {
    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 1 \t Question 1");

        Demo obj = new Demo(10);
        obj.display();
    }
}
