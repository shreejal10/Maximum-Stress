package Lab2;
/*
 * 3. Create four button and one text field. If 1st button is clicked display first button is clicked in text field and same for all other button
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ButtonText extends JFrame {
    JButton b1, b2, b3, b4;
    JTextField t1;

    public void setForm() {
        b1 = new JButton("Button 1");
        b2 = new JButton("Button 2");
        b3 = new JButton("Button 3");
        b4 = new JButton("Button 4");

        t1 = new JTextField(20);

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(t1);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t1.setText("Button 1 is clicked");
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t1.setText("Button 2 is clicked");
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t1.setText("Button 3 is clicked");
            }
        });

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t1.setText("Button 4 is clicked");
            }
        });

        setLayout(new FlowLayout());
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

}

public class ClickDemo {
    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 2 \t Question 3");
        ButtonText b = new ButtonText();
        b.setForm();
    }

}
