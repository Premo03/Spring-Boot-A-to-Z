package com.premjeet.curddemo.dao;

import com.premjeet.curddemo.entity.Instructor;


public interface AppDAO {

    void save(Instructor theInstructor);
    
    Instructor findINInstructorById(int theId);

}