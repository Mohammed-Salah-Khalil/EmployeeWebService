package org.lucifer.theemployeeswebservice.service;

import org.lucifer.theemployeeswebservice.entity.Employee;
import org.lucifer.theemployeeswebservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.get();
    }

    @Override
    @Transactional
    public Employee save(Employee e) {
        return employeeRepository.save(e);
    }
    @Override
    @Transactional
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Override
    @Transactional
    public void delete(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee employee = optionalEmployee.get();
        employeeRepository.delete(employee);
    }




}
