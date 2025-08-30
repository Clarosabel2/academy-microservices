package com.borcla.springcloud.msvc.application.usecase;

import com.borcla.springcloud.msvc.application.exception.CourseNotFoundException;
import com.borcla.springcloud.msvc.application.ports.in.IReserveSeatUseCase;
import com.borcla.springcloud.msvc.domain.exception.CourseFullException;

public class ReserveSeatUseCaseImpl implements IReserveSeatUseCase {
    @Override
    public void reserve(Long idCourse) throws CourseNotFoundException, CourseFullException {

    }
}
