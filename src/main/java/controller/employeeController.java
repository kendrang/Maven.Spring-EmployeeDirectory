package controller;

import Models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.EmployeeServices;

@RestController
public class employeeController {
    @Autowired
    EmployeeServices service;


    public employeeController(EmployeeServices employeeService) {
        this.service = employeeService;
    }

    @PostMapping("/employees/")
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        return new ResponseEntity<>(service.createEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> read(@PathVariable Long id){
        return new ResponseEntity<>(service.getEmployeeById(id), HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee employee){
        return new ResponseEntity<>(service.updateEmployee(id, employee), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Employee> delete(@PathVariable Long id){
        service.deleteEmployeeById(id);
        return new ResponseEntity<Employee>(HttpStatus.OK);
    }

}
