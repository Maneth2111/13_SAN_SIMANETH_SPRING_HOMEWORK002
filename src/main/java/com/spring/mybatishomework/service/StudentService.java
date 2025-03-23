package com.spring.mybatishomework.service;

import com.spring.mybatishomework.model.Student;
import com.spring.mybatishomework.model.request.StudentRequest;

import java.util.List;

public interface StudentService {
    List<Student> getStudents(Integer page, Integer size);

    Student getStudentById(Integer id);

    Student createStudent(StudentRequest request);
    Student updateStudent(Integer id, StudentRequest request);
    void deleteStudent(Integer id);


}
