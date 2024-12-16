package Lab1;

/*
 * Write a program to demonstrate method overloading.
 */

public class MethodOverloading {

    // Function to add two integers
    public static int add(int a, int b) {
        return a + b;
    }

    // Function to add three integers
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    // Function to add two doubles
    public static double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 1 \t Question 3");
        System.out.println("Sum of 2 and 3: " + add(2, 3));
        System.out.println("Sum of 2, 3 and 4: " + add(2, 3, 4));
        System.out.println("Sum of 2.5 and 3.5: " + add(2.5, 3.5));
    }

}
