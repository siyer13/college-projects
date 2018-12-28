package com.education.school.mapper;

import com.education.school.entity.FinalResult;
import com.education.school.entity.Student;
import com.education.school.exception.StudentNotFoundException;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select * from student")
    @Results(value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "middleName", column = "middle_name"),
            @Result(property = "college", column = "college"),
            @Result(property = "department", column = "department"),
            @Result(property = "course", column = "course")
    })
    List<Student> findAllStudents();

    @Select("select * from ")
    List getAllStudentResults();

    @Select("select * from student where student_id = #{studentId}")
    @Results(value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "middleName", column = "middle_name"),
            @Result(property = "college", column = "college"),
            @Result(property = "department", column = "department"),
            @Result(property = "course", column = "course")
    })
    Student findStudentById(@Param("studentId") String studentId) throws StudentNotFoundException;
}
