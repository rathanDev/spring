package shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopping.bean.LoginForm;
import shopping.model.Customer;
import shopping.repo.CustomerRepo;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public List<Customer> getCustomers() {
        return customerRepo.findAll();
    }

    public Customer login(LoginForm loginForm) {
        Customer customer = customerRepo.getCustomerByUsername(loginForm.getUsername());
        if(customer == null) {
            throw new RuntimeException("Customer not found");
        }
        if(!customer.getPassword().equals(loginForm.getPassword())) {
            throw new RuntimeException("Incorrect username or password");
        }
        return customer;
    }

}
