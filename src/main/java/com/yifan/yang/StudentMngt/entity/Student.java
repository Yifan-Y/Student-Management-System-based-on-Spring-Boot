package com.yifan.yang.StudentMngt.entity;

import com.yifan.yang.StudentMngt.entity.model.Person;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.List;

/**
 * Class for students.
 * @author Yifan Yang
 */

@Entity
@Table(name = "student")
public class Student extends Person {
    @Column(name = "country_of_origin")
    private String countryOfOrigin;
    @Column(name = "year_of_entry")
    private int yearOfEntry;
    @Column(name = "year_of_limit")
    private int yearOfLimit;
    @Column(name = "student_type")
    private String studentType;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                          CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="department_id")
    private Department department;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                          CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="program_id")
    private Program program;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public int getYearOfEntry() {
        return yearOfEntry;
    }

    public void setYearOfEntry(int yearOfEntry) {
        this.yearOfEntry = yearOfEntry;
    }

    public int getYearOfLimit() {
        return yearOfLimit;
    }

    public void setYearOfLimit(int yearOfLimit) {
        this.yearOfLimit = yearOfLimit;
    }

    public String getStudentType() {
        return studentType;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}
