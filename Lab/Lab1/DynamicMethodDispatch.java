package Lab1;

/*
 * Provide an example on Dynamic Method Dispatch in Java.
 */

class A {
    public void display() {
        System.out.println("Class A");
    }
}

class B extends A {
    @Override
    public void display() {
        System.out.println("Class B");
    }
}

class C extends B {
    @Override
    public void display() {
        System.out.println("Class C");
    }
}

public class DynamicMethodDispatch {
    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 1 \t Question 8");
        A a = new A();
        B b = new B();
        C c = new C();

        A ref;

        ref = a;
        ref.display();

        ref = b;
        ref.display();

        ref = c;
        ref.display();
    }

}
