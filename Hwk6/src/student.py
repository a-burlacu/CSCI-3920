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
    enrolled_to = []
    def __init__(self, name: str, email: str):

        self._name = name
        self._email = email

        # set first id, increment counter
        self._id = str(Student.id_count).rjust(6,"0")
        Student.id_count += 1


    @property
    def name(self):
        """return Student name"""
        return self._name

    @property
    def id(self):
        """return Student id"""
        return self._id

    @property
    def email(self):
        """return Student email"""
        return self._email

    @email.setter
    def email(self, email):
        # validate email format
        if not email.endswith("@ucdenver.edu"):
            raise AttributeError("Invalid Graduate level, enter 'master' or 'phd'.")
        else:
            self._email = email



    @staticmethod
    def reset_id_numbering():
        Student.id_count = 1

    @abstractmethod
    def get_standing(self):
        pass

    def enroll_to(self, course: Course):
        """adds student to enrolled_to list"""
        self.enrolled_to.append(course)

    def __str__(self):
        """returns string representation of student"""
        return f'{self.name:<20} -   {self.id.rjust(6,"0")}   - {self.email:<50} - Standing: {self.get_standing()}'


# ------------------------------------------------------------------
#                    Undergraduate subclass
# ------------------------------------------------------------------
class UnderGrad(Student):
    """class of Undergraduate students"""

    def __init__(self, name, email, gpa: float):
        super().__init__(name, email)
        self._gpa = gpa

    @property
    def gpa(self):
        """return undergrad gpa"""
        return self._gpa

    @gpa.setter
    def gpa(self, gpa):
        if self._gpa not in range(0, 4):
            raise ValueError("Invalid GPA, enter GPA between 0-4.")
        else:
            self._gpa = gpa

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
        super().__init__(name, email)
        self._current_level = current_level

    @property
    def current_level(self):
        return self._current_level

    @current_level.setter
    def current_level(self,current_level):
        if not(current_level.islower()):
            raise ValueError("Invalid Graduate level, enter 'master' or 'phd'.")
        else:
            self._current_level = current_level

    def get_standing(self):
       if self.current_level == "master":
           return "Master"
       elif self.current_level == "phd":
            return "PhD"

    def __str__(self):
        return super().__str__()
