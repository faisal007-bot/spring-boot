package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<List<Employee>> saveEmployees(@RequestBody List<Employee> employees) {
        List<Employee> employees1 = employeeService.saveEmployees(employees);
        return new ResponseEntity<>(employees1, HttpStatus.OK);
    }

    @PutMapping("/employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatus.OK);
    }

    @PutMapping("/employees")
    public ResponseEntity<List<Employee>> updateEmployees(@RequestBody List<Employee> employees) {
        List<Employee> employees1 = employeeService.updateEmployees(employees);
        return new ResponseEntity<>(employees1, HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id) {
        employeeService.deletemployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("employees")
    public ResponseEntity<?> deleteEmployees(@RequestParam("ids") List<Integer> ids) {
        employeeService.deleteEmployees(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
        Employee employee = employeeService.getEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam("ids") List<Integer> ids) {
        List<Employee> employees = employeeService.getEmployees(ids);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employees/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }

    @GetMapping("/employee/sort/{field}")
    public ResponseEntity<List<Employee>> getSortedEmployees(@PathVariable("field") String field) {
        List<Employee> employeesInSortingOrder = employeeService.getEmployeesInSortingOrder(field);
        return new ResponseEntity<>(employeesInSortingOrder, HttpStatus.OK);
    }

    @GetMapping("/employee/paginated/{offset}/{size}")
    public ResponseEntity<Page<Employee>> getPaginatedEmployees(@PathVariable("offset") int offset,
                                                                @PathVariable("size") int size) {
        Page<Employee> employeesInPaginatedFormat =
                employeeService.getEmployeesInPaginatedFormat(offset, size);
        return new ResponseEntity<>(employeesInPaginatedFormat, HttpStatus.OK);
    }

    @GetMapping("/employee/paginatedSorted/{offset}/{size}/{field}")
    public ResponseEntity<Page<Employee>> getPaginatedSortedEmployees
            (@PathVariable("offset") int offset,
             @PathVariable("size") int size,
             @PathVariable("field") String field) {
        Page<Employee> employeesInSortedPaginatedFormat =
                employeeService.getEmployeesInSortedPaginatedFormat(offset, size, field);
        return new ResponseEntity<>(employeesInSortedPaginatedFormat, HttpStatus.OK);
    }
}
