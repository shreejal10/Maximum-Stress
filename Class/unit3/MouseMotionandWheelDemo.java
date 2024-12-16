package unit3;
/*
 * mouse motion is generated when mouse is dragged and mouse wheel event is generated when wheel of mouse is moved
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MouseExtra extends JFrame {
    JLabel l1;
    JTextArea t1;

    public void setMouse() {
        l1 = new JLabel("Result");
        t1 = new JTextArea(20, 20);

        t1.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                l1.setText("Mouse Dragged");
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                l1.setText("Mouse Moved");
            }
        });

        t1.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                l1.setText("Mouse Wheel Moved");
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

public class MouseMotionandWheelDemo {
    public static void main(String[] args) {

        MouseExtra m = new MouseExtra();
        m.setMouse();
    }

}
