package unit4;

/*
 * Java Database Connectivity (JDBC) is a Java API that allows Java programs to access and manipulate data in a database.
 * To connect with with external data source like xml file sql server etc JDBC driver is required.
 * STEPS:
 * 1. initilialize DJDBS driver using Class.forName("com.mysql.jdbc.Driver");
 * 2. connect with database using connection object, for this DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","root");
 * Three paramater url, username, password
 * 3. Write proper query and execute it with statement object
 * 4. Close connection
 */
import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
        try {
            // step1: initialize driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // step2: connect with database
            Connection con;

            String url = "jdbc:mysql://localhost:3306/primecsita";
            // protocol:server:port:database
            String sUserName = "root";
            String sPassword = "";

            con = DriverManager.getConnection(url, sUserName, sPassword);

            if (con != null) {
                System.out.println("Connection established successfully");
            } else {
                System.out.println("Connection not established");
            }

            String tblQuery = "CREATE TABLE IF NOT EXISTS tbl_reg (id INT PRIMARY KEY, username VARCHAR(50), password VARCHAR(50), repassword VARCHAR(50), gender VARCHAR(50), course varchar(50), country varchar(50))";

            // execute query
            Statement stmt = con.createStatement();
            stmt.execute(tblQuery);

            /*
             * for crud operation either use execute or executeUpdate method
             * for select use executeQuery method
             */

            System.out.println("Table created successfully");

            System.out.println("Inserting data into table");

            // String insQuery = "INSERT INTO tbl_reg VALUES(1,'ram', 'ram', 'ram', 'male',
            // 'csit', 'nepal')";

            // Statement st = con.createStatement();
            // int res = st.executeUpdate(insQuery); // return 1 if successfull

            // if (res > 0) {
            // System.out.println("Data inserted successfully");
            // } else {
            // System.out.println("Data not inserted");
            // }

            System.out.println("fetching data from table");
            String selQuery = "SELECT * FROM tbl_reg";
            Statement st1 = con.createStatement();

            // to fetch data, execute query is used which return ResultSet object
            ResultSet rs = st1.executeQuery(selQuery);

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String repassword = rs.getString("repassword");

                String gender = rs.getString("gender");
                String course = rs.getString("course");
                String country = rs.getString("country");

                System.out.println("ID: " + id + " Username: " + username + " Password: " +
                        password + " Repassword: "
                        + repassword + " Gender: " + gender + " Course: " + course +
                        " Country: " + country);

            }

        } catch (ClassNotFoundException e) {
            // if driver is not found
            System.out.println(e);
        } catch (SQLException e) {
            // if connection is not established or swl query is incorrect
            System.out.println(e);
        }
    }

}
