package unit4;

/*
 * Fethcing data in jtable from database
 */

import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;

import java.sql.*;

class DisplayData extends JFrame {
    JTable jt;
    Connection conn;

    public void displayTable() {
        jt = new JTable();

        // set size of table
        jt.setPreferredScrollableViewportSize(new Dimension(400, 100));

        // adding scrollbar to table
        JScrollPane sp = new JScrollPane(jt);
        add(sp); // adding scrollbar to frame

        // add column
        DefaultTableModel dt = (DefaultTableModel) jt.getModel();

        dt.addColumn("id");
        dt.addColumn("username");
        dt.addColumn("password");
        dt.addColumn("repassword");
        dt.addColumn("gender");
        dt.addColumn("course");
        dt.addColumn("country");

        // add scrollbar

        setVisible(true);
        setSize(500, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(3);

        // connect to database and display result
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/primecsita";
            String susername = "root";
            String spassword = "";
            conn = DriverManager.getConnection(url, susername, spassword);

            String disQuery = "SELECT * FROM tbl_reg";
            PreparedStatement ps = conn.prepareStatement(disQuery);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // dt.addRow(
                // new Object[] { rs.getInt(1), rs.getString(2), rs.getString(3),
                // rs.getString(4), rs.getString(5),
                // rs.getString(6), rs.getString(7) });

                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String repassword = rs.getString(4);
                String gender = rs.getString(5);
                String course = rs.getString(6);
                String country = rs.getString(7);

                dt.addRow(new Object[] { id, username, password, repassword, gender, course, country });
            }

            conn.close();

        } catch (ClassNotFoundException c) {
            System.out.println(c);
        } catch (SQLException se) {
            System.out.println(se);
        }

    }
}

public class SwingDisplayTable {

    public static void main(String[] args) {
        DisplayData d = new DisplayData();
        d.displayTable();

    }

}
