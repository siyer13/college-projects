package com.education.school.service;

import com.education.school.entity.Student;
import com.education.school.resource.StudentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class StudentService implements StudentResource {

    @Autowired
    private Student student;

    @Override
    @RequestMapping(method = RequestMethod.POST, value = "/register/student")
    @ResponseBody
    public Student registerStudent(String firstName, String middleName, String lastName, String college,String department, String course) {
       student.setFirstName(firstName);
       student.setMiddleName(middleName);
       student.setLastName(lastName);
       student.setDepartment(department);
       student.setCourse(course);
       student.setStudentID(generateStudentID());
       return student;
    }

    private String generateStudentID() {
        Random random = new Random();
        int univID = random.nextInt(90) + 10;
        int collegeID = random.nextInt(90) + 10;
        int randomID = random.nextInt(9999) + 1000;
        return univID + "-" + collegeID + "-" + randomID;
    }
}
