package com.employee.service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        Employee employee1 = employeeRepository.saveAndFlush(employee);
        return employee1;
    }

    public List<Employee> saveEmployees(List<Employee> employees) {
        List<Employee> employees1 = employeeRepository.saveAllAndFlush(employees);
        return employees1;
    }

    public Employee updateEmployee(Employee employee) {
        Employee employee1 = employeeRepository.saveAndFlush(employee);
        return employee1;
    }

    public List<Employee> updateEmployees(List<Employee> employees) {
        List<Employee> employees1 = employeeRepository.saveAllAndFlush(employees);
        return employees1;
    }

    public void deletemployee(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public void deleteEmployees(List<Integer> ids) {
        employeeRepository.deleteAllByIdInBatch(ids);
    }

    public Employee getEmployee(int employeeId) {
        Optional<Employee> byId = employeeRepository.findById(employeeId);
        Employee employee = byId.get();
        return employee;
    }

    public List<Employee> getEmployees(List<Integer> ids) {
        List<Employee> employees = employeeRepository.findAllById(ids);
        return employees;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public List<Employee> getEmployeesInSortingOrder(String field) {
        List<Employee> employees = employeeRepository.findAll(Sort.by(Sort.Direction.DESC, field));
        return employees;
    }

    public Page<Employee> getEmployeesInPaginatedFormat(int offset, int size) {
        Page<Employee> employees = employeeRepository.findAll(PageRequest.of(offset, size));
        return employees;
    }

    public Page<Employee> getEmployeesInSortedPaginatedFormat(int offset, int size, String field) {
        Page<Employee> employees =
                employeeRepository.
                        findAll(PageRequest.of(offset, size, Sort.by(Sort.Direction.ASC, field)));
        return employees;
    }
}
