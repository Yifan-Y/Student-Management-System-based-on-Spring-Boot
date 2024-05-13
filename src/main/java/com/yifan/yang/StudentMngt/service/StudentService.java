package com.yifan.yang.StudentMngt.service;

import com.yifan.yang.StudentMngt.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> findAll();
    public List<Student> findBy(String theFirstName, String theLastName);
    public Student findById(int theId);
    public void save(Student theStudent);
    public void deleteById(int theId);
}
