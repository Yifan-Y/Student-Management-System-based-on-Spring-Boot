package com.yifan.yang.StudentMngt.controller;

import com.yifan.yang.StudentMngt.entity.Student;
import com.yifan.yang.StudentMngt.service.StudentService;
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

class StudentControllerTest {

    @InjectMocks
    StudentController studentController;

    @Mock
    StudentService studentService;

    @Mock
    Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("List all students")
    void listStudents() {
        Student student1 = new Student();
        Student student2 = new Student();
        when(studentService.findAll()).thenReturn(Arrays.asList(student1, student2));

        String viewName = studentController.listStudents(model);

        verify(studentService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("students"), anyList());
        assertEquals("students/list-students", viewName);
    }

    @Test
    @DisplayName("Show form for adding a student")
    void showFormForAdd() {
        String viewName = studentController.showFormForAdd(model);

        verify(model, times(1)).addAttribute(eq("student"), any(Student.class));
        assertEquals("students/student-form", viewName);
    }

    @Test
    @DisplayName("Save a student")
    void saveStudent() {
        Student student = new Student();
        String viewName = studentController.saveStudent(student);

        verify(studentService, times(1)).save(student);
        assertEquals("redirect:/students/list", viewName);
    }

    @Test
    @DisplayName("Show form for updating a student")
    void showFormForUpdate() {
        Student student = new Student();
        when(studentService.findById(anyInt())).thenReturn(student);

        String viewName = studentController.showFormForUpdate(1, model);

        verify(studentService, times(1)).findById(1);
        verify(model, times(1)).addAttribute("student", student);
        assertEquals("students/student-form", viewName);
    }

    @Test
    @DisplayName("Delete a student")
    void delete() {
        String viewName = studentController.delete(1);

        verify(studentService, times(1)).deleteById(1);
        assertEquals("redirect:/students/list", viewName);
    }

    @Test
    @DisplayName("Search for students by first and last name")
    void search() {
        Student student1 = new Student();
        Student student2 = new Student();
        when(studentService.findBy(anyString(), anyString())).thenReturn(Arrays.asList(student1, student2));

        String viewName = studentController.search("John", "Doe", model);

        verify(studentService, times(1)).findBy("John", "Doe");
        verify(model, times(1)).addAttribute("students", Arrays.asList(student1, student2));
        assertEquals("students/list-students", viewName);
    }
}