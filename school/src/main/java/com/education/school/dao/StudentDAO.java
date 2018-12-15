package com.education.school.dao;

import com.education.school.entity.Marks;
import com.education.school.entity.Student;

public interface StudentDAO {

    void persistStudent(Student student, String txnID) throws Exception;
    Student findStudentByID(String studentID, String txnID);
    Marks getStudentMarkDetailsByID(String studentID, String txnID);
}
