package Niveau3_persistens;

import Niveau2_logik.TerminalInput;

public class Facade {

    Mapper mapper = new Mapper();
    public void addCustomer() {
        mapper.addCustomer();
    }

    public void updateCustomer() {
        System.out.println("Update Customer Name / Address");
        String input = TerminalInput.getString("Insert 'Name' or 'Address'");;

        while (true) {
            switch (input) {
                case "Name" -> mapper.updateCustomerName();
                case "Address" -> mapper.updateCustomerAddress();
                default -> System.out.println("Something went wrong.. Try again");
            }
            break;
        }
    }

    public void showCustomerNames() {
        mapper.showCustomersOnID();
    }

    public void showAllCustomerData() {
        mapper.showCustomersOnIDAndAddress();
    }

    public void deleteCustomer() {
        mapper.deleteCustomer();
    }
}
