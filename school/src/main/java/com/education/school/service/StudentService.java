package com.education.school.service;

import com.education.school.entity.Student;
import com.education.school.resource.StudentResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@Api(value = "/student", description = "Student Service", produces = "application/json")
@RequestMapping("/student")
public class StudentService implements StudentResource {

    @Autowired
    private Student student;

    @ApiOperation(value = "register student", response = Student.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Student details", response = Student.class),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "Registration Failure")
    })

    @Override
    @RequestMapping(method = RequestMethod.POST, value = "/registerstudent", produces = "application/json")
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
