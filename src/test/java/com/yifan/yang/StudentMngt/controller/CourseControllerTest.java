package com.yifan.yang.StudentMngt.controller;

import com.yifan.yang.StudentMngt.entity.Course;
import com.yifan.yang.StudentMngt.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CourseControllerTest {

    @InjectMocks
    private CourseController courseController;

    @Mock
    private CourseService courseService;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("List courses")
    void listCourses() {
        Course course = new Course();
        List<Course> courses = Arrays.asList(course);
        when(courseService.findAll()).thenReturn(courses);
        String viewName = courseController.listCourses(model);
        verify(model, times(1)).addAttribute("courses", courses);
        assertEquals("courses/list-courses", viewName);
    }

    @Test
    @DisplayName("Show form for add")
    void showFormForAdd() {
        String viewName = courseController.showFormForAdd(model);
        verify(model, times(1)).addAttribute(eq("course"), any(Course.class));
        assertEquals("courses/course-form", viewName);
    }

    @Test
    @DisplayName("Save course")
    void saveCourse() {
        Course course = new Course();
        String viewName = courseController.saveCourse(course);
        verify(courseService, times(1)).save(course);
        assertEquals("redirect:/courses/list", viewName);
    }

    @Test
    @DisplayName("Show form for update")
    void showFormForUpdate() {
        Course course = new Course();
        when(courseService.findById(anyInt())).thenReturn(course);
        String viewName = courseController.showFormForUpdate(1, model);
        verify(model, times(1)).addAttribute("course", course);
        assertEquals("courses/course-form", viewName);
    }

    @Test
    @DisplayName("Delete course")
    void delete() {
        String viewName = courseController.delete(1);
        verify(courseService, times(1)).deleteById(1);
        assertEquals("redirect:/courses/list", viewName);
    }
}
