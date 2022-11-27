# student.py
"""stores Student, UnderGrad, and Graduate classes"""
from abc import ABC, abstractmethod
from course import Course


# ------------------------------------------------------------------
#                     Student superclass
# ------------------------------------------------------------------
class Student(ABC):
    """abstract class that represents general students"""
    id_count = 0o00001

    def __init__(self, name: str, email: str):

        self.__name = name

        # validate email format
        if email.islower() and email.endswith("@ucdenver.edu"):
            self.__email = email
        else:
            raise ValueError("Invalid Email, use 'username@ucdenver.edu' format.")

        # set first id, increment counter
        self.__id = str(Student.id_count)
        Student.id_count += 1

        self.enrolled_to = []

    @property
    def name(self):
        """return Student name"""
        return self.__name

    @property
    def id(self):
        """return Student id"""
        return self.__id

    @property
    def email(self):
        """return Student email"""
        return self.__email

    @staticmethod
    def reset_id_numbering():
        Student.id_count = 0o00001

    @abstractmethod
    def get_standing(self):
        pass

    def enroll_to(self, course: Course):
        """adds student to enrolled_to list"""
        self.enrolled_to.append(course)

    def __str__(self):
        """returns string representation of student"""
        return f'{self.name:<{20}} -   {self.id:06}   - {self.email:50} - Standing: {self.get_standing()}'


# ------------------------------------------------------------------
#                    Undergraduate subclass
# ------------------------------------------------------------------
class UnderGrad(Student):
    """class of Undergraduate students"""

    def __init__(self, name, email, gpa: float):
        super().__init__(name, id, email)
        if self.__gpa not in range(0, 4):
            raise ValueError("Invalid GPA, enter GPA between 0-4.")
        else:
            self.__gpa = gpa

    @property
    def gpa(self):
        """return undergrad gpa"""
        return self.__gpa

    # overriding abstract method
    def get_standing(self):
        return "Undergraduate"

    def __str__(self):
        return super().__str__()


# ------------------------------------------------------------------
#                       Graduate subclass
# ------------------------------------------------------------------
class Graduate(Student):
    """class of graduate (master/phd) students"""

    def __init__(self, name, email, current_level: str):
        super().__init__(name, id, email)
        if current_level != "master" or "phd":
            raise ValueError("Invalid Graduate level, enter 'master' or 'phd'.")
        else:
            self.__current_level = current_level

    @property
    def current_level(self):
        return self.__current_level

    # overriding abstract method
    def get_standing(self):
        return self.current_level

    def __str__(self):
        return super().__str__()
