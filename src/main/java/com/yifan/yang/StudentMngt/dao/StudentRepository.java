package com.yifan.yang.StudentMngt.dao;

import com.yifan.yang.StudentMngt.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    public List<Student> findAllByOrderByLastNameAsc();
    public List<Student> findByFirstNameContainsAndLastNameContainsAllIgnoreCase(String theFirstName, String theLastName);
}
