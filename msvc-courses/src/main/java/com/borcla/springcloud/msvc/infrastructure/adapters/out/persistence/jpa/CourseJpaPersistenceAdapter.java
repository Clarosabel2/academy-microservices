package com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa;

import com.borcla.springcloud.msvc.domain.ports.out.persistence.ICourseRepositoryPort;
import com.borcla.springcloud.msvc.domain.model.Course;
import com.borcla.springcloud.msvc.domain.model.enums.CourseStatus;
import com.borcla.springcloud.msvc.domain.pagination.PageResult;
import com.borcla.springcloud.msvc.domain.pagination.PaginationRequest;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa.mapper.ICourseJpaMapper;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa.repository.JpaCourseRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CourseJpaPersistenceAdapter implements ICourseRepositoryPort {

    private final ICourseJpaMapper courseJpaMapper;
    private  final JpaCourseRepository jpaRepo;

    public CourseJpaPersistenceAdapter(ICourseJpaMapper courseJpaMapper, JpaCourseRepository jpaCourseRepository) {
        this.courseJpaMapper = courseJpaMapper;
        this.jpaRepo = jpaCourseRepository;
    }

    @Override
    public Course save(Course course) {
        return courseJpaMapper.toDomain(
                        jpaRepo.save(courseJpaMapper.toEntity(course)));
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
    public Optional<Course>  findById(Long id) {
        return jpaRepo.findById(id).map(courseJpaMapper::toDomain);
    }

    @Override
    public Optional<Course> findByCode(String code) {
        return jpaRepo.findByCode(code).map(courseJpaMapper::toDomain);
    }

    @Override
    public Optional<Course> findByName(String name) {
        return jpaRepo.findByName(name).map(courseJpaMapper::toDomain);
    }

    @Override
    public PageResult<Course> findAll(PaginationRequest pagination) {
        return null;
    }

    @Override
    public PageResult<Course> findByInstructor(Long instructorId, PaginationRequest pagination) {
        return null;
    }

    @Override
    public PageResult<Course> findByStatus(CourseStatus status, PaginationRequest pagination) {
        return null;
    }

    @Override
    public List<Course> findLatest(int limit) {
        return List.of();
    }
}
