package Niveau3_persistens;

import java.sql.*;
import java.util.Scanner;

public class DatabaseConnection {

    // OBJECTS OF CLASSES
    private Scanner scan;
    protected Connection connection;


    // PRIMITIVE DATA FIELDS
    private int id;

    // CONSTRUCTOR
    public DatabaseConnection() {
        this.scan = new Scanner(System.in);
    }

    // Method to create a connection to the SQL workbench
    protected Connection createConnection() {
        DatabasePassword databasePassword = new DatabasePassword(); // creating a new Niveau3_persistens.DatabasePassword object

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
        } catch (SQLException e) { // wrapped in a try catch to handle the otherwise thrown SQLException that would prevent us from running our program
            e.printStackTrace();
        }
    }


}
