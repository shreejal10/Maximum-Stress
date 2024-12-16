package unit4;

/*
 * using onky result set we can fetch data from row 1 to 2 to row 3 and so on. but using scrollable and updatable result set we can fetch data of any row and also can be updated
 */

import java.sql.*;

public class ScrollableAndUpdateTableDemo {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/primecsita";
            String susername = "root";
            String spassword = "";
            Connection conn = DriverManager.getConnection(url, susername, spassword);

            String disQuery = "SELECT * FROM tbl_reg";
            // creating scrollable and updatetable result set, to make result set
            // scrollable: to go on any row
            int scroll = ResultSet.TYPE_SCROLL_SENSITIVE;
            // to create updateTable: to do update operation
            int updateTable = ResultSet.CONCUR_UPDATABLE;

            // to make readonly result set, use ResultSet.CONCUR_READ_ONLY
            // int read = ResultSet.CONCUR_READ_ONLY;

            Statement st = conn.createStatement(scroll, updateTable);

            ResultSet rs = st.executeQuery(disQuery);

            System.out.println("Data from last row of table");
            rs.last();
            System.out.println("id is: " + rs.getString("id") + "\nUsername is: " + rs.getString("username")
                    + "\nPassword is: " + rs.getString("password") + "\nRepassword is: " + rs.getString("repassword")
                    + "\nGender is: " + rs.getString("gender") + "\nCourse is: " + rs.getString("course")
                    + "\nCountry is: " + rs.getString("country"));

            // to fetch data of any row

            System.out.println("Fetching 3rd row data");
            rs.absolute(1);

            System.out.println("id is: " + rs.getString("id") + "\nUsername is: " + rs.getString("username"));

            // updatung username to shyam whose id is 1
            // (columnName, value)
            rs.updateString("username", "shyam");
            rs.updateRow();

            System.out.println("id is: " + rs.getString("id") + "\nUsername is: " + rs.getString("username"));
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException c) {
            System.out.println(c);
        }

    }

}