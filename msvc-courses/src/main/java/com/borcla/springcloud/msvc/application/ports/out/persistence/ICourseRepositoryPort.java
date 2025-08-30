package com.borcla.springcloud.msvc.application.ports.out.persistence;

import com.borcla.springcloud.msvc.domain.model.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseRepositoryPort {
    Course save(Course course);
    Course update (Course course, Long idCourse);
    boolean deleteById(Long id);
    Optional<Course> findById(Long id);
    Optional<Course> findByCode(String code);
    Optional<Course> findByName(String name);
}