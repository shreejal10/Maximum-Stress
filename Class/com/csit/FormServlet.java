/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csit;

//to process form or any http request servelt should be created by extending HttpServelt Class

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

/**
 *
 * @author ShreejalDhungana
 */
public class FormServlet extends HttpServlet{
    //override post method
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //extract all the form fields
        String id = req.getParameter("id");
        String uname = req.getParameter("uname");
        String pass = req.getParameter("pass");
        String repass = req.getParameter("repass");
        String gender = req.getParameter("gender");
        
        //for multiple value
        String []course = req.getParameterValues("crc");
        
        //convert into string
        String cr = "";
        for(String c:course){
            cr += c+" ";
        }
        
        String country = req.getParameter("con");
        
        //displaying from data
        
        res.setContentType("text/html");
        
        PrintWriter pw = res.getWriter();
        pw.println("<h2>id is" +id+"uname is "+uname +"pass is "+ pass + "re pass is "+ repass + "gender is "+ gender + "course is "+ cr+ "country is"+ country);
        
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
            
            String insQuery = "Insert into tbl_reg values(?,?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(insQuery);
            ps.setString(1, id);
            ps.setString(2, uname);
            ps.setString(3, pass);
            ps.setString(4, repass);
            ps.setString(5, gender);
            ps.setString(6, cr);
            ps.setString(7, country);
            
            ps.executeUpdate();
            
        }catch (ClassNotFoundException e){
            System.out.println("Error" +e);
            
        }catch(SQLException c){
               System.out.println("Error"+ c);
        }
    }
}
