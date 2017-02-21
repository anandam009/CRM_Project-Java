package crm.dao;

import crm.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();
    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);
}
