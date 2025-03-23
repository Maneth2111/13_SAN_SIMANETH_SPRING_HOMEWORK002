package com.spring.mybatishomework.service;

import com.spring.mybatishomework.model.Course;
import com.spring.mybatishomework.model.Instructor;
import com.spring.mybatishomework.model.request.CourseRequest;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    Course getCourseById(Integer id);

//    Course addCourse(CourseRequest request);
    Course addCourse(CourseRequest request);

    Course updateCourse(Integer id, CourseRequest request);
    void deleteCourse(Integer id);
}
