package edu.ucdenver.library;

import java.time.LocalDate;

public class Book {

    private String title;
    private LocalDate publicationDate;
    private String [] otherTitles;
    private String isbn;
    private int numPages;
    private Author author;


    public Book(String title, LocalDate publicationDate, String[] otherTitles, Author author, String isbn){
        this.title = title;
        this.publicationDate = publicationDate;
        this.otherTitles = otherTitles;
        this.isbn = isbn;
        this.author = author;
    }

    @Override
    public String toString(){
        return String.format("Book: %s (isbn:%s), published on %s authored by %s with %d pages and %d other " +
                        "titles.\n",
                title, isbn, publicationDate.toString(), author.toString(), this.getNumPages(), otherTitles.length);
    }

    //getters
    public String getTitle(){
        return title;
    }
    public LocalDate getPublicationDate(){
        return publicationDate;
    }
    public String[] getOtherTitles(){
        return otherTitles;
    }
    public String getISBN() {
        return isbn;
    }
    public int getNumPages() {
        return numPages;
    }
    public Author getAuthor(){
        return author;
    }

    //setters
    public void setTitle(String title){
        this.title = title;
    }
    public void setPublicationDate(LocalDate publicationDate){
        this.publicationDate = publicationDate;
    }
    public void setOtherTitles(String[] otherTitles){
        this.otherTitles = otherTitles;
    }

}