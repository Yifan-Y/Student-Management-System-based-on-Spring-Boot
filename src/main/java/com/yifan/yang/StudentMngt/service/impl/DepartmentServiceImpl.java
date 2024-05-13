package com.yifan.yang.StudentMngt.service.impl;

import com.yifan.yang.StudentMngt.dao.DepartmentRepository;
import com.yifan.yang.StudentMngt.entity.Department;
import com.yifan.yang.StudentMngt.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository theDepartmentRepository) {
        departmentRepository = theDepartmentRepository;
    }
    @Override
    public List<Department> findAll() {
        return departmentRepository.findAllByOrderByDepartmentTitleAsc();
    }

    @Override
    public List<Department> findByTitle(String theTitle) {
        List<Department> result = departmentRepository.findByDepartmentTitle(theTitle);
        List<Department> theDepartments = null;
        if(!result.isEmpty()) {
            theDepartments.addAll(result);
        } else {
            throw new RuntimeException("Cannot find department by Id: " + theTitle);
        }
        return theDepartments;
    }

    @Override
    public Department findById(int theId) {
        Optional<Department> result = departmentRepository.findById(theId);
        Department theDepartment = null;
        if(result.isPresent()) {
            theDepartment = result.get();
        } else {
            throw new RuntimeException("Cannot find department by ID: " + theId);
        }
        return theDepartment;
    }

    @Override
    public void save(Department theDepartment) {
        departmentRepository.save(theDepartment);
    }

    @Override
    public void deleteById(int theId) {
        departmentRepository.deleteById(theId);
    }
}
