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
    public StudentDto createStudent(@RequestBody Student student) throws JsonProcessingException {
        return studentService.saveStudent(student);
    }

    @GetMapping
    public List<StudentDto> getAll() {
        return studentService.getAllStudents();
    }
}
