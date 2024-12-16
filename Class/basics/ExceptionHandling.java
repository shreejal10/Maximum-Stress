package basics;

import java.util.*;

/*
 * Exception handling keywords
 * 1. try
 * 2. catch
 * 3. throw : to ecplicitly throw an exception
 * 4. throws : if excpttion can occur from method
 * 5. finally : block will always execute
 */

class ExceptionExample extends Exception {
    public ExceptionExample(String s) {
        super(s);
    }
}

public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 1st number: ");
        int a = sc.nextInt();
        System.out.print("Enter 2nd number: ");
        int b = sc.nextInt();

        try {
            int c = a / b;
            System.out.println("Division is: " + c);

            // array index of out bounds: if data inserted more than its size
            int[] arr = new int[5];
            arr[0] = 10;
            arr[1] = 20;
            arr[2] = 30;
            arr[3] = 40;
            arr[4] = 50;
            arr[5] = 60; // ArrayIndexOutOfBoundsException
        } catch (ArithmeticException e) {
            System.out.println("Exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception: " + e);
        } catch (Exception e) {
            // errors super class
            System.out.println("Exception: " + e);
        } finally {
            System.out.println("Finally block");
        }

        try {
            throw new ExceptionExample("Custom Exception");
        } catch (ExceptionExample e) {
            System.out.println("Exception: " + e);
        } finally {
            System.out.println("Finally block");
        }
    }
}
