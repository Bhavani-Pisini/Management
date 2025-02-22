package com.employee.Management.controller;

import com.employee.Management.model.Employee;
import com.employee.Management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee result=employeeService.saveEmployee(employee);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> result=employeeService.getAllEmployees();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee > getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedEmployee= employeeService.updateEmployee(id,employee);
        return ResponseEntity.ok(updatedEmployee);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("employee deleted successfully");
    }
    @GetMapping("/search")
    public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam String name) {
        List<Employee> employees = employeeService.getEmployeesByName(name);
        if (employees.isEmpty()) {
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok(employees);
    }
}
