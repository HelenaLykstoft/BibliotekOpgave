package Niveau3_persistens;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfig {
    public static Connection getConnection() {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/demodb?serverTimezone=CET&useSSL=false";
        String user = "root";
        String password = "Mysql1238Code18";
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return connection;
    }
}
