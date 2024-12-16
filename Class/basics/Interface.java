package basics;

/*
 * Interface is like a abstract class but difference is that it only list of abstract method
 * Interface doesnot contains constructor
 * variable declared inside interface are constant
 * declared using final keyword
 * its object cannot be created
 * it is used to achieve multiple inheritacne i.e. one class can implement two or more interface
 * Both abstract class and interface provide abstraction
 * To use inrerface normal class have to use implements keyword and such class have to provide body part of all methof of interface
 */

interface Caclulation {
    // contains list of method without body part
    void findSum(int x, int y);

    void findDiff(int x, int y);
}

class Solution implements Caclulation {

    private int x;
    private int y;

    public Solution() {
        this.x = 0;
        this.y = 0;
    }

    public Solution(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void findSum(int x, int y) {
        System.out.println("The Sum is :: " + (x + y));
    }

    @Override
    public void findDiff(int x, int y) {
        System.out.println("The Difference is :: " + (x - y));
    }
}

public class Interface {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        s1.findSum(45, 8);
        s1.findDiff(12, 6);

        /*
         * Dynamic method dispatch: It is a process of assigning sub class's object to
         * reference variable of super class
         * Now superclass reference will call sub class version of overridem method
         */
        Caclulation s2 = new Solution();
        s2.findSum(10, 2);
        s2.findDiff(10, 2);
    }
}
