package com.patil.student_service.feignClient;

import com.patil.student_service.dto.CourseDto;
import com.patil.student_service.fallback.CourseClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "course-service", fallback = CourseClientFallBack.class)
public interface CourseClient {
    @GetMapping("/course/{id}")
    CourseDto getCourseById(@PathVariable Integer id);
}
