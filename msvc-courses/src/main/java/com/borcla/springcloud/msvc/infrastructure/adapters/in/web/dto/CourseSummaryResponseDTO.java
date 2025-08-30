package com.borcla.springcloud.msvc.infrastructure.adapters.in.web.dto;

public record CourseSummaryResponseDTO(
        Long id,
        String courseName,
        String description
) {
}
