package com.borcla.springcloud.msvc.application.usecase;

import com.borcla.springcloud.msvc.domain.ports.in.ICreateCourseUseCase;
import com.borcla.springcloud.msvc.domain.ports.out.persistence.ICourseRepositoryPort;
import com.borcla.springcloud.msvc.domain.model.Course;

public class CreateCourseUseCaseImpl implements ICreateCourseUseCase {

    private final ICourseRepositoryPort courseRepositoryPort;
    public CreateCourseUseCaseImpl(ICourseRepositoryPort courseRepositoryPort) {
        this.courseRepositoryPort = courseRepositoryPort;
    }
    @Override
    public Course createCourse(Course course) {
        return courseRepositoryPort.save(course);
    }
}
