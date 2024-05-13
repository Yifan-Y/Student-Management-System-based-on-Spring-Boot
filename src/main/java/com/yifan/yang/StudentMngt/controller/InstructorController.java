package com.yifan.yang.StudentMngt.controller;
import com.yifan.yang.StudentMngt.entity.Instructor;
import com.yifan.yang.StudentMngt.service.InstructorService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService theInstructorService) {
        instructorService = theInstructorService;
    }

    @GetMapping("/list")
    public String listInstructors(Model theModel) {
        List<Instructor> theInstructors = instructorService.findAll();
        theModel.addAttribute("instructors", theInstructors);
        return "instructors/list-instructors";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Instructor theInstructor = new Instructor();
        theModel.addAttribute("instructor", theInstructor);
        return "instructors/instructor-form";
    }

    @PostMapping("/save")
    public String saveInstructor(@ModelAttribute("instructor") Instructor theInstructor) {
        instructorService.save(theInstructor);
        return "redirect:/instructors/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("instructorId") int theId, Model theModel) {
        Instructor theInstructor = instructorService.findById(theId);
        theModel.addAttribute("instructor", theInstructor);
        return "instructors/instructor-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("instructorId") int theId) {
        instructorService.deleteById(theId);
        return "redirect:/instructors/list";
    }

}
