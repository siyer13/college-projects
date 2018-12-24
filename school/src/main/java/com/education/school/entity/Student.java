package com.education.school.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Component
@Entity
@Table(name="student")
public class Student {

    @Id
    @Column(name="student_id")
    private String studentId;
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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", college='" + college + '\'' +
                ", department='" + department + '\'' +
                ", course='" + course + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getStudentId(), student.getStudentId()) &&
                Objects.equals(getFirstName(), student.getFirstName()) &&
                Objects.equals(getMiddleName(), student.getMiddleName()) &&
                Objects.equals(getLastName(), student.getLastName()) &&
                Objects.equals(getCollege(), student.getCollege()) &&
                Objects.equals(getDepartment(), student.getDepartment()) &&
                Objects.equals(getCourse(), student.getCourse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId());
    }
}
