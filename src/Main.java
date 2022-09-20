import Niveau2_logik.TerminalInput;
import Niveau3_persistens.Facade;

public class Main {

    private static Facade facade = new Facade();
    private static String bullet = "\u2022";

    public static void main(String[] args) {
        allMenus();
    }

    public static void allMenus() {
        customerMenu();
        booksMenu();
    }

    private static void booksMenu() {
        int input;
        String s = "\nBooks Menu: " +
                "\n" + bullet + " 1 = add" +
                "\n" + bullet + " 2 = update a customer" +
                "\n" + bullet + " 3 = delete a customer" +
                "\n" + bullet + " 4 = show all customers\n";

        while (true) {
            input = TerminalInput.getInt(s);
            switch (input) {
                case 1:
                    facade.addCustomer();
                    break;
                case 2:
                    facade.updateCustomer();
                    break;
                case 3:
                    facade.deleteCustomer();
                    break;
                case 4:
                    facade.showCustomerNames();
                    break;
                default:
                    System.out.println("Something went wrong.. Try again");
            }
        }
    }

    public static void customerMenu() {
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
        }
    }
}
