from course import Course
from student import Student


class University:
    DB = {
        "hostname": "cse-mllab-pastorino.ucdenver.pvt",
        "port": 3399,
        "user": "guest",
        "passwd": "guest",
        "database": "university"
        # Complete the dicitonary with the information provided in the readme.md
    }

    def __init__(self, name: str):
        self.__name = name
        self.__students = []
        self.__courses = []

    @property
    def name(self):
        return self.__name

    def __str__(self):
        return """{} University with {} students and {} courses.""".format(self.__name, len(self.__students),
                                                                           len(self.__courses))
        pass

    @staticmethod
    def sample_student_list():
        return [Student("B0000", "John Doe", "john.doe@ucdenver.edu", "UNDERGRAD", 3.6),
                Student("B0001", "Jane Doe", "jane.doe@ucdenver.edu", "UNDERGRAD", 3.5),
                Student("B0002", "Alice Doe", "alice.doe@ucdenver.edu", "GRADUATE", 2.6),
                Student("B0003", "Martin Doe", "martin.doe@ucdenver.edu", "GRADUATE", 3.9)]

    # #################### LOADING DATA FROM DATABASE ####################

    def load_all_students(self) -> []:
        # implement using delegation to the Student Class.
        self.__students = Student.load_all(self.DB)
        return self.__students

    def load_students_by_name(self, name: str):
        #implement using delegation to the Student Class.

        for student in self.__students:
            if student.name == name:
                self.__students = Student.load_by_name(self.DB, name)
                return self.__students

        return None

    def load_all_courses(self):
        # implement using delegation to the Course Class.
        self.__courses =  Course.load_all(self.DB)
        return self.__courses

    def load_courses_by_subject(self, subject: str):
        # implement using delegation to the Course Class.

        for course in self.__courses:
            if course.subject == subject:
                self.__courses = Course.load_all_subject(self.DB, subject)
                return self.__courses

        return None
