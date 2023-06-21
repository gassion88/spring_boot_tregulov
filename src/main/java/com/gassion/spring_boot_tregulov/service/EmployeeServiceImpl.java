package com.gassion.spring_boot_tregulov.service;

import com.gassion.spring_boot_tregulov.dao.EmployeeDAO;
import com.gassion.spring_boot_tregulov.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployee();
    }

    @Override
    public Employee getEmployeeById(int employeeID) {
        return employeeDAO.getEmployeeByID(employeeID);
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveOrUpdateEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int employeeID) {
        employeeDAO.deleteEmployeeID(employeeID);
    }
}
