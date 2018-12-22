package com.education.school.service;

import com.education.school.dao.StudentDAO;
import com.education.school.entity.Marks;
import com.education.school.entity.Student;
import com.education.school.mapper.StudentMapper;
import com.education.school.resource.StudentResource;
import com.education.school.util.SchoolUtilities;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@Api(value = "/student", description = "Student Service", produces = "application/json")
@RequestMapping("/student")
public class StudentService implements StudentResource {

    private final static Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private Student student;
    @Autowired
    private StudentDAO studentDao;

    private StudentMapper studentMapper;

    public StudentService(StudentMapper studentMapper) {
        System.out.println("DOEs thsi get called");
        this.studentMapper = studentMapper;
    }

    @ApiOperation(value = "register student", response = Student.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Student details", response = Student.class),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "Registration Failure")
    })

    @Override
    @RequestMapping(method = RequestMethod.POST, value = "/registerstudent", produces = "application/json")
    @ResponseBody
    public Student registerStudent(String firstName, String middleName, String lastName, String college,String department, String course) { student.setFirstName(firstName);
       String txnID = SchoolUtilities.generateTransactionID();
       student.setMiddleName(middleName);
       student.setLastName(lastName);
       student.setCollege(college);
       student.setDepartment(department);
       student.setCourse(course);
       student.setStudentId(generateStudentID());
       logger.info("Student service. " + student + " txnID: "+ txnID);
       try {
           studentDao.persistStudent(student,txnID);
       }catch(Exception e) {
           e.getMessage();
       }

       return student;
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/getStudentDetailsByID", produces = "application/json")
    @ResponseBody
    public Student getStudentDetailsByID(String studentID) {
        String txnID = SchoolUtilities.generateTransactionID();
        return studentDao.findStudentByID(studentID, txnID);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/getStudentMarkDetailsByID", produces = "application/json")
    @ResponseBody
    public Marks getStudentMarkDetailsByID(String studentID) {
        String txnID = SchoolUtilities.generateTransactionID();
        return studentDao.getStudentMarkDetailsByID(studentID, txnID);
    }

    private String generateStudentID() {
        Random random = new Random();
        int univID = random.nextInt(90) + 10;
        int collegeID = random.nextInt(90) + 10;
        int randomID = random.nextInt(9999) + 1000;
        return univID + "-" + collegeID + "-" + randomID;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findAllStudents", produces = "application/json")
    @ResponseBody
    public List<Student> findAll() {
        return studentMapper.findAllStudents();
    }
}
