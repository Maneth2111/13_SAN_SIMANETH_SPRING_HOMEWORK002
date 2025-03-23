package com.spring.mybatishomework.service.implementation;

import com.spring.mybatishomework.model.Student;
import com.spring.mybatishomework.model.request.StudentRequest;
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
    public List<Student> getStudents(Integer page, Integer size) {
        return studentRepo.findAllStudents(page,size);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepo.findStudentById(id);
    }

    @Override
    public Student createStudent(StudentRequest request) {
        Student student = new Student();
        student.setStudentName(request.getStudentName());
        student.setStudentEmail(request.getStudentEmail());
        student.setPhoneNumber(request.getPhoneNumber());
        Integer studentId = studentRepo.createStudent(student);
        student.setStudentId(studentId);
        return student;
    }

    @Override
    public Student updateStudent(Integer id, StudentRequest request) {
        Student student = new Student();
        student.setStudentId(id);
        student.setStudentName(request.getStudentName());
        student.setStudentEmail(request.getStudentEmail());
        student.setPhoneNumber(request.getPhoneNumber());
        studentRepo.updateStudent(student);
        return studentRepo.findStudentById(id);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepo.deleteStudent(id);
    }

//    @Override
//    public Student addNewStudent() {
//        return studentRepo.addNewStudent();
//    }
}
