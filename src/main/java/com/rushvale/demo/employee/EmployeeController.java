package com.rushvale.demo.employee;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	private EmployeeRepository employeeRepository;
    
    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @PostMapping("/employees")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
    }
    
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }
}
