package com.yifan.yang.StudentMngt.controller;

import com.yifan.yang.StudentMngt.entity.Program;
import com.yifan.yang.StudentMngt.service.ProgramService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/programs")
public class ProgramController {
    private ProgramService programService;

    public ProgramController(ProgramService theProgramService) {
        programService = theProgramService;
    }

    @GetMapping("/list")
    public String listPrograms(Model theModel) {
        List<Program> thePrograms = programService.findAll();

        theModel.addAttribute("programs", thePrograms);

        return "programs/list-programs";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Program theProgram = new Program();
        theModel.addAttribute("program", theProgram);
        return "programs/program-form";
    }

    @PostMapping("/save")
    public String saveProgram(@ModelAttribute("Program") Program theProgram) {
        programService.save(theProgram);
        return "redirect:/programs/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("programId") int theId, Model theModel) {
        Program theProgram = programService.findById(theId);
        theModel.addAttribute("program", theProgram);
        return "programs/program-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("programId") int theId) {
        programService.deleteById(theId);
        return "redirect:/programs/list";
    }

}
