package com.gassion.spring_boot_tregulov.dao;

import com.gassion.spring_boot_tregulov.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployee();

    Employee getEmployeeByID(int employeeID);

    void saveOrUpdateEmployee(Employee employee);

    void deleteEmployeeID(int employeeID);
}
