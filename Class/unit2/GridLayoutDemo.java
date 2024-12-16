package unit2;

/*
 * places the content in terms of rows and columns i.e
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GridDemo extends JFrame {
    JButton b1, b2, b3, b4, b5;
    JTextArea ta;

    public void setGrid() {
        b1 = new JButton("Button1");
        b2 = new JButton("Button2");
        b3 = new JButton("Button3");
        b4 = new JButton("Button4");
        b5 = new JButton("Button5");

        ta = new JTextArea(20, 20);

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(ta);

        setVisible(true);
        setSize(400, 400);

        // adding component into grid
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(ta);

        setLayout(new GridLayout(3, 2));

        // after button is clicked
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setText("Button1 is clicked");
            }
        });
    }
}

public class GridLayoutDemo {

    public static void main(String[] args) {
        GridDemo g = new GridDemo();
        g.setGrid();
    }

}
