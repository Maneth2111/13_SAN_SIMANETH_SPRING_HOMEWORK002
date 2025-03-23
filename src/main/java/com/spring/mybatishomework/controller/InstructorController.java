package com.spring.mybatishomework.controller;

import com.spring.mybatishomework.model.Instructor;
import com.spring.mybatishomework.model.request.InstructorRequest;
import com.spring.mybatishomework.model.response.ApiResponse;
import com.spring.mybatishomework.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructors() {
        List<Instructor> instructors = instructorService.getAllInstructors();

        ApiResponse<List<Instructor>> data = ApiResponse.<List<Instructor>>builder()
                .message("Get all instructors")
                .payload(instructors)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @GetMapping ("/{instructor-id}")
    public ApiResponse<Instructor> getInstructorById(@PathVariable ("instructor-id") Integer id) {
        Instructor instructor = instructorService.getInstructorById(id);

        return ApiResponse.<Instructor>builder()
                .message("Get instructor by id")
                .payload(instructor)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();

    }

    // Create

    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> createInstructor(@RequestBody InstructorRequest request) {
        Instructor newInstructor = instructorService.createInstructor(request);
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .message("Create new instructor successfully")
                .payload(newInstructor)
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{instructor-id}")
    public ResponseEntity<ApiResponse<Instructor>> updateInstructorById(
            @PathVariable("instructor-id") Integer id,
            @RequestBody InstructorRequest request) {
        Instructor updatedInstructor = instructorService.updateInstructorById(id, request);
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .message("Instructor updated successfully")
                .payload(updatedInstructor)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
