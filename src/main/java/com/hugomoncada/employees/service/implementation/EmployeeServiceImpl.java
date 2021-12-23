package com.hugomoncada.employees.service.implementation;

import java.util.List;
import java.util.Optional;

import com.hugomoncada.employees.entity.Employee;
import com.hugomoncada.employees.exception.ResourceNotFoundException;
import com.hugomoncada.employees.repository.EmployeeRepository;
import com.hugomoncada.employees.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository; 

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Long employeeId) {
        getOneEmployee(employeeId);
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee update(Long employeeId, Employee employee) {
        Employee existingEmployee = getOneEmployee(employeeId);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }

    @Override
    public Employee getOneEmployee(Long employeeId){
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if(employee.isEmpty()){
            throw new ResourceNotFoundException("Employee with id "+ employeeId + " not found!");
        }
        return employee.get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
}
