package com.yifan.yang.StudentMngt.controller;

import com.yifan.yang.StudentMngt.entity.Department;
import com.yifan.yang.StudentMngt.service.DepartmentService;
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

class DepartmentControllerTest {

    @InjectMocks
    private DepartmentController departmentController;

    @Mock
    private DepartmentService departmentService;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("List departments")
    void listDepartments() {
        Department department = new Department();
        List<Department> departments = Arrays.asList(department);
        when(departmentService.findAll()).thenReturn(departments);
        String viewName = departmentController.listDepartments(model);
        verify(model, times(1)).addAttribute("departments", departments);
        assertEquals("departments/list-departments", viewName);
    }

    @Test
    @DisplayName("Show form for add")
    void showFormForAdd() {
        String viewName = departmentController.showFormForAdd(model);
        verify(model, times(1)).addAttribute(eq("department"), any(Department.class));
        assertEquals("departments/department-form", viewName);
    }

    @Test
    @DisplayName("Save department")
    void saveDepartment() {
        Department department = new Department();
        String viewName = departmentController.saveDepartment(department);
        verify(departmentService, times(1)).save(department);
        assertEquals("redirect:/departments/list", viewName);
    }

    @Test
    @DisplayName("Show form for update")
    void showFormForUpdate() {
        Department department = new Department();
        when(departmentService.findById(anyInt())).thenReturn(department);
        String viewName = departmentController.showFormForUpdate(1, model);
        verify(model, times(1)).addAttribute("department", department);
        assertEquals("departments/department-form", viewName);
    }

    @Test
    @DisplayName("Delete department")
    void delete() {
        String viewName = departmentController.delete(1);
        verify(departmentService, times(1)).deleteById(1);
        assertEquals("redirect:/departments/list", viewName);
    }
}