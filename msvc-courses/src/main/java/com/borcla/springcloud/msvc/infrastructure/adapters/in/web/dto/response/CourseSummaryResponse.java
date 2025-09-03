package com.borcla.springcloud.msvc.infrastructure.adapters.in.web.dto.response;

public record CourseSummaryResponse(
        Long id,
        String courseName,
        String description
) {
}
