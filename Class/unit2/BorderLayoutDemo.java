package unit2;

/*
 * Layout determines how the content should be viewed in window. following are the layout of swing 
 * 1. flow layout
 * 2. border layout
 * 3. Grid layout
 * 4. grid bag layout
 * 5. Card layout
 * 6. Null layout
 * Border layer: place the content in terms of direction: north(top), south(bottom), east(right), west(left), center
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class BorderDemo extends JFrame {
    JButton b1, b2, b3, b4;
    JTextArea ta;

    public void setBorder() {
        b1 = new JButton("North Button");
        b2 = new JButton("South Button");
        b3 = new JButton("West Button");
        b4 = new JButton("East Button");

        ta = new JTextArea(20, 20);

        setVisible(true);
        setSize(400, 400);
        // BorderLayout bl = new BorderLayout();
        // set layout of frame
        setLayout(new BorderLayout());

        // adding component into border
        add(b1, BorderLayout.NORTH);

        add(b2, BorderLayout.SOUTH);

        add(b3, BorderLayout.WEST);

        add(b4, BorderLayout.EAST);

        add(ta, BorderLayout.CENTER);

        // after button is clicked
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setText("North Button is clicked");
            }
        });
    }
}

public class BorderLayoutDemo {

    public static void main(String[] args) {
        BorderDemo b = new BorderDemo();
        b.setBorder();
    }

}
