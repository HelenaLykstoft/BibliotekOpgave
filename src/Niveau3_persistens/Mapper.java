package Niveau3_persistens;

import Niveau2_logik.TerminalInput;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Mapper {

    DatabaseConnection DBConn = new DatabaseConnection();

    public void listOfCustomers() {
        String ListOfCustomers = "List of Customers: ";
        System.out.println(ListOfCustomers);
        showCustomers();
    }

    protected void addCustomer() {
        String sql = "INSERT INTO Customers (CustomerName, PostalCode, Address) VALUES (?,?,?)";

        try (Connection con = DBConn.createConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, TerminalInput.getString("Name"));
            ps.setString(2, TerminalInput.getString("Postal Code"));
            ps.setString(3, TerminalInput.getString("Address"));
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            System.out.println("We now have " + id + " amount of customers");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR!! This postal code and address is not valid. Check the 'City' table and make changes there first!");
        }
    }

    protected void updateCustomer() {
        listOfCustomers();
        String sql = "update Customers set CustomerName = ? where CustomerID = ?";

        try (Connection con = DBConn.createConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {

            int customerID = TerminalInput.getInt("Update customer ID");
            String customerName = TerminalInput.getString("Type the new name");

            ps.setInt(2, customerID);
            ps.setString(1, customerName);
            int res = ps.executeUpdate();

            if (res > 0) {
                System.out.println("The customer with the ID "
                        + customerID + " has now been updated to "
                        + "\"" + customerName + "\"");
            } else {
                System.out.println("A customer with this ID does not exist.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        listOfCustomers();
    }

    protected void showCustomers() {
        List<String> customerList = new ArrayList<>();

        String sql = "select * from Customers";

        try (Connection con = DBConn.createConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("CustomerID");
                String customerName = rs.getString("CustomerName");
                customerList.add("ID: " + id + " : " + customerName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String ListOfCustomers = "List of Customers: ";
        System.out.println(ListOfCustomers);
        for (String s : customerList) {
            System.out.println(s);
        }
    }

    protected void deleteCustomer() {
        showCustomers();
        String sql = "delete from Customers where CustomerID = ?";

        try (Connection con = DBConn.createConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {

            int customerID = Integer.parseInt(TerminalInput.getString("Choose a customer ID to delete"));
            ps.setInt(1, customerID);

            int res = ps.executeUpdate();

            if (res > 0) {
                System.out.println(customerID + "with the name has now been deleted");
            } else {
                System.out.println("Something went wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
