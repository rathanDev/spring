package org.jana.postgresxp.service;

import org.jana.postgresxp.model.Customer;
import org.jana.postgresxp.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public List<Customer> getAll() {
        return customerRepo.findAll();
    }

}
