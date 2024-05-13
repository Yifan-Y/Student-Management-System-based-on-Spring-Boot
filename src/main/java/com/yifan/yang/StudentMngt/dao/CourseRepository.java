package com.yifan.yang.StudentMngt.dao;

import com.yifan.yang.StudentMngt.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    public List<Course> findAllByOrderByCodeAsc();
    public List<Course> findByCourseTitle(String theTitle);
}
