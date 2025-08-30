package com.borcla.springcloud.msvc.application.usecase;

import com.borcla.springcloud.msvc.application.exception.CourseNotFoundException;
import com.borcla.springcloud.msvc.application.ports.in.IRemoveInstructorUseCase;
import com.borcla.springcloud.msvc.application.ports.out.persistence.ICourseRepositoryPort;
import com.borcla.springcloud.msvc.domain.model.Course;

public class RemoveInstructorUseCaseImpl implements IRemoveInstructorUseCase {

    private final ICourseRepositoryPort courseRepositoryPort;

    public RemoveInstructorUseCaseImpl(ICourseRepositoryPort courseRepositoryPort) {
        this.courseRepositoryPort = courseRepositoryPort;
    }

    @Override
    public void removeInstructor(Long instructorId, Long idCourse) throws CourseNotFoundException {
        Course course = courseRepositoryPort.findById(idCourse)
                .orElseThrow(CourseNotFoundException::new);

        if (course.getInstructorIds() != null) {
            course.getInstructorIds().remove(instructorId);
        }

        courseRepositoryPort.update(course, course.getId());
    }
}
