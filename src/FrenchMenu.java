import Niveau2_logik.TerminalInput;
import Niveau3_persistens.Facade;

public class FrenchMenu implements LanguageController {
    private static Facade facade = new Facade();
    private static String bullet = "\u2022";

    @Override
    public void allMenus() {
        int input;
        String s = "\nBibliothèque du menu principal" +
                "\nDans quel menu voulez-vous aller ?" +
                "\n" + bullet + " 1 = Clients" +
                "\n" + bullet + " 2 = Livres" +
                "\n" + bullet + " 3 = Louer un Livres\n";

        while (true) {
            input = TerminalInput.getInt(s);
            switch (input) {
                case 1 -> customerMenu();
                case 2 -> booksMenu();
                case 3 -> bookRentalMenu();
                default -> System.out.println("Excuse-moi il'sappelle une croissant oui oui");
            }
            facade.closeConnectionDB();
        }
    }

    @Override
    public void customerMenu() {
        int input;
        String s = "\nMenu pour un client: " +
                "\n" + bullet + " 1 = Ajouter un client" +
                "\n" + bullet + " 2 = J'aime manger des saucisses au petit déjeuner" +      //The French menu shown to the customer
                "\n" + bullet + " 3 = Éloigne-toi de ma vue" +
                "\n" + bullet + " 4 = Je pense que les girafes devraient être considérées comme des oiseaux" +
                "\n" + bullet + " 5 = Montrez-moi le contenu de votre peuple de gressins\n";


        while (true) {
            input = TerminalInput.getInt(s);
            switch (input) {
                case 1 -> facade.addCustomer();
                case 2 -> facade.updateCustomer();
                case 3 -> facade.deleteCustomer();
                case 4 -> facade.showCustomerNames();
                case 5 -> facade.showAllCustomerData();
                default -> System.out.println("Tu as merdé, espèce d'œuf. réessayer");
            }
            allMenus();
        }
    }

    @Override
    public void booksMenu() {
        int input;
        String s = "\nCarte des livres: " +
                "\n" + bullet + " 1 = ajouter un nouveau démon à votre armée" +
                "\n" + bullet + " 2 = Mettez à jour le contenu de votre palais mental" +
                "\n" + bullet + " 3 = J'apprécie le jus de haricots noirs rôtis le matin" +
                "\n" + bullet + " 4 = Tout montrer!\n";

        while (true) {
            input = TerminalInput.getInt(s);
            switch (input) {
                case 1 -> facade.addBook();
                case 2 -> facade.updateBooks();
                case 3 -> facade.deleteBook();
                case 4 -> facade.showBooks();
                default -> System.out.println("Réessayez .. espèce de crétin");
            }
            allMenus();
        }
    }

    @Override
    public void bookRentalMenu() {
        int input;
        String s = "\nRéserver le menu de la location: " +
                "\n" + bullet + " 1 = Louer une vache au pâturage" +
                "\n" + bullet + " 2 = Afficher toutes les vaches\n";

//                + //TODO: EVT, LAV EN RETUNÉR BOOK/ DELETE BOOK
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
                default -> System.out.println("Réessaye mon dieu");


            }
            allMenus();
        }

    }
}
