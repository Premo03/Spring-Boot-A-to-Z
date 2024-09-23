package com.premjeet.curddemo.dao;

import com.premjeet.curddemo.entity.Instructor;
import com.premjeet.curddemo.entity.InstructorDetail;


public interface AppDAO {

    void save(Instructor theInstructor);
    
    Instructor findInstructorById(int theId);
    
    void deleteInstructorById(int theId);
    
    InstructorDetail findInstructorDetailById(int theId);

}