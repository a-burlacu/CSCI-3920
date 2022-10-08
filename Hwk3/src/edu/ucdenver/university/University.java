package edu.ucdenver.university;

import java.time.LocalDate;
import java.util.*;

public class University {

    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    public Map<String,Integer> studentCount;

    public University() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.studentCount = new HashMap<>();
    }

    public ArrayList<Student> getStudents() {return students;}
    public ArrayList<Course> getCourses() {return courses;}

    // Get methods
    public Student getStudent(String name) throws IllegalArgumentException{
        for(Student s : this.students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Student is not in the university");
    }
    public Course getCourse(String subject, int number) throws IllegalArgumentException {

        for(Course c : this.courses) {
            if (c.getNumber()==number && c.getSubject().equalsIgnoreCase(subject)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Course is not in the university");
    }

    // Add methods
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
    public void addUndergrad(String name, LocalDate dob, String id) {
        this.students.add(new Undergraduate(name,dob,id));
    }
    public void addMaster(String name, LocalDate dob, String id) {
        this.students.add(new Master(name,dob,id));
    }
    public void addPhD(String name, LocalDate dob, String id,String dissertation) {
        this.students.add(new PhD(name,dob, id, dissertation));
    }


    // Calls StudentComparator class to sort students by standing
    public void sortStudents(){
        students.sort(new StudentComparator());
    }

    // Returns key:value pairs of student standings and number of students with that standing
    public Map<String,Integer> countStudentsPerStanding() {

        for(Student s : this.students) {
            if(studentCount.containsKey(s.getStanding())){
                int count = studentCount.get(s.getStanding());
                studentCount.put(s.getStanding(),count + 1);
            }
            else {
                studentCount.put(s.getStanding(),1);
            }
        }
        return studentCount;
    }

    // Checks student id against list of students, if found, removes student, if not found throws exception
    public void removeStudentById(String id) throws IllegalArgumentException {

        Student student = null;

        for (Student s : this.students) {
            if (s.getId().equals(id)) {
                student = s;
                break;
            }
        }
        if (student != null) {
            students.remove(student);
        }
        else {
            throw new IllegalArgumentException(String.format("No student found with id:%s",id));
        }
    }

    // Shuffles the list of students
    public void randomizeStudentList() {

        Collections.shuffle(students);
    }


    @Override
    public String toString() {
        return String.format("University with %d students and %d courses.",
                this.students.size(), this.courses.size());
    }
}



