package com.spring.mybatishomework.model.request;


import com.spring.mybatishomework.model.Course;
import com.spring.mybatishomework.model.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String studentName;
    private String studentEmail;
    private String phoneNumber;
    private List<Integer> courses;
}
