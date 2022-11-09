# 1. Description
**For this homework, you are not allowed to import any module, and you need to implement the requirements using basic control structures and functions as described in these chapters.**

# 2. To-Do

1. Create a *Pure Python* project in PyCharm using a virtual environment with python 3.8. In that project create a folder called  ***src*** and mark that [folder as sources root](https://www.jetbrains.com/help/pycharm/configuring-folders-within-a-content-root.html#project_tool_window).
2. Create a module (file) called **hw5.py** under the *src* directory. Remember that in Python a module is just a python file that will declare functions and/or classes. *Do not add any other code outside your functions.*
3. Create a python file called `main.py`, in which you can test your functions. You will submit this but we will not execute this file. 
   1. the first statement you should have in main.py is "*import hw5"*
   2. then you can test your functions, for instance, if in hw5.py you have a function "*def test():...*", in your main.py you should be able to call "*hw5.test()*". We will use this syntax to grade your homework. 

**Create the following functions in your module *hw5.py:***

1. Function: ***`split_number`***

   - it takes an integer and returns a string with a digit, space, digit, space, ...., digit. (no space at the end) for each digit in the number.
   - Example for 123 will return "1 2 3"

2. Function: ***`is_palindrome`***

   - it takes an integer and returns true if the number is a palindrome, false otherwise

   - Example for 15561 will return *False*, for 123321 will return *True*

3. Function: ***`compute_variance`***

   - takes an arbitrary number of arguments (see sect. 4.11) and computes the variance

   - Variance is computed as
      $
       \sigma^{2}=\frac{\left\{1\right\}}{m-1}\sum_{i=1}^m\left(x_i-\overline{x}\right)^2 
      $
      
       σ2={1}m−1∑mi=1(xi−x¯¯¯)2

- 
  - where *m* is the number of elements to compute the variance, xi is the *ith* element, and  x¯ is the mean of the values.
  - Example *hw6.compute_variance(1,2,3,4,5,4,3,4,3)* will return *1.4444444444444446*

1. Function: ***`compute_variance_req`***
   - a variant of the previous, in which your function requires at least 2 arguments (values to compute the variance). 

2. Function: ***`compute_change_few_coins`***

   - The function takes a real number representing the change a cashier will give the customer. It will compute, the minimum number of coins to give the customer for the exact amount of the change. 

   - The function will return a tuple (see sec 4.5) specifying the number of coins of each value to give the customer. Tuple's order will be (Dollar, quarter, dime, nickel, penny) each valued in ($1, $0.25, $0.10, $0.05, $0.01)

   - For instance, if you change is $23.73, you will return a tuple: (23, 2, 2, 0, 3 ) representing 23 dollars, 2 quarters, 2 dimes, and 3 pennies

   - *HINT*: Do not use decimals to compute the small coins but change the scale to use integers

3. Function: ***`binary_to_decimal`***

   - It takes a string as an argument, containing a sequence of all 0's and 1's.

   - The function returns the decimal number equivalent to the received binary string. Check the description of exercise 3.20 in our textbook for more detail on the conversion.

   - Example: "01" will return 1, and "1101" will return 13.

4. Function:  ***`factorial`***

   - The function implements an iterative factorial.
   - It takes an integer *n* as an argument and returns *n!*
   - The method needs to be computed interactively (not recursively)

5. Function: ***`approx_pie`***

   - The function approximates the value of π. It takes an integer argument representing the number of terms used to compute the approximation. 
     $
     \pi=4-\frac{4}{3}+\frac{4}{5}-\frac{4}{7}+\frac{4}{9}-\frac{4}{11}+\:...
     $

     - The previous example has 5 terms being $-\frac{4}{3}$ the first and $-\frac{4}{11}$ the fifth.

6. Function: ***`approx_e`***
   - Similarly, we will approximate the number $e =2.718281828459045$ The function takes an integer representing the number of terms used to compute the approximation.
   - The approximation is computed as $e=1+\frac{1}{1!}+\frac{1}{2!}+\frac{1}{3!}+\frac{1}{4!}+\frac{1}{5!}+...$
   
   - The previous example has 6 terms.
   
   - *Hint*: use the factorial implemented above
