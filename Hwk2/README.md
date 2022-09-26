# 1. Description
This homework will navigate through concepts of arrays, collections, inheritance, polymorphism, abstract classes and the use of interfaces. In summary, you will be constructing a very simple program to manipulate both printed and electronics books in a library. 

# 2. Problem Description
The classes with its methods (services or public interface) and attributes are described in the UML Class Diagram below. Please remember that in UML composition and aggregations are usually implemented by instance attributes, and in the case of a composition, the class that is composed by other objects has usually the responsibility to create those objects, while if the class that aggregates other objects usually does not create those objects. 

## 2.1 Packages
The project will have two packages one. One to store the application and another to store the library domain logic. In UML class diagram packages are shown as "folders", and the package name goes in the upper left tab of that folder.

In Java, packages are represented by 1) a directory structure and 2) a package statement. For instance, if a class Example, stored in Example.java, is on the package edu.ucdenver.csci3920, the first line of the file Example.java should be "package edu.ucdenver.csci3920;" and the file should be saved in the following path: "src/edu/ucdenver/csci3920/Example.java". It is customary to use unique names for the packages, and therefore it is usual to use the inverse domain name of the company and department, thus for csci3920.ucdenver.edu, the package would be edu.ucdenver.csci3920.

## 2.2 Main Classes
### Library Class

The library class works as some fashion of public interface for the package, and the apps access the domain logic through this class. 

#### Main Methods:

`getAuthor(author name)` : takes the name of the author and returns the Author if it exists. Throws an illegal argument exception otherwise.

`addPrintedBook(title, publication date,other titles, author name, isbn, number of pages)`: adds a new printed book to the library. If the author is not in the library, it throws an illegal argument exception.

`addEBook(title, publication date,other titles, author name, isbn, number of words in the ebook, words per page)`: analogous to addPrintedBook but for electronic books.

`addAuthor(author name)`: if there are no author with that name, adds a new one. Throws an illegal argument exception otherwise.

`printBooks()`: returns a new-line delimited string printing all the books in the library. 
### Book, PrintedBook EBook Classes
These classes represent the hierarchy of different types of books that the library may have. Book is part of the generalization of books. PrintedBook represents paperback books while EBook represent electronic (digital) books. 
#### Main Methods:

`getNumPages()`: returns the number of pages in the book. This will be different for books and for ebooks. For the latter are basically computed by $\lfloor{numWords\ /\ numWordsPerPage} \rfloor$ and for printed books is the actual number of pages. *Throw ArithmeticException error to prevent division by 0!* 

`toString()`: each class should return the string that represent the context of the object for the class. Code should not be rewritten but reused.

#### Constructors:

Find below the description of the arguments for each class constructor:

`Book(book title, publication date, list of other titles, author, isbn)`

`EBook(book title, publication date, list of other titles, author, isbn,  number of words, words per page)`

`PrintedBook(book title, publication date, list of other titles, author, isbn, number of pages)`

`Library(library name)`

`Author(author name)`

### MyLibraryApp Class
Contains a demo program that uses the library domain classes.

# 3. UML Class Diagram
<img src="https://github.com/a-burlacu/CSCI-3920/blob/main/Hwk2/Hwk2.png" width="300" center >