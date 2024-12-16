package Lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * Write a program to find the sum and difference of two number. Use two text field to take input and another one textfield to display result. Display sum if two number if mouse is clicked and display difference if mouse is released.
 */

public class MouseEventDemo extends JFrame {
    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1;

    public MouseEventDemo() {
        l1 = new JLabel("Enter First Number");
        l2 = new JLabel("Enter Second Number");
        l3 = new JLabel("Result");

        t1 = new JTextField(20);
        t2 = new JTextField(20);
        t3 = new JTextField(20);

        b1 = new JButton("Calculate");

        t3.setEditable(false);

        add(l1);
        add(t1);
        add(l2);
        add(t2);

        add(b1);

        add(l3);
        add(t3);

        setVisible(true);
        setSize(380, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(3);

        b1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());
                int sum = a + b;
                t3.setText("Sum is: " + sum);
            }

            public void mouseReleased(MouseEvent e) {
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());
                int diff = a - b;
                t3.setText("Difference is: " + diff);

            }
        });
    }

    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 3 \t Question 2");
        new MouseEventDemo();
    }
}
