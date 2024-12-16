package unit2;

/*
 * 1. JTable: used to show data in form of row and column
 *    Create object of JTable and pass data and column as parameter. to add scroll bar, JScrollPane is used
 * 2. JSplitPane: divide the content into two parts
 *    Create object if JSplitPane and pass sub window as component
 * 3. JList: same as combo box but shows all the content without clicking any button. to add scroll bar scroll pane is used
 */

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

import java.awt.*;

import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;

class OtherComp extends JFrame {
    JTable tb1;
    JSplitPane sp1;
    JList<String> l1;

    public void setOther() {
        // for jtable
        String[] col = { "Id", "Name", "Faculty" };
        String[][] data = { { "1", "Ram", "CSIT" }, { "2", "Shyam", "BCA" }, { "3", "Hari", "BBA" },
                { "4", "Sita", "BIM" }, { "5", "Gita", "CSIT" }, { "6", "Nita", "BCA" }, { "7", "Rita", "BBA" },
                { "8", "Rama", "BIM" }, { "9", "Sita", "CSIT" }, { "10", "Gita", "BCA" }, { "11", "Nita", "BBA" },
                { "12", "Rita", "BIM" }, { "13", "Rama", "CSIT" }, { "14", "Sita", "BCA" }, { "15", "Gita", "BBA" },
                { "16", "Nita", "BIM" }, { "17", "Rita", "CSIT" }, { "18", "Rama", "BCA" }, { "19", "Sita", "BBA" },
                { "20", "Gita", "BIM" } };

        tb1 = new JTable(data, col);

        // seeting size of table to scroll
        tb1.setPreferredScrollableViewportSize(new Dimension(400, 200));

        // adding table to scrollbar
        JScrollPane sp = new JScrollPane(tb1);
        add(sp); // adding scrollbar to frame

        // example on splitpane
        // adding two component into splitpane
        String[] item = { "Nepal", "USA", "UK", "Canada", "Australia" };
        JComboBox<String> cb = new JComboBox<String>(item);
        JTextField t1 = new JTextField(20);

        // it takes 3 paramaters: 1. orientation of slider (vertical or horizontal),
        // 2.sub window pannel
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        p1.add(cb);
        p2.add(t1);

        sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p1, p2);

        // to set slider for expandable release
        sp1.setOneTouchExpandable(true);

        // to set gap between slider and content
        sp1.setDividerLocation(20);

        add(sp1);

        // JList
        String[] country = { "CSIT", "BCA", "BBA", "BIM", "MIT", "MCA", "BIT", "BSC", "BBS", "BTTM" };

        l1 = new JList<String>(country);
        // l1.setPreferredSize(new Dimension(50, 50));

        JScrollPane spa = new JScrollPane(l1);

        l1.setSelectionMode(2);// multi select

        JTextField t2 = new JTextField(20);
        add(t2);

        // when item in list is clicked ListSelectionEvent is generated
        l1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // to extract items
                ArrayList<String> arr1 = (ArrayList) l1.getSelectedValuesList();

                String val = "";
                for (String data : arr1) {
                    val += data + " ";
                }
                t1.setText(val);
            }

            // displaying data of list
        });

        add(spa);

        setVisible(true);
        setSize(400, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(3);
    }
}

public class OtherSwingComponents {
    public static void main(String[] args) {
        OtherComp oc = new OtherComp();
        oc.setOther();
    }

}
