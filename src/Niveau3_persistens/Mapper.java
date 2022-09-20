package Niveau3_persistens;

import Niveau2_logik.TerminalInput;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Mapper {

    DatabaseConnection DBConn = new DatabaseConnection();

    protected void closeConnection() {
        DBConn.closeConnection();
    }

    //LISTS
    public void listOfCustomers() {
        //String ListOfCustomers = "CUSTOMER LIST - ID / NAME";
        //System.out.println(ListOfCustomers);
        showCustomersOnID();
    }

    public void listOfBooks() {
        showAllBooks();
    }

    //CUSTOMERS TABLE METHODS
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
            System.out.println("We now have " + id + " customers registered");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR!! This postal code and address is not valid. Check the 'City' table and make changes there first!");
        }
    }

    public void updateCustomer() {
        System.out.println("Update Customer Name / Address");
        String input = TerminalInput.getString("Insert 'Name' or 'Address'");

        switch (input) {
            case "Name" -> updateCustomerName();
            case "Address" -> updateCustomerAddress();
            default -> System.out.println("Something went wrong.. Try again");
        }
    }

    protected void updateCustomerName() {
        listOfCustomers();
        String sql = "update Customers set CustomerName = ? where CustomerID = ?";

        try (Connection con = DBConn.createConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {

            int customerID = TerminalInput.getInt("Update customer ID");
            String customerName = TerminalInput.getString("Type the new name");

            ps.setInt(2, customerID);
            ps.setString(1, customerName);
            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("The customer with the ID "
                        + customerID + " has now been updated to "
                        + "'" + customerName + "'");
            } else {
                System.out.println("A customer with this ID does not exist.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        listOfCustomers();
    }

    protected void updateCustomerAddress() {
        showCustomerData();
        String sql = "update Customers set Address = ? where CustomerID = ?";

        try (Connection con = DBConn.createConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {

            int customerID = TerminalInput.getInt("\nUpdate customer ID");
            String address = TerminalInput.getString("Type the new address");

            ps.setInt(2, customerID);
            ps.setString(1, address);
            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("The customer with the ID "
                        + customerID + "'s address has now been updated to "
                        + "'" + address + "'");
            } else {
                System.out.println("A customer with this ID does not exist.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void showCustomersOnID() {
        List<String> customerList = new ArrayList<>();

        String sql = "select * from Customers";

        try (Connection con = DBConn.createConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("CustomerID");
                String customerName = rs.getString("CustomerName");
                customerList.add("ID " + id + " : " + customerName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("CUSTOMER LIST - ID / NAME");
        for (String s : customerList) {
            System.out.println(s);
        }
    }

    protected void showCustomerData() {
        List<String> customerAddressList = new ArrayList<>();

        String sql = "select * from Customers";

        try (Connection con = DBConn.createConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("CustomerID");
                String customerName = rs.getString("CustomerName");
                int postalCode = rs.getInt("PostalCode");
                String address = rs.getString("Address");
                customerAddressList.add("ID " + id + " : " + customerName + ", " + postalCode + ", " + address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("CUSTOMER DATA - ID / NAME / POSTAL CODE / ADDRESS");
        for (String s : customerAddressList) {
            System.out.println(s);
        }
    }

    protected void deleteCustomer() {
        showCustomersOnID();
        String sql = "delete from Customers where CustomerID = ?";

        try (Connection con = DBConn.createConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {

            int customerID = Integer.parseInt(TerminalInput.getString("Choose a customer ID to delete"));
            ps.setInt(1, customerID);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("A customer with the ID " + customerID + "has now been deleted");
            } else {
                System.out.println("Something went wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //BOOKS TABLE METHODS
    protected void addBookData() {
        String sql = "INSERT INTO Books (Title, Author, ReleaseYear, Version) VALUES (?,?,?,?)";

        try (Connection con = DBConn.createConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, TerminalInput.getString("Title"));
            ps.setString(2, TerminalInput.getString("Author"));
            ps.setString(3, TerminalInput.getString("Release Year"));
            ps.setString(4, TerminalInput.getString("Version"));
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            System.out.println("We now have " + id + " books registered");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong");
        }
    }

    protected void updateBookName() {
        listOfBooks();
        String sql = "update Books set Title = ? where BookID = ?";

        try (Connection con = DBConn.createConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {

            int bookID = TerminalInput.getInt("Update book ID");
            String title = TerminalInput.getString("Type the new title");

            ps.setInt(2, bookID);
            ps.setString(1, title);
            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("The book with the ID "
                        + bookID + "'s title has now been updated to"
                        + "'" + title + "'");
            } else {
                System.out.println("A book with this ID does not exist.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        listOfBooks();
    }

    protected void updateBookAuthor() {
        listOfBooks();
        String sql = "update Books set Author = ? where BookID = ?";

        try (Connection con = DBConn.createConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {

            int bookID = TerminalInput.getInt("Update book ID");
            String author = TerminalInput.getString("Type the new author");

            ps.setInt(2, bookID);
            ps.setString(1, author);
            int res = ps.executeUpdate();

            if (res > 0) {
                System.out.println("The book with the ID "
                        + bookID + "'s author has now been updated to "
                        + "'" + author + "'");
            } else {
                System.out.println("A book with this ID does not exist.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        listOfBooks();
    }

    protected void updateBookReleaseYear() {
        listOfBooks();
        String sql = "update Books set ReleaseYear = ? where BookID = ?";

        try (Connection con = DBConn.createConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {

            int bookID = TerminalInput.getInt("Update book ID");
            int releaseYear = TerminalInput.getInt("Type the new release year");

            ps.setInt(2, bookID);
            ps.setInt(1, releaseYear);
            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("The book with the ID "
                        + bookID + "'s release year has now been updated to "
                        + "'" + releaseYear + "'");
            } else {
                System.out.println("A book with this ID does not exist.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        listOfBooks();
    }

    protected void updateBookVersion() {
        listOfBooks();
        String sql = "update Books set Version = ? where BookID = ?";

        try (Connection con = DBConn.createConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {

            int bookID = TerminalInput.getInt("Update book ID");
            int version = TerminalInput.getInt("Type the new version number");

            ps.setInt(2, bookID);
            ps.setInt(1, version);
            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("The book with the ID "
                        + bookID + "'s version number has now been updated to "
                        + "'" + version + "'");
            } else {
                System.out.println("A book with this ID does not exist.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        listOfBooks();
    }

    protected void deleteBookData() {
    }

    protected void showAllBooks() {
        List<String> bookList = new ArrayList<>();

        String sql = "select * from Books";

        try (Connection con = DBConn.createConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("BookID");
                String title = rs.getString("Title");
                String author = rs.getString("Author");
                int release_year = rs.getInt("ReleaseYear");
                int version = rs.getInt("Version");
                bookList.add("ID " + id + " : " + title + ", " + author + ", " + release_year + ", " + version);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("BOOK DATA - ID / TITLE / AUTHOR / RELEASE YEAR / VERSION");
        for (String s : bookList) {
            System.out.println(s);
        }
    }

    //BOOK RENTAL TABLE METHODS



}
