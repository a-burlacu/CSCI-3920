from __future__ import annotations
from datetime import date

import mysql.connector


# ---------------------------------------------------------------------------
#                               Author Class
# ---------------------------------------------------------------------------

class Author:
    _next_id: int = 0

    def __init__(self, oid: int = None, author_name: str = None):
        if not oid:
            oid = Author._next_id
            Author._next_id += 1
        self.__id = oid
        self.__name = author_name

    def __str__(self):
        return f"""{self.name} (Author)"""

    @property
    def name(self):
        return self.__name

    @property
    def id(self):
        return self.__id

    @property
    def num_of_pages(self):
        return

    # ----------------------
    def load(self):
        my_db = mysql.connector.connect(host=Library.DB["hostname"], port=Library.DB["port"], user=Library.DB["user"],
                                        password=Library["password"], database=Library.DB["db"])
        cursor = my_db.cursor()
        cursor.execute("SELECT id, name FROM author WHERE id = %s")

        # lazily process query, returns one tuple at a time
        for row in cursor.fetchall():
            self.__name = row[1]

    # represents a pointer to table that you query

    # ----------------------
    @staticmethod
    def load_all_authors() -> []:
        pass


# ---------------------------------------------------------------------------
#                               Book Class
# ---------------------------------------------------------------------------
class Book:
    _next_id: int = 0

    def __init__(self, oid: int = None, title: str = None, publication_date: int = None, author: Author = None,
                 number_pages: int = None):
        if not oid:
            oid = Book._next_id
            Book._next_id += 1

        self.__id = oid
        self.__title = title
        self.__publication_date = publication_date
        self.__author = author
        self.__num_of_pages = number_pages

    def __str__(self):
        return f"""Book: {self.title}, with{self.num_of_pages} pages published on {self.publication_date} written by {self.author}."""

    # ----------------------
    @property
    def name(self):
        return self.__name

    @property
    def publication_date(self):
        return self.publication_date

    @property
    def num_of_pages(self):
        return

    @property
    def author(self):
        return self.__name

    @author.setter
    def author(self, an_author):
        self.__name = an_author

    @property
    def id(self):
        return self.__id

    # ----------------------
    def load(self) -> Book:
        pass

    # ----------------------
    @staticmethod
    def load_all_books() -> []:
        pass


# ---------------------------------------------------------------------------
#                               Library Class
# ---------------------------------------------------------------------------
class Library:
    # create constant variable, dict contains hostname,port, username, password, db name
    DB = {"hostname": "localhost", "port": 3306, "user": "root", "password": "", "db": "csci3920"}

    def __init__(self, name: str):
        self.__name = name

    def __str__(self):
        return f"""{self.name} Library"""

    # ----------------------
    @property
    def name(self):
        return self.__name

    def __search_author(self, name: str):
        pass

    def add_book(self, title: str, publication_date: date, num_pages: int, author_name: str):
        pass

    def add_author(self, name: str):
        pass

    # ----------------------
    def load(self):
        pass
