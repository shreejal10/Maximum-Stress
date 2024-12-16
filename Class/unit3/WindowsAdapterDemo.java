package unit3;
/*
 * window listener contains 7 method and all should be compulsory used as listener is interface
 * using window adapter we can use any method out of 7 as per our need.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class WindowAdapEg extends JFrame {
    JFrame f;

    public void setWindow() {
        f = new JFrame("Window Event");

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("Window Opened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                // whe window is closed using tab bar
                System.out.println("Window Closing");
            }
        });

        f.setSize(500, 500);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
        f.setDefaultCloseOperation(3);
    }
}

public class WindowsAdapterDemo {
    public static void main(String[] args) {
        WindowAdapEg w = new WindowAdapEg();
        w.setWindow();
    }

}
