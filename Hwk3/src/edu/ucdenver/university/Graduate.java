package edu.ucdenver.university;

import java.time.LocalDate;

//Abstract prevents the class to instantiate objects, and remove its implementation of getStanding()
public abstract class Graduate extends Student{

    public Graduate(String name, LocalDate dob, String id) {
        super(name,dob,id);
    }
    @Override
    public abstract String getStanding();
}
