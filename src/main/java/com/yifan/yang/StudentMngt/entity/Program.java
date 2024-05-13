package com.yifan.yang.StudentMngt.entity;

import com.yifan.yang.StudentMngt.entity.model.BaseEntity;
import jakarta.persistence.*;

import java.util.List;

/**
 * Class for programs.
 *
 * This class represents a program in the student management system.
 * It extends the BaseEntity class and includes properties for the program title, program type, duration, credit,
 * the department the program belongs to, and a list of students enrolled in the program.
 *
 * @author Yifan Yang
 */

@Entity
@Table(name = "program")
public class Program extends BaseEntity {
    // The title of the program
    @Column(name = "program_title")
    private String programTitle;

    // The type of the program
    @Column(name = "program_type")
    private String programType;

    // The duration of the program (e.g., "4 years")
    @Column(name = "duration")
    private String duration;

    // The total credit of the program
    @Column(name = "credit")
    private int credit;

    // The department that offers the program
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                          CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="department_id")
    private Department department;

    // The list of students enrolled in the program
    @OneToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Student> students;

    // Constructor with all properties
    public Program(String programTitle, String programType, String duration, int credit, Department department, List<Student> students) {
        this.programTitle = programTitle;
        this.programType = programType;
        this.duration = duration;
        this.credit = credit;
        this.department = department;
        this.students = students;
    }

    // Default constructor
    public Program() {

    }

    // Getters and setters for all properties
    public String getProgramTitle() {
        return programTitle;
    }

    public void setProgramTitle(String programTitle) {
        this.programTitle = programTitle;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}