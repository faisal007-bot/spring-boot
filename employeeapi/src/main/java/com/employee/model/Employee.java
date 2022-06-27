package com.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    @Id
    @Column(name = "employee", length = 10,
            insertable = true, nullable = false)
    private Integer employeeId;
    @Column(name = "employee_name", length = 20, updatable = true)
    private String employeeName;
    @Column(name = "employee_city", length = 30, updatable = true)
    private String employeeCity;

    public Employee() {
    }

    public Employee(Integer employeeId, String employeeName, String employeeCity) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeCity = employeeCity;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeCity() {
        return employeeCity;
    }

    public void setEmployeeCity(String employeeCity) {
        this.employeeCity = employeeCity;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "studentId=" + employeeId +
                ", studentName='" + employeeName + '\'' +
                ", studentCity='" + employeeCity + '\'' +
                '}';
    }
}
