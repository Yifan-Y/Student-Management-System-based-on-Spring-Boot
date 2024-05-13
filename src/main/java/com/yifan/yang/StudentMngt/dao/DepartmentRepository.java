package com.yifan.yang.StudentMngt.dao;

import com.yifan.yang.StudentMngt.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    public List<Department> findAllByOrderByDepartmentTitleAsc();
    public List<Department> findByDepartmentTitle(String theTitle);
}
