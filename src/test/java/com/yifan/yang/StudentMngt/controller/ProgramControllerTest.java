package com.yifan.yang.StudentMngt.controller;

import com.yifan.yang.StudentMngt.entity.Program;
import com.yifan.yang.StudentMngt.service.ProgramService;
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

class ProgramControllerTest {

    @InjectMocks
    private ProgramController programController;

    @Mock
    private ProgramService programService;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("List programs")
    void listPrograms() {
        Program program = new Program();
        List<Program> programs = Arrays.asList(program);
        when(programService.findAll()).thenReturn(programs);
        String viewName = programController.listPrograms(model);
        verify(model, times(1)).addAttribute("programs", programs);
        assertEquals("programs/list-programs", viewName);
    }

    @Test
    @DisplayName("Show form for add")
    void showFormForAdd() {
        String viewName = programController.showFormForAdd(model);
        verify(model, times(1)).addAttribute(eq("program"), any(Program.class));
        assertEquals("programs/program-form", viewName);
    }

    @Test
    @DisplayName("Save program")
    void saveProgram() {
        Program program = new Program();
        String viewName = programController.saveProgram(program);
        verify(programService, times(1)).save(program);
        assertEquals("redirect:/programs/list", viewName);
    }

    @Test
    @DisplayName("Show form for update")
    void showFormForUpdate() {
        Program program = new Program();
        when(programService.findById(anyInt())).thenReturn(program);
        String viewName = programController.showFormForUpdate(1, model);
        verify(model, times(1)).addAttribute("program", program);
        assertEquals("programs/program-form", viewName);
    }

    @Test
    @DisplayName("Delete program")
    void delete() {
        String viewName = programController.delete(1);
        verify(programService, times(1)).deleteById(1);
        assertEquals("redirect:/programs/list", viewName);
    }
}