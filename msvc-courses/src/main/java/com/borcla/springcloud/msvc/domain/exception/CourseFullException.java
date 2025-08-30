package com.borcla.springcloud.msvc.domain.exception;

public class CourseFullException extends Exception {
    private final Long courseId;
    private final Integer capacity;
    private final Integer enrolled;

    public CourseFullException(Long courseId, Integer capacity, Integer enrolled) {
        super(String.format("Course %s is full (capacity=%d, enrolled=%d).", courseId, capacity, enrolled));
        this.courseId = courseId;
        this.capacity = capacity;
        this.enrolled = enrolled;
    }

    public CourseFullException(String message) {
        super(message);
        this.courseId = null;
        this.capacity = null;
        this.enrolled = null;
    }

    public Long getCourseId() { return courseId; }
    public Integer getCapacity() { return capacity; }
    public Integer getEnrolled() { return enrolled; }
}
