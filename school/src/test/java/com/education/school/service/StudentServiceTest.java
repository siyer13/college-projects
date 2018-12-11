package com.education.school.service;

import com.education.school.dao.StudentDAO;
import com.education.school.entity.Student;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.when;


@RunWith(JUnitParamsRunner.class)
public class StudentServiceTest {

    @Spy
    private Student student;
    @Mock
    private StudentDAO studentDao;
    @InjectMocks
    private StudentService studentService;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Parameters({"Sridhar,R,Iyer,SSUD,Computers,Masters,FY,FY"})
    public void registerStudentTest(String firstName, String middleName, String lastName, String college,String department, String course, String courseYear, String courseSemester) {
        student = studentService.registerStudent(firstName,middleName,lastName,college,department,course,courseYear,courseSemester);
        System.out.println(student.getStudentID());
        assertThat(student.getStudentID(),containsString("-"));
    }
}
