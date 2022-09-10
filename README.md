## CSCI-3920 (Fall 2022)
### Advanced Programming with Java &amp; Python
##### @ University of Colorado Denver
---

# <ins>List of Assignments:</ins>

## **HW 1:** 
### 1. Part #1 - Pythagorean Triples
   1.  A right triangle can have sides whose lengths are all integers. The set of three integer values for the lengths of the sides of a right triangle is called a Pythagorean triple. The lengths of the three sides must satisfy the relationship that the sum of the squares of two of the sides is equal to the square of the hypotenuse.
   2.  To do this, you will write a program that given three integers, will say if satisfy the conditions to be the sides of a Pythagorean triple. Moreover, you will compute all possible Pythagorean triples for a given range of side sizes.
         1. Create a new Java Class called `PythagoreanTriples`
         2. Define a method `isTriple` that receives three int numbers and returns either true or false (boolean) if $a^{2}+b^{2}=c^{2}$
         3. Define a method `listOfTriples` that
            1.  takes six integers namely: `aMin`, `bMin`, `cMin`, `aMax`, `bMax`, `cMax`
            2. returns a `String` that lists all Pythagorean Triples between [aMin, aMax], [bMin, bMax], [cMin, cMax] 

   For example: 

     listOfTriples(1,2,3,100,10,20)
     
  will return a string:
     
     3 4 5
     4 3 5
     6 8 10
     8 6 10
     12 5 13
     12 9 15
     15 8 17
     
  More clearly the string:
  `"3 4 5\n4 3 5\n6 8 10\n12 5 13\n 12 9 15\n15 8 17\n"`
  Corresponding to each of the values of the triplets **a b c\n**  (Note the new line always)

### 2. Part #2 - Diamond Printing Program
   Construct a program to print shapes like the following:

      *
     ***
    *****
     ***
      *
1. In the same project, create a class called `DiamondPrinting`
   
2. Define a public method called `getCharSequence`, that takes two arguments: A  String, and an int
     1. Returns a string repeating the string argument as many times as the int argument. 
     2.  Examples `getCharSequence("a",5)`  will return `"aaaaa"`
  
  1. Define a public method called `getDiamond` that
        1. Takes an int representing how many lines should the diamond use. 
           1. In the example above, it would correspond to 5.
           2. The number of lines must be an odd number, between 1 and 99.
        2. It returns a `String`, representing the diamond
        3. If the input is invalid, just return an empty string.
        4. You will need to use the getCharSequence method defined in (2)

Example:

`getDiamond(5)`

Would return the following String:

  `*\n ***\n*****\n ***\n  *\n`

Which represents the image from the example above. Note there are no spaces after the *.

*Hint: consider two iterations, one that prints the upper part, and another that prints the lower part of the diamond. You may want to use the String.format() method.*

### 3. Part #3 - Digital Health Records
   In this problem, you’ll design a “starter” HealthProfile class for a person.
1. In the same project create a class called `HealthRecord`
2. Define the following private attributes for the class:
   1.  first name, last name and gender (M/F),
   2. Date of birth, consisting of separate attributes for the month, day and year of birth
   3. Height (in inches) and Weight (in pounds).
3. Add a constructor that receives the data to properly initialize the classes' attributes.
4. For each attribute, provide set and get methods. Except for the Date of Birth, which you will provide:
   1. A getter for each part of the date (`getDobDay`, `getDobMonth` and `getDobYear`)
   2. A `setDOB` method that takes three integers (day, month and year - in that sequence) to initialize all the attributes.
5. In addition provide these methods:
   1. `getAge()`, which returns an integer corresponding with the person's age. Consider only the year for this computation.
      1. You can for this: `import java.util.Calendar;`
      2. To get current year:  `int currentYear = Calendar.getInstance().get(Calendar.YEAR);`
   2. `getMaximumHeartRate()`, which returns and integer corresponding to $220-age$.
   3. `getTargetHeartRate()`
      1. which returns a string representing the target heart rate of the person. 
      2. the output format should be `"%d - %d"`, representing the minimum HR and the maximum HR recommended when exercising. 
      3. The Minimum Target HR is 50% of the Maximum Heart Rate
      4. The Maximum Target HR is 85% of the Maximum Heart Rate.
   4. `getBMI()`
      1. returns a decimal number representing the Body Mass Index.
      2. Number should have 2 decimal places 
   5. `toString()`
      1. Returns a `String`, representing the object. 
      2. This is a special method for printing, we will discuss it later in the course, but for now should suffice to know that it should return a string to represent the current object. 
      3. The string should have this format:
         1. `Name:{lastName}, {firstName}. Gender:{gender} DOB:{month}/{day}/{year} AGE:{age} H:{height}in. W:{weight}lb., MHR:{maximumHeartRate}, THR:{targetHeartRate}, BMI:{BMI}`
         2. {xxx} represent data from the object.
         3. date parts should have leading zeros and be format MM/DD/YYYY, i.e. April 1st 2020 should be shown as 04/01/2020
         4. Age, Height, Weight and MHR should be aligned to a field of 3 digits in width.

    Example:
    ```
    hr = new HealthRecord("John","Doe",'M', 1,3,1990,70,180);
    System.out.println(hr);
    hr = new HealthRecord("Jane","Doe",'F', 20,5,1995,60,150);
    System.out.println(hr);
  
    ```
    The output should be:
    ```
    Name:Doe, John. Gender:M DOB:03/01/1990 AGE: 30 H: 70in. W:180lb., MHR:190, THR:95 - 161, BMI:25.82
    Name:Doe, Jane. Gender:F DOB:05/20/1995 AGE: 25 H: 60in. W:150lb., MHR:195, THR:97 - 165, BMI:29.29
    ```
<img src="https://github.com/a-burlacu/CSCI-3920/blob/main/Hwk1/hwk1_health_record.png" width="300">