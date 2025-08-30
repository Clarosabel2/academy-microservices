package com.borcla.springcloud.msvc.application.ports.out;

public interface ICheckInstructorExistsPort {
    boolean exists(Long instructorId);
}
