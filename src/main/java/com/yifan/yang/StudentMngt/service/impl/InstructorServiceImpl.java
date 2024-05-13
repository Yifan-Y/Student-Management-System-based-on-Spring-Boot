package com.yifan.yang.StudentMngt.service.impl;

import com.yifan.yang.StudentMngt.dao.InstructorRepository;
import com.yifan.yang.StudentMngt.entity.Instructor;
import com.yifan.yang.StudentMngt.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {


    public InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository theInstructorRepository) {
        instructorRepository = theInstructorRepository;
    }

    @Override
    public List<Instructor> findAll() {
        return instructorRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public List<Instructor> findByLastName(String theLastName) {
        List<Instructor> result = instructorRepository.findByLastName(theLastName);
        List<Instructor> theInstructors = null;
        if(!result.isEmpty()) {
            theInstructors.addAll(result);
        } else {
            throw new RuntimeException("Cannot find instructor by last name: " + theLastName);
        }
        return theInstructors;
    }

    @Override
    public Instructor findById(int theId) {
        Optional<Instructor> result = instructorRepository.findById(theId);
        Instructor theInstructor = null;
        if(result.isPresent()) {
            theInstructor = result.get();
        } else {
            throw new RuntimeException("Cannot find instructor by ID: " + theId);
        }
        return theInstructor;
    }

    @Override
    public void save(Instructor theInstructor) {
        instructorRepository.save(theInstructor);
    }

    @Override
    public void deleteById(int theId) {
        instructorRepository.deleteById(theId);
    }
}
