package edu.ucdenver.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Library {

    private String libraryName;
    private ArrayList<Book> libraryBooks = new ArrayList<>();
    private ArrayList<Author> libraryAuthors = new ArrayList<>();

    // constructor
    public Library(String libraryName){
        this.libraryName = libraryName;
    }


    public String getName() {
        return libraryName;
    }

    public synchronized void addBook(String title, LocalDate publicationDate,int numPages, String authorName) throws IllegalArgumentException {

        Author auth = null;

        for (Author a : this.libraryAuthors) {
            if (a.getName().equals(authorName)) {
                auth = a;
                break;
            }
        }
        if (auth == null) {
            throw new IllegalArgumentException("This author does not exist.");
        }
        Book temp = new Book(title, publicationDate, numPages, auth);
        libraryBooks.add(temp);
    }

    public synchronized void addAuthor(String authorName) throws IllegalArgumentException {

        for(Author author : libraryAuthors) {
            if(author.getName().equals(authorName)) {
                throw new IllegalArgumentException("Author already exists.");
            }
        }
        Author anAuthor = new Author(authorName);
        libraryAuthors.add(anAuthor);
    }

    public synchronized String toString(){
        StringBuilder output = new StringBuilder();
        output.append(String.format("This is the %s Library. |", this.libraryName));
        output.append("== Author List == |");
        for(Author a: libraryAuthors){output.append(a).append("|");}
        output.append("== Book List == |");
        for(Book b: libraryBooks){output.append(b).append("|");}
        output.append("--o--");

        return output.toString();

//        String str1 = String.format("This is the %s library. | == Author List == |",libraryName);
//        String str2 = "";
//
//        if (libraryAuthors.isEmpty()) {
//            str2 = "--o--";
//        }
//        else {
//            for(Author auth : libraryAuthors) {
//                str2 = str2 + auth + "\n";
//            }
//        }
//
//        String str3 = "\n== Book List ==\n";
//        String str4 = "";
//
//        if(libraryBooks.isEmpty()) {
//            str4 = "--o--";
//        }
//        else {
//            for (Book bk : libraryBooks) {
//                str4 = str4 + bk + "\n";
//            }
//        }
//        return str1 + str2 + str3 + str4;
   }

}
