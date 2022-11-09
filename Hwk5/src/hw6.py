def split_number(num):
    """takes an integer and returns a string with a digit, space, digit, space, ...., digit.
        (no space at the end) for each digit in the number."""

    strint = []  # string-int = strint
    for x in str(num):
        strint.append(x)

    print(' '.join(strint))


def is_palindrome(num):
    """it takes an integer and returns true if the number is a palindrome, false otherwise"""
    strint = []
    strint1 = []
    strint2 = []
    mid = len(strint)//2  # find halfway point in string
    for x in str(num):
        strint.append(x)

    for x in strint[:mid]:  # make list of first half of digits in integer
        strint1.append(x)

    for x in strint[mid:]:  # make list of second half of digits
        strint2.append(x)


    print(strint1, strint2)


def compute_variance():
    """takes an arbitrary number of arguments and computes the variance"""
    pass


def compute_variance_req():
    """a variant of the previous, in which your function requires at least 2 arguments"""
    pass


def compute_change_few_coins():
    """The function takes a real number representing the change a cashier will give the customer.
    It will compute, the minimum number of coins to give the customer for the exact amount of the change.
    The function will return a tuple (see sec 4.5) specifying the number of coins of each value to give the customer.
    Tuple's order will be (Dollar, quarter, dime, nickel, penny) each valued in ($1, $0.25, $0.10, $0.05, $0.01)"""
    pass


def binary_to_decimal():
    """It takes a string as an argument, containing a sequence of all 0's and 1's.
        The function returns the decimal number equivalent to the received binary string. """
    pass


def factorial():
    """The function implements an iterative factorial.
        It takes an integer n as an argument and returns n!"""
    pass


def approx_pie():
    """The function approximates the value of pi.
        It takes an integer argument representing the number of terms used to compute the approximation. """
    pass


def approx_e():
    """The function approximates the value of e.
        It takes an integer representing the number of terms used to compute the approximation.
        Hint: use the factorial implemented above"""
    pass
