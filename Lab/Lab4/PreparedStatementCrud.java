package Lab4;

/*
 * 2. Write a program to perform CRUD operation using prepared statement
 */

import java.sql.*;
import java.util.*;

class DBOperationDemo {
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
            String insertQuery = "INSERT INTO tbl_reg VALUES(?, ?, ?, ?, ?, ?, ?)";

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter id: ");
            int id = sc.nextInt();
            System.out.print("Enter username: ");
            String username = sc.next();
            System.out.print("Enter password: ");
            String password = sc.next();
            System.out.print("Enter repassword: ");
            String repassword = sc.next();
            System.out.print("Enter gender: ");
            String gender = sc.next();
            System.out.print("Enter course: ");
            String course = sc.next();
            System.out.print("Enter country: ");
            String country = sc.next();

            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setInt(1, id);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, repassword);
            ps.setString(5, gender);
            ps.setString(6, course);
            ps.setString(7, country);

            int res = ps.executeUpdate();

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

            String updateQuery = "UPDATE tbl_reg SET username = ? WHERE id = ?";
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter id: ");
            int id = sc.nextInt();
            System.out.print("Enter new username: ");
            String username = sc.next();

            PreparedStatement ps = con.prepareStatement(updateQuery);
            ps.setString(1, username);
            ps.setInt(2, id);

            int res = ps.executeUpdate();

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
            String deleteQuery = "DELETE FROM tbl_reg WHERE id = ?";

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter id: ");
            int id = sc.nextInt();

            PreparedStatement ps = con.prepareStatement(deleteQuery);
            ps.setInt(1, id);

            int res = ps.executeUpdate();

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

public class PreparedStatementCrud {
    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 4 \t Question 2");

        DBOperationDemo db = new DBOperationDemo();
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
