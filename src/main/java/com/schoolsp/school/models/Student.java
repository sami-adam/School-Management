package com.schoolsp.school.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.util.Date;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private String email;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String fullName;

    @Column(name = "birthday")
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
    public Student(){}

    public Student(String email, User user, String fullName, Date dateOfBirth, Grade grade, School school) {
        this.email = email;
        this.user = user;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.grade = grade;
        this.school = school;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getEmail() {
        try {
            return user.getEmail();
        } catch (NullPointerException e) {
            return email;
        }
    }
}
