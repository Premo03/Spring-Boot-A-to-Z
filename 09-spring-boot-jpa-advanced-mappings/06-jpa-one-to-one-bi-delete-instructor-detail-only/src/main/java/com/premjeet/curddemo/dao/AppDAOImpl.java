package com.premjeet.curddemo.dao;


import com.premjeet.curddemo.entity.Instructor;
import com.premjeet.curddemo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    
    // Save
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    // Find Instructor By Id
	@Override
	public Instructor findInstructorById(int theId) {
		
		return entityManager.find(Instructor.class, theId);
	}
	
	
	// Delete Instructor By Id
	@Override
	@Transactional
	public void deleteInstructorById(int theId) {
		// retrieve the instructor
		Instructor tempInstructor = entityManager.find(Instructor.class, theId);
		
		// delete the instructor
		entityManager.remove(tempInstructor);		
		
		
	}

	// Find Instructor Detail By Id
	@Override
	public InstructorDetail findInstructorDetailById(int theId) {
		
		return entityManager.find(InstructorDetail.class, theId);
	}

	// delete Instructor Detail By Id
	
	@Override
	@Transactional
	public void deleteInstructorDetailById(int theId) {
		// retrieve the instructoe
		InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);
		
		// remove the associated object reference
		// break bi-directional object reference
		// 
		tempInstructorDetail.getInstructor().setInstructorDetail(null);
		
		
		// delete the instructor
		entityManager.remove(tempInstructorDetail);
		
		
	}
}
