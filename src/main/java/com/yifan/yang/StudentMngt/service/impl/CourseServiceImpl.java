package com.yifan.yang.StudentMngt.service.impl;

import com.yifan.yang.StudentMngt.dao.CourseRepository;
import com.yifan.yang.StudentMngt.entity.Course;
import com.yifan.yang.StudentMngt.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository theCourseRepository) {
        courseRepository = theCourseRepository;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int theId) {
        Optional<Course> result = courseRepository.findById(theId);
        Course theCourse = null;
        if(result.isPresent()) {
            theCourse = result.get();
        } else {
            throw new RuntimeException("Cannot find course by ID: " + theId);
        }
        return theCourse;
    }

    @Override
    public List<Course> findByCourseTitle(String theTitle) {
        List<Course> result = courseRepository.findByCourseTitle(theTitle);
        List<Course> theCourses = null;
        if(!result.isEmpty()) {
            theCourses.addAll(result);
        } else {
            throw new RuntimeException("Cannot find course by Title: " + theTitle);
        }
        return theCourses;
    }

    @Override
    public void save(Course theCourse) {
        courseRepository.save(theCourse);
    }

    @Override
    public void deleteById(int theId) {
        courseRepository.deleteById(theId);
    }
}
