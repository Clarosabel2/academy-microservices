package com.borcla.springcloud.msvc.domain.ports.in;

import com.borcla.springcloud.msvc.domain.model.Course;
import com.borcla.springcloud.msvc.domain.model.enums.CourseStatus;
import com.borcla.springcloud.msvc.domain.pagination.PageResult;
import com.borcla.springcloud.msvc.domain.pagination.PaginationRequest;

import java.util.List;

public interface IListCoursesUseCase {
    PageResult<Course> list(PaginationRequest pagination);
    PageResult<Course> listByInstructor(Long instructorId, PaginationRequest pagination);
    PageResult<Course> listByStatus(CourseStatus status, PaginationRequest pagination);
    List<Course> listLatest(int limit);
}
