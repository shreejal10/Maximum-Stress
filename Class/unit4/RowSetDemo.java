package unit4;

/*
 * row set is more flexible than result set as it is by default scrollable and updatable.
 * rowset resides on package, javax.sql.rowset
 */
import java.sql.*;

import javax.sql.rowset.*;

public class RowSetDemo {
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
            jrs.execute();

            System.out.println("Data from 2nd row of table");
            jrs.absolute(2);

            System.out.println("id is: " + jrs.getString("id") + "\nUsername is: " + jrs.getString("username")
                    + "\nPassword is: " + jrs.getString("password") + "\nRepassword is: " + jrs.getString("repassword")
                    + "\nGender is: " + jrs.getString("gender") + "\nCourse is: " + jrs.getString("course")
                    + "\nCountry is: " + jrs.getString("country"));
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException c) {
            System.out.println(c);
        }
    }

}
