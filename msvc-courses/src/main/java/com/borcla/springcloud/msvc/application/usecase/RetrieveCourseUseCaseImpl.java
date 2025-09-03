package com.borcla.springcloud.msvc.application.usecase;

import com.borcla.springcloud.msvc.application.exception.CourseNotFoundException;
import com.borcla.springcloud.msvc.domain.ports.in.IRetrieveCourseUseCase;
import com.borcla.springcloud.msvc.domain.ports.out.persistence.ICourseRepositoryPort;
import com.borcla.springcloud.msvc.domain.model.Course;

import java.util.Optional;

public class RetrieveCourseUseCaseImpl implements IRetrieveCourseUseCase {
    private final ICourseRepositoryPort courseRepositoryPort;

    public RetrieveCourseUseCaseImpl(ICourseRepositoryPort courseRepositoryPort) {
        this.courseRepositoryPort = courseRepositoryPort;
    }

    @Override
    public Optional<Course> getCourseById(Long idCourse) throws CourseNotFoundException {
        Optional<Course> course = courseRepositoryPort.findById(idCourse);
        if (course.isEmpty()) {
            throw new CourseNotFoundException();
        }
        return course;
    }

    @Override
    public Optional<Course> getCourseByCode(String codeCourse) throws CourseNotFoundException {
        Optional<Course> course = courseRepositoryPort.findByCode(codeCourse);
        if (course.isEmpty()) {
            throw new CourseNotFoundException();
        }
        return course;
    }

    @Override
    public Optional<Course> getCourseByName(String nameCourse) throws CourseNotFoundException {
        Optional<Course> course = courseRepositoryPort.findByName(nameCourse);
        if (course.isEmpty()) {
            throw new CourseNotFoundException();
        }
        return course;
    }
}
