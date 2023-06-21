package com.gassion.spring_boot_tregulov.dao;

import com.gassion.spring_boot_tregulov.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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
//        Session session = entityManager.unwrap(Session.class);
//        return session.createQuery("From Employee", Employee.class).getResultList();

        Query query = entityManager.createQuery("from Employee ");
        return (List<Employee>) query.getResultList();
    }

    @Override
    public Employee getEmployeeByID(int employeeID) {
//        Session session = entityManager.unwrap(Session.class);
//        return session.get(Employee.class, employeeID);

        return entityManager.find(Employee.class, employeeID);
    }

    @Override
    public void saveOrUpdateEmployee(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);

        entityManager.merge(employee);
    }

    @Override
    public void deleteEmployeeID(int employeeID) {
//        Session session = entityManager.unwrap(Session.class);
//        session.createQuery("delete from Employee where id=:employeeID").setParameter("employeeID", employeeID).executeUpdate();

        entityManager.createQuery("delete from Employee where id=:employeeID").setParameter("employeeID", employeeID).executeUpdate();
    }
}
