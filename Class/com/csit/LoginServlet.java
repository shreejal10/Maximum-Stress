/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csit;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

/**
 *
 * @author ShreejalDhungana
 */
public class LoginServlet extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        String uname = req.getParameter("uname");
        String pass = req.getParameter("pass");
        
        //check whether uname and password match with db or not. if yes, display data of such person.
        //database connection
        try{
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
            
            
            String checkQuery = "SELECT * FROM tbl_reg WHERE username=? AND password=?";
            
            PreparedStatement ps = con.prepareStatement(checkQuery);
            
            ps.setString(1,uname);
            ps.setString(2,pass);
            
            //execute query and if success, display data in table
            
            ResultSet rs = ps.executeQuery();
            
            
            res.setContentType("text/html");
            PrintWriter pw = res.getWriter();
                
            pw.println("<table>"
                        + "<tr> "
                        + "<th>ID</th> "
                        + "<th>Uname</th> "
                        + "<th>Password </th>"
                        + "<th>Gender</th>"
                        + "<th>Course</th>"
                        + "<th>Country</th>"
                        + "</tr>");
            
            while(rs.next()){
                pw.println("<tr>"
                        + "<td>" +rs.getString("id") + "</td>"
                        + "<td>" +rs.getString("username") + "</td>"
                        + "<td>" +rs.getString("password") + "</td>"
                        + "<td>" +rs.getString("gender") + "</td>"
                        + "<td>" +rs.getString("course") + "</td>"
                        + "<td>" +rs.getString("country") + "</td>"
                        + "</tr>");
            }
            pw.println("</table>");
                
        }catch (ClassNotFoundException e){
            System.out.println("Error" +e);
            
        }catch(SQLException c){
               System.out.println("Error"+ c);
        }
    }
    
}
