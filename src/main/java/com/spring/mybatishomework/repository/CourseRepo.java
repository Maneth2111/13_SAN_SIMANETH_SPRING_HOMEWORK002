package com.spring.mybatishomework.repository;

import com.spring.mybatishomework.model.Course;
import com.spring.mybatishomework.model.Student;
import com.spring.mybatishomework.model.request.CourseRequest;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface CourseRepo {

    @Select("select * from courses")
    @Result(property = "courseId",column = "course_id")
    @Result(property = "courseName",column = "course_name")
    @Result(property = "instructor", column = "instructor_id",
            one = @One(select = "com.spring.mybatishomework.repository.InstructorRepo.findInstructorById"))
    List<Course> allCourses();

    @Select("select * from courses a inner join student_course as n on a.course_id=n.course_id where n.student_id =#{studentId}")
    @Result(property = "courseId",column = "course_id")
    @Result(property = "courseName",column = "course_name")
    @Result(property = "instructor", column = "instructor_id",
            one = @One(select = "com.spring.mybatishomework.repository.InstructorRepo.findInstructorById"))
    List<Course> allCoursesByStudentId(int studentId);

    Course findCourseById(Integer id);

    @Insert("INSERT INTO courses(course_name, description, instructor_id) VALUES (#{courseName}, #{description}, #{instructorId}) RETURNING course_id")
    Integer createCourse(Course course);

    @Update("UPDATE courses SET course_name = #{courseName}, description = #{description}, instructor_id = #{instructorId} WHERE course_id = #{courseId}")
    void updateCourse(Course course);

    @Delete("DELETE FROM courses WHERE course_id = #{id}")
    void deleteCourse(Integer id);

    void insertCourseToStudent(Integer CourseId, Integer StudentId);
}
