package Niveau3_persistens;

import Niveau2_logik.TerminalInput;

public class Facade {

    Mapper mapper = new Mapper();

    public void addCustomer() {
        mapper.addCustomer();
    }

    public void updateCustomer() {
        System.out.println("Update Customer Name / Address");
        String input = TerminalInput.getString("Insert 'Name' or 'Address'");

        switch (input) {
            case "Name" -> mapper.updateCustomerName();
            case "Address" -> mapper.updateCustomerAddress();
            default -> System.out.println("Something went wrong.. Try again");
        }
    }

    public void showCustomerNames() {
        mapper.showCustomersOnID();
    }

    public void showAllCustomerData() {
        mapper.showCustomerData();
    }

    public void deleteCustomer() {
        mapper.deleteCustomer();
    }

    public void addBook() {
        mapper.addBookData();
    }

    public void updateBooks() {
        mapper.updateBookName();
        mapper.updateBookAuthor();
        mapper.updateBookReleaseYear();
        mapper.updateBookVersion();
    }

    public void deleteBook() {
        mapper.deleteBookData();
    }

    public void showBooks() {
        mapper.showAllBooks();
    }

    public void closeConnectionDB() {
        mapper.closeConnection();
    }


}
