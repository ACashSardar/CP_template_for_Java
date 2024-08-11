#include <stdio.h>

void roundGrades(int grades[], int n)
{
    for (int i = 0; i < n; i++)
    {
        if (grades[i] >= 38)
        {
            int nextMultipleOfFive = ((grades[i] / 5) + 1) * 5;
            if (nextMultipleOfFive - grades[i] < 3)
            {
                grades[i] = nextMultipleOfFive;
            }
        }
    }
}

int main()
{
    int n;
    scanf("%d", &n);

    int grades[n];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &grades[i]);
    }

    roundGrades(grades, n);

    for (int i = 0; i < n; i++)
    {
        printf("%d\n", grades[i]);
    }

    return 0;
}
