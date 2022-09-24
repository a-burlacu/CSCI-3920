package edu.ucdenver.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Library {

    private String libraryName;
    ArrayList<Book> libraryBooks = new ArrayList<>();
    ArrayList<Author> libraryAuthors = new ArrayList<>();

    // constructor
    public Library(String libraryName){
        this.libraryName = libraryName;
    }

    // getters
    public String getName() {
        return libraryName;
    }



    //returns Author object if found by searching String 'authorName'
    public Author getAuthor(String authorName) throws IllegalArgumentException {

        if (libraryAuthors.isEmpty()) {
            throw new IllegalArgumentException("This author does not exist.");
        }
        for (Author auth : libraryAuthors) {
            if (Objects.equals(auth.getName(), authorName)) {
                return auth;
                }
        }
        throw new IllegalArgumentException("This author does not exist.");
    }

    // if no author by name, add new one
    public void addAuthor(String authorName) throws IllegalArgumentException {

        if (libraryAuthors.isEmpty()) {
            Author temp = new Author(authorName);
            libraryAuthors.add(temp);
        } else {
            for (int i = 0; i < libraryAuthors.size(); i++) {
                if (Objects.equals(libraryAuthors.get(i).getName(), authorName)) {
                    throw new IllegalArgumentException("This author already exists.");
                } else {
                    Author temp = new Author(authorName);
                    libraryAuthors.add(temp);
                }
            }
        }
    }



    // adds printed book to library
    public void addPrintedBook(String title, LocalDate publicationDate, String [] otherTitles,
                               String authorName, String isbn,  int numPages) throws IllegalArgumentException {

        if(libraryAuthors.isEmpty()) {
            PrintedBook temp = new PrintedBook(title,publicationDate,otherTitles,getAuthor(authorName),isbn,numPages);
            libraryBooks.add(temp);
        } else {
            for (Author libraryAuthor : libraryAuthors) {
                if (!Objects.equals(libraryAuthor.getName(), authorName)) {
                    throw new IllegalArgumentException("This author does not exist.");
                } else {
                    PrintedBook temp = new PrintedBook(title, publicationDate, otherTitles, getAuthor(authorName),
                            isbn, numPages);
                    libraryBooks.add(temp);
                }
            }
        }
    }

    // adds electronic book to library
    public void addEBook(String title, LocalDate publicationDate, String [] otherTitles, String authorName,
                         String isbn,  int numberOfWords, int wordsPerPage) throws IllegalArgumentException{

        if(libraryAuthors.isEmpty()) {
            EBook temp = new EBook(title,publicationDate,otherTitles,getAuthor(authorName),isbn,numberOfWords,wordsPerPage);
            libraryBooks.add(temp);
        } else {
            for (Author libraryAuthor : libraryAuthors) {
                if (!Objects.equals(libraryAuthor.getName(), authorName)) {
                    throw new IllegalArgumentException("This author does not exist.");
                } else {
                    EBook temp = new EBook(title,publicationDate,otherTitles,getAuthor(authorName),isbn,numberOfWords,wordsPerPage);
                    libraryBooks.add(temp);
                }
            }
        }

    }


    // returns new-line delimited string printing all the books in the library
    public String printBooks() {

        String str1 = "";

        if(libraryBooks.isEmpty()) {
            str1 = "--o--";}
        else {
            for (Book book : libraryBooks) {
                str1 = str1 + book;
            }
        }
        return str1;
    }



    // display method
    public String toString(){

        String str1 = String.format("This is the %s library.\n== Author List ==\n", libraryName);
        String str2 = "";

        if (libraryAuthors.isEmpty()) {
            str2 = "--o--";
        }
        else {
            for(Author auth : libraryAuthors) {
                str2 = str2 + auth + "\n";
            }
        }

        String str3 = "\n== Book List ==\n";
        String str4 = printBooks();

        return str1 + str2 + str3 + str4;
    }
}
