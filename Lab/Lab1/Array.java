package Lab1;

import java.util.*;
/*
 * Write a program to create one dimensional and multidimensional array and dispaly the array using for and for  each loop. All the data of the array should be taken as input from the user.
 */

public class Array {

    // Function to display 1D array
    public static void display1DArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Function to display 2D array
    public static void display2DArray(int[][] arr) {
        // for (int i = 0; i < arr.length; i++) {
        // for (int j = 0; j < arr[i].length; j++) {
        // System.out.print(arr[i][j] + " ");
        // }
        // System.out.println();
        // }

        // using for each loop
        for (int[] row : arr) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 1 \t Question 2");
        Scanner sc = new Scanner(System.in);

        // 1D array
        System.out.print("Enter the size of 1D array: ");
        int n = sc.nextInt();
        int[] arr1D = new int[n];
        System.out.print("Enter the elements of 1D array: ");
        for (int i = 0; i < n; i++) {
            arr1D[i] = sc.nextInt();
        }
        System.out.println("1D array:");
        display1DArray(arr1D);

        // 2D array
        System.out.print("\nEnter the number of rows of 2D array: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns of 2D array: ");
        int cols = sc.nextInt();
        int[][] arr2D = new int[rows][cols];
        System.out.println("Enter the elements of 2D array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr2D[i][j] = sc.nextInt();
            }
        }
        System.out.println("2D array:");
        display2DArray(arr2D);

        sc.close();
    }

}
