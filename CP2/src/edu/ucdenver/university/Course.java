package edu.ucdenver.university;

public class Course {

    private String subject;
    private int number;
    private String title;

    public Course(String subject, int number, String title) {
        this.subject = subject;
        this.number = number;
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString(){
        return String.format("%s %-4d - %s",
                this.subject, this.number, this.title);
    }
}
