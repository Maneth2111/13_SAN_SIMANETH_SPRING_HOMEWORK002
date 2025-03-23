package com.spring.mybatishomework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course{
    private String courseName;
    private String description;
    private Instructor instructor;
}
