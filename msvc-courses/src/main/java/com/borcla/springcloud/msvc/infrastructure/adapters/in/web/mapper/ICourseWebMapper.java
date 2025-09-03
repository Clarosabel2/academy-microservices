package com.borcla.springcloud.msvc.infrastructure.adapters.in.web.mapper;

import com.borcla.springcloud.msvc.domain.model.Course;
import com.borcla.springcloud.msvc.infrastructure.adapters.in.web.dto.response.CourseCreatedResponse;
import com.borcla.springcloud.msvc.infrastructure.adapters.in.web.dto.response.CourseSummaryResponse;
import org.mapstruct.Mapper;

@Mapper
public interface ICourseWebMapper {
    CourseCreatedResponse toDto(Course course);
    CourseSummaryResponse toSummaryDto(Course course);
    Course toDomain(CourseCreatedResponse dto);
}
