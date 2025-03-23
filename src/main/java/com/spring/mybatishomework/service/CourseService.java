package com.spring.mybatishomework.service;

import com.spring.mybatishomework.model.Course;
import com.spring.mybatishomework.model.Instructor;
import com.spring.mybatishomework.model.request.CourseRequest;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    Course addCourse(CourseRequest request);
}
