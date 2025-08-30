package com.borcla.springcloud.msvc.domain.model;

import com.borcla.springcloud.msvc.domain.model.enums.CourseStatus;
import com.borcla.springcloud.msvc.domain.model.enums.Level;
import com.borcla.springcloud.msvc.domain.model.enums.Modality;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;

public class Course {

    private Long id;
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

    private BigDecimal price;
    private String currency;

    private Set<Long> instructorIds;
    private Set<String> tags;

    private Instant createdAt;
    private Instant updatedAt;

    public Course(String name, String description, LocalDate endDate) {
        this.name = name;
        this.description = description;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
        this.endDate = endDate;
        this.status = CourseStatus.PUBLISHED;
    }

    public void publish() {
        if (status == CourseStatus.ARCHIVED) throw new IllegalStateException("No se publica archivado");
        this.status = CourseStatus.PUBLISHED;
    }

    public void archive() {
        this.status = CourseStatus.ARCHIVED;
    }

    public void reserveSeat() {
        if (capacity == null) return;
        if (enrolledCount >= capacity) throw new IllegalStateException("Curso lleno");
        enrolledCount += 1;
    }

    public void releaseSeat() {
        if (enrolledCount > 0) enrolledCount -= 1;
    }

    public boolean isFull() {
        return capacity != null && enrolledCount >= capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }

    public Modality getModality() {
        return modality;
    }

    public void setModality(Modality modality) {
        this.modality = modality;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getEnrolledCount() {
        return enrolledCount;
    }

    public void setEnrolledCount(Integer enrolledCount) {
        this.enrolledCount = enrolledCount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Set<Long> getInstructorIds() {
        return instructorIds;
    }

    public void setInstructorIds(Set<Long> instructorIds) {
        this.instructorIds = instructorIds;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
