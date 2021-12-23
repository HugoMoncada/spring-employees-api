package com.hugomoncada.employees.service;

import java.util.List;

import com.hugomoncada.employees.entity.Employee;

public interface EmployeeService {
    
    Employee save(Employee employee); 

    void delete(Long employeeId);

    Employee update(Long employeeId, Employee employee); 

    Employee getOneEmployee(Long employeeId);

    List<Employee> getAllEmployees(); 
    
}
