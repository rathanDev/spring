package org.jana.service;

import org.jana.model.Employee;
import org.jana.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        System.out.println("service employeeRepository = " + employeeRepository);
        return employeeRepository.findAll();
    }

}
