package edu.ucdenver.library;

public class Author {

    private String authorName;

    // constructor
    public Author(String authorName) {
        this.authorName = authorName;

    }

    // getter
    public String getName() {
        return authorName;
    }


    // class methods
    @Override
    public String toString(){

        return String.format("%s (Author)", authorName);
    }
}