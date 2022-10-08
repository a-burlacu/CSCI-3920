package edu.ucdenver.university;

import java.time.LocalDate;

public class Undergraduate extends Student{

    public Undergraduate(String name, LocalDate dob, String id) {
        super(name,dob,id);
    }

    @Override
    public String getStanding() {
        return "Undergraduate";
    }
}
