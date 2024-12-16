<%-- 
    Document   : LoginJSP
    Created on : Sep 4, 2024, 7:36:52 AM
    Author     : ShreejalDhungana
    JSP: Java Server Page
    in jsp, we can add both front end and backend program. Frontend is done by html and backend is done by using declarative symbol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            for(int i=1; i<=10; i ++){
                out.println("This is JSP");
            }
        %>
        
        <form method="post" action=''>
            <label>ID</label>
                <input type="text" name="id"/></br>
                <label>Username</label>
                <input type="text" name="uname"/></br>
                <label>Password</label>
                <input type="password" name="pass"/></br>
                <label>Re password</label>
                <input type="password" name="repass"/></br>
                <label>Gender</label>
                <label>Male</label>
                <input type="radio" name="gender" value="male"/>
                <label>Female</label>
                <input type="radio" name="gender" value="female"/></br>
                <label>Course</label>
                <input type="checkbox" name="crc" value="java">Java
                <input type="checkbox" name="crc" value="c++">c++
                <input type="checkbox" name="crc" value="c">c</br>
                <label>country</label>
                <select name="con">
                    <option value="-1">Select Country</option>
                    <option value="nepal">Nepal</option>
                    <option value="usa">USA</option>
                    <option value="japan">Japan</option>
                </select> </br>
                <input type="submit" name="submit" value="submit"/>
        </form>
        <% 
            String id = request.getParameter("id");
            String uname = request.getParameter("uname");
            String pass = request.getParameter("pass");
            String repass = request.getParameter("repass");
            String gender = request.getParameter("gender");
            
            String []course = request.getParameterValues("crc");
        
            //convert into string
            String cr = "";
            if(course!=null){
                
                for(String c:course){
                    cr += c+" ";
                }
            }
        
            String country = request.getParameter("con");
            
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
        %>
    </body>
</html>
