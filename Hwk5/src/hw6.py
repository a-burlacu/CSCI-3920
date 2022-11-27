def split_number(num):
    """takes an integer and returns a string with a digit, space, digit, space, ...., digit.
        (no space at the end) for each digit in the number."""

    strint = []  # string-int = strint
    for x in str(num):
        strint.append(x)

    strint = ' '.join(strint)

    return strint


def is_palindrome(num):
    """it takes an integer and returns true if the number is a palindrome, false otherwise"""

    temp = num
    rev = 0
    while num > 0:
        dig = num % 10
        rev = rev * 10 + dig
        num = num // 10

    # compare strings to see if they are equal
    if temp == rev:
        return True
    else:
        return False


def compute_variance(*args):
    """takes an arbitrary number of arguments and computes the variance"""

    n = len(args)
    mean = sum(args) / n
    deviations = 0

    for x in args:
        deviations = deviations + ((x - mean) ** 2)

    variance = deviations / (n - 1)

    return variance


def compute_variance_req(num1, num2, *args):
    """a variant of the previous, in which your function requires at least 2 arguments"""

    n = 2 + len(args)
    mean = (num1 + num2 + sum(args)) / n
    deviations = ((num1 - mean) ** 2) + ((num2 - mean) ** 2)

    for x in args:
        deviations = deviations + ((x - mean) ** 2)

    variance = deviations / (n - 1)

    return variance


def compute_change_few_coins(change):
    """Takes a real number representing the change a cashier will give the customer.
        Computes minimum number of coins to give the customer for the exact amount of the change.
        Return a tuple specifying the number of coins of each value to give the customer.
        Tuple's order will be (Dollar, quarter, dime, nickel, penny) each valued in ($1, $0.25, $0.10, $0.05, $0.01)"""

    change = int(change * 100)  # convert decimal to whole integer

    dollars = change // 100
    change = change % 100

    quarters = change // 25
    change = change % 25

    dimes = change // 10
    change = change % 10

    nickels = change // 5

    pennies = change % 5

    change_amount = (dollars, quarters, dimes, nickels, pennies)  # tuple of values
    return change_amount


def binary_to_decimal(num):
    """It takes a string as an argument, containing a sequence of all 0's and 1's.
        The function returns the decimal number equivalent to the received binary string. """

    dec_value = 0
    base = 1
    len1 = len(num)
    for i in range(len1 - 1, -1, -1):
        if (num[i]) == '1':
            dec_value += base
        base *= 2

    return dec_value


def factorial(n):
    """The function implements an iterative factorial.
        It takes an integer n as an argument and returns n!"""

    fact = 1
    if n == 0:
        return 1
    for i in range(1, n + 1):
        fact *= i

    return fact


def approx_pie(n):
    """The function approximates the value of pi.
        It takes an integer argument representing the number of terms used to compute the approximation. """

    pi = 0.0
    num = 4
    denom = 1

    for i in range(1, n + 2):
        s = 2 * (i % 2) - 1
        pi += s * (num / denom)
        denom += 2

    return pi


def approx_e(n):
    """The function approximates the value of e.
        It takes an integer representing the number of terms used to compute the approximation. """

    e = 0

    for i in range(n):
        e += (1 / factorial(i))
        i += 1

    return e
