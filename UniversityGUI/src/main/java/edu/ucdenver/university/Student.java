package edu.ucdenver.university;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Student implements Serializable {

    private LocalDate dob;
    private String name;
    private String email;

    //add a list to keep track of the courses the student is enrolled in.
    private ArrayList<Course> enrolledCourses;

    public Student(String name, LocalDate dob){
        this.dob = dob;
        this.name = name;
        setEmail(name);
        this.enrolledCourses = new ArrayList<>(100);
    }

    public LocalDate getDob() {return dob;}

    public void setDob(LocalDate dob) {this.dob = dob;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = name + "@ucdenver.edu";}

    public abstract String getStanding();

    //add a method enrollTo(Course), that takes a course object and adds that course to the enrollment list.
    public void enrollTo(Course course){
        this.enrolledCourses.add(course);
    }

    @Override
    public String toString(){
        return String.format("%-20s - %s - %-50s - Standing: %s", this.name, this.dob, this.email, this.getStanding());
    }
}
