package com.spring.mybatishomework.controller;

import com.spring.mybatishomework.model.Student;
import com.spring.mybatishomework.model.response.ApiResponse;
import com.spring.mybatishomework.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // get all Student

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getStudents() {
        List<Student> students = studentService.getStudents();
        ApiResponse<List<Student>> response = ApiResponse.<List<Student>>builder()
                .message("Get all students")
                .payload(students)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
    return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // find Student by ID

    @GetMapping ("/{student-id}")
    public ApiResponse<Student> getStudentById(@PathVariable ("student-id") Integer id) {
        Student student = studentService.getStudentById(id);

        return ApiResponse.<Student>builder()
                .message("Get student by id")
                .payload(student)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();

    }

}
