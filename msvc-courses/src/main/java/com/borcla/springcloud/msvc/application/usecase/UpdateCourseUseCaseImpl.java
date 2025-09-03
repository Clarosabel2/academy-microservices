package com.borcla.springcloud.msvc.application.usecase;

import com.borcla.springcloud.msvc.domain.ports.in.IUpdateCourseUseCase;
import com.borcla.springcloud.msvc.domain.ports.out.persistence.ICourseRepositoryPort;
import com.borcla.springcloud.msvc.domain.model.Course;

public class UpdateCourseUseCaseImpl implements IUpdateCourseUseCase {
    private final ICourseRepositoryPort courseRepositoryPort;

    public UpdateCourseUseCaseImpl(ICourseRepositoryPort courseRepositoryPort) {
        this.courseRepositoryPort = courseRepositoryPort;
    }

    @Override
    public Course updateCourse(Long idCourse, Course course) {
        return courseRepositoryPort.update(course, idCourse);
    }
}
