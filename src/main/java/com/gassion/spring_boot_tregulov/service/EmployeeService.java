package com.gassion.spring_boot_tregulov.service;

import com.gassion.spring_boot_tregulov.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    Employee getEmployeeByID(int employeeID);
    void saveEmployee(Employee employee);
    void deleteEmployeeByID(int employeeID);
}
