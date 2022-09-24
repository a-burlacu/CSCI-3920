package edu.ucdenver.library;

import java.time.LocalDate;

public class Book {

    private String title;
    private LocalDate publicationDate;
    private String [] otherTitles;
    private int numPages;
    private Author author;


    public Book(String title, LocalDate publicationDate, String[] otherTitles, int numPages, Author author){
        this.title = title;
        this.publicationDate = publicationDate;
        this.otherTitles = otherTitles;
        this.numPages = numPages;
        this.author = author;
    }

    public String toString(){
        String str1 = String.format("Book: %s, with %d pages published on %s written by %s.",
                title,numPages, publicationDate.toString(),author.getName());

        String str2 = "";
        for (String s : otherTitles) {
            str2 = str2 + "---a.k.a: " + s + "\n";

        }
        return str1 + str2;
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
    public int getNumberPages(){
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
    public void setNumberPages(int numPages){
        this.numPages = numPages;
    }
}