package com.sudip.learn.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/TestDbServlet")
public class TestDBServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //setup connection variables

        String user = "sa";
        //Add Database Password in *******
        String pass = "*******";

        String jdbcUrl = "jdbc:sqlserver://127.0.0.1:1433;databaseName=springmvchibernate";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

        //get connection
        PrintWriter out = resp.getWriter();

        out.println("Connecting to database :: " + jdbcUrl);
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            out.println("Success !!!!");
            myConn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
