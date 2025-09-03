package com.borcla.springcloud.msvc.domain.ports.in;

import com.borcla.springcloud.msvc.application.exception.CourseNotFoundException;
import com.borcla.springcloud.msvc.domain.model.Course;

public interface IRetrieveCourseUseCase {
    Course getCourseById(Long idCourse) throws CourseNotFoundException;
    Course getCourseByCode(String codeCourse) throws CourseNotFoundException;
    Course getCourseByName(String nameCourse) throws CourseNotFoundException;
}
