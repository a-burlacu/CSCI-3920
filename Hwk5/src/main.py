from hw6 import *


def main():
    print("\n---------------Test split_number function---------------\n")

    n = 1234
    for i in range(5):
        print(f"Splitting number: {n} -> {split_number(n)}")
        n = n * 77

    print("\n---------------Test is_palindrome function---------------\n")

    print(f"\nCheck if palindrome:   n = 1234 -----> {is_palindrome(1234)}")
    print(f"Check if palindrome:   n = 1221 -----> {is_palindrome(1221)}")
    print(f"Check if palindrome:   n = 11555566 -> {is_palindrome(11555566)}\n")

    print("\n---------------Test compute_variance function---------------\n")

    print(f"Compute variance: 1,2,3,4,5,4,3,4,3 ------> {compute_variance(1, 2, 3, 4, 5, 4, 3, 4, 3)}")
    print(f"Compute variance: 1,1,2,2,4,5,6,7,7,8,9 --> {compute_variance(1, 1, 2, 2, 4, 5, 6, 7, 7, 8, 9)}\n")

    print("\n---------------Test compute_variance_req function---------------\n")

    print(f"Compute variance (2 req arguments): 1,2,3,4,5,4,3,4,3 -->"
          f" {compute_variance_req(1, 2, 3, 4, 5, 4, 3, 4, 3)}")
    print(f"Compute variance (2 req arguments): 1,1,2,3,4,9 --------> {compute_variance_req(1, 1, 2, 3, 4, 9)}\n")

    print("\n---------------Test compute_change_few_coins function---------------\n")

    print(f"Return change amount: $23.73  -> {compute_change_few_coins(23.73)}")
    print(f"Return change amount: $12.00  -> {compute_change_few_coins(12.00)}")
    print(f"Return change amount: $100.50 -> {compute_change_few_coins(100.50)}\n")

    print("\n---------------Test binary_to_decimal conversion---------------\n")

    print(f"Binary: 1101 ------------> Decimal: {binary_to_decimal('1101')}")
    print(f"Binary: 110  ------------>  Decimal: {binary_to_decimal('110')}")
    print(f"Binary: 1010101010 ------> Decimal: {binary_to_decimal('1010101010')}\n")

    print("\n---------------Test factorial finding function---------------\n")

    print(f"Factorial of: 4 ---> {factorial(4)}")
    print(f"Factorial of: 7 ---> {factorial(7)}")
    print(f"Factorial of: 1 ---> {factorial(1)}")
    print(f"Factorial of: 0 ---> {factorial(0)}\n")

    print("\n---------------Test approx_pie function---------------\n")

    print(f"Approx pi with 4 terms: -----> {approx_pie(5)}")
    print(f"Approx pi with 50 terms: ----> {approx_pie(50)}")
    print(f"Approx pi with 500 terms: ---> {approx_pie(500)}\n")

    print("\n---------------Test approx_e function---------------\n")

    print(f"Approx e with 6 terms: ----> {approx_e(6)}")
    print(f"Approx e with 12 terms: ---> {approx_e(12)}")
    print(f"Approx e with 240 terms: --> {approx_e(240)}\n")



if __name__ == '__main__':
    main()
