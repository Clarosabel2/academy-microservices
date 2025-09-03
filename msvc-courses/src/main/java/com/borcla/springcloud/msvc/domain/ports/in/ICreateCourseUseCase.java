package com.borcla.springcloud.msvc.domain.ports.in;

import com.borcla.springcloud.msvc.domain.model.Course;

public interface ICreateCourseUseCase {
    Course createCourse(Course course);
}
