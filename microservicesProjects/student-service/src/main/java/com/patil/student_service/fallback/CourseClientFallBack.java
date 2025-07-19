package com.patil.student_service.fallback;

import com.patil.student_service.dto.CourseDto;
import com.patil.student_service.feignClient.CourseClient;
import org.springframework.stereotype.Component;

@Component
public class CourseClientFallBack implements CourseClient {
    @Override
    public CourseDto getCourseById(Integer id) {
        return new CourseDto("Unknown");
    }
}
