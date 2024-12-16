package unit3;

/*
 * generated when any component gain focus of, key mouse etc
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Focuses extends JFrame {
    JLabel l1;
    JButton b1, b2;

    public void setFocus() {
        l1 = new JLabel("result");

        b1 = new JButton("Button 1");
        b2 = new JButton("Button 2");

        add(l1);
        add(b1);
        add(b2);
        setVisible(true);
        setSize(500, 500);

        setLayout(new FlowLayout());

        setDefaultCloseOperation(3);

        b1.addFocusListener(new FocusListener() {

            // contains 2 methods
            @Override
            public void focusGained(FocusEvent e) {
                l1.setText("Button 1 is focused");
            }

            @Override
            public void focusLost(FocusEvent e) {
                l1.setText("Button 1 is not focused");
            }
        });

    }
}

public class FocusEventDemo {
    public static void main(String[] args) {
        Focuses f = new Focuses();
        f.setFocus();
    }

}
