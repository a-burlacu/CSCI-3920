# university.py
import re

from student import UnderGrad,Graduate
from course import Course

# ------------------------------------------------------------------
#                     University superclass
# ------------------------------------------------------------------
class University:
    """class that represents the university which has students and courses"""
    def __init__(self, name: str):
        self.__name = name
        self.students = []
        self.courses = []

    @property
    def name(self):
        return self.__name

    # ------------------------------------------------------------------
    #                         addition methods
    # ------------------------------------------------------------------
    def add_undergrad(self, name, email, gpa):
        """create and add undergraduate student to university"""
        self.students.append(UnderGrad(name, email, gpa))

    def add_graduate(self,name, email, level):
        """create and add graduate student to university"""
        self.students.append(Graduate(name, email,level))

    def add_course(self, subject, number, title):
        """add course to university"""
        try:
            self.courses.append(Course(subject, number, title))
        except ValueError:
            print("Course already exists in university.")

    # ------------------------------------------------------------------
    #                        deletion methods
    # ------------------------------------------------------------------
    def remove_student(self, name):
        """removes all students that have specified name"""
        removed_students = []
        for student in self.students:
            if re.search(name, student.name, flags=re.IGNORECASE):
                removed_students.append(student)
                self.students.remove(student)
        return removed_students

    # ------------------------------------------------------------------
    #                       getting methods
    # ------------------------------------------------------------------
    def get_students(self, name="", id="", email=""):
        """returns list of students that match search criteria"""
        temp_students = []

        for student in self.students:
            if re.search(name, student.name, flags=re.IGNORECASE) or \
                    re.search(id, student.id) or re.search(email,student.email,flags=re.IGNORECASE):

                temp_students.append(student)
        return temp_students

    def get_courses(self, subject="", number=0, title=""):
        """returns list of courses that match search criteria"""
        temp_courses = []
        for course in self.courses:
            if subject == course.subject or number == course.number  or title == course.title:
                temp_courses.append(course)
        return temp_courses

    # ------------------------------------------------------------------
    #                       enrollment methods
    # ------------------------------------------------------------------
    def enroll_student(self, id, subject, number):
        """enrolls student to speicified course"""
        for student in self.students:
            if id == student.id:
                for course in student.enrolled_to:
                    if subject == course.subject or number == course.number:
                        print("Student already enrolled in this course.")
                        break
                    else:
                        student.enroll_to(subject,number)


    def enrollment_report(self):
        """returns a dictionary of courses with enrolled students"""
        report = {}


