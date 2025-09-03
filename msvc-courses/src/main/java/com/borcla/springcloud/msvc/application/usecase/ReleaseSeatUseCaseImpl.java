package com.borcla.springcloud.msvc.application.usecase;

import com.borcla.springcloud.msvc.application.exception.CourseNotFoundException;
import com.borcla.springcloud.msvc.domain.ports.in.IReleaseSeatUseCase;
import com.borcla.springcloud.msvc.domain.ports.out.persistence.ICourseRepositoryPort;
import com.borcla.springcloud.msvc.domain.exception.CourseFullException;
import com.borcla.springcloud.msvc.domain.model.Course;

public class ReleaseSeatUseCaseImpl implements IReleaseSeatUseCase {

    private final ICourseRepositoryPort courseRepositoryPort;

    public ReleaseSeatUseCaseImpl(ICourseRepositoryPort courseRepositoryPort) {
        this.courseRepositoryPort = courseRepositoryPort;
    }

    @Override
    public void releaseSeat(Long idCourse) throws CourseNotFoundException, CourseFullException {
        Course course = courseRepositoryPort.findById(idCourse)
                .orElseThrow(CourseNotFoundException::new);
        course.releaseSeat();
        courseRepositoryPort.update(course, course.getId());
    }

    @Override
    public void releaseSeatByName(String name) throws CourseNotFoundException, CourseFullException {
        Course course = courseRepositoryPort.findByName(name)
                .orElseThrow(CourseNotFoundException::new);
        course.releaseSeat();
        courseRepositoryPort.update(course, course.getId());
    }
}
