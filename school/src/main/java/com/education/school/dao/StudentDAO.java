package com.education.school.dao;

import com.education.school.entity.Student;

public interface StudentDAO {

    void persistStudent(Student student);
    Student findStudentByID(String studentID);
}
