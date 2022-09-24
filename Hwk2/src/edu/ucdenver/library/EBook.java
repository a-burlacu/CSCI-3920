package edu.ucdenver.library;

import java.time.LocalDate;

public class EBook extends Book{

    private int numWords;
    private int wordsPerPage;

    // subclass constructor
    public EBook(String title, LocalDate publicationDate, String[] otherTitles, Author author, String isbn,
                 int numWords, int wordsPerPage) {

        super(title, publicationDate, otherTitles, author, isbn);
        this.numWords = numWords;
        this.wordsPerPage = wordsPerPage;

    }
    // getters
    public int getNumPages(){
        int numPages = 0;
        try{
             numPages = numWords/wordsPerPage;
        } catch (ArithmeticException e){System.out.println("ERROR:"+e);}
        return numPages;
    }
    public void setWordsPerPage(int wordsPerPage){
        this.wordsPerPage = wordsPerPage;
    };


    public String toString() {
        return "Electronic-" + super.toString();

    }
}
