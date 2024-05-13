package com.yifan.yang.StudentMngt.service.impl;

import com.yifan.yang.StudentMngt.dao.ProgramRepository;
import com.yifan.yang.StudentMngt.entity.Program;
import com.yifan.yang.StudentMngt.service.impl.ProgramServiceImpl;
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

class ProgramServiceImplTest {

    @InjectMocks
    private ProgramServiceImpl programService;

    @Mock
    private ProgramRepository programRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Find all programs")
    void findAll() {
        Program program = new Program();
        List<Program> programs = Arrays.asList(program);
        when(programRepository.findAllByOrderByProgramTitleAsc()).thenReturn(programs);
        List<Program> result = programService.findAll();
        assertEquals(programs, result);
    }



    @Test
    @DisplayName("Find program by id")
    void findById() {
        Program program = new Program();
        program.setId(1);
        when(programRepository.findById(1)).thenReturn(Optional.of(program));
        Program result = programService.findById(1);
        assertEquals(1, result.getId());
    }

    @Test
    @DisplayName("Save program")
    void save() {
        Program program = new Program();
        programService.save(program);
        verify(programRepository, times(1)).save(program);
    }

    @Test
    @DisplayName("Delete program by id")
    void deleteById() {
        programService.deleteById(1);
        verify(programRepository, times(1)).deleteById(1);
    }
}