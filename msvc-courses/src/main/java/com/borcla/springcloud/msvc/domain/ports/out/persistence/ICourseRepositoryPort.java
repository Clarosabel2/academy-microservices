package com.borcla.springcloud.msvc.domain.ports.out.persistence;

import com.borcla.springcloud.msvc.domain.model.Course;
import com.borcla.springcloud.msvc.domain.model.enums.CourseStatus;
import com.borcla.springcloud.msvc.domain.pagination.PageResult;
import com.borcla.springcloud.msvc.domain.pagination.PaginationRequest;

import java.util.List;
import java.util.Optional;

public interface ICourseRepositoryPort {
    Course save(Course course);
    Course update (Course course, Long idCourse);
    boolean deleteById(Long id);
    Optional<Course> findById(Long id);
    Optional<Course> findByCode(String code);
    Optional<Course> findByName(String name);

    PageResult<Course> findAll(PaginationRequest pagination);
    PageResult<Course> findByInstructor(Long instructorId, PaginationRequest pagination);
    PageResult<Course> findByStatus(CourseStatus status, PaginationRequest pagination);
    List<Course> findLatest(int limit);
}