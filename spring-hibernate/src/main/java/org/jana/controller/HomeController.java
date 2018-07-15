package org.jana.controller;

import org.jana.model.Employee;
import org.jana.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public String index() {
        return "Greeting from spring boot hibernate";
    }

    @RequestMapping("/query")
    public List<Employee> query() {
        System.out.println("employeeRepository = " + employeeRepository);
        return employeeRepository.findAll();
    }

}
