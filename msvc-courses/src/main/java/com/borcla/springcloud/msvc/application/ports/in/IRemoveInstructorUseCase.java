package com.borcla.springcloud.msvc.application.ports.in;

import com.borcla.springcloud.msvc.application.exception.CourseNotFoundException;
import com.borcla.springcloud.msvc.domain.exception.CourseFullException;

public interface IRemoveInstructorUseCase {
    void removeInstructor(Long instructorId, Long idCourse)  throws CourseNotFoundException;
}
