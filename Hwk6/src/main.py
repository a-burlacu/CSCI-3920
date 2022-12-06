# main.py - for testing purposes
from student import *
from course import *
from university import *

def main():

    print(f'Hi')


if __name__ == '__main__':

    university = University("Twilight")

    university.add_undergrad("Alice Cullen", "alice@ucdenver.edu",3.0)
    university.add_undergrad("Edward Cullen", "edward@ucdenver.edu", 3.6)
    university.add_undergrad("Edward Cullen", "edward2@ucdenver.edu", 2.6)
    university.add_undergrad("Rosalie Cullen", "rosalie@ucdenver.edu", 2.6)
    university.add_undergrad("Emmett Cullen", "emmett@ucdenver.edu", 2.0)
    university.add_undergrad("Jasper Cullen", "jasper@ucdenver.edu", 3.9)
    university.add_undergrad("Carlisle Cullen", "carlisle@ucdenver.edu", 4.0)
    university.add_undergrad("Esme Cullen", "esme@ucdenver.edu", 3.5)

    university.add_graduate("Bella Swan", "bella@ucdenver.edu", "master")
    university.add_graduate("Charlie Swan", "charlie@ucdenver.edu","phd")
    university.add_graduate("Jacob Black", "jacob@ucdenver.edu", "master")
    university.add_graduate("Billy Black", "billy@ucdenver.edu", "phd")

    print("\n\n")
    print(university.__str__())

    print("----------------------------------------------------------------------")
    for i in range(len(university.students)):
        print(university.students[i])
    print("----------------------------------------------------------------------")

    university.add_course("CSCI",3920,"Advanced Programming with Java & Python")
    university.add_course("CSCI",3412,"Algorithms Analysis")
    university.add_course("CSCI",2421,"Data Structures")
    university.add_course("CSCI",3515,"Internet of Things")
    university.add_course("CSCI",2511,"Discrete Structures")


    for i in range(len(university.courses)):
        print(university.courses[i])

    print("----------------------------------------------------------------------")
    university.enroll_student('000007','CSCI', 3920)
    university.enroll_student('000003', 'CSCI', 3920)

    university.remove_student("Alice Cullen")
    print(university.__str__())
    print("----------------------------------------------------------------------")
    for i in range(len(university.students)):
        print(university.students[i])

    print(university.enrollment_report())
    print(university.get_students("Edward"))
    print(university.get_courses("CSCI"))




