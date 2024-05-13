package com.yifan.yang.StudentMngt.service.impl;

import com.yifan.yang.StudentMngt.dao.ProgramRepository;
import com.yifan.yang.StudentMngt.entity.Program;
import com.yifan.yang.StudentMngt.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;

    @Autowired
    public ProgramServiceImpl(ProgramRepository theProgramRepository) {
        programRepository = theProgramRepository;
    }

    @Override
    public List<Program> findAll() {
        return programRepository.findAllByOrderByProgramTitleAsc();
    }

    @Override
    public List<Program> findByProgramTitle(String theTitle) {
        List<Program> result = programRepository.findByProgramTitle(theTitle);
        List<Program> thePrograms = null;
        if(!result.isEmpty()) {
            thePrograms.addAll(result);
        } else {
            throw new RuntimeException("Cannot find program by title: " + theTitle);
        }
        return thePrograms;
    }

    @Override
    public Program findById(int theId) {
        Optional<Program> result = programRepository.findById(theId);
        Program theProgram = null;
        if(result.isPresent()) {
            theProgram = result.get();
        } else {
            throw new RuntimeException("Cannot find program by ID: " + theId);
        }
        return theProgram;
    }

    @Override
    public void save(Program theProgram) {
        programRepository.save(theProgram);
    }

    @Override
    public void deleteById(int theId) {
        programRepository.deleteById(theId);
    }
}
