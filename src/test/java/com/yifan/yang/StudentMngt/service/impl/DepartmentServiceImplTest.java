package com.yifan.yang.StudentMngt.service.impl;

import com.yifan.yang.StudentMngt.dao.DepartmentRepository;
import com.yifan.yang.StudentMngt.entity.Department;
import com.yifan.yang.StudentMngt.service.impl.DepartmentServiceImpl;
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

class DepartmentServiceImplTest {

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Mock
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Find all departments")
    void findAll() {
        Department department = new Department();
        List<Department> departments = Arrays.asList(department);
        when(departmentRepository.findAllByOrderByDepartmentTitleAsc()).thenReturn(departments);
        List<Department> result = departmentService.findAll();
        assertEquals(departments, result);
    }

    @Test
    @DisplayName("Find department by title")
    void findByTitle() {
        Department department = new Department();
        department.setDepartmentTitle("Computer Science");
        when(departmentRepository.findByDepartmentTitle("Computer Science")).thenReturn(Arrays.asList(department));
        List<Department> result = departmentService.findByTitle("Computer Science");
        assertEquals(1, result.size());
        assertEquals("Computer Science", result.get(0).getDepartmentTitle());
    }

    @Test
    @DisplayName("Find department by id")
    void findById() {
        Department department = new Department();
        department.setId(1);
        when(departmentRepository.findById(1)).thenReturn(Optional.of(department));
        Department result = departmentService.findById(1);
        assertEquals(1, result.getId());
    }

    @Test
    @DisplayName("Save department")
    void save() {
        Department department = new Department();
        departmentService.save(department);
        verify(departmentRepository, times(1)).save(department);
    }

    @Test
    @DisplayName("Delete department by id")
    void deleteById() {
        departmentService.deleteById(1);
        verify(departmentRepository, times(1)).deleteById(1);
    }
}