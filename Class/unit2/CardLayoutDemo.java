package unit2;

/*
 * Places the content in terms of sequence of cards
 * one content is placed beside another
 */

import javax.swing.*;
import java.awt.*;

class Cards extends JFrame {
    JButton b1, b2, b3;

    public void setCard() {
        b1 = new JButton("Card 1");
        b2 = new JButton("Card 2");
        b3 = new JButton("Card 3");

        // subwindow: to change the content
        JPanel p1 = new JPanel();
        p1.add(b1, "btn1");
        p1.add(b2, "btn2");
        p1.add(b3, "btn3");

        CardLayout c = new CardLayout();
        p1.setLayout(c);
        add(p1);
        setVisible(true);
        setSize(400, 400);
        setDefaultCloseOperation(3);

        // showing second component
        c.next(p1);
        c.show(p1, "btn2");

    }
}

public class CardLayoutDemo {
    public static void main(String[] args) {
        Cards c = new Cards();
        c.setCard();

    }

}
