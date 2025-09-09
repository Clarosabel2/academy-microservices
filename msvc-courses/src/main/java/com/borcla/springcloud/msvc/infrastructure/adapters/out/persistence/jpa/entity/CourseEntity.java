package com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.jpa.entity;

import com.borcla.springcloud.msvc.domain.model.enums.CourseStatus;
import com.borcla.springcloud.msvc.domain.model.enums.Level;
import com.borcla.springcloud.msvc.domain.model.enums.Modality;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courses")
public class CourseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String code;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private CourseStatus status;

    @Enumerated(EnumType.STRING)
    private Modality modality;
    @Enumerated(EnumType.STRING)
    private Level level;
    private String language;

    private Integer capacity;
    private Integer enrolledCount;

    private LocalDate startDate;
    private LocalDate endDate;

    @Column(precision = 12, scale = 2)
    private BigDecimal price;
    @Column(length = 3)
    private String currency;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "course_instructor", joinColumns = @JoinColumn(name = "course_id"))
    @Column(name = "instructor_id", nullable = false)
    private Set<Long> instructorIds;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "course_tag", joinColumns = @JoinColumn(name = "course_id"))
    @Column(name = "tag", length = 50)
    private Set<String> tags;

    private Instant createdAt;
    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;
}
