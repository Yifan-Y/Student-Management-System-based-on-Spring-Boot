package com.yifan.yang.StudentMngt.entity;

import com.yifan.yang.StudentMngt.entity.Department;
import com.yifan.yang.StudentMngt.entity.Program;
import com.yifan.yang.StudentMngt.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudentTest {

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student();
    }

    @Test
    @DisplayName("Student fields are set correctly")
    void studentFieldsAreSetCorrectly() {
        Department department = new Department();
        Program program = new Program();

        student.setCountryOfOrigin("USA");
        student.setYearOfEntry(2020);
        student.setYearOfLimit(2024);
        student.setStudentType("Undergraduate");
        student.setDepartment(department);
        student.setProgram(program);
        student.setCourses(Collections.emptyList());

        assertEquals("USA", student.getCountryOfOrigin());
        assertEquals(2020, student.getYearOfEntry());
        assertEquals(2024, student.getYearOfLimit());
        assertEquals("Undergraduate", student.getStudentType());
        assertEquals(department, student.getDepartment());
        assertEquals(program, student.getProgram());
        assertNotNull(student.getCourses());
    }
}