package com.patil.student_service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patil.student_service.dto.CourseDto;
import com.patil.student_service.dto.StudentDto;
import com.patil.student_service.entity.Student;
import com.patil.student_service.feignClient.CourseClient;
import com.patil.student_service.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepo studentRepository;
    private final CourseClient  courseClient;

    public StudentService(StudentRepo studentRepository, CourseClient courseClient) {
        this.studentRepository = studentRepository;
        this.courseClient = courseClient;
    }

    public StudentDto saveStudent(Student student) throws JsonProcessingException {
        StudentDto studentDto = new StudentDto();
        studentDto.setEmail(student.getEmail());
        studentDto.setPassword(student.getPassword());
        CourseDto courseDto = courseClient.getCourseById(student.getCourseId());
        studentDto.setCourseDto(courseDto);

        Student saved = studentRepository.save(student);
        return studentDto;
    }

    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream().map(this::studentToDto).toList();
    }


    private StudentDto studentToDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setEmail(student.getEmail());
        studentDto.setPassword(student.getPassword());
        studentDto.setCourseDto(courseClient.getCourseById(student.getCourseId()));
        return studentDto;
    }
}
