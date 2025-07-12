package com.patil.student_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDto {
    private String email;
    private String password;
    private String course;
}
