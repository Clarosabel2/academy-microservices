package com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa.repository;

import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCourseRepository extends JpaRepository<CourseEntity, Long> {
}
