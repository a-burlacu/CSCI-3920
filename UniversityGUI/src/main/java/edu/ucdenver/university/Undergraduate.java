package edu.ucdenver.university;

import java.time.LocalDate;

public class Undergraduate extends Student{

    public Undergraduate(String name, LocalDate dob){
        super(name, dob);
    }
    @Override
    public String getStanding(){
        return "Undergraduate";
    }

}
