package com.yifan.yang.StudentMngt.dao;

import com.yifan.yang.StudentMngt.entity.Instructor;
import com.yifan.yang.StudentMngt.dao.InstructorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class InstructorRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private InstructorRepository instructorRepository;

    @BeforeEach
    void setUp() {
        Instructor instructor1 = new Instructor();
        instructor1.setLastName("Smith");
        entityManager.persist(instructor1);

        Instructor instructor2 = new Instructor();
        instructor2.setLastName("Johnson");
        entityManager.persist(instructor2);

        entityManager.flush();
    }

    @Test
    @DisplayName("Find all instructors ordered by last name ascending")
    void findAllByOrderByLastNameAsc() {
        List<Instructor> instructors = instructorRepository.findAllByOrderByLastNameAsc();

        assertThat(instructors).hasSize(2);
        assertThat(instructors.get(0).getLastName()).isEqualTo("Johnson");
        assertThat(instructors.get(1).getLastName()).isEqualTo("Smith");
    }

    @Test
    @DisplayName("Find instructor by last name")
    void findByLastName() {
        List<Instructor> instructors = instructorRepository.findByLastName("Smith");

        assertThat(instructors).hasSize(1);
        assertThat(instructors.get(0).getLastName()).isEqualTo("Smith");
    }
}