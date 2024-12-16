package Lab1;
/*
 * Demonstrate inheritance in interface (extending the interface)
 */

interface I1 {
    void method1();
}

interface I2 extends I1 {
    void method2();
}

class Example implements I2 {
    @Override
    public void method1() {
        System.out.println("Method 1");
    }

    @Override
    public void method2() {
        System.out.println("Method 2");
    }
}

public class InterfaceInheritance {

    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 1 \t Question 10");
        Example example = new Example();
        example.method1();
        example.method2();
    }
}
