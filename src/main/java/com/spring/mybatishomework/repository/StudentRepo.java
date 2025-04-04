package com.spring.mybatishomework.repository;

import com.spring.mybatishomework.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepo {
    @Select("""
    SELECT * FROM students
    OFFSET #{size} * (#{page} - 1)
    LIMIT #{size}
    """)
    @Results(id = "studentMapping", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "studentEmail", column = "email"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "courses", column = "student_id",
                    many = @Many(select = "com.spring.mybatishomework.repository.CourseRepo.allCoursesByStudentId"))
    })
    List<Student> findAllStudents(Integer page, Integer size);

    @Select("""
    SELECT * FROM students
    WHERE student_id = #{id};
    """)
    @ResultMap("studentMapping")
    Student findStudentById(Integer id);

    @Insert("""
    INSERT INTO students (student_name, email, phone_number)
    VALUES (#{studentName}, #{studentEmail}, #{phoneNumber})
    RETURNING student_id
    """)
    Integer createStudent(Student student);

    @Update("""
    UPDATE students
    SET student_name = #{studentName}, email = #{studentEmail}, phone_number = #{phoneNumber}
    WHERE student_id = #{studentId}
    """)
    void updateStudent(Student student);

    @Delete("DELETE FROM students WHERE student_id = #{id}")
    void deleteStudent(Integer id);
}
