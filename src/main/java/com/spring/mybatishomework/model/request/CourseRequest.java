package com.spring.mybatishomework.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    private Integer courseId;
    private String courseName;
    private String description;
    private Integer instructorId;
}
