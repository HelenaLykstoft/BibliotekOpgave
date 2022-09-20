import Niveau2_logik.TerminalInput;
import Niveau3_persistens.Facade;

public class Main {

    private static Facade facade = new Facade();
    private static String bullet = "\u2022";
    public static void main(String[] args) {
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
                    facade.showCustomers();
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
                    facade.showCustomers();
                    break;
                default:
                    System.out.println("Something went wrong.. Try again");
            }
        }
    }

}