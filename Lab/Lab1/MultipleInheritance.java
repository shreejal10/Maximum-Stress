package Lab1;

/*
 * Demonstrate multiple inheritance using interface
 */

/**
 * InnerMultiLevelInheritance
 */
interface IColor {
    void getColor();

    void setColor();
}

interface IShape {
    void getShape();

    void setShape();
}

// multiple inheritance using interface, in class square we are implementing two
// interfaces
class Square implements IColor, IShape {

    @Override
    public void getColor() {
        System.out.println("Color is red");
    }

    @Override
    public void setColor() {
        System.out.println("Color is set to red");
    }

    @Override
    public void getShape() {
        System.out.println("Shape is square");
    }

    @Override
    public void setShape() {
        System.out.println("Shape is set to square");
    }

}

public class MultipleInheritance {

    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 1 \t Question 9");
        Square square = new Square();
        square.getColor();
        square.setColor();
        square.getShape();
        square.setShape();
    }

}
