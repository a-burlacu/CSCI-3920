package edu.cudenver.university;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Student implements Serializable {

    private LocalDate dob;
    private String name;
    private String email;

    private ArrayList<Course> enrolledCourses;

    public Student(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
        setEmail(name);
        this.enrolledCourses = new ArrayList<>();
    }

    public LocalDate getDob() {return dob;}

    public void setDob(LocalDate dob) {this.dob = dob;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}

    public void setEmail(String email) {

        this.email = name + "@ucdenver.edu";
    }

    public abstract String getStanding();
    //.................................................................................................................//
    //takes a course object and adds that course to the enrollment list
    public void enrollTo(Course course) {
        this.enrolledCourses.add(course);
    }
    //.................................................................................................................//
    @Override
    public String toString() {
        return String.format("%-20s - %s - %-50s - Standing: %s",
                this.name, this.dob, this.email, this.getStanding());
    }
}