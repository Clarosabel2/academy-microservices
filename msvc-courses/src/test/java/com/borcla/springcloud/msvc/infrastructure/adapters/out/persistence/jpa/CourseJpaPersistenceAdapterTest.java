package com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa;

import com.borcla.springcloud.msvc.domain.model.Course;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa.entity.CourseEntity;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa.mapper.ICourseJpaMapper;
import com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa.repository.JpaCourseRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class CourseJpaPersistenceAdapterTest {

    @Test
    void findByIdReturnsCourseWithMandatoryFields() {
        JpaCourseRepository repo = Mockito.mock(JpaCourseRepository.class);
        ICourseJpaMapper mapper = new ICourseJpaMapper() {
            @Override
            public CourseEntity toEntity(Course course) {
                return null;
            }
        };
        CourseEntity entity = new CourseEntity();
        entity.setId(1L);
        entity.setName("Test");
        entity.setDescription("Desc");
        entity.setEndDate(LocalDate.now());

        when(repo.findById(1L)).thenReturn(Optional.of(entity));

        CourseJpaPersistenceAdapter adapter = new CourseJpaPersistenceAdapter(mapper, repo);
        Optional<Course> result = adapter.findById(1L);

        assertTrue(result.isPresent());
        Course course = result.get();
        assertNotNull(course.getName());
        assertNotNull(course.getDescription());
        assertNotNull(course.getEndDate());
    }
}
