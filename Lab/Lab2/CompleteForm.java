package Lab2;

/*
 * 1.	Write a program to demonstrate complete form using swing. For should contains, labels, textfield, passwordfield, radio button, check box, combo box, text area, buttons. If button is pressed then display the content of form in label
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Form extends JFrame {
    // create instance varibales of controls
    JLabel l1, l2, l3, l4, l5, l6, l7;
    JTextField t1;
    JPasswordField p1, p2;
    JRadioButton r1, r2;
    JCheckBox c1, c2, c3;
    JComboBox<String> cb1;
    JButton b1;

    // create object of each control
    public void setForm() {
        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        l3 = new JLabel("Repassword");
        l4 = new JLabel("Gender");
        l5 = new JLabel("Course");
        l6 = new JLabel("Country");
        l7 = new JLabel("Result");

        t1 = new JTextField(20);

        p1 = new JPasswordField(20);
        p2 = new JPasswordField(20);

        r1 = new JRadioButton("Male");
        r2 = new JRadioButton("Female");

        // radio button should be placed in buttongroup
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        c1 = new JCheckBox("C");
        c2 = new JCheckBox("C++");
        c3 = new JCheckBox("Java");

        // combobox: list of item should be created
        String[] country = { "Nepal", "USA", "UK", "Canada", "Australia" };
        cb1 = new JComboBox<String>(country);

        b1 = new JButton("Submit");

        // adding components into JFrame
        add(l1);
        add(t1);
        add(l2);
        add(p1);
        add(l3);
        add(p2);
        add(l4);
        add(r1);
        add(r2);
        add(l5);
        add(c1);
        add(c2);
        add(c3);
        add(l6);
        add(cb1);
        add(b1);
        add(l7);

        // setting properties of JFrame
        setVisible(true);
        // setSize(getPreferredSize());
        setSize(340, 400);
        setLayout(new FlowLayout()); // how content should be displayed

        // if window is closed, then program should be terminated
        // setDefaultCloseOperation(3);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = t1.getText();
                String password = p1.getText();

                String repassword = p2.getText();

                String gender = "";

                if (r1.isSelected()) {
                    gender = r1.getText();
                } else if (r2.isSelected()) {
                    gender = r1.getText();
                }

                String course = "";
                if (c1.isSelected()) {
                    course += c1.getText() + " ";
                }
                if (c2.isSelected()) {
                    course += c2.getText() + " ";
                }
                if (c3.isSelected()) {
                    course += c3.getText() + " ";
                }

                // String country = cb1.getSelectedItem().toString();
                String country = "";

                if (cb1.getSelectedItem() != null) {
                    country = cb1.getSelectedItem().toString();
                }

                if (username.equals("")) {
                    l7.setText("Please enter username");
                    return;
                }

                if (password.equals("")) {
                    l7.setText("Please enter password");
                    return;
                }

                if (repassword.equals("")) {
                    l7.setText("Please enter repassword");
                    return;
                }

                if (gender == "") {
                    l7.setText("Please select a gender");
                    return;
                }

                if (course == "") {
                    l7.setText("Please select a course");
                    return;
                }

                if (country == "") {
                    l7.setText("Please select a country");
                    return;
                }

                if (password.equals(repassword)) {
                    l7.setText(
                            "Username: " + username + "\nPassword: " + password + "\nGender: " + gender + "\nCourse: "
                                    + course + "\nCountry: " + country);
                } else {
                    l7.setText("Password does not match");
                }
            }
        });
    }
}

public class CompleteForm {
    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 2 \t Question 1");
        Form f = new Form();
        f.setForm();
    }
}
