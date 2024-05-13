package com.yifan.yang.StudentMngt.service;

import com.yifan.yang.StudentMngt.entity.Instructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface InstructorService {
    public List<Instructor> findAll();
    public List<Instructor> findByLastName(String theLastName);
    public Instructor findById(int theId);
    public void save(Instructor theInstructor);
    public void deleteById(int theId);
}
