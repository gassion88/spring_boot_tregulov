package com.gassion.spring_boot_tregulov.dao;

import com.gassion.spring_boot_tregulov.entity.Employee;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{


    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployee() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("From Employee", Employee.class).getResultList();
    }

    @Override
    public Employee getEmployeeByID(int employeeID) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Employee.class, employeeID);
    }

    @Override
    public void saveOrUpdateEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    public void deleteEmployeeID(int employeeID) {
        Session session = entityManager.unwrap(Session.class);
        session.createQuery("delete from Employee where id=:employeeID").setParameter("employeeID", employeeID).executeUpdate();
    }
}
