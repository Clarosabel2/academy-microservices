package com.borcla.springcloud.msvc.infrastructure.adapters.in.web.controller;

import com.borcla.springcloud.msvc.application.ports.in.ICreateCourseUseCase;
import com.borcla.springcloud.msvc.application.ports.in.IRetrieveCourseUseCase;
import com.borcla.springcloud.msvc.infrastructure.adapters.in.web.dto.CourseSummaryResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

}
