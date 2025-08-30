package com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa;

import com.borcla.springcloud.msvc.application.ports.out.persistence.ICourseRepositoryPort;
import com.borcla.springcloud.msvc.domain.model.Course;
import com.borcla.springcloud.msvc.domain.model.enums.CourseStatus;
import com.borcla.springcloud.msvc.domain.pagination.PageResult;
import com.borcla.springcloud.msvc.domain.pagination.PaginationRequest;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa.entity.CourseEntity;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa.mapper.ICourseJpaMapper;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa.repository.JpaCourseRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
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

    @Override
    public PageResult<Course> findAll(PaginationRequest pagination) {
        PageRequest pageRequest = PageRequest.of(pagination.getPage(), pagination.getSize());
        Page<CourseEntity> page = jpaCourseRepository.findAll(pageRequest);
        return toPageResult(page);
    }

    @Override
    public PageResult<Course> findByInstructor(Long instructorId, PaginationRequest pagination) {
        PageRequest pageRequest = PageRequest.of(pagination.getPage(), pagination.getSize());
        Page<CourseEntity> page = jpaCourseRepository.findByInstructorIdsContains(instructorId, pageRequest);
        return toPageResult(page);
    }

    @Override
    public PageResult<Course> findByStatus(CourseStatus status, PaginationRequest pagination) {
        PageRequest pageRequest = PageRequest.of(pagination.getPage(), pagination.getSize());
        Page<CourseEntity> page = jpaCourseRepository.findByStatus(status, pageRequest);
        return toPageResult(page);
    }

    @Override
    public List<Course> findLatest(int limit) {
        PageRequest pageRequest = PageRequest.of(0, limit);
        Page<CourseEntity> page = jpaCourseRepository.findAllByOrderByCreatedAtDesc(pageRequest);
        return page.getContent().stream().map(courseJpaMapper::toDomain).toList();
    }

    private PageResult<Course> toPageResult(Page<CourseEntity> page) {
        List<Course> items = page.getContent().stream().map(courseJpaMapper::toDomain).toList();
        return new PageResult<>(items, page.getTotalElements());
    }
}
