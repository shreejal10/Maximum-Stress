package unit4;

// structured example for jdbc and prepared statement, with functions for connection, table creation, and data insertion
import java.sql.*;
import java.util.*;

class DataBasedemo {
    private static final String URL = "jdbc:mysql://localhost:3306/primecsita";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    Connection conn;

    private Connection createDbConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public void createTable() {
        try {
            conn = createDbConnection();
            if (conn != null) {
                String tblQuery = "CREATE TABLE IF NOT EXISTS tbl_reg (id INT PRIMARY KEY, username VARCHAR(50), password VARCHAR(50), repassword VARCHAR(50), gender VARCHAR(50), course varchar(50), country varchar(50))";

                Statement stmt = conn.createStatement();
                stmt.execute(tblQuery);

                System.out.println("Table created successfully");
            } else {
                System.out.println("Connection not established");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void fetchAllData() {
        try {
            conn = createDbConnection();
            if (conn != null) {
                String selQuery = "SELECT * FROM tbl_reg";
                Statement st1 = conn.createStatement();

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
            } else {
                System.out.println("Connection not established");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

public class StructuredDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataBasedemo db = new DataBasedemo();
        String ch;
        int choice;

        do {
            System.out.println("1. Create table");
            System.out.println("2. Insert data");
            System.out.println("3. Fetch all data");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    db.createTable();
                    break;
                case 2:
                    // insert data
                    break;
                case 3:
                    db.fetchAllData();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }

            System.out.print("Do you want to continue? (y/n): ");
            ch = sc.next();
        } while (ch.equalsIgnoreCase("y"));

        sc.close();
    }

}
