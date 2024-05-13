package com.yifan.yang.StudentMngt.controller;

import com.yifan.yang.StudentMngt.entity.Course;
import com.yifan.yang.StudentMngt.service.CourseService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService theCourseService) {
        this.courseService = theCourseService;
    }

    @GetMapping("/list")
    public String listCourses(Model theModel) {
        List<Course> theCourses = courseService.findAll();

        theModel.addAttribute("courses", theCourses);

        return "courses/list-courses";
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Course theCourse = new Course();
        theModel.addAttribute("course", theCourse);
        return "courses/course-form";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("course") Course theCourse) {
        courseService.save(theCourse);
        return "redirect:/courses/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("courseId") int theId, Model theModel) {
        Course theCourse = courseService.findById(theId);
        theModel.addAttribute("course", theCourse);
        return "courses/course-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("courseId") int theId) {
        courseService.deleteById(theId);
        return "redirect:/courses/list";
    }

}
