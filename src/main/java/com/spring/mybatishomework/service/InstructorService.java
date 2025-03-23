package com.spring.mybatishomework.service;

import com.spring.mybatishomework.model.Instructor;
import com.spring.mybatishomework.model.request.InstructorRequest;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructors(Integer page ,Integer size);

    Instructor getInstructorById(Integer id);

    Instructor createInstructor(InstructorRequest request);

    Instructor updateInstructorById(Integer id,InstructorRequest request);

    void deleteInstructor(Integer id);
}
