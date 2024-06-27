package org.lucifer.theemployeeswebservice.service;

import org.lucifer.theemployeeswebservice.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee e);
    void delete(int id);
    Employee update(Employee employee);
}
