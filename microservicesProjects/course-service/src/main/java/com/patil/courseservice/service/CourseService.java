package com.patil.courseservice.service;

import com.patil.courseservice.entity.Course;
import com.patil.courseservice.repository.CourseRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;

    public Integer addCourse(Course course){
        return courseRepo.save(course).getId();
    }

    public List<Course> getAllCourses(){
        return courseRepo.findAll();
    }

    public Course getCourseById(Integer id){
        return courseRepo.findById(id).orElseThrow(()->new EntityNotFoundException("Course not found with id " + id));
    }
}
