package com.borcla.springcloud.msvc.infrastructure.adapters.in.web.controller;

import com.borcla.springcloud.msvc.application.exception.CourseNotFoundException;
import com.borcla.springcloud.msvc.domain.model.Course;
import com.borcla.springcloud.msvc.domain.pagination.PageResult;
import com.borcla.springcloud.msvc.domain.pagination.PaginationRequest;
import com.borcla.springcloud.msvc.domain.ports.in.*;
import com.borcla.springcloud.msvc.infrastructure.adapters.in.web.dto.CourseRequestDTO;
import com.borcla.springcloud.msvc.infrastructure.adapters.in.web.dto.CourseSummaryResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final ICreateCourseUseCase createCourseUseCase;
    private final IRetrieveCourseUseCase retrieveCourseUseCase;
    private final IListCoursesUseCase listCoursesUseCase;
    private final IUpdateCourseUseCase updateCourseUseCase;
    private final IDeleteCourseUseCase deleteCourseUseCase;

    public CourseController(ICreateCourseUseCase createCourseUseCase,
                            IRetrieveCourseUseCase retrieveCourseUseCase,
                            IListCoursesUseCase listCoursesUseCase,
                            IUpdateCourseUseCase updateCourseUseCase,
                            IDeleteCourseUseCase deleteCourseUseCase) {
        this.createCourseUseCase = createCourseUseCase;
        this.retrieveCourseUseCase = retrieveCourseUseCase;
        this.listCoursesUseCase = listCoursesUseCase;
        this.updateCourseUseCase = updateCourseUseCase;
        this.deleteCourseUseCase = deleteCourseUseCase;
    }

    @GetMapping
    public Page<CourseSummaryResponseDTO> list(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size) {
        PageResult<Course> result = listCoursesUseCase.list(new PaginationRequest(page, size));
        List<CourseSummaryResponseDTO> dtoList = result.getItems().stream()
                .map(this::toSummaryDto)
                .toList();
        return new PageImpl<>(dtoList, PageRequest.of(page, size), result.getTotal());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseSummaryResponseDTO> getById(@PathVariable Long id) throws CourseNotFoundException {
        return retrieveCourseUseCase.getCourseById(id)
                .map(course -> ResponseEntity.ok(toSummaryDto(course)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CourseSummaryResponseDTO> create(@RequestBody CourseRequestDTO dto) {
        Course course = createCourseUseCase.createCourse(toDomain(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(toSummaryDto(course));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseSummaryResponseDTO> update(@PathVariable Long id, @RequestBody CourseRequestDTO dto) {
        Course updated = updateCourseUseCase.updateCourse(id, toDomain(dto));
        return ResponseEntity.ok(toSummaryDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws CourseNotFoundException {
        deleteCourseUseCase.deleteCourseById(id);
        return ResponseEntity.noContent().build();
    }

    private CourseSummaryResponseDTO toSummaryDto(Course course) {
        return new CourseSummaryResponseDTO(course.getId(), course.getName(), course.getDescription());
    }

    private Course toDomain(CourseRequestDTO dto) {
        return new Course(dto.courseName(), dto.description(), dto.endDate());
    }
}
