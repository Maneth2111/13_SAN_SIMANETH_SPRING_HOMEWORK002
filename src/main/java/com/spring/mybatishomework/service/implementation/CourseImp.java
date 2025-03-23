package com.spring.mybatishomework.service.implementation;

import com.spring.mybatishomework.model.Course;
import com.spring.mybatishomework.model.request.CourseRequest;
import com.spring.mybatishomework.repository.CourseRepo;
import com.spring.mybatishomework.repository.InstructorRepo;
import com.spring.mybatishomework.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseImp implements CourseService {

    private final CourseRepo courseRepo;
    private final InstructorRepo instructorRepo;

    public CourseImp(CourseRepo courseRepo, InstructorRepo instructorRepo) {
        this.courseRepo = courseRepo;
        this.instructorRepo = instructorRepo;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.allCourses();
    }



    @Override
    public Course getCourseById(Integer id) {
        return courseRepo.findCourseById(id);
    }

//    @Override
//    public Course addCourse(CourseRequest request) {
//        Course course = new Course();
//        course.setCourseName(request.getCourseName());
//        course.setDescription(request.getDescription());
////        course.setInstructorId(request.getInstructorId());
//        Integer courseId = courseRepo.createCourse(course);
//        course.setCourseId(courseId);
//        return course;
//    }

    public Course addCourse(CourseRequest request) {
        // Check if the instructor exists
        if (instructorRepo.findInstructorById(request.getInstructorId()) == null) {
            throw new IllegalArgumentException("Instructor ID does not exist");
        }

        Course course = new Course();
        course.setCourseName(request.getCourseName());
        course.setDescription(request.getDescription());
//        course.setInstructorId(request.getInstructorId());
        Integer courseId = courseRepo.createCourse(course);
        course.setCourseId(courseId);
        return course;
    }

    @Override
    public Course updateCourse(Integer id, CourseRequest request) {
        Course course = new Course();
        course.setCourseId(id);
        course.setCourseName(request.getCourseName());
        course.setDescription(request.getDescription());
//        course.setInstructorId(request.getInstructorId());
        courseRepo.updateCourse(course);
        return courseRepo.findCourseById(id);
    }

    @Override
    public void deleteCourse(Integer id) {
        courseRepo.deleteCourse(id);
    }
}
