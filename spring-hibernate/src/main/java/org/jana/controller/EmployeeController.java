package org.jana.controller;

import org.jana.model.Employee;
import org.jana.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/find-all")
    public List<Employee> getAllEmployees() {
        System.out.println("contorller employeeService = " + employeeService);
        return employeeService.getAllEmployees();
    }

}
