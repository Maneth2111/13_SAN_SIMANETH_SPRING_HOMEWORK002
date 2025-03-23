package com.spring.mybatishomework.service.implementation;

import com.spring.mybatishomework.model.Course;
import com.spring.mybatishomework.model.request.CourseRequest;
import com.spring.mybatishomework.repository.CourseRepo;
import com.spring.mybatishomework.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseImp implements CourseService {

    private final CourseRepo courseRepo;

    public CourseImp(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.allCourses();
    }

    @Override
    public Course addCourse(CourseRequest request) {
        return  courseRepo.addNewCourse(request);
    }
}
