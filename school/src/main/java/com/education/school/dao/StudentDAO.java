package com.education.school.dao;

import com.education.school.entity.Marks;
import com.education.school.entity.Student;
import com.education.school.exception.StudentNotFoundException;

public interface StudentDAO {

    void persistStudent(Student student, String txnID) throws Exception;
    Student findStudentByID(String studentID, String txnID) throws StudentNotFoundException;
    Marks getStudentMarkDetailsByID(String studentID, String txnID);
}
