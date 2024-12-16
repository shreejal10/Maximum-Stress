package unit3;

/*
 * for every action like clicking button, using mouse etc event is generated. for every event, listener is used to listen such event. Listener is an interface that contains list of method to handle event. if listener is used then all the method defined by it should be compulsary used. this is known as delegation event method
 * button -> action event
 * radio button -> action event
 * checkbox -> action event and item event
 * combobox -> action event and item event
 * list -> ListSelectionEvent
 * 
 * MouseEvent: generated when mouse is clicked, : press, release, enter, exit
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MouseEg extends JFrame {
    JLabel l1;
    JTextField t1;

    public void setMouse() {
        l1 = new JLabel("Result");
        t1 = new JTextField(20);

        // when some mouse action is performed in t1
        t1.addMouseListener(new MouseListener() {
            // it contains 5 method and all method must be used
            public void mouseClicked(MouseEvent e) {
                // when mouser is clicekd and release
                l1.setText("Mouse Clicked");
            }

            public void mousePressed(MouseEvent e) {
                // when mouse is continuously pressed
                l1.setText("Mouse Pressed");
            }

            public void mouseReleased(MouseEvent e) {
                // when mouse is released
                l1.setText("Mouse Released");
            }

            public void mouseEntered(MouseEvent e) {
                // when mouse is entered
                l1.setText("Mouse Entered in " + e.getX() + " " + e.getY());
            }

            public void mouseExited(MouseEvent e) {
                // when mouse is exited
                l1.setText("Mouse Exited");
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

public class MouseEventDemo {
    public static void main(String[] args) {
        MouseEg m = new MouseEg();
        m.setMouse();

    }

}
