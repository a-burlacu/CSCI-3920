package edu.ucdenver.university;

import java.time.LocalDate;
import java.util.ArrayList;

public class University {

    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    public University() {
        this.students = new ArrayList<>(100);
        this.courses = new ArrayList<>(100);
    }

    public ArrayList<Student> getStudents() {return students;}

    public ArrayList<Course> getCourses() {return courses;}


    public Student getStudent(String name) throws IllegalArgumentException{
        for(Student s : this.students) {;
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Student is not in the university");
    }





    public Course getCourse(String subject, int number) throws IllegalArgumentException {

        for(Course c : this.courses) {;
            if (c.getNumber()==number && c.getSubject().equalsIgnoreCase(subject)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Course is not in the university");
    }

    public void addCourse(String subject, int number, String title) throws IllegalArgumentException {
        Course course = null;

        try{
            course = this.getCourse(subject,number);
        }
        catch (IllegalArgumentException iae){
            this.courses.add(new Course(subject,number,title));
        }
        if(course != null) {
            throw new IllegalArgumentException("Course is already in the university");
        }
    }



    public void addUndergrad(String name, LocalDate dob) {
        this.students.add(new Undergraduate(name,dob));
    }
    public void addMaster(String name, LocalDate dob) {
        this.students.add(new Master(name,dob));
    }
    public void addPhD(String name, LocalDate dob, String dissertation) {
        this.students.add(new PhD(name,dob,dissertation));
    }


    @Override
    public String toString() {
        return String.format("University with %d students and %d courses.",
                this.students.size(), this.courses.size());
    }
}
