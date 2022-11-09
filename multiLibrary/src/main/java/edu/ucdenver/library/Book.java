package edu.ucdenver.library;

import java.time.LocalDate;

public class Book {

    private String title;
    private LocalDate publicationDate;
    private int numPages;
    private Author author;


    public Book(String title, LocalDate publicationDate, int numPages, Author author) {
        this.title = title;
        this.publicationDate = publicationDate;
        this.numPages = numPages;
        this.author = author;
    }

    public String toString(){
        return String.format("Book: %s, with %d pages published on %s written by %s.",
                this.getTitle(), this.getNumPages(), this.getPublicationDate(),this.getAuthor());
    }

    //getters
    public String getTitle() {
        return title;
    }
    public LocalDate getPublicationDate() {
        return publicationDate;
    }
    public int getNumPages() {
        return numPages;
    }
    public Author getAuthor() {
        return author;
    }

    //setters
    public void setTitle(String title){
        this.title = title;
    }
    public void setPublicationDate(LocalDate publicationDate){
        this.publicationDate = publicationDate;
    }
    public void setNumberPages(int numPages){
        this.numPages = numPages;
    }



}
