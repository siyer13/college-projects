package com.education.school.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Component
@Entity
@Table(name="student")
public class Student {

    @Id
    @Column(name="student_id")
    private String studentID;
    @NotNull
    @Column(name="first_name")
    private String firstName;
    @Column(name="middle_name")
    private String middleName;
    @NotNull
    @Column(name="last_name")
    private String lastName;
    @NotNull
    @Column(name="college")
    private String college;
    @NotNull
    @Column(name="department")
    private String  department;
    @NotNull
    @Column(name="course")
    private String course;
    @Column(name="course_year")
    private String courseYear;
    @Column(name="course_semester")
    private String courseSemester;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(String courseYear) {
        this.courseYear = courseYear;
    }

    public String getCourseSemester() {
        return courseSemester;
    }

    public void setCourseSemester(String courseSemester) {
        this.courseSemester = courseSemester;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", college='" + college + '\'' +
                ", department='" + department + '\'' +
                ", course='" + course + '\'' +
                ", courseYear='" + courseYear + '\'' +
                ", courseSemester='" + courseSemester + '\'' +
                '}';
    }
}
