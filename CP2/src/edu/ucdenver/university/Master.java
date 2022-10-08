package edu.ucdenver.university;

import java.time.LocalDate;

public class Master extends Graduate{

    public Master(String name, LocalDate dob) {
        super(name,dob);
    }

    @Override
    public String getStanding() {
        return "Master";
    }
}
