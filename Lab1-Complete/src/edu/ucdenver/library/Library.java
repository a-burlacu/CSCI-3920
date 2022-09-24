package edu.ucdenver.library;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Library {

    private String name;

    private ArrayList<Book> books;
    private ArrayList<Author> authors;

    public Library(String name){
        this.name = name;
        books = new ArrayList<>();
        authors = new ArrayList<>();
    }

    public void addBook(String title, LocalDate publicationDate, String[] otherTitles, int numPages, String name) throws IllegalArgumentException{

        Author temp = new Author(name);
        try {
            for (Author auth : authors) {
                if (auth.equals(temp)) {
                    Book book = new Book(title, publicationDate, otherTitles, numPages, temp);
                    books.add(book);
                }
            }
        }
        catch (IllegalArgumentException ie){ System.out.println("ERROR: This author does not exist."+ie);
        }
    }

    public void addAuthor(String name) throws IllegalArgumentException{

        Author temp = new Author(name);

        try {
            if (!authors.contains(temp)) {
                Author newAuthor = new Author(name);
                authors.add(newAuthor);
            }

        }
        catch (IllegalArgumentException ie){System.out.println("ERROR: This author already exists." + ie);
        }
    }

    public String toString(){

        String str1 = String.format("This is the %s library. \n== Author List ==\n",name);
        String str2 = "";

        if (authors.isEmpty()) {
            str2 = "--o--";
        }
        else {
            for(Author auth : authors) {
                str2 = str2 + auth + "\n";
            }
        }

        String str3 = "\n== Book List ==\n";
        String str4 = "";

        if(books.isEmpty()) {
            str4 = "--o--";
        }
        else {
            for (Book bk : books) {
                str4 = str4 + bk + "\n";
            }
        }
        return str1 + str2 + str3 + str4;
    }

    public String getName() {
        return name;
    }

}
