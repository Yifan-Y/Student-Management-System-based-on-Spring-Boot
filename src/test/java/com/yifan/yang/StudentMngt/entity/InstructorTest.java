package com.yifan.yang.StudentMngt.entity;

import com.yifan.yang.StudentMngt.entity.Course;
import com.yifan.yang.StudentMngt.entity.Department;
import com.yifan.yang.StudentMngt.entity.Instructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class InstructorTest {

    @InjectMocks
    private Instructor instructor;

    @Mock
    private Department department;

    @Mock
    private List<Course> courses;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Set and get department")
    void department() {
        instructor.setDepartment(department);
        assertEquals(department, instructor.getDepartment());
    }

    @Test
    @DisplayName("Set and get courses")
    void courses() {
        Course course = new Course();
        courses = Arrays.asList(course);
        instructor.setCourses(courses);
        assertEquals(courses, instructor.getCourses());
    }
}