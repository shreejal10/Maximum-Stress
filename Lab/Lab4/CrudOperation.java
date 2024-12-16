package Lab4;

/*
 * 1. Write a program to perform CRUD operation
 */

import java.sql.*;
import java.util.*;

class DbOperation {
    private Connection con;

    private Connection establishConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/primecsita";
            String sUserName = "root";
            String sPassword = "";

            con = DriverManager.getConnection(url, sUserName, sPassword);

            return con;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public void createTable() {
        try {
            con = establishConnection();
            String tblQuery = "CREATE TABLE IF NOT EXISTS tbl_reg (id INT PRIMARY KEY, username VARCHAR(50), password VARCHAR(50), repassword VARCHAR(50), gender VARCHAR(50), course varchar(50), country varchar(50))";

            Statement stmt = con.createStatement();
            stmt.execute(tblQuery);
            System.out.println("Table created successfully");
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insertData() {
        try {
            con = establishConnection();
            String insertQuery = "INSERT INTO tbl_reg VALUES(1, 'admin', 'admin', 'admin', 'male', 'BSc.CSIT', 'Nepal')";

            Statement stmt = con.createStatement();
            int res = stmt.executeUpdate(insertQuery);

            if (res > 0) {
                System.out.println("Data inserted successfully");
            } else {
                System.out.println("Data insertion failed");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void readData() {
        try {
            con = establishConnection();
            String selectQuery = "SELECT * FROM tbl_reg";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1) + ", Username: " + rs.getString(2) + ", Password: "
                        + rs.getString(3) + ", Repassword: " + rs.getString(4) + "Gender: " + rs.getString(5)
                        + ", Course: " + rs.getString(6) + ", Country: " + rs.getString(7));
            }

            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateData() {
        try {
            con = establishConnection();
            String updateQuery = "UPDATE tbl_reg SET username = 'newadmin' WHERE id = 1";

            Statement stmt = con.createStatement();
            int res = stmt.executeUpdate(updateQuery);

            if (res > 0) {
                System.out.println("Data updated successfully");
            } else {
                System.out.println("Data updation failed");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteData() {
        try {
            con = establishConnection();
            String deleteQuery = "DELETE FROM tbl_reg WHERE id = 1";

            Statement stmt = con.createStatement();
            int res = stmt.executeUpdate(deleteQuery);

            if (res > 0) {
                System.out.println("Data deleted successfully");
            } else {
                System.out.println("Data deletion failed");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

public class CrudOperation {

    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 4 \t Question 1");
        DbOperation db = new DbOperation();
        Scanner sc = new Scanner(System.in);
        String ch;

        do {
            System.out.println("1. Create table");
            System.out.println("2. Insert data");
            System.out.println("3. Read data");
            System.out.println("4. Update data");
            System.out.println("5. Delete data");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    db.createTable();
                    break;
                case 2:
                    db.insertData();
                    break;
                case 3:
                    db.readData();
                    break;
                case 4:
                    db.updateData();
                    break;
                case 5:
                    db.deleteData();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.print("Do you want to continue? (y/n) :");
            ch = sc.next();
        } while (ch.equals("y"));
        sc.close();
    }

}
