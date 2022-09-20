package Niveau3_persistens;

import Niveau2_logik.TerminalInput;

public class Facade {

    Mapper mapper = new Mapper();

    public void addCustomer() {
        mapper.addCustomer();
    }

    public void updateCustomer() {
        mapper.updateCustomer();
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

    public void bookRental(){
        mapper.bookRental();
    }

    public void showBooksRentedView(){
        mapper.showBooksRentedView();
    }

    public void closeConnectionDB() {
        mapper.closeConnection();
    }


}
