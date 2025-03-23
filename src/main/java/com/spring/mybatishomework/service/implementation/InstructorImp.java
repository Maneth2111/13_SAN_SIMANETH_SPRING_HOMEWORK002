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
    public Instructor createInstructor(InstructorRequest instructor) {
        return instructorRepo.createInstructor(instructor);
    }

    @Override
    public Instructor updateInstructorById(Integer id, InstructorRequest request) {
        instructorRepo.updateInstructor(id, request);
        return instructorRepo.findInstructorById(id);
    }

//    @Override
//    public Instructor updateInstructorById(Integer id, Instructor request) {
//        request.setInstructorId(id); // ✅ Ensure ID is set in the request
//        return instructorRepo.updateInstructor(request);
//    }
}
