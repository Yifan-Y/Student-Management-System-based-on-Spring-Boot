package com.yifan.yang.StudentMngt.dao;

import com.yifan.yang.StudentMngt.entity.Course;
import com.yifan.yang.StudentMngt.dao.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CourseRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CourseRepository courseRepository;

    @BeforeEach
    void setUp() {
        Course course1 = new Course();
        course1.setCourseTitle("Computer Science");
        entityManager.persist(course1);

        Course course2 = new Course();
        course2.setCourseTitle("Business Administration");
        entityManager.persist(course2);

        entityManager.flush();
    }

    @Test
    @DisplayName("Find all courses ordered by course code ascending")
    void findAllByOrderByCodeAsc() {
        List<Course> courses = courseRepository.findAllByOrderByCodeAsc();

        assertThat(courses).hasSize(2);
        assertThat(courses.get(0).getCourseTitle()).isEqualTo("Business Administration");
        assertThat(courses.get(1).getCourseTitle()).isEqualTo("Computer Science");
    }

    @Test
    @DisplayName("Find course by course title")
    void findByCourseTitle() {
        List<Course> courses = courseRepository.findByCourseTitle("Computer Science");

        assertThat(courses).hasSize(1);
        assertThat(courses.get(0).getCourseTitle()).isEqualTo("Computer Science");
    }
}