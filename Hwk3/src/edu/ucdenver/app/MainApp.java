package edu.ucdenver.app;

import edu.ucdenver.university.*;
import java.time.LocalDate;
import java.util.Map;

public class MainApp {
    public static void main(String[] args) {
        University university = new University();

        university.addUndergrad("John Smith", LocalDate.of(1999,5,20),"1");
        university.addUndergrad("Alice Smith", LocalDate.of(2000,6,21),"4");
        university.addUndergrad("Dan Smith", LocalDate.of(2001,7,22),"6");
        university.addMaster("John Doe", LocalDate.of(1997,8,10),"5");
        university.addMaster("Alice Doe", LocalDate.of(1998,9,11),"2");
        university.addMaster("Jane Doe", LocalDate.of(1999,10,12),"3");
        university.addPhD("Javier Pastorino", LocalDate.of(1999,5,20),"7","Artificial Intelligence");
        university.addPhD("Ellie Miller", LocalDate.of(1999,5,20),"9","Forensics");

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

        System.out.println(">>>>>>>>>>>>>>>>>>>>>> UNIVERSITY Students Per Standing <<<<<<<<<<<<<<<<<<<<<<<<<<");

        for(Map.Entry<String,Integer> count : university.countStudentsPerStanding().entrySet()){
            System.out.printf("%-25s  %d\n", count.getKey(), count.getValue());
        }
        System.out.println();
        System.out.println("Removing Student by ID.....");
        university.removeStudentById("7");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>> updated UNIVERSITY Students <<<<<<<<<<<<<<<<<<<<<<<<<<");
        for (Student s : university.getStudents()){
            System.out.println(s);
        }
        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> UNIVERSITY <<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(university);
        System.out.println();

        university.randomizeStudentList();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> UNIVERSITY Students <<<<<<<<<<<<<<<<<<<<<<<<<<");
        for (Student s : university.getStudents()){
            System.out.println(s);
        }
        System.out.println();


        university.sortStudents();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>> UNIVERSITY Students <<<<<<<<<<<<<<<<<<<<<<<<<<");
        for (Student s : university.getStudents()){
            System.out.println(s);
        }
        System.out.println();

    }
}
