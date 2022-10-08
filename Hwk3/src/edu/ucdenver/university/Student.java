package edu.ucdenver.university;

import java.time.LocalDate;

public abstract class Student {

    private LocalDate dob;
    private String name;
    private String email;
    private String id;

    public Student(String name, LocalDate dob, String id) {
        this.name = name;
        this.dob = dob;
        this.id = id;
        setEmail(name);
    }

    public String getId() {
        return id;
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

    @Override
    public String toString() {
        return String.format("%-20s - %s - %-50s  - Standing: %s",
                this.name, this.dob, this.email, this.getStanding());
    }
}
