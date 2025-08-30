package com.borcla.springcloud.msvc.application.usecase;

import com.borcla.springcloud.msvc.application.exception.CourseNotFoundException;
import com.borcla.springcloud.msvc.application.ports.in.IAssignInstructorUseCase;
import com.borcla.springcloud.msvc.application.ports.out.persistence.ICourseRepositoryPort;
import com.borcla.springcloud.msvc.domain.model.Course;

import java.util.HashSet;
import java.util.Set;

public class AssignInstructorUseCaseImpl implements IAssignInstructorUseCase {

    private final ICourseRepositoryPort courseRepositoryPort;

    public AssignInstructorUseCaseImpl(ICourseRepositoryPort courseRepositoryPort) {
        this.courseRepositoryPort = courseRepositoryPort;
    }

    @Override
    public void assignInstructor(Long instructorId, Long idCourse) throws CourseNotFoundException {
        Course course = courseRepositoryPort.findById(idCourse)
                .orElseThrow(CourseNotFoundException::new);

        Set<Long> instructors = course.getInstructorIds();
        if (instructors == null) {
            instructors = new HashSet<>();
            course.setInstructorIds(instructors);
        }
        instructors.add(instructorId);

        courseRepositoryPort.update(course, course.getId());
    }
}
