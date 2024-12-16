package unit4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

/*
 * Creating a form and connecting with database
 */

class SwingForm extends JFrame {
    // create instance varibales of controls
    JLabel l0, l1, l2, l3, l4, l5, l6, l7;
    JTextField t0, t1;
    JPasswordField p1, p2;
    JRadioButton r1, r2;
    JCheckBox c1, c2, c3;
    JComboBox<String> cb1;
    JButton b1;
    Connection conn;

    // create object of each control
    public void setForm() {
        l0 = new JLabel("Id");
        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        l3 = new JLabel("Repassword");
        l4 = new JLabel("Gender");
        l5 = new JLabel("Course");
        l6 = new JLabel("Country");
        l7 = new JLabel("Result");

        t0 = new JTextField(20);
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
        add(l0);
        add(t0);
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
        setSize(400, 400);
        setLayout(new FlowLayout()); // how content should be displayed

        // if window is closed, then program should be terminated
        // setDefaultCloseOperation(3);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close operation

        // after button pressed
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = t0.getText();
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

                if (id.equals("")) {
                    l7.setText("Please enter id");
                    return;
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

                int UserId = Integer.parseInt(id);

                if (password.equals(repassword)) {
                    l7.setText(
                            "Username: " + username + "\nPassword: " + password + "\nGender: " + gender + "\nCourse: "
                                    + course + "\nCountry: " + country);

                    // putting data into database
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        String url = "jdbc:mysql://localhost:3306/primecsita";
                        String susername = "root";
                        String spassword = "";
                        conn = DriverManager.getConnection(url, susername, spassword);

                        // inserting into database

                        String insQuery = "insert into tbl_reg VALUES(?,?,?,?,?,?,?)";

                        PreparedStatement ps = conn.prepareStatement(insQuery);
                        ps.setInt(1, UserId);
                        ps.setString(2, username);
                        ps.setString(3, password);
                        ps.setString(4, repassword);
                        ps.setString(5, gender);
                        ps.setString(6, course);
                        ps.setString(7, country);

                        int res = ps.executeUpdate();

                        if (res > 0) {
                            l7.setText(res + " data inserted");
                        } else {
                            l7.setText("Data not inserted");
                        }
                        conn.close();

                    } catch (ClassNotFoundException c) {
                        System.out.println(c);
                    } catch (SQLException se) {
                        System.out.println(se);
                    }
                } else {
                    l7.setText("Password does not match");
                }
            }
        });
    }

}

public class SwingConnectionDemo {
    public static void main(String[] args) {
        SwingForm sf = new SwingForm();
        sf.setForm();
    }

}
