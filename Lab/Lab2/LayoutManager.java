package Lab2;

/*
 *    2.	Write a program to demonstrate different layout manager (null, flow layout, card layout, border layout, grid layout, grid bag layout and group layout)
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;

class NullLayout extends JFrame {
    NullLayout() {
        setTitle("Null Layout");
        setLayout(null);

        JButton b1 = new JButton("Button 1");
        JButton b2 = new JButton("Button 2");

        b1.setBounds(50, 50, 100, 30);
        b2.setBounds(200, 50, 100, 30);

        add(b1);
        add(b2);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class FlowLayoutDemo extends JFrame {
    FlowLayoutDemo() {
        setTitle("Flow Layout");
        setLayout(new FlowLayout());

        for (int i = 1; i <= 4; i++) {
            add(new JButton("Button " + i));
        }

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class CardLayoutDemo extends JFrame {
    CardLayoutDemo() {
        setTitle("Card Layout");
        setLayout(new CardLayout());

        add(new JButton("Button 1"), "1");
        add(new JButton("Button 2"), "2");
        add(new JButton("Button 3"), "3");

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class BorderLayoutDemo extends JFrame {
    BorderLayoutDemo() {
        setTitle("Border Layout");
        setLayout(new BorderLayout());

        add(new JButton("North"), BorderLayout.NORTH);
        add(new JButton("South"), BorderLayout.SOUTH);
        add(new JButton("East"), BorderLayout.EAST);
        add(new JButton("West"), BorderLayout.WEST);
        add(new JButton("Center"), BorderLayout.CENTER);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class GridLayoutDemo extends JFrame {
    GridLayoutDemo() {
        setTitle("Grid Layout");
        setLayout(new GridLayout(3, 3));

        for (int i = 1; i <= 4; i++) {
            add(new JButton("Button " + i));
        }

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class GridBagLayoutDemo extends JFrame {
    GridBagLayoutDemo() {
        setTitle("Grid Bag Layout");
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        add(new JButton("Button 1"), c);

        c.gridx = 1;
        c.gridy = 0;
        add(new JButton("Button 2"), c);

        c.gridx = 2;
        c.gridy = 0;
        add(new JButton("Button 3"), c);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class GroupLayoutDemo extends JFrame {
    GroupLayoutDemo() {
        setTitle("Group Layout");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup().addComponent(new JButton("Button 1"))
                .addComponent(new JButton("Button 2")).addComponent(new JButton("Button 3")));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup().addComponent(new JButton("Button 1"))
                .addComponent(new JButton("Button 2")).addComponent(new JButton("Button 3")));
        layout.setVerticalGroup(vGroup);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

public class LayoutManager {
    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 2 \t Question 2");
        Scanner sc = new Scanner(System.in);
        String ch;
        do {
            // switch case to select the layout
            int choice = 1;

            System.out.println("1. Null Layout");
            System.out.println("2. Flow Layout");
            System.out.println("3. Card Layout");
            System.out.println("4. Border Layout");
            System.out.println("5. Grid Layout");
            System.out.println("6. Grid Bag Layout");
            System.out.println("7. Group Layout");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    new NullLayout();
                    break;
                case 2:
                    new FlowLayoutDemo();
                    break;
                case 3:
                    new CardLayoutDemo();
                    break;
                case 4:
                    new BorderLayoutDemo();
                    break;
                case 5:
                    new GridLayoutDemo();
                    break;
                case 6:
                    new GridBagLayoutDemo();
                    break;
                case 7:
                    new GroupLayoutDemo();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.print("Do you want to continue? (y/n) :");
            ch = sc.next();

        } while (ch.equals("y"));
        sc.close();
    }
}
