package com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.mongo.repository;

import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.mongo.document.CourseDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseMongoRepository extends MongoRepository<CourseDocument, Long> {
}
