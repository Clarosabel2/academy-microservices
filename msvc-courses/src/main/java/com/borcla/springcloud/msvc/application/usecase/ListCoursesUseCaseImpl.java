package com.borcla.springcloud.msvc.application.usecase;

import com.borcla.springcloud.msvc.domain.ports.in.IListCoursesUseCase;
import com.borcla.springcloud.msvc.domain.ports.out.persistence.ICourseRepositoryPort;
import com.borcla.springcloud.msvc.domain.model.Course;
import com.borcla.springcloud.msvc.domain.model.enums.CourseStatus;
import com.borcla.springcloud.msvc.domain.pagination.PageResult;
import com.borcla.springcloud.msvc.domain.pagination.PaginationRequest;

import java.util.List;

public class ListCoursesUseCaseImpl implements IListCoursesUseCase {

    private final ICourseRepositoryPort courseRepositoryPort;

    public ListCoursesUseCaseImpl(ICourseRepositoryPort courseRepositoryPort) {
        this.courseRepositoryPort = courseRepositoryPort;
    }

    @Override
    public PageResult<Course> list(PaginationRequest pagination) {
        return courseRepositoryPort.findAll(pagination);
    }

    @Override
    public PageResult<Course> listByInstructor(Long instructorId, PaginationRequest pagination) {
        return courseRepositoryPort.findByInstructor(instructorId, pagination);
    }

    @Override
    public PageResult<Course> listByStatus(CourseStatus status, PaginationRequest pagination) {
        return courseRepositoryPort.findByStatus(status, pagination);
    }

    @Override
    public List<Course> listLatest(int limit) {
        return courseRepositoryPort.findLatest(limit);
    }
}
