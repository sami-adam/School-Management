package com.schoolsp.school.dto;

import com.schoolsp.school.models.Grade;
import com.schoolsp.school.models.School;
import com.schoolsp.school.models.User;

import java.util.Date;

public class StudentDTO {
    private String fullName;
    private String email;
    private User user;
    private Date dateOfBirth;
    private Grade grade;
    private School school;

    public StudentDTO() {
    }

    public StudentDTO(String fullName, String email, User user, Date dateOfBirth, Grade grade, School school) {
        this.fullName = fullName;
        this.email = email;
        this.user = user;
        this.dateOfBirth = dateOfBirth;
        this.grade = grade;
        this.school = school;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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


}
