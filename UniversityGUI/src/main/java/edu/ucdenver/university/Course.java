package edu.ucdenver.university;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {
    private String subject;
    private int number;
    private String title;

    //add a list to keep track of the students enrolled in the course.
    private ArrayList<Student> enrolledStudents;

    public Course(String subject, int number, String title){
        this.subject = subject;
        this.number = number;
        this.title = title;
        this.enrolledStudents = new ArrayList<>(100);
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

    //add a method addStudentToCourse(Student), that takes a student object and adds it to the students enrolled list.
    public void addStudentToCourse(Student student){
        this.enrolledStudents.add(student);
    }

    //add a method getEnrolledStudents() that returns a List<Student> with the enrolled students.
    public ArrayList<Student> getEnrolledStudents(){
        return enrolledStudents;
    }

    @Override
    public String toString(){
        return String.format("%s %-4d - %s", this.subject, this.number, this.title);
    }
}
