package com.borcla.springcloud.msvc.application.usecase;

import com.borcla.springcloud.msvc.application.exception.CourseNotFoundException;
import com.borcla.springcloud.msvc.application.ports.in.IPublishCourseUseCase;
import com.borcla.springcloud.msvc.application.ports.out.persistence.ICourseRepositoryPort;
import com.borcla.springcloud.msvc.domain.model.Course;

public class PublishCourseUseCaseImpl implements IPublishCourseUseCase {

    private final ICourseRepositoryPort courseRepositoryPort;

    public PublishCourseUseCaseImpl(ICourseRepositoryPort courseRepositoryPort) {
        this.courseRepositoryPort = courseRepositoryPort;
    }

    @Override
    public void publishCourse(Long idCourse) {
        Course course = courseRepositoryPort.findById(idCourse)
                .orElseThrow(CourseNotFoundException::new);
        course.publish();
        courseRepositoryPort.update(course, course.getId());
    }

    @Override
    public void publishCourseByName(String nameCourse) {
        Course course = courseRepositoryPort.findByName(nameCourse)
                .orElseThrow(CourseNotFoundException::new);
        course.publish();
        courseRepositoryPort.update(course, course.getId());
    }
}
