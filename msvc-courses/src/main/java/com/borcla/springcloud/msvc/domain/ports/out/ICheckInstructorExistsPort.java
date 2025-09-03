package com.borcla.springcloud.msvc.domain.ports.out;

public interface ICheckInstructorExistsPort {
    boolean exists(Long instructorId);
}
