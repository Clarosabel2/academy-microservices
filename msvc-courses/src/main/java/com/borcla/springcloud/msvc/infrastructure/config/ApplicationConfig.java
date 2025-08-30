package com.borcla.springcloud.msvc.infrastructure.config;

import com.borcla.springcloud.msvc.application.ports.in.*;
import com.borcla.springcloud.msvc.application.ports.out.persistence.ICourseRepositoryPort;
import com.borcla.springcloud.msvc.application.usecase.*;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa.CourseJpaPersistenceAdapter;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.mongo.CourseMongoPersistenceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfig {

    @Bean
    public ICreateCourseUseCase createCourseUseCase(ICourseRepositoryPort courseRepository) {
        return new CreateCourseUseCaseImpl(courseRepository);
    }
    @Bean
    public IRetrieveCourseUseCase retrieveCourseUseCase(ICourseRepositoryPort courseRepository) {
        return new RetrieveCourseUseCaseImpl(courseRepository);
    }

    @Bean
    public IUpdateCourseUseCase updateCourseUseCase(ICourseRepositoryPort courseRepository) {
        return new UpdateCourseUseCaseImpl(courseRepository);
    }

    @Bean
    public IDeleteCourseUseCase deleteCourseUseCase(ICourseRepositoryPort courseRepository) {
        return new DeleteCourseUseCaseImpl(courseRepository);
    }

    @Bean
    public IListCoursesUseCase listCoursesUseCase(ICourseRepositoryPort courseRepository) {
        return new ListCoursesUseCaseImpl(courseRepository);
    }
}
