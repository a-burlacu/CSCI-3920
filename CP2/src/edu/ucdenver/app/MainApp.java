package edu.ucdenver.app;

import edu.ucdenver.university.*;
import java.time.LocalDate;

public class MainApp {
    public static void main(String[] args) {
        University university = new University();

        university.addUndergrad("John Smith", LocalDate.of(1999,5,20));
        university.addUndergrad("Alice Smith", LocalDate.of(2000,6,21));
        university.addUndergrad("Dan Smith", LocalDate.of(2001,7,22));
        university.addMaster("John Doe", LocalDate.of(1997,8,10));
        university.addMaster("Alice Doe", LocalDate.of(1998,9,11));
        university.addMaster("Jane Doe", LocalDate.of(1999,10,12));
        university.addPhD("Javier Pastorino", LocalDate.of(1999,5,20), "Artificial Intelligence");
        university.addPhD("Ellie Miller", LocalDate.of(1999,5,20), "Forensics");

        university.addCourse("CSCI", 3920, "Advanced Programming with Java and Python");
        university.addCourse("CSCI", 3800, "NextGen CyberThreats and GAN");
        university.addCourse("MATh", 1500, "Algebra");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>> UNIVERSITY <<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(university);
        System.out.println();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>> UNIVERSITY Students <<<<<<<<<<<<<<<<<<<<<<<<<<");
        for (Student s : university.getStudents()){
            System.out.println(s);
        }
        System.out.println();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>> UNIVERSITY Courses <<<<<<<<<<<<<<<<<<<<<<<<<<");
        for (Course c : university.getCourses()){
            System.out.println(c);
        }
        System.out.println();

    }
}
