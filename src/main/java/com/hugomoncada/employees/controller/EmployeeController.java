package com.hugomoncada.employees.controller;

import javax.validation.Valid;

import com.hugomoncada.employees.entity.Employee;
import com.hugomoncada.employees.response.*;
import com.hugomoncada.employees.service.implementation.EmployeeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    
    @Autowired
    EmployeeServiceImpl employeeService; 

    @PostMapping
    public ResponseEntity<SuccessResponse> saveEmployee(@Valid @RequestBody Employee employee){
        SuccessResponse response = new SingleDataSuccessResponse<Employee>("Success", employeeService.save(employee));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<SuccessResponse> getAllEmployees(){
        SuccessResponse response = new MultipleDataSuccessResponse<Employee>("Success", employeeService.getAllEmployees().size(), employeeService.getAllEmployees());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{employeeId}")
    public ResponseEntity<SuccessResponse> getOneEmployees(@PathVariable("employeeId") Long employeeId){
        SuccessResponse response = new SingleDataSuccessResponse<Employee>("Success", employeeService.getOneEmployee(employeeId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("{employeeId}")
    public ResponseEntity<SuccessResponse> deleteEmployee(@PathVariable("employeeId") Long employeeId){
        employeeService.delete(employeeId);
        SuccessResponse response = new SingleDataSuccessResponse<Employee>("Success", null);
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

    @PutMapping("{employeeId}")
    public ResponseEntity<SuccessResponse> updateEmployee(@PathVariable("employeeId") Long employeeId, @Valid @RequestBody Employee employee){
        SuccessResponse response = new SingleDataSuccessResponse<Employee>("Success", employeeService.update(employeeId, employee));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
