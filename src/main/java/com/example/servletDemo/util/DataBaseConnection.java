package com.example.servletDemo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static String url = "jdbc:mysql://localhost:3306/data";
    private static String username = "root";
    private static String password = "123456";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            System.out.println("注册驱动异常");
            e.printStackTrace();
        } catch (SQLException throwables) {
            System.out.println("创建数据库连接异常");
            throwables.printStackTrace();
        }
        return connection;
    }

}
