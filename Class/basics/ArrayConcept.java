package basics;

class Array {

    public void simpleArray() {
        System.out.println("\nSimple Array");
        int[] arr = new int[5];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        // other way of declaring array
        int[] arr1 = { 60, 70, 80, 90, 100 };

        // other way of declaring array
        int[] arr2 = new int[] { 110, 120, 130, 140, 150 };

        // using for
        System.out.println("\nUsing for loop");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // using for each
        System.out.println("\nUsing for each loop");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();

        // using while
        System.out.println("\nUsing while loop");
        int i = 0;
        while (i < arr2.length) {
            System.out.print(arr2[i] + " ");
            i++;
        }
        System.out.println();
    }

    public void TwoDArray() {
        System.out.println("\n2D Array");

        // 2D array declaration
        int[][] arr = new int[2][2];

        // 2D array initialization
        arr[0][0] = 10;
        arr[0][1] = 20;
        arr[1][0] = 30;
        arr[1][1] = 40;

        // 2D array declaration and initialization
        int[][] arr1 = { { 50, 60 }, { 70, 80 } };

        // 2D array declaration and initialization
        int[][] arr2 = new int[][] { { 90, 100 }, { 110, 120 } };

        // using for
        System.out.println("\nUsing for loop");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // using for each
        System.out.println("\nUsing for each loop");
        for (int[] i : arr1) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // using for loop
        System.out.println("\nUsing for loop");
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void jaggedArray() {

        System.out.println("\nJagged Array");

        // jagged array declaration
        int[][] arr = new int[2][];

        // jagged array initialization
        arr[0] = new int[2];
        arr[1] = new int[3];

        arr[0][0] = 10;
        arr[0][1] = 20;
        arr[0][2] = 30;
        arr[1][0] = 40;
        arr[1][1] = 50;
        arr[1][2] = 60;

        // jagged array declaration and initialization
        int[][] arr1 = { { 50, 60 }, { 70, 80, 90 } };

        // jagged array declaration and initialization
        int[][] arr2 = new int[][] { { 90, 100 }, { 110, 120, 130 } };

        // using for
        System.out.println("\nUsing for loop");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // using for each
        System.out.println("\nUsing for each loop");
        for (int[] i : arr1) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // using for loop
        System.out.println("\nUsing for loop");
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class ArrayConcept {

    public static void main(String[] args) {

        System.out.println("Array Concept");
        Array array = new Array();
        array.simpleArray();
        array.TwoDArray();
        array.jaggedArray();
    }
}
