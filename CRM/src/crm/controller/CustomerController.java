package crm.controller;


import crm.entity.Customer;
import crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/customer")
public class CustomerController {

//    // need to inject the customer dao
//    @Autowired
//    private CustomerDAO customerDAO;

    // need to inject the customer service
    @Autowired
    private CustomerService customerService;

    @GetMapping ("/list")    // changed to new GetMapping annotation
    public String listCustomers(Model theModel) {

        // get customers from the service
        List<Customer> theCustomers = customerService.getCustomers();

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }
}
