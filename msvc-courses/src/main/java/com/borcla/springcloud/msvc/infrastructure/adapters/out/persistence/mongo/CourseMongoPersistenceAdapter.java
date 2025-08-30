package com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.mongo;

import com.borcla.springcloud.msvc.application.ports.out.persistence.ICourseRepositoryPort;
import com.borcla.springcloud.msvc.domain.model.Course;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.mongo.document.CourseDocument;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.mongo.mapper.ICourseMongoMapper;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.mongo.repository.CourseMongoRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Profile("mongo")
@Component
public class CourseMongoPersistenceAdapter implements ICourseRepositoryPort {
    private final CourseMongoRepository courseMongoRepository;
    private final ICourseMongoMapper courseMongoMapper;

    public CourseMongoPersistenceAdapter(CourseMongoRepository courseMongoRepository, ICourseMongoMapper courseMongoMapper) {
        this.courseMongoRepository = courseMongoRepository;
        this.courseMongoMapper = courseMongoMapper;
    }

    @Override
    public Course save(Course course) {
        CourseDocument doc = courseMongoMapper.toDocument(course);
        CourseDocument saved = courseMongoRepository.save(doc);
        return courseMongoMapper.toDomain(saved);
    }

    @Override
    public Course update(Course course, Long idCourse) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public Optional<Course> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Course> findByCode(String code) {
        return Optional.empty();
    }

    @Override
    public Optional<Course> findByName(String name) {
        return Optional.empty();
    }
}
