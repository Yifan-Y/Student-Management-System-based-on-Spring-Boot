package com.yifan.yang.StudentMngt.dao;

import com.yifan.yang.StudentMngt.entity.Program;
import com.yifan.yang.StudentMngt.dao.ProgramRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ProgramRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProgramRepository programRepository;

    @BeforeEach
    void setUp() {
        Program program1 = new Program();
        program1.setProgramTitle("Computer Science");
        entityManager.persist(program1);

        Program program2 = new Program();
        program2.setProgramTitle("Business Administration");
        entityManager.persist(program2);

        entityManager.flush();
    }

    @Test
    @DisplayName("Find all programs ordered by program title ascending")
    void findAllByOrderByProgramTitleAsc() {
        List<Program> programs = programRepository.findAllByOrderByProgramTitleAsc();

        assertThat(programs).hasSize(2);
        assertThat(programs.get(0).getProgramTitle()).isEqualTo("Business Administration");
        assertThat(programs.get(1).getProgramTitle()).isEqualTo("Computer Science");
    }

    @Test
    @DisplayName("Find program by program title")
    void findByProgramTitle() {
        List<Program> programs = programRepository.findByProgramTitle("Computer Science");

        assertThat(programs).hasSize(1);
        assertThat(programs.get(0).getProgramTitle()).isEqualTo("Computer Science");
    }
}