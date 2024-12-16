package unit2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Ques extends JFrame {
    JLabel l1, l2, l3;
    JTextField t1, t2;
    JButton b1, b2;

    public void setQues() {
        l1 = new JLabel("Enter First Number");
        l2 = new JLabel("Enter Second Number");
        l3 = new JLabel("Result");

        t1 = new JTextField(20);
        t2 = new JTextField(20);

        b1 = new JButton("Add");
        b2 = new JButton("Subtract");

        add(l1);
        add(t1);
        add(l2);
        add(t2);

        add(b1);
        add(b2);
        add(l3);

        setVisible(true);
        setSize(400, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(3);

        /*
         * when button is pressed then it will generate event known as action event. to
         * handle any event event listener is used. listener is interface so we havce to
         * use all the method of listener. it contains actionPerformed method which we
         * should override.
         */
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // extract form filed
                int num1 = Integer.parseInt(t1.getText());
                int num2 = Integer.parseInt(t2.getText());
                int sum = num1 + num2;
                l3.setText("Sum is: " + sum);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(t1.getText());
                int num2 = Integer.parseInt(t2.getText());
                int sub = num1 - num2;
                l3.setText("Subtraction is: " + sub);
            }
        });
    }
}

public class QuestionDemo {

    public static void main(String[] args) {

        Ques q = new Ques();
        q.setQues();
    }

}
