package edu.ucdenver.library;

import java.time.LocalDate;

public class MyLibraryApp {


    /**
     * This is a sample program that will use the Library.
     */
    public static void main(String[] args) {
        Library myLibrary = new Library("My Auraria Library");
        System.out.println(">>>>>>>>>>>>>>>>>>");
        System.out.println(myLibrary);
        System.out.println("<<<<<<<<<<<<<<<<<<");

        try {
            myLibrary.addAuthor("John Grisham");
        }
        catch (IllegalArgumentException ie){ System.out.println("ERROR:"+ie); }

        try {
            myLibrary.addAuthor("David Baldacci");
        }
        catch (IllegalArgumentException ie){ System.out.println("ERROR:"+ie); }

        try {
            myLibrary.addAuthor("John Grisham");
        }
        catch (IllegalArgumentException ie){ System.out.println("ERROR:"+ie); }


        System.out.println(">>>>>>>>>>>>>>>>>>");
        System.out.println(myLibrary);
        System.out.println("<<<<<<<<<<<<<<<<<<");

        try{

            myLibrary.addBook("The Guardians", LocalDate.of(2019,10,15),120,"John Grisham");
        }catch (IllegalArgumentException ie){ System.out.println("ERROR:"+ie); }

        try{

            myLibrary.addBook("Book 1", LocalDate.of(2000,1,1),120,"Al. Baker" );
        }catch (IllegalArgumentException ie){ System.out.println("ERROR:"+ie); }

        try{

            myLibrary.addBook("Camino Winds", LocalDate.of(2020,4,28),300,"John Grisham" );
        }catch (IllegalArgumentException ie){ System.out.println("ERROR:"+ie); }
        System.out.println(">>>>>>>>>>>>>>>>>>");
        System.out.println(myLibrary);
        System.out.println("<<<<<<<<<<<<<<<<<<");
    }
}

///*
//*** This is the sample of executing this program.
///Library/Java/JavaVirtualMachines/jdk1.8.0_261.jdk/Contents/Home/bin/java ..........
//>>>>>>>>>>>>>>>>>>
//This is the My Auraria Library library.
//== Author List ==
//== Book List ==
//--o--
//<<<<<<<<<<<<<<<<<<
//ERROR:java.lang.IllegalArgumentException: The author already exists.
//>>>>>>>>>>>>>>>>>>
//This is the My Auraria Library library.
//== Author List ==
//John Grisham (Author)
//David Baldacci (Author)
//== Book List ==
//--o--
//<<<<<<<<<<<<<<<<<<
//ERROR:java.lang.IllegalArgumentException: The author name does not exists
//>>>>>>>>>>>>>>>>>>
//This is the My Auraria Library library.
//== Author List ==
//John Grisham (Author)
//David Baldacci (Author)
//== Book List ==
//Book: The Guardians,  with 120 pages published on 2019-10-15 written by John Grisham (Author).
//   a.k.a:The Guardians: A Novel
//   a.k.a:Guardians
//   a.k.a:Guardianes
//
//Book: Camino Winds,  with 300 pages published on 2020-04-28 written by John Grisham (Author).
//   a.k.a:Camino Winds
//   a.k.a:Winds
//   a.k.a:The last one
//
//--o--
//<<<<<<<<<<<<<<<<<<
//
//Process finished with exit code 0
// */