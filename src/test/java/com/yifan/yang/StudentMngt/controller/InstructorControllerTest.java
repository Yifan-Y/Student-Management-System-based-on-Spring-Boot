package com.yifan.yang.StudentMngt.controller;

import com.yifan.yang.StudentMngt.entity.Instructor;
import com.yifan.yang.StudentMngt.service.InstructorService;
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

class InstructorControllerTest {

    @InjectMocks
    private InstructorController instructorController;

    @Mock
    private InstructorService instructorService;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("List instructors")
    void listInstructors() {
        Instructor instructor = new Instructor();
        List<Instructor> instructors = Arrays.asList(instructor);
        when(instructorService.findAll()).thenReturn(instructors);
        String viewName = instructorController.listInstructors(model);
        verify(model, times(1)).addAttribute("instructors", instructors);
        assertEquals("instructors/list-instructors", viewName);
    }

    @Test
    @DisplayName("Show form for add")
    void showFormForAdd() {
        String viewName = instructorController.showFormForAdd(model);
        verify(model, times(1)).addAttribute(eq("instructor"), any(Instructor.class));
        assertEquals("instructors/instructor-form", viewName);
    }

    @Test
    @DisplayName("Save instructor")
    void saveInstructor() {
        Instructor instructor = new Instructor();
        String viewName = instructorController.saveInstructor(instructor);
        verify(instructorService, times(1)).save(instructor);
        assertEquals("redirect:/instructors/list", viewName);
    }

    @Test
    @DisplayName("Show form for update")
    void showFormForUpdate() {
        Instructor instructor = new Instructor();
        when(instructorService.findById(anyInt())).thenReturn(instructor);
        String viewName = instructorController.showFormForUpdate(1, model);
        verify(model, times(1)).addAttribute("instructor", instructor);
        assertEquals("instructors/instructor-form", viewName);
    }

    @Test
    @DisplayName("Delete instructor")
    void delete() {
        String viewName = instructorController.delete(1);
        verify(instructorService, times(1)).deleteById(1);
        assertEquals("redirect:/instructors/list", viewName);
    }
}