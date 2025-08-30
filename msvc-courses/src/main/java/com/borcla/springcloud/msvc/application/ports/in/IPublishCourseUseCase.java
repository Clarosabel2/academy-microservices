package com.borcla.springcloud.msvc.application.ports.in;

import com.borcla.springcloud.msvc.domain.model.Course;

public interface IPublishCourseUseCase {
    void publishCourse(Long idCourse);
    void publishCourseByName(String nameCourse);
}
