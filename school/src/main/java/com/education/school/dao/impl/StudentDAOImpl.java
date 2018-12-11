package com.education.school.dao.impl;

import com.education.school.dao.StudentDAO;
import com.education.school.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Override
    public void persistStudent(Student student) {
        // DB code goes here
        System.out.println("Student saved to DB");
    }
}
