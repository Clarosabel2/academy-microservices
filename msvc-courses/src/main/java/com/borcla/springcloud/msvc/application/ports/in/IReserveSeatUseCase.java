package com.borcla.springcloud.msvc.application.ports.in;

import com.borcla.springcloud.msvc.domain.exception.CourseFullException;
import com.borcla.springcloud.msvc.application.exception.CourseNotFoundException;

public interface IReserveSeatUseCase {
    void reserve(Long idCourse) throws CourseNotFoundException, CourseFullException;
}
