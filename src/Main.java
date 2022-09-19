import Niveau2_logik.TerminalInput;
import Niveau3_persistens.DatabaseConnection;
import Niveau3_persistens.Facade;

public class Main {
    public static void main(String[] args) {
 /*       DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.createConnection();*/

        Facade facade = new Facade();

        int input;
        String s = "What do you wish to do?";

        while (true) {
            input = TerminalInput.getInt(s);
            switch (input) {
                case 1:
                    facade.createCustomer();
                    break;
                case 2:
                    facade.updateCustomer();
                    break;
                case 3:
                    facade.showCustomers();
                    break;
                default:
                    System.out.println("Something went wrong.. Try again");
            }
        }
    }


    }
}