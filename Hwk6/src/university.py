# university.py
import re

from student import Student, UnderGrad, Graduate
from course import Course


# ------------------------------------------------------------------
#                     University superclass
# ------------------------------------------------------------------
class University:
    """class that represents the university which has students and courses"""
    report = {}

    def __init__(self, name: str):
        self.__name = name
        self.students = []
        self.courses = []

    def __str__(self):
        """returns string representation of university"""
        return f'{self.name} University with {len(self.students)} students and {len(self.courses)} courses.'

    @property
    def name(self):
        return self.__name

    # ------------------------------------------------------------------
    #                         addition methods
    # ------------------------------------------------------------------
    def add_undergrad(self, name, email, gpa):
        """create and add undergraduate student to university"""
        self.students.append(UnderGrad(name, email, gpa))

    def add_graduate(self, name, email, level):
        """create and add graduate student to university"""
        self.students.append(Graduate(name, email, level))

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
            if name == student.name:
                removed_students.append(student)
                self.students.remove(student)
        return removed_students

    # ------------------------------------------------------------------
    #                       getting methods
    # ------------------------------------------------------------------
    def get_students(self, name="", sid="", email=""):
        """returns list of students that match search criteria"""
        if name == "" and sid == 0 and email == "":
            return self.students
        else:
            temp_students = []

            for student in self.students:
                # if student.name == name or student.id == id or student.email == email:
                if re.search(name, student.name) and re.search(sid, student.id) and re.search(email, student.email):
                    temp_students.append(student)

        return temp_students

    def get_courses(self, subject="", number=0, title=""):
        """returns list of courses that match search criteria"""

        if subject is None and number is None and title is None:
            return self.courses
        else:
            temp_courses = []
            for course in self.courses:
                if re.search(subject, course.subject) and re.search(str(number), str(course.number)) and re.search(
                        title, course.title):
                    # if course.subject == subject or course.number == number or course.title == title:
                    temp_courses.append(course)
            return temp_courses

    # ------------------------------------------------------------------
    #                       enrollment methods
    # ------------------------------------------------------------------
    def enroll_student(self, sid: str, subject: str, number: int):
        """enrolls student to speicified course"""

        for course in self.courses:
            if course.subject == subject and course.number == number:

                for student in self.students:
                    if re.search(sid, student.id):
                        student.enroll_to(course)

                    if course in self.report.keys():
                        self.report[course] = self.report.get(course, student.name)
                else:
                    self.report[course] = student.name

    def enrollment_report(self):
        """returns a dictionary of courses with enrolled students"""

        for student in self.students:
            for course in self.courses:
                if course in student.enrolled_to:
                    self.report[course] = self.report.get(course, student.name)

                    break

        return self.report
