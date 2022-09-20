package Niveau3_persistens;

public class Facade {

    Mapper mapper = new Mapper();
    public void addCustomer() {
        mapper.addCustomer();
    }

    public void updateCustomer() {
        mapper.updateCustomer();
    }

    public void showCustomers() {
        mapper.showCustomers();
    }

    public void deleteCustomer() {
        mapper.deleteCustomer();
    }




}
