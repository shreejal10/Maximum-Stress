package Lab3;
/*
 * Write a program to handle
 * - action event (using button and normal button)
 * - item event (using checkbox)
 * - mouse event (both adapter and delegation method)
 * - key event (both adapter and delegation method)
 * - list selection event
 * - Focus event
 * - window event (both adapter and delegation method)
 */

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;

class EventsDemo {

}

public class EventHandlingDemo extends JFrame {

    public EventHandlingDemo() {
        setTitle("Event Handling Example");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Radio button event handling (Action Event)
        JRadioButton radioButton1 = new JRadioButton("Radio Button 1");
        JRadioButton radioButton2 = new JRadioButton("Radio Button 2");
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);

        radioButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Radio Button 1 selected");
            }
        });

        radioButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Radio Button 2 selected");
            }
        });

        add(radioButton1);
        add(radioButton2);

        // Button (Action Event)
        JButton button = new JButton("Click Me");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
            }
        });
        add(button);

        // CheckBox event handling (Item Event)
        JCheckBox checkBox = new JCheckBox("Accept Terms");
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("Terms accepted");
                } else {
                    System.out.println("Terms not accepted");
                }
            }
        });
        add(checkBox);

        // Mouse event handling (both Adapter and Delegation methods)
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse clicked at: " + e.getPoint());
            }
        });

        addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent e) {
                System.out.println("Mouse pressed");
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

            public void mouseClicked(MouseEvent e) {
            }
        });

        // Key event handling (both Adapter and Delegation methods)
        addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                System.out.println("Key typed: " + e.getKeyChar());
            }
        });

        addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                System.out.println("Key pressed: " + e.getKeyCode());
            }

            public void keyReleased(KeyEvent e) {
            }

            public void keyTyped(KeyEvent e) {
            }
        });

        // List selection event handling
        String[] listItems = { "Item 1", "Item 2", "Item 3", "Item 4" };
        JList<String> list = new JList<>(listItems);
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    System.out.println("List selection changed: " + list.getSelectedValue());
                }
            }
        });
        add(new JScrollPane(list));

        // Focus event handling
        JTextField textField = new JTextField(20);
        textField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                System.out.println("Text field focused");
            }

            public void focusLost(FocusEvent e) {
                System.out.println("Text field focus lost");
            }
        });
        add(textField);

        // Window event handling (both Adapter and Delegation methods)
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Window closing...");
            }
        });

        addWindowListener(new WindowListener() {
            public void windowOpened(WindowEvent e) {
                System.out.println("Window opened");
            }

            public void windowClosing(WindowEvent e) {
            }

            public void windowClosed(WindowEvent e) {
            }

            public void windowIconified(WindowEvent e) {
            }

            public void windowDeiconified(WindowEvent e) {
            }

            public void windowActivated(WindowEvent e) {
            }

            public void windowDeactivated(WindowEvent e) {
            }
        });

        // Make the window visible
        setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 3 \t Question 1");

        new EventHandlingDemo();

    }

}
