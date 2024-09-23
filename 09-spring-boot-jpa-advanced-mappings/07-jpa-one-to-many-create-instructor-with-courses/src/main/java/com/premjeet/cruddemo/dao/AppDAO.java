package com.premjeet.cruddemo.dao;

import com.premjeet.cruddemo.entity.Instructor;
import com.premjeet.cruddemo.entity.InstructorDetail;


public interface AppDAO {

    void save(Instructor theInstructor);
    
    Instructor findInstructorById(int theId);
    
    void deleteInstructorById(int theId);
    
    InstructorDetail findInstructorDetailById(int theId);
    
    void deleteInstructorDetailById(int theId);

}