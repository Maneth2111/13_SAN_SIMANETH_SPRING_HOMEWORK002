package com.spring.mybatishomework.repository;

import com.spring.mybatishomework.model.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepo {

    @Select("""
    SELECT * FROM courses
    """)
    @Results({
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "description", column = "description"),
            @Result(property = "instructor", column = "instructor_id",
                    one = @One(select = "com.spring.mybatishomework.repository.InstructorRepo.findInstructorById"))
    })
    List<Course> allCourses();

    @Select("""
    SELECT * FROM courses a 
    INNER JOIN student_course n ON a.course_id = n.course_id 
    WHERE n.student_id = #{studentId}
    """)
    @Results({
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "description", column = "description"),
            @Result(property = "instructor", column = "instructor_id",
                    one = @One(select = "com.spring.mybatishomework.repository.InstructorRepo.findInstructorById"))
    })
    List<Course> allCoursesByStudentId(int studentId);


    Course findCourseById(Integer id);

    @Insert("INSERT INTO courses(course_name, description, instructor_id) VALUES (#{courseName}, #{description}, #{instructorId}) RETURNING course_id")
    Integer createCourse(Course course);

    @Update("UPDATE courses SET course_name = #{courseName}, description = #{description}, instructor_id = #{instructorId} WHERE course_id = #{courseId}")
    void updateCourse(Course course);

    @Delete("DELETE FROM courses WHERE course_id = #{id}")
    void deleteCourse(Integer id);


}
