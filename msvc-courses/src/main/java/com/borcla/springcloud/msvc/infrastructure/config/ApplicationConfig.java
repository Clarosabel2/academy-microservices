package com.borcla.springcloud.msvc.infrastructure.config;

import com.borcla.springcloud.msvc.application.services.CourseService;
import com.borcla.springcloud.msvc.domain.ports.in.*;
import com.borcla.springcloud.msvc.domain.ports.out.persistence.ICourseRepositoryPort;
import com.borcla.springcloud.msvc.application.usecase.*;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa.CourseJpaPersistenceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public CourseService courseService(
            ICourseRepositoryPort courseRepositoryPort
    ) {
        return new CourseService(
                new CreateCourseUseCaseImpl(courseRepositoryPort),
                new DeleteCourseUseCaseImpl(courseRepositoryPort),
                new ListCoursesUseCaseImpl(courseRepositoryPort),
                new RetrieveCourseUseCaseImpl(courseRepositoryPort),
                new UpdateCourseUseCaseImpl(courseRepositoryPort)
        );
    }

    @Bean
    public ICourseRepositoryPort courseRepositoryPort(CourseJpaPersistenceAdapter  courseJpaPersistenceAdapter) {
        return courseJpaPersistenceAdapter;
    }
}
