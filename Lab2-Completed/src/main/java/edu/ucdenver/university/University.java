//TEAM MEMBERS: Alexa Selby and Alina Burlacu

package edu.ucdenver.university;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class University implements Serializable {

    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    public static final String filename =  "./university.ser";

    public University(){
        this.students = new ArrayList<>(100);
        this.courses = new ArrayList<>(100);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public Student getStudent(String name) throws IllegalArgumentException{
        for(Student s: this.students){
            if (s.getName().equalsIgnoreCase(name)){
                return s;
            }
        }
        throw  new IllegalArgumentException("Course is not in the university.");
    }

    public Course getCourse(String subject, int number) throws IllegalArgumentException{
        for(Course c: this.courses){
            if (c.getNumber() == number && c.getSubject().equalsIgnoreCase(subject)){
                return c;
            }
        }
        throw  new IllegalArgumentException("Course is not in the university.");
    }

    public void addCourse(String subject, int number, String title) throws IllegalArgumentException{
       Course course = null;
        try{
            course = this.getCourse(subject, number);
        }
        catch (IllegalArgumentException iae){
            this.courses.add(new Course(subject, number, title));
        }

        if (course != null){
            throw new IllegalArgumentException("Course is already in the university.");
        }
    }

    public void addUndergrad(String name, LocalDate dob){
        this.students.add(new Undergraduate(name, dob));
    }

    public void addMaster(String name, LocalDate dob){
        this.students.add(new Master(name, dob));
    }

    public void addPhD(String name, LocalDate dob, String dissertation){
        this.students.add(new PhD(name, dob, dissertation));
    }

//    add a method enrollStudentToCourse(String, String, int):
//    it takes the student's name and the course's subject and number (in that order).
//    The method should search for the student to match the name and the course matching the course's information.
//    String comparison should be case-insensitive.
//    If both are found, will enroll the student and course using the methods described in (1.2) and (2.2).
//    If either the student or course is not found it should throw an IllegalArgumentException with a message to
//    report what was the specific problem. Please declare that the method may throw such exception.
    public void enrollStudentToCourse(String name, String subject, int courseNumber) throws IllegalArgumentException {

        Course course = null;
        Student student = null;


        try {
            for (Student s : this.students) {
                for (Course c : this.courses) {
                    if (s.getName().equalsIgnoreCase(name) && c.getNumber() == courseNumber && c.getSubject().equalsIgnoreCase(subject)) {
                        student = s;
                        course = c;
                        student.enrollTo(course);
                        course.addStudentToCourse(student);
                    }
                }
            }
        } catch (IllegalArgumentException iae){
            if (student == null) {
                System.out.println("Student is not found in university");
            }
            if (course == null) {
                System.out.println("Course is not found in university");
            }
        }
    }

    @Override
    public String toString(){
        return String.format("University with %d students and %d courses.", this.students.size(), this.courses.size());
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void saveToFile(){
        ObjectOutputStream oos = null;

        try{
            oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(this);
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
        finally {
            if (oos != null){
                try{
                    oos.close();
                }
                catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
        }
    }

    public static University loadFromFile(){
        ObjectInputStream ois = null;
        University university = null;

        try{
            ois = new ObjectInputStream(new FileInputStream(University.filename));
            university = (University) ois.readObject();
        }
        catch (Exception e){
            e.printStackTrace();
            university = new University();
        }
        finally{
            if (ois != null){
                try{
                    ois.close();
                }
                catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
        }
        return university;
    }
}


