package com.patil.student_service.repository;

import com.patil.student_service.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {

}
