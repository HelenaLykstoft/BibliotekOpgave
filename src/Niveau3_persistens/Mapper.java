package Niveau3_persistens;

import Niveau2_logik.TerminalInput;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Mapper {

    DatabaseConnection DBConn = new DatabaseConnection();
    protected void updateCustomer() {
        showCustomers();
        String sql = "update  Customers set CustomerName = ? where CustomerID = ?";

        try (Connection con = DBConn.createConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {
            String customerName = TerminalInput.getString("Update customer: ");
            ps.setString(1, customerName);
            ps.setInt(2, TerminalInput.getInt("Write the ID: "));

            int res = ps.executeUpdate();

            if (res > 0) {

                System.out.println("The customer with the name " + "\"" + customerName + "\"" + " has now been updated.");
            } else {
                System.out.println("A customer with this number doesnt exist.");

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        showCustomers();
    }

    /*protected void deleteCustomer() {
        showCustomers();
        String sql = "delete from navne where Navne = ?";

        try (Connection con = DBConn.createConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {
            String kundeNavn = TerminalInput.getString("skriv navnet på den kunde der skal slettes ");
            ps.setString(1, kundeNavn);


            int res = ps.executeUpdate();       //https://javaconceptoftheday.com/difference-between-executequery-executeupdate-execute-in-jdbc/

            if (res > 0) {

                System.out.println("Kunden med navnet " + "\"" + kundeNavn + "\"" + " er nu blevet slettet");
            } else {

                System.out.println("en kunde med navnet " + "\"" + kundeNavn + "\"" + " fandtes ikke i listen");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        showCustomers();
    }*/

    protected void showCustomers() {
        List<String> customerList = new ArrayList<>();

        String sql = "select * from Customers ";

        try (Connection con = DBConn.createConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("CustomerID");
                String customerName = resultSet.getString("CustomerName");
                customerList.add(id + " : " + customerName);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

        for (String s : customerList) {
            System.out.println(s);
        }
    }

    protected void createCustomer() {
        String sql = "INSERT INTO Customers (CustomerName) VALUES (?)";

        try (Connection con = DBConn.createConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, TerminalInput.getString("Write a name: "));
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            System.out.println("We now have " + id +" amount of customers.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
