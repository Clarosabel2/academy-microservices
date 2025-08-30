package com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa.repository;

import com.borcla.springcloud.msvc.domain.model.enums.CourseStatus;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa.entity.CourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCourseRepository extends JpaRepository<CourseEntity, Long> {
    Page<CourseEntity> findByInstructorIdsContains(Long instructorId, Pageable pageable);
    Page<CourseEntity> findByStatus(CourseStatus status, Pageable pageable);
    Page<CourseEntity> findAllByOrderByCreatedAtDesc(Pageable pageable);
}
