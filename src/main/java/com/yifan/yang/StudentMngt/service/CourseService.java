package com.yifan.yang.StudentMngt.service;

import com.yifan.yang.StudentMngt.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    public List<Course> findAll();
    public Course findById(int theId);
    public List<Course> findByCourseTitle(String theTitle);
    public void save(Course theCourse);
    public void deleteById(int theId);
}
