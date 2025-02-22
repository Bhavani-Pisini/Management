package com.employee.Management.service;

import com.employee.Management.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee  getEmployeeById(Long id);

    void deleteEmployee(Long id);

    Employee updateEmployee(Long id, Employee employee);
    List<Employee> getEmployeesByName(String name);

}
