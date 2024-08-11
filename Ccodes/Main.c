#include <stdio.h>

// Function to check if a number is a palindrome
int isPalindrome(int num)
{
    int originalNum = num;
    int reversedNum = 0, remainder;

    while (num != 0)
    {
        remainder = num % 10;
        reversedNum = reversedNum * 10 + remainder;
        num /= 10;
    }

    return originalNum == reversedNum;
}

// Function to generate Fibonacci series up to n terms
void fibonacciSeries(int n)
{
    int t1 = 0, t2 = 1, nextTerm;

    printf("Fibonacci Series: %d, %d", t1, t2);

    for (int i = 3; i <= n; ++i)
    {
        nextTerm = t1 + t2;
        printf(", %d", nextTerm);
        t1 = t2;
        t2 = nextTerm;
    }
    printf("\n");
}

// Function to check if a number is prime
int isPrime(int num)
{
    if (num <= 1)
        return 0;
    for (int i = 2; i <= num / 2; ++i)
    {
        if (num % i == 0)
            return 0;
    }
    return 1;
}

// Function to calculate the sum of digits of a number
int sumOfDigits(int num)
{
    int sum = 0;
    while (num != 0)
    {
        sum += num % 10;
        num /= 10;
    }
    return sum;
}

// Function to check if a year is a leap year
int isLeapYear(int year)
{
    if (year % 4 == 0)
    {
        if (year % 100 == 0)
        {
            if (year % 400 == 0)
                return 1;
            else
                return 0;
        }
        else
            return 1;
    }
    else
        return 0;
}

int main()
{
    int choice, number, n, year;

    printf("Choose an option:\n");
    printf("1. Check if the number is a palindrome\n");
    printf("2. Fibonacci series up to n terms\n");
    printf("3. Check if a given number is prime\n");
    printf("4. Calculate the sum of digits of a number\n");
    printf("5. Check if a given year is a leap year\n");
    printf("Enter your choice: ");
    scanf("%d", &choice);

    switch (choice)
    {
    case 1:
        printf("Enter a number: ");
        scanf("%d", &number);
        if (isPalindrome(number))
        {
            printf("%d is a palindrome.\n", number);
        }
        else
        {
            printf("%d is not a palindrome.\n", number);
        }
        break;

    case 2:
        printf("Enter the number of terms: ");
        scanf("%d", &n);
        fibonacciSeries(n);
        break;

    case 3:
        printf("Enter a number: ");
        scanf("%d", &number);
        if (isPrime(number))
        {
            printf("%d is a prime number.\n", number);
        }
        else
        {
            printf("%d is not a prime number.\n", number);
        }
        break;

    case 4:
        printf("Enter a number: ");
        scanf("%d", &number);
        printf("Sum of digits of %d is %d.\n", number, sumOfDigits(number));
        break;

    case 5:
        printf("Enter a year: ");
        scanf("%d", &year);
        if (isLeapYear(year))
        {
            printf("%d is a leap year.\n", year);
        }
        else
        {
            printf("%d is not a leap year.\n", year);
        }
        break;

    default:
        printf("Invalid choice.\n");
        break;
    }

    return 0;
}
