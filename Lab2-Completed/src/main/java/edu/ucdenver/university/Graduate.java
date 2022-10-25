package edu.ucdenver.university;

import java.time.LocalDate;

public class Graduate extends Student{

    public Graduate(String name, LocalDate dob){
        super(name, dob);
    }
    @Override
    public String getStanding(){
        return "Graduate";
    }
}
