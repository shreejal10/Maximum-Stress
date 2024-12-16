package Lab2;

/*
 * 4. How JTable and JComboBox is created? Show with program
 */
import javax.swing.*;
import java.awt.*;

class TableAndComboBox extends JFrame {
    JTable tb1;
    JSplitPane sp1;
    JList<String> l1;

    public void setOther() {
        // for jtable
        String[] col = { "Id", "Name", "Faculty" };
        String[][] data = { { "1", "Shreejal Dhungana", "CSIT" }, { "2", "Shyam", "BCA" }, { "3", "Hari", "BBA" },
                { "4", "Sita", "BIM" }, { "5", "Gita", "CSIT" }, { "6", "Nita", "BCA" }, { "7", "Rita", "BBA" },
                { "8", "Rama", "BIM" }, { "9", "Sita", "CSIT" }, { "10", "Shreejal Dhungana", "BCA" },
                { "11", "Nita", "BBA" },
                { "12", "Rita", "BIM" }, { "13", "Rama", "CSIT" }, { "14", "Sita", "BCA" }, { "15", "Gita", "BBA" },
                { "16", "Nita", "BIM" }, { "17", "Rita", "CSIT" }, { "18", "Rama", "BCA" }, { "19", "Sita", "BBA" },
                { "20", "Shreejal Dhungana", "BIM" } };

        tb1 = new JTable(data, col);

        // seeting size of table to scroll
        tb1.setPreferredScrollableViewportSize(new Dimension(400, 200));

        // adding table to scrollbar
        JScrollPane sp = new JScrollPane(tb1);
        add(sp); // adding scrollbar to frame

        String[] item = { "Nepal", "USA", "UK", "Canada", "Australia" };
        JComboBox<String> cb = new JComboBox<String>(item);

        add(cb);

        setVisible(true);
        setSize(400, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(3);
    }
}

public class JTableDemo {
    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 2 \t Question 4");
        TableAndComboBox t = new TableAndComboBox();
        t.setOther();
    }

}
