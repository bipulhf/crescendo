package com.crescendo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public void loadDriver() {
        try {
            String dbdriver = "com.mysql.cj.jdbc.Driver";
            Class.forName(dbdriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        loadDriver();
        Connection con = null;
        try {
            String dbpassword = "24553";
            String dburl = "jdbc:mysql://localhost:3306/course_management";
            String dbuname = "root";
            con = DriverManager.getConnection(dburl, dbuname, dbpassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
