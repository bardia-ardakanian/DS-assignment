#include <stdio.h>

int main()
{
    int x = 0, n = 10, cnt = 0, i, j;
    for (i = 1; i < n; i++)
    {
        cnt++;
        for(j = 1; j < n; j++) 
        {
            x++;
            cnt++;
        }

        j = 1;
        while(j < 2)
        {
            x++;
            j = j*2;
            cnt++;
        }
    }

    printf("%d", cnt);
    return 0;
}