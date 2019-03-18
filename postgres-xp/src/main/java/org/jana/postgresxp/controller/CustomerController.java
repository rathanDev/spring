package org.jana.postgresxp.controller;

import org.jana.postgresxp.model.Customer;
import org.jana.postgresxp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/get-customers")
    public List<Customer> getCustomers() {
        return customerService.getAll();
    }

}
