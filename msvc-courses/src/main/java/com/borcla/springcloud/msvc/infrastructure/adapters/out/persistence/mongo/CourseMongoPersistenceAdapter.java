package com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.mongo;

import com.borcla.springcloud.msvc.domain.ports.out.persistence.ICourseRepositoryPort;
import com.borcla.springcloud.msvc.domain.model.Course;
import com.borcla.springcloud.msvc.domain.model.enums.CourseStatus;
import com.borcla.springcloud.msvc.domain.pagination.PageResult;
import com.borcla.springcloud.msvc.domain.pagination.PaginationRequest;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.mongo.document.CourseDocument;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.mongo.mapper.ICourseMongoMapper;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.mongo.repository.CourseMongoRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
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
//        CourseDocument document = courseMongoMapper.toDocument(course);
//        document.setId(idCourse);
//        CourseDocument saved = courseMongoRepository.save(document);
//        return courseMongoMapper.toDomain(saved);
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        if (!courseMongoRepository.existsById(id)) {
            return false;
        }
        courseMongoRepository.deleteById(id);
        return true;
    }

    @Override
    public Optional<Course> findById(Long id) {
        return null;
    }

    @Override
    public Optional<Course> findByCode(String code) {
        return null;
    }

    @Override
    public Optional<Course> findByName(String name) {
        return null;
    }

    @Override
    public PageResult<Course> findAll(PaginationRequest pagination) {
        PageRequest pageRequest = PageRequest.of(pagination.getPage(), pagination.getSize());
        Page<CourseDocument> page = courseMongoRepository.findAll(pageRequest);
        return toPageResult(page);
    }

    @Override
    public PageResult<Course> findByInstructor(Long instructorId, PaginationRequest pagination) {
        PageRequest pageRequest = PageRequest.of(pagination.getPage(), pagination.getSize());
        Page<CourseDocument> page = courseMongoRepository.findByInstructorIdsContains(instructorId, pageRequest);
        return toPageResult(page);
    }

    @Override
    public PageResult<Course> findByStatus(CourseStatus status, PaginationRequest pagination) {
        PageRequest pageRequest = PageRequest.of(pagination.getPage(), pagination.getSize());
        Page<CourseDocument> page = courseMongoRepository.findByStatus(status, pageRequest);
        return toPageResult(page);
    }

    @Override
    public List<Course> findLatest(int limit) {
        PageRequest pageRequest = PageRequest.of(0, limit);
        Page<CourseDocument> page = courseMongoRepository.findAllByOrderByCreatedAtDesc(pageRequest);
        return page.getContent().stream().map(courseMongoMapper::toDomain).toList();
    }

    private PageResult<Course> toPageResult(Page<CourseDocument> page) {
        List<Course> items = page.getContent().stream().map(courseMongoMapper::toDomain).toList();
        return new PageResult<>(items, page.getTotalElements());
    }
}
