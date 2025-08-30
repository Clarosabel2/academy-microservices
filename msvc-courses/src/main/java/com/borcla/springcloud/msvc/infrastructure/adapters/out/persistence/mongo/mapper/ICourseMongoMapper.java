package com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.mongo.mapper;

import com.borcla.springcloud.msvc.domain.model.Course;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.mongo.document.CourseDocument;
import org.mapstruct.Mapper;

@Mapper
public interface ICourseMongoMapper {
    CourseDocument toDocument(Course course);
    Course toDomain(CourseDocument doc);
}
