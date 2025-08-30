package com.borcla.springcloud.msvc.application.ports.in;

import com.borcla.springcloud.msvc.domain.model.Course;
import com.borcla.springcloud.msvc.domain.model.enums.CourseStatus;

import java.util.List;

public interface IListCoursesUseCase {
    List<Course> list(int page, int size);
    List<Course> listByInstructor(Long instructorId, int page, int size);
    List<Course> listByStatus(CourseStatus status, int page, int size);
    List<Course> listLatest(int limit);
}
