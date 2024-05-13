package com.yifan.yang.StudentMngt.entity;

import com.yifan.yang.StudentMngt.entity.model.Person;
import jakarta.persistence.*;

import java.util.List;

/**
 * Class for instructors.
 *
 * This class represents an instructor in the student management system.
 * It extends the Person class and includes properties for the department the instructor belongs to,
 * and a list of courses the instructor teaches.
 *
 * @author Yifan Yang
 */
@Entity
@Table(name = "instructor")
public class Instructor extends Person {
    // The department the instructor belongs to
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                          CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="department_id")
    private Department department;

    // The list of courses the instructor teaches
    @OneToMany(mappedBy = "instructor",
               fetch = FetchType.LAZY,
               cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                          CascadeType.DETACH, CascadeType.REFRESH})
    private List<Course> courses;

    // Default constructor
    public Instructor() {
    }

    // Constructor with all properties
    public Instructor(Department department, List<Course> courses) {
        this.department = department;
        this.courses = courses;
    }

    // Getter and setter for courses
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // Getter and setter for department
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}