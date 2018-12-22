package com.education.school.mapper;

import com.education.school.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
}
