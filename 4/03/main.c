#include <stdio.h>
#include <string.h>

int findPath(int row, int column, int (*matrix)[column], int x, int y) {
    int result = 1;
    if (x+1 < row && matrix[x][y] + 1 == matrix[x+1][y])
    {
        int temp = 1 + findPath(row, column, matrix, x+1, y);
        if (temp > result)
        {
            result = temp;
        }
    }
    if (y+1 < column && matrix[x][y] + 1 == matrix[x][y+1])
    {
        int temp = 1 + findPath(row, column, matrix, x, y+1);
        if (temp > result)
        {
            result = temp;
        }
    }
    if (x-1 >= 0 && matrix[x][y] + 1 == matrix[x-1][y])
    {
        int temp = 1 + findPath(row, column, matrix, x-1, y);
        if (temp > result)
        {
            result = temp;
        }
    }
    if (y-1 >= 0 && matrix[x][y] + 1 == matrix[x][y-1])
    {
        int temp = 1 + findPath(row, column, matrix, x, y-1);
        if (temp > result)
        {
            result = temp;
        }
    }
    if (x+1 < row && y+1 < column && matrix[x][y] + 1 == matrix[x+1][y+1])
    {
        int temp = 1 + findPath(row, column, matrix, x+1, y+1);
        if (temp > result)
        {
            result = temp;
        }
    }
    if (x-1 >= 0 && y+1 < column && matrix[x][y] + 1 == matrix[x-1][y+1])
    {
        int temp = 1 + findPath(row, column, matrix, x-1, y+1);
        if (temp > result)
        {
            result = temp;
        }
    }
    if (x+1 < row && y-1 >= 0 && matrix[x][y] + 1 == matrix[x+1][y-1])
    {
        int temp = 1 + findPath(row, column, matrix, x+1, y-1);
        if (temp > result)
        {
            result = temp;
        }
    }
    if (x-1 >= 0 && y-1 >= 0 && matrix[x][y] + 1 == matrix[x-1][y-1])
    {
        int temp = 1 + findPath(row, column, matrix, x-1, y-1);
        if (temp > result)
        {
            result = temp;
        }
    }

    return result;
}

int main()
{
    int row, column;
    scanf("%d%d", &row, &column);

    int matrix[row][column];

    fflush(stdin);
    for (int i = 0; i < row; i++)
    {
        char next[column*2];
        gets(next);
        int t=0;
        for (int j = 0; j < strlen(next); j++)
        {
            if (next[j] != ' ')
            {
                matrix[i][t] = next[j];
                t++;
            }
        }
    }

    fflush(stdin);
    char c;
    scanf("%c", &c);
    int x=0, y=0, longestPath=0;

    for (int i = 0; i < row; i++)
    {
        for (int j = 0; j < column; j++)
        {
            int temp;
            if (matrix[i][j] == c)
            {
                temp = findPath(row, column, matrix, i, j);
                if (temp > longestPath)
                {
                    x=i; y=j;
                    longestPath = temp;
                }
            }
        }
    }

    printf("%d\n%d %d\n", longestPath, x, y);

    return 0;
}