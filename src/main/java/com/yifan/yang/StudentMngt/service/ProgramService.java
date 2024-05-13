package com.yifan.yang.StudentMngt.service;

import com.yifan.yang.StudentMngt.entity.Program;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProgramService {
    public List<Program> findAll();
    public List<Program> findByProgramTitle(String theTitle);
    public Program findById(int theId);
    public void save(Program theProgram);
    public void deleteById(int theId);
}
