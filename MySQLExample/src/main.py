from library import Library, Author

if __name__ == "__main__":
    library = Library("Auraria")
    library.load()
    print(str(library).replace("|","\n"))

    author = Author()
    author.load()
    print(str(author).replace("|","\n"))