package com.yifan.yang.StudentMngt.service.impl;

import com.yifan.yang.StudentMngt.dao.InstructorRepository;
import com.yifan.yang.StudentMngt.entity.Instructor;
import com.yifan.yang.StudentMngt.service.impl.InstructorServiceImpl;
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

class InstructorServiceImplTest {

    @InjectMocks
    private InstructorServiceImpl instructorService;

    @Mock
    private InstructorRepository instructorRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Find all instructors")
    void findAll() {
        Instructor instructor = new Instructor();
        List<Instructor> instructors = Arrays.asList(instructor);
        when(instructorRepository.findAllByOrderByLastNameAsc()).thenReturn(instructors);
        List<Instructor> result = instructorService.findAll();
        assertEquals(instructors, result);
    }

    @Test
    @DisplayName("Find instructor by last name")
    void findByLastName() {
        Instructor instructor = new Instructor();
        instructor.setLastName("Smith");
        when(instructorRepository.findByLastName("Smith")).thenReturn(Arrays.asList(instructor));
        List<Instructor> result = instructorService.findByLastName("Smith");
        assertEquals(1, result.size());
        assertEquals("Smith", result.get(0).getLastName());
    }

    @Test
    @DisplayName("Find instructor by id")
    void findById() {
        Instructor instructor = new Instructor();
        instructor.setId(1);
        when(instructorRepository.findById(1)).thenReturn(Optional.of(instructor));
        Instructor result = instructorService.findById(1);
        assertEquals(1, result.getId());
    }

    @Test
    @DisplayName("Save instructor")
    void save() {
        Instructor instructor = new Instructor();
        instructorService.save(instructor);
        verify(instructorRepository, times(1)).save(instructor);
    }

    @Test
    @DisplayName("Delete instructor by id")
    void deleteById() {
        instructorService.deleteById(1);
        verify(instructorRepository, times(1)).deleteById(1);
    }
}