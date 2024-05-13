package com.yifan.yang.StudentMngt.entity;

import com.yifan.yang.StudentMngt.entity.model.BaseEntity;
import jakarta.persistence.*;

import java.util.List;

/**
 * Class for courses.
 * @author Yifan Yang
 */

@Entity
@Table(name = "course")
public class Course extends BaseEntity {
    @Column(name = "code")
    private String code;
    @Column(name = "course_title")
    private String courseTitle;
    @Column(name = "max_capacity")
    private int maxCapacity;
    @Column(name = "credit")
    private int credit;
    @Column(name = "course_level")
    private String courseLevel;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                          CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="department_id")
    private Department department;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                          CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="instructor_id")
    private Instructor instructor;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

    public Course() {
    }

    public Course(String code, String courseTitle, int maxCapacity, int credit, String courseLevel, Department department, Instructor instructor, List<Student> students) {
        this.code = code;
        this.courseTitle = courseTitle;
        this.maxCapacity = maxCapacity;
        this.credit = credit;
        this.courseLevel = courseLevel;
        this.department = department;
        this.instructor = instructor;
        this.students = students;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(String courseLevel) {
        this.courseLevel = courseLevel;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
