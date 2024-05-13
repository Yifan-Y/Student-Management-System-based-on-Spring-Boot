package com.yifan.yang.StudentMngt.dao;

import com.yifan.yang.StudentMngt.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Integer> {
    public List<Program> findAllByOrderByProgramTitleAsc();
    public List<Program> findByProgramTitle(String theTitle);
}
