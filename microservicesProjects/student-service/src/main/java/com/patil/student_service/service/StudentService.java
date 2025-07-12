package com.patil.student_service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patil.student_service.dto.StudentDto;
import com.patil.student_service.entity.Student;
import com.patil.student_service.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepo studentRepository;
    private final KafkaProducer kafkaProducer;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public StudentService(StudentRepo studentRepository, KafkaProducer kafkaProducer) {
        this.studentRepository = studentRepository;
        this.kafkaProducer = kafkaProducer;
    }

    public Student saveStudent(StudentDto student) throws JsonProcessingException {
        Student s = new Student();
        s.setEmail(student.getEmail());
        s.setPassword(student.getPassword());
//        s.setCourse(student.getCourse());
        Student saved = studentRepository.save(s);
        String json = objectMapper.writeValueAsString(saved);
        kafkaProducer.sendMessage(json);
        return saved;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
