import Niveau2_logik.TerminalInput;
import Niveau3_persistens.Facade;

public class Main {

    private static Facade facade = new Facade();
    private static String bullet = "\u2022";

    public static void main(String[] args) {
        allMenus();
    }

    public static void allMenus() {
        int input;
        String s = "\nMain Menu - Library" +
                "\nWhich menu do you want to go to?" +
                "\n" + bullet + " 1 = Customers" +
                "\n" + bullet + " 2 = Books" +
                "\n" + bullet + " 3 = Book Rentals\n";

        while (true) {
            input = TerminalInput.getInt(s);
            switch (input) {
                case 1 -> customerMenu();
                case 2 -> booksMenu();
                case 3 -> bookRentalMenu();
                default -> System.out.println("Something went wrong.. Try again");
            }
            facade.closeConnectionDB();
        }
    }

    private static void customerMenu() {
        int input;
        String s = "\nCustomer Menu: " +
                "\n" + bullet + " 1 = add a customer" +
                "\n" + bullet + " 2 = update a customer" +
                "\n" + bullet + " 3 = delete a customer" +
                "\n" + bullet + " 4 = show all customer names" +
                "\n" + bullet + " 5 = show all customer data\n";


        while (true) {
            input = TerminalInput.getInt(s);
            switch (input) {
                case 1 -> facade.addCustomer();
                case 2 -> facade.updateCustomer();
                case 3 -> facade.deleteCustomer();
                case 4 -> facade.showCustomerNames();
                case 5 -> facade.showAllCustomerData();
                default -> System.out.println("Something went wrong.. Try again");
            }
            allMenus();
        }
    }

    private static void booksMenu() {
        int input;
        String s = "\nBooks Menu: " +
                "\n" + bullet + " 1 = add new book" +
                "\n" + bullet + " 2 = update book data" +
                "\n" + bullet + " 3 = delete a book" +
                "\n" + bullet + " 4 = show all books\n";

        while (true) {
            input = TerminalInput.getInt(s);
            switch (input) {
                case 1 -> facade.addBook();
                case 2 -> facade.updateBooks();
                case 3 -> facade.deleteBook();
                case 4 -> facade.showBooks();
                default -> System.out.println("Something went wrong.. Try again");
            }
            allMenus();
        }
    }

    private static void bookRentalMenu() {
        int input;
        String s = "\nBook Rental Menu: " +
                "\n" + bullet + " 1 = Rent out a book" +
                "\n" + bullet + " 2 = Show all rented books\n";

//                + //TODO: EVT, LAV EN RETUNÉR BOOK/ DELETE BOOK
//                "\n" + bullet + " 3 = return a book" +
//                "\n" + bullet + " 4 = ";
//
        input = TerminalInput.getInt(s);
        while(true){
            switch (input){
                case 1 -> facade.bookRental();
                case 2 -> facade.showBooksRentedView();
//                case 3 -> facade.returnBook();            //TODO: EVT EKSTRA ARBEJDE
//                case 4 -> facade.deleteBookRental();
                default -> System.out.println("Something went wrong.. Try again");


            }
            allMenus();
        }

    }
}
