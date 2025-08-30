package com.borcla.springcloud.msvc.application.usecase;

import com.borcla.springcloud.msvc.application.exception.CourseNotFoundException;
import com.borcla.springcloud.msvc.application.ports.in.IReleaseSeatUseCase;
import com.borcla.springcloud.msvc.domain.exception.CourseFullException;

public class ReleaseSeatUseCaseImpl implements IReleaseSeatUseCase {
    @Override
    public void releaseSeat(Long idCourse) throws CourseNotFoundException, CourseFullException {

    }

    @Override
    public void releaseSeatByName(String name) throws CourseNotFoundException, CourseFullException {

    }
}
