package edu.ucdenver.library;

import java.time.LocalDate;

public class PrintedBook extends Book{

    private int numPages;

    // subclass constructor
    public PrintedBook(String title, LocalDate publicationDate, String[] otherTitles, Author author, String isbn, int numPages) {

        super(title, publicationDate, otherTitles, author, isbn);
        this.numPages = numPages;

    }
    // class methods
    public int getNumPages(){
        return numPages;
    }


    public String toString() {
        return ("Printed-" + super.toString());

    }
}
