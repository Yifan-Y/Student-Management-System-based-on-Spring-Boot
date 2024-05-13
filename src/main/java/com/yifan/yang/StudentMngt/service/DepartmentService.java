package com.yifan.yang.StudentMngt.service;

import com.yifan.yang.StudentMngt.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public List<Department> findAll();
    public List<Department> findByTitle(String theTitle);
    public Department findById(int theId);
    public void save(Department theDepartment);
    public void deleteById(int theId);

}
