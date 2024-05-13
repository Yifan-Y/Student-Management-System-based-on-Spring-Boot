package com.yifan.yang.StudentMngt.service.impl;

import com.yifan.yang.StudentMngt.dao.CourseRepository;
import com.yifan.yang.StudentMngt.entity.Course;
import com.yifan.yang.StudentMngt.service.impl.CourseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CourseServiceImplTest {

    @InjectMocks
    private CourseServiceImpl courseService;

    @Mock
    private CourseRepository courseRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Find all courses")
    void findAll() {
        Course course = new Course();
        List<Course> courses = Arrays.asList(course);
        when(courseRepository.findAll()).thenReturn(courses);
        List<Course> result = courseService.findAll();
        assertEquals(courses, result);
    }

    @Test
    @DisplayName("Find course by id")
    void findById() {
        Course course = new Course();
        course.setId(1);
        when(courseRepository.findById(1)).thenReturn(Optional.of(course));
        Course result = courseService.findById(1);
        assertEquals(1, result.getId());
    }

    @Test
    @DisplayName("Find course by title")
    void findByCourseTitle() {
        Course course = new Course();
        course.setCourseTitle("Computer Science");
        when(courseRepository.findByCourseTitle("Computer Science")).thenReturn(Arrays.asList(course));
        List<Course> result = courseService.findByCourseTitle("Computer Science");
        assertEquals(1, result.size());
        assertEquals("Computer Science", result.get(0).getCourseTitle());
    }

    @Test
    @DisplayName("Save course")
    void save() {
        Course course = new Course();
        courseService.save(course);
        verify(courseRepository, times(1)).save(course);
    }

    @Test
    @DisplayName("Delete course by id")
    void deleteById() {
        courseService.deleteById(1);
        verify(courseRepository, times(1)).deleteById(1);
    }
}