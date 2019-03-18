package shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import shopping.model.Customer;
import shopping.bean.LoginForm;
import shopping.service.CustomerService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/login")
    public String getLogin() {
        List<Customer> customers = customerService.getCustomers();
        System.out.println("customers = " + customers);
        return "customer-login";
    }

    @PostMapping("/login")
    public String login(LoginForm loginForm, Map<String, Object> map) {
        Customer customer = customerService.login(loginForm);
        map.put("username", customer.getUsername());
        return "dashboard";
    }

}
