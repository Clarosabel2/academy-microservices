package com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa.mapper;

import com.borcla.springcloud.msvc.domain.model.Course;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa.entity.CourseEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ICourseJpaMapper {
    CourseEntity toEntity(Course course);
    Course toDomain(CourseEntity courseEntity);
}
