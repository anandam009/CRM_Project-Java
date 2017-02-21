package crm.controller;


import crm.entity.Customer;
import crm.service.CustomerService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    private Logger logger = Logger.getLogger(getClass());

    @GetMapping ("/list")    // changed to new GetMapping annotation
    public String listCustomers(Model theModel) {

        // get customers from the service
        List<Customer> theCustomers = customerService.getCustomers();

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
       // create model attribute to bind form data
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){

        //save the customer using the service
        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel){

        logger.info("showing form for update");

        // get customer from db
        Customer theCustomer = customerService.getCustomer(theId);
        // set customer as a model attribute to pre-populate the form
        theModel.addAttribute("customer", theCustomer);
        // send over to our form
        return "customer-form";
    }
}
