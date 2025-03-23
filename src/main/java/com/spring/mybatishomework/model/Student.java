package com.spring.mybatishomework.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student  {
    private Integer studentId;
    private String studentName;
    private String studentEmail;
    private String phoneNumber;
    private List<Course> courses;
}
