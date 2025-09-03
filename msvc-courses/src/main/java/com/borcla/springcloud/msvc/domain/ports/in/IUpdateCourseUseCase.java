package com.borcla.springcloud.msvc.domain.ports.in;

import com.borcla.springcloud.msvc.domain.model.Course;

public interface IUpdateCourseUseCase {
    Course updateCourse(Long idCourse, Course course);
}
