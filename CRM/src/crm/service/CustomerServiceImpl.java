package crm.service;

import crm.dao.CustomerDAO;
import crm.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    // injection of customer DAO
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional   // service layer will define the beginning and end of transaction
    public List<Customer> getCustomers(){
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerDAO.saveCustomer(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {

        return customerDAO.getCustomer(theId);
    }
}
