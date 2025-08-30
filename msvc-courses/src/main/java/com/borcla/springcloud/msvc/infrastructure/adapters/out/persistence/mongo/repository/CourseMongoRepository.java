package com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.mongo.repository;

import com.borcla.springcloud.msvc.domain.model.enums.CourseStatus;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.mongo.document.CourseDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CourseMongoRepository extends MongoRepository<CourseDocument, Long> {
    Page<CourseDocument> findByInstructorIdsContains(Long instructorId, Pageable pageable);
    Page<CourseDocument> findByStatus(CourseStatus status, Pageable pageable);
    Page<CourseDocument> findAllByOrderByCreatedAtDesc(Pageable pageable);

    Optional<CourseDocument> findByCode(String code);
    Optional<CourseDocument> findByName(String name);
}
