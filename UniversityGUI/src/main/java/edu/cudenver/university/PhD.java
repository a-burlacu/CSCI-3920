package edu.cudenver.university;

import java.time.LocalDate;

public class PhD extends Graduate{

    private String dissertationTopic;

    public PhD(String name, LocalDate dob, String dissertationTopic) {
        super(name,dob);
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
                super.toString(),this.dissertationTopic);
    }
}
