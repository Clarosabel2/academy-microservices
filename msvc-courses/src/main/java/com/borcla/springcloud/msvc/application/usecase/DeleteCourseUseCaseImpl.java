package com.borcla.springcloud.msvc.application.usecase;

import com.borcla.springcloud.msvc.application.exception.CourseNotFoundException;
import com.borcla.springcloud.msvc.domain.ports.in.IDeleteCourseUseCase;
import com.borcla.springcloud.msvc.domain.ports.out.persistence.ICourseRepositoryPort;

public class DeleteCourseUseCaseImpl implements IDeleteCourseUseCase {
    private final ICourseRepositoryPort courseRepositoryPort;
    public DeleteCourseUseCaseImpl(ICourseRepositoryPort courseRepositoryPort) {
        this.courseRepositoryPort = courseRepositoryPort;
    }

    @Override
    public boolean deleteCourseById(Long id) {
        return courseRepositoryPort.findById(id)
                .map(c -> { courseRepositoryPort.deleteById(id); return true; })
                .orElse(false);
    }

    @Override
    public boolean deleteCourseByCourseCode(String code) {
        return courseRepositoryPort.findByCode(code)
                .map(c -> { courseRepositoryPort.deleteById(c.getId()); return true; })
                .orElse(false);
    }

    @Override
    public boolean deleteCourseByName(String name)  {
        var matches = courseRepositoryPort.findByName(name);
        if (matches.isEmpty()) throw new CourseNotFoundException();
        courseRepositoryPort.deleteById(matches.get().getId());
        return true;
    }
}
