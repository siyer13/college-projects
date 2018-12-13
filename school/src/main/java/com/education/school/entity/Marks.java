package com.education.school.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Component
@Entity
@Table(name="marks")
public class Marks {

    private String subject;
    private String type;
    private int marks;
    private char grade;
    @Column(name="course_year")
    private String course_semester;
    @Column(name="course_semester")
    private String course_year;
    private String pass_month;
    private String pass_year;


}
