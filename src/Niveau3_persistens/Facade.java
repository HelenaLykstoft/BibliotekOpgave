package Niveau3_persistens;

public class Facade {

    Mapper mapper = new Mapper();
    public void createCustomer(){
        mapper.createCustomer();
    }

    public void updateCustomer(){
        mapper.updateCustomer();
    }

    public void showCustomers(){
        mapper.showCustomers();
    }

}
