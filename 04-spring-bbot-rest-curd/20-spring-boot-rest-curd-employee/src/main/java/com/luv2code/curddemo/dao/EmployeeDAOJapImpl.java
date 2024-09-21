package com.luv2code.curddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.curddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class EmployeeDAOJapImpl implements EmployeeDAO {
	
	// define field for entity manager
	
	private EntityManager entityManager;
	
	
	// set up constructor injection
	
	@Autowired
	public EmployeeDAOJapImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		// create a query
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
		
		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		// return the results
		
		return employees;
	}

	
	// find by id
	
	@Override
	public Employee findById(int theId) {

		// get employee
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		
		// return employee
		return theEmployee;
	}

	
	// save
	
	@Override
	public Employee save(Employee theEmployee) {
		
		// save employee 
		Employee dbEmployee = entityManager.merge(theEmployee);

		// return the dbEmployye
		return dbEmployee;
	}
	
	
	// delete by id

	@Override
	public void deleteById(int theId) {
		
		// delete/find employee by id

		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		// remove employee
		entityManager.remove(theEmployee);
		
	}

}
