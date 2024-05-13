package com.yifan.yang.StudentMngt.service.impl;

import com.yifan.yang.StudentMngt.dao.StudentRepository;
import com.yifan.yang.StudentMngt.entity.Student;
import com.yifan.yang.StudentMngt.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class StudentServiceImplTest {

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Find all students ordered by last name ascending")
    void findAllStudents() {
        Student student1 = new Student();
        student1.setFirstName("John");
        student1.setLastName("Doe");

        Student student2 = new Student();
        student2.setFirstName("Jane");
        student2.setLastName("Doe");

        when(studentRepository.findAllByOrderByLastNameAsc()).thenReturn(Arrays.asList(student1, student2));

        List<Student> students = studentService.findAll();

        assertEquals(2, students.size());
        verify(studentRepository, times(1)).findAllByOrderByLastNameAsc();
    }

    @Test
    @DisplayName("Find student by id")
    void findStudentById() {
        Student student = new Student();
        student.setId(1);
        student.setFirstName("John");
        student.setLastName("Doe");

        when(studentRepository.findById(1)).thenReturn(Optional.of(student));

        Student foundStudent = studentService.findById(1);

        assertEquals("John", foundStudent.getFirstName());
        assertEquals("Doe", foundStudent.getLastName());
        verify(studentRepository, times(1)).findById(1);
    }

    @Test
    @DisplayName("Find student by id not found")
    void findStudentByIdNotFound() {
        when(studentRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> studentService.findById(1));
        verify(studentRepository, times(1)).findById(1);
    }

    @Test
    @DisplayName("Find students by first and last name ignoring case")
    void findStudentsByFirstAndLastName() {
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");

        when(studentRepository.findByFirstNameContainsAndLastNameContainsAllIgnoreCase("john", "doe")).thenReturn(Arrays.asList(student));

        List<Student> students = studentService.findBy("john", "doe");

        assertEquals(1, students.size());
        assertEquals("John", students.get(0).getFirstName());
        assertEquals("Doe", students.get(0).getLastName());
        verify(studentRepository, times(1)).findByFirstNameContainsAndLastNameContainsAllIgnoreCase("john", "doe");
    }
}