# course.py

# ------------------------------------------------------------------
#                     Course superclass
# ------------------------------------------------------------------
class Course:
    """class that represents the courses at the university"""

    def __init__(self, subject: str, number: int, title: str):
        self.__subject = subject
        self.__number = number
        self.__title = title

    @property
    def subject(self):
        return self.__subject

    @property
    def number(self):
        return self.__number

    @property
    def title(self):
        return self.__title


    def __str__(self):
        """returns string representation of course"""
        return f'{self.subject}:{self.number}'