package unit4;

/*
prepared statement is used to handle dynamic data 
 */
import java.sql.*;
import java.util.*;

class PreparedEg {
    Connection conn;

    public void insertData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/primecsita";
            String susername = "root";
            String spassword = "";
            conn = DriverManager.getConnection(url, susername, spassword);
            // inserting data into tbl_reg use prepare statement
            // take input from user
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your id: ");
            String id = sc.next();
            System.out.print("Enter your username: ");
            String uname = sc.next();
            System.out.print("Enter your password: ");
            String pass = sc.next();
            System.out.print("Enter your repassword: ");
            String repass = sc.next();
            System.out.print("Enter your gender: ");
            String gender = sc.next();
            System.out.print("Enter your course: ");
            String course = sc.next();
            System.out.print("Enter your country: ");
            String country = sc.next();

            // query
            String insQuery = "insert into tbl_reg values(?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(insQuery);
            ps.setString(1, id);
            ps.setString(2, uname);
            ps.setString(3, pass);
            ps.setString(4, repass);
            ps.setString(5, gender);
            ps.setString(6, course);
            ps.setString(7, country);

            int res = ps.executeUpdate();
            if (res > 0) {
                System.out.println(res + " data inserted");
            }
            conn.close();
            sc.close();

        } catch (ClassNotFoundException c) {
            System.out.println(c);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void fetchData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/primecsita";
            String susername = "root";
            String spassword = "";
            conn = DriverManager.getConnection(url, susername, spassword);
            // display record of person whose id is given by user
            Scanner sc1 = new Scanner(System.in);
            System.out.print("Enter id of person: ");
            String id = sc1.next();
            String disQuery1 = "select * from tbl_reg where id=?";
            // fetch data
            // String disQuery="select * from tbl_reg";
            PreparedStatement ps1 = conn.prepareStatement(disQuery1);
            ps1.setString(1, id);
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                String did = rs.getString("id");
                String duname = rs.getString("username");
                String dpass = rs.getString("password");
                String drepass = rs.getString("repassword");
                String dgender = rs.getString("gender");
                String dcourse = rs.getString("course");
                String dcountry = rs.getString("country");
                System.out.println("id is: " + did + "\nUsername is: " + duname
                        + "\nPassword is: " + dpass +
                        "\nRepassword is: " + drepass +
                        "\nGender is: " + dgender +
                        "\nCOurse is: " + dcourse +
                        "\ncountry is: " + dcountry);
            }
            conn.close();
            sc1.close();
        } catch (ClassNotFoundException c) {
            System.out.println(c);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // updating data
    public void updateData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/primecsita";
            String susername = "root";
            String spassword = "";
            conn = DriverManager.getConnection(url, susername, spassword);
            // update course to ? and country to ? for person whose id is 1

            Scanner sc1 = new Scanner(System.in);
            System.out.print("Enter course of person: ");
            String ucourse = sc1.next();
            System.out.print("Enter country of person: ");
            String ucountry = sc1.next();
            String upQuery = "update tbl_reg set course=?,country=? where id='1'";
            PreparedStatement ps1 = conn.prepareStatement(upQuery);
            ps1.setString(1, ucourse);
            ps1.setString(2, ucountry);
            int res2 = ps1.executeUpdate();
            if (res2 > 0) {
                System.out.println(res2 + " data updated");
            }
            conn.close();
            sc1.close();
        } catch (ClassNotFoundException c) {
            System.out.println(c);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // deleting data from database
    public void delData() {
        // delete record of peroson whose id is given by user
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/primecsita";
            String susername = "root";
            String spassword = "";
            conn = DriverManager.getConnection(url, susername, spassword);
            // update course to ? and country to ? for person whose id is 1

            Scanner sc1 = new Scanner(System.in);
            System.out.print("Enter id of person whose record is to be deleted: ");
            String did = sc1.next();

            String delQuery = "delete from tbl_reg where id=?";
            PreparedStatement ps1 = conn.prepareStatement(delQuery);
            ps1.setString(1, did);
            int res2 = ps1.executeUpdate();
            if (res2 > 0) {
                System.out.println(res2 + " data deleted");
            }
            conn.close();
            sc1.close();
        } catch (ClassNotFoundException c) {
            System.out.println(c);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

public class PreparedStatementDemo {
    public static void main(String[] args) {
        // menu based program
        PreparedEg pe = new PreparedEg();
        Scanner sc = new Scanner(System.in);
        String ch;
        do {
            System.out.println("1. Insert data");
            System.out.println("2. Fetch data");
            System.out.println("3. Update data");
            System.out.println("4. Delete data");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    pe.insertData();
                    break;
                case 2:
                    pe.fetchData();
                    break;
                case 3:
                    pe.updateData();
                    break;
                case 4:
                    pe.delData();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.print("Do you want to continue(y/n): ");
            ch = sc.next();

        } while (ch.equals("y"));

        sc.close();
    }
}
