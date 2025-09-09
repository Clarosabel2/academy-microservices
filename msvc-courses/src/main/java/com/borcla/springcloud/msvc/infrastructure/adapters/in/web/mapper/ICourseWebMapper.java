package com.borcla.springcloud.msvc.infrastructure.adapters.in.web.mapper;

import com.borcla.springcloud.msvc.domain.model.Course;
import com.borcla.springcloud.msvc.infrastructure.adapters.in.web.dto.response.CourseCreatedResponse;
import com.borcla.springcloud.msvc.infrastructure.adapters.in.web.dto.response.CourseSummaryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

    @Mapper(componentModel = "spring")
    public interface ICourseWebMapper {
        CourseCreatedResponse toDto(Course course);
        @Mapping(source = "id", target = "id")
        @Mapping(source = "name", target = "courseName")
        @Mapping(source = "description", target = "description")
        CourseSummaryResponse toSummaryDto(Course course);
        Course toDomain(CourseCreatedResponse dto);
    }
