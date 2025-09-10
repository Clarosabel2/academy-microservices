package com.borcla.springcloud.msvc.infrastructure.adapters.in.web.controller;

import com.borcla.springcloud.msvc.application.exception.CourseNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<Void> handleCourseNotFoundException(CourseNotFoundException ex) {
        log.error("Course not found", ex);
        return ResponseEntity.notFound().build();
    }
}
