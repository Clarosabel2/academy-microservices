package com.borcla.springcloud.msvc.infrastructure.adapters.out.persistence.mongo.document;

import com.borcla.springcloud.msvc.domain.model.enums.CourseStatus;
import com.borcla.springcloud.msvc.domain.model.enums.Level;
import com.borcla.springcloud.msvc.domain.model.enums.Modality;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;

import static org.springframework.data.mongodb.core.mapping.FieldType.DECIMAL128;
import static org.springframework.data.mongodb.core.mapping.FieldType.OBJECT_ID;

@Document(collection = "courses")
@CompoundIndexes({
        @CompoundIndex(name = "code_unique", def = "{'code': 1}", unique = true),
        @CompoundIndex(name = "status_start_idx", def = "{'status': 1, 'startDate': 1}")
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDocument {
    @MongoId(OBJECT_ID)
    private Long id;
    @Indexed(unique = true)
    private String code;
    private String name;
    private String description;
    private CourseStatus status;

    private Modality modality;
    private Level level;
    private String language;

    private Integer capacity;
    private Integer enrolledCount;

    private LocalDate startDate;
    private LocalDate endDate;

    @Field(targetType = DECIMAL128)
    private BigDecimal price;
    private String currency;

    @Indexed
    private Set<Long> instructorIds;
    @Indexed
    private Set<String> tags;

    @CreatedDate
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;

}
