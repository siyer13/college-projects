package com.education.school.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Entity
@Table(name="mark")
public class Marks {

    @Id
    @Column(name="student_id")
    private String student_id;
    @Column(name="subject")
    private String subject;
    @Column(name="type")
    private String type;
    @Column(name="marks")
    private int marks;
    @Column(name="grade")
    private char grade;
    @Column(name="course_semester")
    private String courseSemester;
    @Column(name="course_year")
    private String courseYear;
    @Column(name="pass_month")
    private String passMonth;
    @Column(name="pass_year")
    private String passYear;


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public String getCourseSemester() {
        return courseSemester;
    }

    public void setCourseSemester(String courseSemester) {
        this.courseSemester = courseSemester;
    }

    public String getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(String courseYear) {
        this.courseYear = courseYear;
    }

    public String getPassMonth() {
        return passMonth;
    }

    public void setPassMonth(String passMonth) {
        this.passMonth = passMonth;
    }

    public String getPassYear() {
        return passYear;
    }

    public void setPassYear(String passYear) {
        this.passYear = passYear;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    @Override
    public String toString() {
        return "Marks{" +
                "student_id='" + student_id + '\'' +
                ", subject='" + subject + '\'' +
                ", type='" + type + '\'' +
                ", marks=" + marks +
                ", grade=" + grade +
                ", courseSemester='" + courseSemester + '\'' +
                ", courseYear='" + courseYear + '\'' +
                ", passMonth='" + passMonth + '\'' +
                ", passYear='" + passYear + '\'' +
                '}';
    }
}
