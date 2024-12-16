package unit3;
/*
 * using Listener interface we have to use all the method defined by it, but using Adapter Class, we can use any method as per our need
 * For Eg. mouse listener contains 5 method, and we have to use all of them. but using adapter class, we can use any of them.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MAdapter extends JFrame {
    JLabel l1;
    JTextArea t1;

    public void setMAdapter() {
        l1 = new JLabel("Result");
        t1 = new JTextArea(20, 20);

        t1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                l1.setText("Mouse Entered in " + e.getX() + " " + e.getY());
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

public class MouseAdapterDemo {
    public static void main(String[] args) {
        MAdapter m = new MAdapter();
        m.setMAdapter();
    }
}
