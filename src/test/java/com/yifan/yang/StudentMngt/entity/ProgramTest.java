package com.yifan.yang.StudentMngt.entity;

import com.yifan.yang.StudentMngt.entity.Department;
import com.yifan.yang.StudentMngt.entity.Program;
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

class ProgramTest {

    @InjectMocks
    private Program program;

    @Mock
    private Department department;

    @Mock
    private List<Student> students;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Set and get program title")
    void programTitle() {
        String title = "Computer Science";
        program.setProgramTitle(title);
        assertEquals(title, program.getProgramTitle());
    }

    @Test
    @DisplayName("Set and get program type")
    void programType() {
        String type = "Bachelor";
        program.setProgramType(type);
        assertEquals(type, program.getProgramType());
    }

    @Test
    @DisplayName("Set and get duration")
    void duration() {
        String duration = "4 years";
        program.setDuration(duration);
        assertEquals(duration, program.getDuration());
    }

    @Test
    @DisplayName("Set and get credit")
    void credit() {
        int credit = 120;
        program.setCredit(credit);
        assertEquals(credit, program.getCredit());
    }

    @Test
    @DisplayName("Set and get department")
    void department() {
        program.setDepartment(department);
        assertEquals(department, program.getDepartment());
    }

    @Test
    @DisplayName("Set and get students")
    void students() {
        Student student = new Student();
        students = Arrays.asList(student);
        program.setStudents(students);
        assertEquals(students, program.getStudents());
    }
}