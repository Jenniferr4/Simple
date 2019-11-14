package com.improving.bootcamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ExampleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/css");
        PrintWriter out = response.getWriter();
        out.println("#search{ background-color: pink; }");
        out.println("#row{ padding : 0px 5px 0px 10px; }");

    }

}
