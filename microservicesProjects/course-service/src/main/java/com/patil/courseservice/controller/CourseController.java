package com.patil.courseservice.controller;

import com.patil.courseservice.dto.CourseDto;
import com.patil.courseservice.entity.Course;
import com.patil.courseservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses(Integer id){
        List<Course> course = courseService.getAllCourses();
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        courseService.addCourse(course);
        return ResponseEntity.ok().body(course);
    }

    @GetMapping("/{id}")
    public CourseDto getCourseById(@PathVariable Integer id){
        Course course = courseService.getCourseById(id);
        CourseDto courseDto = new CourseDto();
        courseDto.setCourseName(course.getCourseName());
        return courseDto;
    }
}
