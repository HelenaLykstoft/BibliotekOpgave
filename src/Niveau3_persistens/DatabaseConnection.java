package Niveau3_persistens;

import java.sql.*;
import java.util.Scanner;

public class DatabaseConnection {
    protected Connection connection;
    private int id;

    // CONSTRUCTOR
    public DatabaseConnection() {
        Scanner scan = new Scanner(System.in);
    }

    // Method to create a connection to the SQL workbench
    protected Connection createConnection() {
        DatabasePassword databasePassword = new DatabasePassword();

        try {
            connection = DriverManager.getConnection(databasePassword.getJdbcUrl(), databasePassword.getUsername(), databasePassword.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Method to close a connection to the SQL workbench
    protected void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
