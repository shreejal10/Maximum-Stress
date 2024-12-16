package unit3;
/*
 * key event is generated when key of keyboard is pressed, released or typed
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class KeyEg extends JFrame {
    JLabel l1;
    JTextArea t1;

    public void setKey() {
        l1 = new JLabel("Result");
        t1 = new JTextArea(20, 20);

        t1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                l1.setText("Key Typed");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                l1.setText("Key Pressed");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                l1.setText("Key Released");
            }
        });

        add(l1);
        add(t1);

        setVisible(true);
        setSize(500, 500);

        setLayout(new FlowLayout());

        setDefaultCloseOperation(3);
    }

}

public class KeyEventDemo {
    public static void main(String[] args) {
        KeyEg k = new KeyEg();
        k.setKey();
    }

}
