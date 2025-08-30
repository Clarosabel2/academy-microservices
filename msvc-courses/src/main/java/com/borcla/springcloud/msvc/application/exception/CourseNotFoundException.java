package com.borcla.springcloud.msvc.application.exception;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException() { super("Course not found"); }
}
