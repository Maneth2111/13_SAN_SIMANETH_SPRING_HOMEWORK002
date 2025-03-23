package com.spring.mybatishomework.service;

import com.spring.mybatishomework.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();

    Student getStudentById(Integer id);


}
//    Student addNewStudent(student);