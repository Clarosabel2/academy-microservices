package com.borcla.springcloud.msvc.application.usecase;

import com.borcla.springcloud.msvc.application.exception.CourseNotFoundException;
import com.borcla.springcloud.msvc.domain.ports.in.IReserveSeatUseCase;
import com.borcla.springcloud.msvc.domain.ports.out.persistence.ICourseRepositoryPort;
import com.borcla.springcloud.msvc.domain.exception.CourseFullException;
import com.borcla.springcloud.msvc.domain.model.Course;

public class ReserveSeatUseCaseImpl implements IReserveSeatUseCase {

    private final ICourseRepositoryPort courseRepositoryPort;

    public ReserveSeatUseCaseImpl(ICourseRepositoryPort courseRepositoryPort) {
        this.courseRepositoryPort = courseRepositoryPort;
    }

    @Override
    public void reserve(Long idCourse) throws CourseNotFoundException, CourseFullException {
        Course course = courseRepositoryPort.findById(idCourse)
                .orElseThrow(CourseNotFoundException::new);
        try {
            course.reserveSeat();
        } catch (IllegalStateException e) {
            throw new CourseFullException(course.getId(), course.getCapacity(), course.getEnrolledCount());
        }
        courseRepositoryPort.update(course, course.getId());
    }
}
