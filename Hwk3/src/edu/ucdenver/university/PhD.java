package edu.ucdenver.university;

import java.time.LocalDate;

public class PhD extends Graduate{

    private String dissertationTopic;

    public PhD(String name, LocalDate dob, String id, String dissertationTopic) {
        super(name,dob,id);
        this.dissertationTopic = dissertationTopic;
    }

    public String getDissertationTopic() {
        return dissertationTopic;
    }

    @Override
    public String getStanding() {
        return "PhD";
    }

    @Override
    public String toString() {
        return String.format("%s - Dissertation is about %s",
                super.toString(), this.dissertationTopic);
    }
}
