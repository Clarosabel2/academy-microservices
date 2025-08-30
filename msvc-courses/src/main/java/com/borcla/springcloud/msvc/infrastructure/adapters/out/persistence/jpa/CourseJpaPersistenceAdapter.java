package com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa;

import com.borcla.springcloud.msvc.application.ports.out.persistence.ICourseRepositoryPort;
import com.borcla.springcloud.msvc.domain.model.Course;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa.entity.CourseEntity;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa.mapper.ICourseJpaMapper;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa.repository.JpaCourseRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Profile("jpa")
@Component
public class CourseJpaPersistenceAdapter implements ICourseRepositoryPort {
    private final JpaCourseRepository jpaCourseRepository;
    private final ICourseJpaMapper courseJpaMapper;

    public CourseJpaPersistenceAdapter(JpaCourseRepository jpaCourseRepository, ICourseJpaMapper courseJpaMapper) {
        this.jpaCourseRepository = jpaCourseRepository;
        this.courseJpaMapper = courseJpaMapper;
    }


    @Override
    public Course save(Course course) {
        CourseEntity entity = courseJpaMapper.toEntity(course);
        CourseEntity saved  = jpaCourseRepository.save(entity);
        return courseJpaMapper.toDomain(saved);
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
