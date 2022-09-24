package edu.ucdenver.libraryapp;

import edu.ucdenver.library.Library;
import java.time.LocalDate;

public class MyLibraryApp {
    public static void main(String[] args) {

        Library myLibrary = new Library("My Library");
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
            String[] titles = {"The Guardians: A Novel","Guardians","Guardianes"};
            myLibrary.addPrintedBook("The Guardians", LocalDate.of(2019,10,15),titles,
            "John Grisham", "isbn 123", 120 );
        }catch (IllegalArgumentException ie){ System.out.println("ERROR:"+ie); }

        try{
            String[] titles = {"b1","book 1","the title of book 1"};
            myLibrary.addPrintedBook("Book 1", LocalDate.of(2000,1,1),titles,
            "Al. Baker", "isbn 2", 200 );
        }catch (IllegalArgumentException ie){ System.out.println("ERROR:"+ie); }

        try{
            String[] titles = {"Camino Winds","Winds","The last one"};
            myLibrary.addEBook("Camino Winds", LocalDate.of(2020,4,28),titles,
            "John Grisham", "isbn 234", 500, 50 );
        }catch (IllegalArgumentException ie){ System.out.println("ERROR:"+ie); }

        System.out.println(">>>>>>>>>>>>>>>>>>");
        System.out.println(myLibrary);
        System.out.println("<<<<<<<<<<<<<<<<<<");
        System.out.println(">>>>>>>>>>>>>>>>>>");
        System.out.println("Books in the library:");
        System.out.println(myLibrary.printBooks());
        System.out.println("<<<<<<<<<<<<<<<<<<");

    }
}




// EXPECTED OUTPUT //
//------------
//        -- Notes: --
//        ------------
//        >>>>> and <<<<< are used to delimit the formats.
//        \n indicates the presence of a new line/
//        _ (underscore) in the format indicates a space at the end of the line (if needed)
//
//
//        ------------------------
//        ------  LIBRARY  -------
//        ------------------------
//        >>> FORMAT:<<<
//        >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> This line is not part of the format
//        This is the [library name] library.\n
//        == Author List ==\n
//        [one author per line. using Author format]
//        == Book List ==\n
//        [one author per line. using Book format - an empty line in after each book. ]
//        --o--
//        <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< This line is not part of the format
//
//        >>>> SAMPLE START <<<<<
//        This is the My Auraria Library library.
//        == Author List ==
//        John Grisham (Author)
//        David Baldacci (Author)
//        John Grisham (Author)
//        == Book List ==
//        Printed-Book: The Guardians (isbn:isbn 123), published on 2019-10-15 authored by John Grisham (Author) with 120 pages and 3 other titles.
//
//        Electronic-Book: Camino Winds (isbn:isbn 234), published on 2020-04-28 authored by John Grisham (Author) with 10 pages and 3 other titles.
//
//        --o--
//        >>>>> SAMPLE END <<<<<
//
//
//
//
//
//
//
//
//------------------------
//        ------    BOOK   -------
//        ------------------------
//        >>> FORMAT:<<<
//        >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> This line is not part of the format
//        Book: [book name] (isbn:[book isbn]), published on [date YYYY-MM-DD] authored by [author using author's format] with [num of pages(integer)] pages and [number of other titles (integer)] other titles.\n
//        <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< This line is not part of the format
//
//        >>>> SAMPLE START <<<<<
//        Book: The Guardians (isbn:isbn 123), published on 2019-10-15 authored by John Grisham (Author) with 120 pages and 3 other titles.
//        >>>>> SAMPLE END <<<<<
//
//
//
//
//
//
//
//
//------------------------
//        ----- PRINTED BOOK -----
//        ------------------------
//        >>> FORMAT:<<<
//        >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> This line is not part of the format
//        Printed-[the book text]
//        <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< This line is not part of the format
//        Hint: do not rewrite here!
//
//        >>>> SAMPLE START <<<<<
//        Printed-Book: The Guardians (isbn:isbn 123), published on 2019-10-15 authored by John Grisham (Author) with 120 pages and 3 other titles.
//        >>>>> SAMPLE END <<<<<
//
//
//
//
//
//
//
//
//
//------------------------
//        -----    EBOOK     -----
//        ------------------------
//        >>> FORMAT:<<<
//        >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> This line is not part of the format
//        Electronic-[the book text]
//        <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< This line is not part of the format
//        Hint: do not rewrite here!
//
//        >>>> SAMPLE START <<<<<
//        Electronic-Book: The Guardians (isbn:isbn 123), published on 2019-10-15 authored by John Grisham (Author) with 120 pages and 3 other titles.
//        >>>>> SAMPLE END <<<<<
//
//
//
//
//
//
//------------------------
//        -----    AUTHOR    -----
//        ------------------------
//        >>> FORMAT:<<<
//        >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> This line is not part of the format
//        [author name] (Author)
//        <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< This line is not part of the format
//        Hint: do not rewrite here!
//
//
//        >>>> SAMPLE START <<<<<
//        John Grisham (Author)
//        >>>>> SAMPLE END <<<<<
//
//
