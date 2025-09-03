package com.borcla.springcloud.msvc.domain.ports.in;

import com.borcla.springcloud.msvc.application.exception.CourseNotFoundException;
import com.borcla.springcloud.msvc.domain.model.Course;

import java.util.Optional;

public interface IRetrieveCourseUseCase {
    Optional<Course> getCourseById(Long idCourse) throws CourseNotFoundException;
    Optional<Course> getCourseByCode(String codeCourse) throws CourseNotFoundException;
    Optional<Course> getCourseByName(String nameCourse) throws CourseNotFoundException;
}
