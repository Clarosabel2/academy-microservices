package com.borcla.springcloud.msvc.domain.ports.in;

import com.borcla.springcloud.msvc.application.exception.CourseNotFoundException;
import com.borcla.springcloud.msvc.domain.model.Course;

public interface IDeleteCourseUseCase {
    boolean deleteCourseById(Long id) throws CourseNotFoundException;
    boolean deleteCourseByName(String name)throws CourseNotFoundException;
    boolean deleteCourseByCourseCode(String code)throws CourseNotFoundException;
}
