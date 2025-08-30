package com.borcla.springcloud.msvc.application.usecase;

import com.borcla.springcloud.msvc.application.exception.CourseNotFoundException;
import com.borcla.springcloud.msvc.application.ports.in.IRemoveInstructorUseCase;

public class RemoveInstructorUseCaseImpl implements IRemoveInstructorUseCase {
    @Override
    public void removeInstructor(Long instructorId, Long idCourse) throws CourseNotFoundException {

    }
}
