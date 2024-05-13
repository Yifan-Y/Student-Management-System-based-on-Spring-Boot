package com.yifan.yang.StudentMngt.entity;

import com.yifan.yang.StudentMngt.entity.Department;
import com.yifan.yang.StudentMngt.entity.Student;
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

class DepartmentTest {

    @InjectMocks
    private Department department;

    @Mock
    private List<Student> students;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Set and get department title")
    void departmentTitle() {
        String title = "Computer Science";
        department.setDepartmentTitle(title);
        assertEquals(title, department.getDepartmentTitle());
    }

    @Test
    @DisplayName("Set and get year of foundation")
    void yearOfFound() {
        int year = 2000;
        department.setYearOfFound(year);
        assertEquals(year, department.getYearOfFound());
    }

    @Test
    @DisplayName("Set and get students")
    void students() {
        Student student = new Student();
        students = Arrays.asList(student);
        department.setStudents(students);
        assertEquals(students, department.getStudents());
    }
}