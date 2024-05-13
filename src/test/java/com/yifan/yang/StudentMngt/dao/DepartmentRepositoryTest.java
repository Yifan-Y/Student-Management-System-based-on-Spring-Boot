package com.yifan.yang.StudentMngt.dao;

import com.yifan.yang.StudentMngt.entity.Department;
import com.yifan.yang.StudentMngt.dao.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department1 = new Department();
        department1.setDepartmentTitle("Computer Science");
        entityManager.persist(department1);

        Department department2 = new Department();
        department2.setDepartmentTitle("Business Administration");
        entityManager.persist(department2);

        entityManager.flush();
    }

    @Test
    @DisplayName("Find all departments ordered by department title ascending")
    void findAllByOrderByDepartmentTitleAsc() {
        List<Department> departments = departmentRepository.findAllByOrderByDepartmentTitleAsc();

        assertThat(departments).hasSize(2);
        assertThat(departments.get(0).getDepartmentTitle()).isEqualTo("Business Administration");
        assertThat(departments.get(1).getDepartmentTitle()).isEqualTo("Computer Science");
    }

    @Test
    @DisplayName("Find department by department title")
    void findByDepartmentTitle() {
        List<Department> departments = departmentRepository.findByDepartmentTitle("Computer Science");

        assertThat(departments).hasSize(1);
        assertThat(departments.get(0).getDepartmentTitle()).isEqualTo("Computer Science");
    }
}