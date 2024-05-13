package com.yifan.yang.StudentMngt.entity;

import com.yifan.yang.StudentMngt.entity.model.BaseEntity;
import jakarta.persistence.*;

import java.util.List;

/**
 * Class for departments.
 *
 * This class represents a department in the student management system.
 * It extends the BaseEntity class and includes properties for the department title,
 * year of foundation, and lists of students, courses, instructors, and programs associated with the department.
 *
 * @author Yifan Yang
 */

@Entity
@Table(name = "department")
public class Department extends BaseEntity {
    // The title of the department
    @Column(name = "department-title")
    private String departmentTitle;

    // The year the department was founded
    @Column(name = "year_of_found")
    private int yearOfFound;

    // The list of students associated with the department
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private List<Student> students;

    // The list of courses offered by the department
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Course> courses;

    // The list of instructors working in the department
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_id")
    private List<Instructor> instructors;

    // The list of programs offered by the department
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "program_id")
    private List<Program> programs;

    // Default constructor
    public Department() {
    }

    // Constructor with all properties
    public Department(String departmentTitle, int yearOfFound, List<Student> students, List<Course> courses, List<Instructor> instructors, List<Program> programs) {
        this.departmentTitle = departmentTitle;
        this.yearOfFound = yearOfFound;
        this.students = students;
        this.courses = courses;
        this.instructors = instructors;
        this.programs = programs;
    }

    // Getters and setters for all properties
    public String getDepartmentTitle() {
        return departmentTitle;
    }

    public void setDepartmentTitle(String departmentTitle) {
        this.departmentTitle = departmentTitle;
    }

    public int getYearOfFound() {
        return yearOfFound;
    }

    public void setYearOfFound(int yearOfFound) {
        this.yearOfFound = yearOfFound;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }

}