package org.lucifer.theemployeeswebservice.controller;

import org.lucifer.theemployeeswebservice.entity.Employee;
import org.lucifer.theemployeeswebservice.error.EmployeeErrorResponse;
import org.lucifer.theemployeeswebservice.error.EmployeeException;
import org.lucifer.theemployeeswebservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        return employeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void delete(@PathVariable int employeeId){
        employeeService.delete(employeeId);
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }


    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleExceptions(EmployeeException e){
        EmployeeErrorResponse response = new EmployeeErrorResponse();
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(e.getMessage());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
