package com.spring.mybatishomework.service.implementation;


import com.spring.mybatishomework.model.Instructor;
import com.spring.mybatishomework.model.request.InstructorRequest;
import com.spring.mybatishomework.repository.InstructorRepo;
import com.spring.mybatishomework.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorImp implements InstructorService {

    private final InstructorRepo instructorRepo;

    public InstructorImp(InstructorRepo instructorRepo) {
        this.instructorRepo = instructorRepo;
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepo.getInstructor();
    }

    @Override
    public Instructor getInstructorById(Integer id) {
        return instructorRepo.findInstructorById(id);
    }

    @Override
    public Instructor createInstructor(InstructorRequest request) {
        Instructor instructor = new Instructor();
        instructor.setInstructorName(request.getInstructorName());
        instructor.setInstructorEmail(request.getInstructorEmail());
        Integer instructorId = instructorRepo.createInstructor(instructor);
        instructor.setInstructorId(instructorId);
        return instructor;
    }

    @Override
    public Instructor updateInstructorById(Integer id, InstructorRequest request) {
        Instructor instructor = new Instructor();
        instructor.setInstructorId(id);
        instructor.setInstructorName(request.getInstructorName());
        instructor.setInstructorEmail(request.getInstructorEmail());
        instructorRepo.updateInstructor(instructor);
        return instructorRepo.findInstructorById(id);
    }

    @Override
    public void deleteInstructor(Integer id) {
        instructorRepo.deleteInstructor(id);
    }
}
