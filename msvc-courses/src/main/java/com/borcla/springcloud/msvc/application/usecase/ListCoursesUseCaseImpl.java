package com.borcla.springcloud.msvc.application.usecase;

import com.borcla.springcloud.msvc.application.ports.in.IListCoursesUseCase;
import com.borcla.springcloud.msvc.application.ports.out.persistence.ICourseRepositoryPort;
import com.borcla.springcloud.msvc.domain.model.Course;
import com.borcla.springcloud.msvc.domain.model.enums.CourseStatus;

import java.util.List;

public class ListCoursesUseCaseImpl implements IListCoursesUseCase {

    private final ICourseRepositoryPort courseRepositoryPort;

    public ListCoursesUseCaseImpl(ICourseRepositoryPort courseRepositoryPort) {
        this.courseRepositoryPort = courseRepositoryPort;
    }

    @Override
    public List<Course> list(int page, int size) {
        return List.of();
    }

    @Override
    public List<Course> listByInstructor(Long instructorId, int page, int size) {
        return List.of();
    }

    @Override
    public List<Course> listByStatus(CourseStatus status, int page, int size) {
        return List.of();
    }

    @Override
    public List<Course> listLatest(int limit) {
        return List.of();
    }
}
