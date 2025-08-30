package com.borcla.springcloud.msvc.application.usecase;

import com.borcla.springcloud.msvc.application.exception.CourseNotFoundException;
import com.borcla.springcloud.msvc.application.ports.in.IRetrieveCourseUseCase;
import com.borcla.springcloud.msvc.application.ports.out.persistence.ICourseRepositoryPort;
import com.borcla.springcloud.msvc.domain.model.Course;

import java.util.Optional;

public class RetrieveCourseUseCaseImpl implements IRetrieveCourseUseCase {
    private final ICourseRepositoryPort courseRepositoryPort;

    public RetrieveCourseUseCaseImpl(ICourseRepositoryPort courseRepositoryPort) {
        this.courseRepositoryPort = courseRepositoryPort;
    }

    @Override
    public Optional<Course> getCourseById(Long idCourse) throws CourseNotFoundException {
        Course course = courseRepositoryPort.findById(idCourse)
                .orElseThrow(CourseNotFoundException::new);
        return Optional.of(course);
    }

    @Override
    public Optional<Course> getCourseByCode(String codeCourse) throws CourseNotFoundException {
        Course course = courseRepositoryPort.findByCode(codeCourse)
                .orElseThrow(CourseNotFoundException::new);
        return Optional.of(course);
    }

    @Override
    public Optional<Course> getCourseByName(String nameCourse) throws CourseNotFoundException {
        Course course = courseRepositoryPort.findByName(nameCourse)
                .orElseThrow(CourseNotFoundException::new);
        return Optional.of(course);
    }
}
