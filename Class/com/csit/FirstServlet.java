/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csit;

/*
servlet is a interface which is used to handle request from web browser and response from server
there are three ways to create servlet
1. By implementing servlet interface
2. By using generic class
3. By using HTTPServlet class: use to handle data from web
*/

//previously servlet reside on javac package, now it reside on jakarta package
//import jakarta.servlet.*; //servlet
//import jakarta.servlet.http.*; //http req

import java.io.*; // for print writer
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//creating servlet using servlet interface

        

/**
 *
 * @author ShreejalDhungana
 */
public class FirstServlet implements Servlet{

    // lifecycle method
    ServletConfig config;
    @Override
    public void init(ServletConfig config) throws ServletException {
        //servlet born
        this.config=config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    //lifecycle method
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //servlet provide services to show data prin writer is used
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<h1>Hello World</h1>");
        pw.close();
    }

    //non lifecycle
    @Override
    public String getServletInfo() {
        return "Servlet using interface";
    }

    @Override
    public void destroy() {
        //servlet deleted
        System.out.println("Servlet die");
    }
    
    
}
