package com.spring.mybatishomework.service.implementation;

import com.spring.mybatishomework.model.Student;
import com.spring.mybatishomework.repository.StudentRepo;
import com.spring.mybatishomework.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentImp implements StudentService {
    private  final StudentRepo studentRepo;

    public StudentImp(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepo.findAllStudents();
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepo.findStudentById(id);
    }

//    @Override
//    public Student addNewStudent() {
//        return studentRepo.addNewStudent();
//    }
}
