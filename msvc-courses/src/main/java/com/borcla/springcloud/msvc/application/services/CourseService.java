package com.borcla.springcloud.msvc.application.services;

import com.borcla.springcloud.msvc.application.exception.CourseNotFoundException;
import com.borcla.springcloud.msvc.domain.model.Course;
import com.borcla.springcloud.msvc.domain.model.enums.CourseStatus;
import com.borcla.springcloud.msvc.domain.pagination.PageResult;
import com.borcla.springcloud.msvc.domain.pagination.PaginationRequest;
import com.borcla.springcloud.msvc.domain.ports.in.*;

import java.util.List;
import java.util.Optional;

public class CourseService implements
        ICreateCourseUseCase,
        IDeleteCourseUseCase,
        IListCoursesUseCase,
        IRetrieveCourseUseCase,
        IUpdateCourseUseCase {

    private final ICreateCourseUseCase createCourseUseCase;
    private final IDeleteCourseUseCase deleteCourseUseCase;
    private final IListCoursesUseCase listCoursesUseCase;
    private final IRetrieveCourseUseCase retrieveCourseUseCase;
    private final IUpdateCourseUseCase updateCourseUseCase;

    public CourseService(ICreateCourseUseCase createCourseUseCase, IDeleteCourseUseCase deleteCourseUseCase, IListCoursesUseCase listCoursesUseCase, IRetrieveCourseUseCase retrieveCourseUseCase, IUpdateCourseUseCase updateCourseUseCase) {
        this.createCourseUseCase = createCourseUseCase;
        this.deleteCourseUseCase = deleteCourseUseCase;
        this.listCoursesUseCase = listCoursesUseCase;
        this.retrieveCourseUseCase = retrieveCourseUseCase;
        this.updateCourseUseCase = updateCourseUseCase;
    }

    @Override
    public Course createCourse(Course course) {
        return createCourseUseCase.createCourse(course);
    }

    @Override
    public boolean deleteCourseById(Long id) throws CourseNotFoundException {
        return deleteCourseUseCase.deleteCourseById(id);
    }

    @Override
    public boolean deleteCourseByName(String name) throws CourseNotFoundException {
        return deleteCourseUseCase.deleteCourseByName(name);
    }

    @Override
    public boolean deleteCourseByCourseCode(String code) throws CourseNotFoundException {
        return deleteCourseUseCase.deleteCourseByCourseCode(code);
    }

    @Override
    public PageResult<Course> list(PaginationRequest pagination) {
        return listCoursesUseCase.list(pagination);
    }

    @Override
    public PageResult<Course> listByInstructor(Long instructorId, PaginationRequest pagination) {
        return listCoursesUseCase.listByInstructor(instructorId, pagination);
    }

    @Override
    public PageResult<Course> listByStatus(CourseStatus status, PaginationRequest pagination) {
        return listCoursesUseCase.listByStatus(status, pagination);
    }

    @Override
    public List<Course> listLatest(int limit) {
        return List.of();
    }

    @Override
    public Course getCourseById(Long idCourse) throws CourseNotFoundException {
        return retrieveCourseUseCase.getCourseById(idCourse);
    }

    @Override
    public Course getCourseByCode(String codeCourse) throws CourseNotFoundException {
        return retrieveCourseUseCase.getCourseByCode(codeCourse);
    }

    @Override
    public Course getCourseByName(String nameCourse) throws CourseNotFoundException {
        return retrieveCourseUseCase.getCourseByName(nameCourse);
    }

    @Override
    public Course updateCourse(Long idCourse, Course course) {
        return updateCourseUseCase.updateCourse(idCourse, course);
    }
}
