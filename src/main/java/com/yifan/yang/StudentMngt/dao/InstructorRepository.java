package com.yifan.yang.StudentMngt.dao;

import com.yifan.yang.StudentMngt.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
    public List<Instructor> findAllByOrderByLastNameAsc();
    public List<Instructor> findByLastName(String theLastName);

}
