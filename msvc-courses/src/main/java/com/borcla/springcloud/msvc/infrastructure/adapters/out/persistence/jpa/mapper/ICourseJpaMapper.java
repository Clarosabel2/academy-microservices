package com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa.mapper;

import com.borcla.springcloud.msvc.domain.model.Course;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa.entity.CourseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICourseJpaMapper {
    CourseEntity toEntity(Course course);
    default Course toDomain(CourseEntity courseEntity) {
        if (courseEntity == null) {
            return null;
        }
        Course course = new Course(
                courseEntity.getName(),
                courseEntity.getDescription(),
                courseEntity.getEndDate()
        );
        course.setId(courseEntity.getId());
        course.setCode(courseEntity.getCode());
        course.setStatus(courseEntity.getStatus());
        course.setModality(courseEntity.getModality());
        course.setLevel(courseEntity.getLevel());
        course.setLanguage(courseEntity.getLanguage());
        course.setCapacity(courseEntity.getCapacity());
        course.setEnrolledCount(courseEntity.getEnrolledCount());
        course.setStartDate(courseEntity.getStartDate());
        course.setPrice(courseEntity.getPrice());
        course.setCurrency(courseEntity.getCurrency());
        course.setInstructorIds(courseEntity.getInstructorIds());
        course.setTags(courseEntity.getTags());
        course.setCreatedAt(courseEntity.getCreatedAt());
        course.setUpdatedAt(courseEntity.getUpdatedAt());
        return course;
    }
}
