package com.yifan.yang.StudentMngt.dao;

import com.yifan.yang.StudentMngt.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        Student student1 = new Student();
        student1.setFirstName("John");
        student1.setLastName("Doe");
        student1.setGender("Male");
        entityManager.persist(student1);

        Student student2 = new Student();
        student2.setFirstName("Jane");
        student2.setLastName("Doe");
        student2.setGender("Female");
        entityManager.persist(student2);

        entityManager.flush();
    }

    @Test
    @DisplayName("Find all students ordered by last name ascending")
    void findAllByOrderByLastNameAsc() {
        List<Student> students = studentRepository.findAllByOrderByLastNameAsc();

        assertThat(students).hasSize(2);
        assertThat(students.get(0).getLastName()).isEqualTo("Doe");
        assertThat(students.get(1).getLastName()).isEqualTo("Doe");
    }

    @Test
    @DisplayName("Find students by first and last name ignoring case")
    void findByFirstNameContainsAndLastNameContainsAllIgnoreCase() {
        List<Student> students = studentRepository.findByFirstNameContainsAndLastNameContainsAllIgnoreCase("john", "doe");

        assertThat(students).hasSize(1);
        assertThat(students.get(0).getFirstName()).isEqualTo("John");
        assertThat(students.get(0).getLastName()).isEqualTo("Doe");
    }
}