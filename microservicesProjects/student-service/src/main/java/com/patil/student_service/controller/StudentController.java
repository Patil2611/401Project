package com.patil.student_service.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.patil.student_service.dto.StudentDto;
import com.patil.student_service.entity.Student;
import com.patil.student_service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody StudentDto student) throws JsonProcessingException {
        return studentService.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }
}
