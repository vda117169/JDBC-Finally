package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String USERNAME = "rootroot";
    private static final String PASSWORD = "root";
    private static SessionFactory sessionFactory;

    public static Connection getConnect() {
        Connection connection = null;
        Driver driver;

            try {
                driver = new com.mysql.cj.jdbc.Driver();
                DriverManager.deregisterDriver(driver);

                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }
