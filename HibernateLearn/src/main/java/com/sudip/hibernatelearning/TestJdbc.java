package com.sudip.hibernatelearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

    public static void main(String[] args) {
        try {
            //Insert DB password
            String conUrl = "jdbc:sqlserver://127.0.0.1:1433;databaseName=hibernatelearn;user=sa;password={********}";
            Connection conn = DriverManager.getConnection(conUrl);
            System.out.println("conn is succesfull");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
