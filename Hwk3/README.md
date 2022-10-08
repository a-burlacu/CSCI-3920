# 1. Description
This homework will navigate through concepts of inheritance, polymorphism, abstract classes, the use of interfaces and generic collections while implementing a system for the University.
# 2. To-Dos
### 1. Implement a solution for a University system as we did in class
*(see UML below)*

---

### 2. Adding student Id.
- Add a string attribute (id)for students that represents the student's id.
- Do the proper modification to the constructors to take the id as the 3rd parameter in all constructors.
- Follow Inheritance and Polymorphism guidelines to apply this change.
- Add a `getId()` getter to return the student's id.
- Do NOT change the `toString()` representation of any class.
---
### 3. Modify Graduate Student class
- Prevent the class to instantiate objects, and in consequence remove its implementation of `getStanding()`
---
### 4. Modifications to University class:
#### 1. Impact changes to add student id.
- Make all necessary changes for all add methods (total 3) to take the student id as third argument.

#### 2. Sorting Students
-Students should be sorted by means of the `StudentComparator()` class, and implementation of `java.util.Comparator` and 
implementing the compare method
- Students will be sorted in a multi-lever ordering:
  - First sort by standing, in the following order: Undergraduate, Master, PhD
  - For students with the same standing, sort them by lexicographically by name.
  - *Hint:* create a function `getStandingOrder(String standing)` in the comparator, that for the standing returns an 
    integer (0,1,2,3) representing ordinal of the standing (0 for undergrad, 1 for master, 2 phd and 3 for other, not known yet).
  - Then use that representation in the same fashion of the <a href="https://docs.oracle. com/javase/8/docs/api/java/lang/Comparable.html#compareTo-T-">`compareTo` </a> method.
  
#### 3. Add a method called `countStudentsPerStanding()`
- Method takes no arguments and returns a key-value data structure (HashMap), where the key is the standing and the 
  value and integer representing how many students are in each standing.
- The method will only include standings that have **at least one** student in the university.

#### 4. Add a method called `removeStudentById()`
- The method takes a string representing the student id.
- Will remove all the students with that id.
- If there is no student matching the id, then an `IllegalArgumentException` with the message "No student found with id:##" will be produced. Note that ## represent the id received

#### 5. Add a method called `randomizeStudentList()`
- This method does not return any data.
- Using the functionality provided by `java.util.Collections`, randomize the positions of the students in the university student list.
- This method will NOT return the new randomized collection, instead it changes the actual position of student object in the university attribute storing the students list object.
---

# 3. UML Class Diagram
<img src="https://github.com/a-burlacu/CSCI-3920/blob/main/Hwk3/hwk3.png" width="300" center >