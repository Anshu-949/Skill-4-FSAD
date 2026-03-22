package com.klu.skill_4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int studentId;
    private String name;
    private String course;
    private int year;

    // Constructor Injection
    public Student(
            @Value("101") int studentId,
            @Value("Anshu") String name,
            @Value("CSE") String course,
            @Value("2") int year) {

        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.year = year;
    }

    // Setter Injection
    @Value("AI & ML")
    public void setCourse(String course) {
        this.course = course;
    }

    @Value("3")
    public void setYear(int year) {
        this.year = year;
    }

    public void display() {
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Year: " + year);
    }
}