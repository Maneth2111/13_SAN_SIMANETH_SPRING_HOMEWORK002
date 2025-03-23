package com.spring.mybatishomework.service;

import com.spring.mybatishomework.model.Student;
import com.spring.mybatishomework.model.request.StudentRequest;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();

    Student getStudentById(Integer id);

    Student createStudent(StudentRequest request);
    Student updateStudent(Integer id, StudentRequest request);
    void deleteStudent(Integer id);


}
//    Student addNewStudent(student);