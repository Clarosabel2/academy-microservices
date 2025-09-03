package com.borcla.springcloud.msvc.domain.ports.in;

import com.borcla.springcloud.msvc.application.exception.CourseNotFoundException;
import com.borcla.springcloud.msvc.domain.exception.CourseFullException;

public interface IReleaseSeatUseCase {
    void releaseSeat(Long idCourse) throws CourseNotFoundException, CourseFullException;
    void releaseSeatByName(String name) throws  CourseNotFoundException, CourseFullException;
}
