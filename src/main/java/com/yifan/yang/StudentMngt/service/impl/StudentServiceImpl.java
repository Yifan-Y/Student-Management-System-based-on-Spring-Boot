package com.yifan.yang.StudentMngt.service.impl;

import com.yifan.yang.StudentMngt.dao.StudentRepository;
import com.yifan.yang.StudentMngt.entity.Student;
import com.yifan.yang.StudentMngt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository theStudentRepository) {
        studentRepository = theStudentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Student findById(int theId) {
        Optional<Student> result = studentRepository.findById(theId);

        Student theStudent = null;
        if(result.isPresent()) {
            theStudent = result.get();
        } else {
            throw new RuntimeException("Cannot find student by ID: " + theId);
        }
        return theStudent;
    }

    @Override
    public List<Student> findBy(String theFirstname, String theLastName) {
        return studentRepository.findByFirstNameContainsAndLastNameContainsAllIgnoreCase(theFirstname, theLastName);
    }

    @Override
    public void save(Student theStudent) {
        studentRepository.save(theStudent);
    }

    @Override
    public void deleteById(int theId) {
        studentRepository.deleteById(theId);
    }
}
