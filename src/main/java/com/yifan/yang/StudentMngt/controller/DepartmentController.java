package com.yifan.yang.StudentMngt.controller;

import com.yifan.yang.StudentMngt.entity.Department;
import com.yifan.yang.StudentMngt.service.DepartmentService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService theDepartmentService) {
        departmentService = theDepartmentService;
    }

    @GetMapping("/list")
    public String listDepartments(Model theModel) {
        List<Department> theDepartments = departmentService.findAll();

        theModel.addAttribute("departments", theDepartments);

        return "departments/list-departments";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Department theDepartment = new Department();
        theModel.addAttribute("department", theDepartment);
        return "departments/department-form";
    }

    @PostMapping("/save")
    public String saveDepartment(@ModelAttribute("Department") Department theDepartment) {
        departmentService.save(theDepartment);
        return "redirect:/departments/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("DepartmentId") int theId, Model theModel) {
        Department theDepartment = departmentService.findById(theId);
        theModel.addAttribute("department", theDepartment);
        return "departments/department-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("departmentId") int theId) {
        departmentService.deleteById(theId);
        return "redirect:/departments/list";
    }

}
