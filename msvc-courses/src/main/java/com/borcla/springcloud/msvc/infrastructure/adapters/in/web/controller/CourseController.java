package com.borcla.springcloud.msvc.infrastructure.adapters.in.web.controller;

import com.borcla.springcloud.msvc.application.services.CourseService;
import com.borcla.springcloud.msvc.domain.model.Course;
import com.borcla.springcloud.msvc.infrastructure.adapters.in.web.dto.request.CreateCourseRequest;
import com.borcla.springcloud.msvc.infrastructure.adapters.in.web.dto.request.UpdateCourseRequest;
import com.borcla.springcloud.msvc.infrastructure.adapters.in.web.dto.response.CourseCreatedResponse;
import com.borcla.springcloud.msvc.infrastructure.adapters.in.web.dto.response.CourseSummaryResponse;
import com.borcla.springcloud.msvc.infrastructure.adapters.in.web.mapper.ICourseWebMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;
    private final ICourseWebMapper courseWebMapper;
    public CourseController(CourseService courseService, ICourseWebMapper courseWebMapper) {
        this.courseService = courseService;
        this.courseWebMapper = courseWebMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseSummaryResponse> findCourseById(@PathVariable Long id){
        return ResponseEntity.ok(courseWebMapper.toSummaryDto(courseService.getCourseById(id)));
    }

    @GetMapping
    public ResponseEntity<Page<CourseSummaryResponse>> findAllCourse(PageRequest pageRequest){
        return ResponseEntity.accepted().build();
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody CreateCourseRequest createCourseRequest){
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable Long id){
        return ResponseEntity.accepted().build();
    }

    @PutMapping
    public ResponseEntity<Course> updateCourse(@RequestBody UpdateCourseRequest updateCourseRequest){
        return ResponseEntity.accepted().build();
    }

}
