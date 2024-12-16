package Lab4;

/*
 * Demonstrate the use of row set and updatable and scrollable result set.
 */

import java.sql.*;

import javax.sql.rowset.*;

public class RowAndResultSet {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/primecsita";
            String susername = "root";
            String spassword = "";
            Connection conn = DriverManager.getConnection(url, susername, spassword);

            // creating rowset object
            JdbcRowSet jrs = RowSetProvider.newFactory().createJdbcRowSet();

            // creating connection
            jrs.setUrl(url);
            jrs.setUsername(susername);
            jrs.setPassword(spassword);

            jrs.setCommand("SELECT * FROM tbl_reg");
            System.out.println("Using RowSet");
            jrs.execute();

            System.out.println("Data from last row of table");
            jrs.last();

            System.out.println("id is: " + jrs.getString("id") + "\nUsername is: " + jrs.getString("username")
                    + "\nPassword is: " + jrs.getString("password") + "\nRepassword is: " + jrs.getString("repassword")
                    + "\nGender is: " + jrs.getString("gender") + "\nCourse is: " + jrs.getString("course")
                    + "\nCountry is: " + jrs.getString("country"));

            String disQuery = "SELECT * FROM tbl_reg";
            int scroll = ResultSet.TYPE_SCROLL_SENSITIVE;
            int updateTable = ResultSet.CONCUR_UPDATABLE;

            Statement st = conn.createStatement(scroll, updateTable);

            ResultSet rs = st.executeQuery(disQuery);

            System.out.println("Using ResultSet");
            System.out.println("Data from last row of table");
            rs.last();
            System.out.println("id is: " + rs.getString("id") + "\nUsername is: " + rs.getString("username")
                    + "\nPassword is: " + rs.getString("password") + "\nRepassword is: " + rs.getString("repassword")
                    + "\nGender is: " + rs.getString("gender") + "\nCourse is: " + rs.getString("course")
                    + "\nCountry is: " + rs.getString("country"));

            System.out.println("Fetching 3rd row data");
            rs.absolute(3);
            System.out.println("id is: " + rs.getString("id") + "\nUsername is: " + rs.getString("username")
                    + "\nPassword is: " + rs.getString("password") + "\nRepassword is: " + rs.getString("repassword")
                    + "\nGender is: " + rs.getString("gender") + "\nCourse is: " + rs.getString("course")
                    + "\nCountry is: " + rs.getString("country"));

            conn.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
