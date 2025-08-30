package com.borcla.springcloud.msvc.application.ports.in;

import com.borcla.springcloud.msvc.application.exception.CourseNotFoundException;

public interface IAssignInstructorUseCase {
    void assignInstructor(Long instructorId, Long idCourse) throws CourseNotFoundException;
}
