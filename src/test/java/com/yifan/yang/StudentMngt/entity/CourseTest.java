package com.yifan.yang.StudentMngt.entity;

import com.yifan.yang.StudentMngt.entity.Course;
import com.yifan.yang.StudentMngt.entity.Department;
import com.yifan.yang.StudentMngt.entity.Instructor;
import com.yifan.yang.StudentMngt.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CourseTest {

    private Course course;

    @BeforeEach
    void setUp() {
        course = new Course();
    }

    @Test
    @DisplayName("Course fields are set correctly")
    void courseFieldsAreSetCorrectly() {
        Department department = new Department();
        Instructor instructor = new Instructor();
        Student student = new Student();

        course.setCode("CS101");
        course.setCourseTitle("Computer Science 101");
        course.setMaxCapacity(30);
        course.setCredit(3);
        course.setCourseLevel("Undergraduate");
        course.setDepartment(department);
        course.setInstructor(instructor);
        course.setStudents(Collections.singletonList(student));

        assertEquals("CS101", course.getCode());
        assertEquals("Computer Science 101", course.getCourseTitle());
        assertEquals(30, course.getMaxCapacity());
        assertEquals(3, course.getCredit());
        assertEquals("Undergraduate", course.getCourseLevel());
        assertEquals(department, course.getDepartment());
        assertEquals(instructor, course.getInstructor());
        assertNotNull(course.getStudents());
        assertEquals(1, course.getStudents().size());
    }
}