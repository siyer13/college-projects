package com.education.school.resource;

import com.education.school.entity.Student;

public interface StudentResource {

    Student registerStudent(String firstName, String middleName, String lastName, String college,String department, String course, String courseYear, String courseSemester);
}
