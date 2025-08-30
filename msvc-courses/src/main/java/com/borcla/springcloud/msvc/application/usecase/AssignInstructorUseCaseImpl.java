package com.borcla.springcloud.msvc.application.usecase;

import com.borcla.springcloud.msvc.application.exception.CourseNotFoundException;
import com.borcla.springcloud.msvc.application.ports.in.IAssignInstructorUseCase;
import com.borcla.springcloud.msvc.application.ports.out.persistence.ICourseRepositoryPort;

public class AssignInstructorUseCaseImpl implements IAssignInstructorUseCase {
    @Override
    public void assignInstructor(Long instructorId, Long idCourse) throws CourseNotFoundException {

    }
}
