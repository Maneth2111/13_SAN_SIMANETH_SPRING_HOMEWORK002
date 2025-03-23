package com.spring.mybatishomework.controller;

import com.spring.mybatishomework.model.Course;
import com.spring.mybatishomework.model.Instructor;
import com.spring.mybatishomework.model.request.CourseRequest;
import com.spring.mybatishomework.model.response.ApiResponse;
import com.spring.mybatishomework.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        ApiResponse<List<Course>> response = ApiResponse.<List<Course>>builder()
                .message("Get All Courses")
                .payload(courses)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Course>> addCourse(@RequestBody CourseRequest request) {
        Course newCourse = courseService.addCourse(request);
        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .message("Create new instructor successfully")
                .payload(newCourse)
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

