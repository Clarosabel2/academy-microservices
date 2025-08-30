package com.borcla.springcloud.msvc.infrastructure.adapters.in.web.dto;

import java.time.LocalDate;

public record CourseRequestDTO(
        String courseName,
        String description,
        LocalDate endDate
) {
}
