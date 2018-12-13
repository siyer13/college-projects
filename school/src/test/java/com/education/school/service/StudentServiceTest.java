package com.education.school.service;

import com.education.school.dao.StudentDAO;
import com.education.school.entity.Student;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
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
    @Parameters({"Sridhar,R,Iyer,SSUD,Computers,Masters"})
    public void registerStudentTest(String firstName, String middleName, String lastName, String college,String department, String course) {
        student = studentService.registerStudent(firstName,middleName,lastName,college,department,course);
        System.out.println(student.getStudentID());
        assertThat(student.getStudentID(),containsString("-"));
    }

    @Test
    @Parameters({"046-26-0100"})
    public void getStudentDetailsByIDTest(String studentId) {
        when(studentDao.findStudentByID(studentId,null)).thenReturn(newStudent());
        student = studentService.getStudentDetailsByID(studentId);
        System.out.println(student.getFirstName());
        assertEquals(student.getFirstName(),"some good student");
    }

    private Student newStudent() {
        Student student = new Student();
        student.setFirstName("some good student");
        return student;
    }
}
