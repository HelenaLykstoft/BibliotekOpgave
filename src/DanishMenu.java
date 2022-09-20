import Niveau2_logik.TerminalInput;
import Niveau3_persistens.Facade;

public class DanishMenu implements LanguageController {

    private static Facade facade = new Facade();
    private static String bullet = "\u2022";
    @Override
    public void allMenus() {
        int input;
        String s = "\nHovedMenu - Bibliotek" +
                "\nVenligst vælg en Menu ud fra de nedenstående eksempler:" +
                "\n" + bullet + " 1 = Kunder" +
                "\n" + bullet + " 2 = Bøger" +
                "\n" + bullet + " 3 = Bog Udlån\n";

        while (true) {
            input = TerminalInput.getInt(s);
            switch (input) {
                case 1 -> customerMenu();
                case 2 -> booksMenu();
                case 3 -> bookRentalMenu();
                default -> System.out.println("Fejl i input -- Venligt prøv igen..");
            }
            facade.closeConnectionDB();
        }
    }

    @Override
    public void customerMenu() {
        int input;
        String s = "\nKunde Menu: " +
                "\n" + bullet + " 1 = Tilføj Kunde" +
                "\n" + bullet + " 2 = Opdater Kundeinformation" +
                "\n" + bullet + " 3 = Slet Kunde" +
                "\n" + bullet + " 4 = Vis alle registreret Kundenavne" +
                "\n" + bullet + " 5 = Vis alt registreret KundeData\n";


        while (true) {
            input = TerminalInput.getInt(s);
            switch (input) {
                case 1 -> facade.addCustomer();
                case 2 -> facade.updateCustomer();
                case 3 -> facade.deleteCustomer();
                case 4 -> facade.showCustomerNames();
                case 5 -> facade.showAllCustomerData();
                default -> System.out.println("Fejl i input -- Venligst prøv igen..");
            }
            allMenus();
        }
    }

    @Override
    public void booksMenu() {
        int input;
        String s = "\nBog Menu: " +
                "\n" + bullet + " 1 = Tilføj ny Bog" +
                "\n" + bullet + " 2 = Opdater Bog Information" +
                "\n" + bullet + " 3 = Slet en Bog" +
                "\n" + bullet + " 4 = Vis alle bøger\n";

        while (true) {
            input = TerminalInput.getInt(s);
            switch (input) {
                case 1 -> facade.addBook();
                case 2 -> facade.updateBooks();
                case 3 -> facade.deleteBook();
                case 4 -> facade.showBooks();
                default -> System.out.println("Fejl i input -- Venligst prøv igen..");
            }
            allMenus();
        }
    }

    @Override
    public void bookRentalMenu() {
        int input;
        String s = "\nBog Udlejning: " +
                "\n" + bullet + " 1 = Lej en Bog" +
                "\n" + bullet + " 2 = Vis alle Udlejet Bøger\n";

        //+ //TODO: EVT, LAV EN RETUNÉR BOOK/ DELETE BOOK
//                "\n" + bullet + " 3 = return a book" +
//                "\n" + bullet + " 4 = ";
//
        input = TerminalInput.getInt(s);
        while (true) {
            switch (input) {
                case 1 -> facade.bookRental();
                case 2 -> facade.showBooksRentedView();
//                case 3 -> facade.returnBook();            //TODO: EVT EKSTRA ARBEJDE
//                case 4 -> facade.deleteBookRental();
                default -> System.out.println("Fejl i input -- Venligst prøv igen..");


            }
            allMenus();
        }
    }
}
