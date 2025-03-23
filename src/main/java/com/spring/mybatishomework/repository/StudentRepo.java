package com.spring.mybatishomework.repository;

import com.spring.mybatishomework.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepo {
    @Select("select * from students")
    @Results(id = "studentMapping", value = {
            @Result(property = "studentId",column = "student_id"),
            @Result(property = "studentName",column = "student_name"),
            @Result(property = "studentEmail",column = "email"),
            @Result(property = "phoneNumber",column = "phone_number")
    })
    //the courses data is depended on student_id in student_courses table
    @Result(property = "courses",column = "student_id",
            many = @Many(select = "com.spring.mybatishomework.repository.CourseRepo.allCoursesByStudentId"))
    List<Student> findAllStudents();

    @Select("""
    select * from students
    where student_id = #{id};
    """)
    @ResultMap("studentMapping")
    Student findStudentById(Integer id);


}
//    Student addNewStudent();
