package com.gassion.spring_boot_tregulov.service;

import com.gassion.spring_boot_tregulov.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int employeeID);
    void saveEmployee(Employee employee);
    void deleteEmployeeById(int employeeID);
}
