#include <stdio.h>

#define SIZE 10

int click = 0;

void time_complexity()
{
    printf("number of clicks :: %d\n",click);
}

void displayArray(int array[])
{
    printf("[");
    for (int i = 0; i < SIZE; i++)
    {
        if (i == SIZE - 1)
        {
            printf("%d",array[i]);
        }
        else
        {
            printf("%d ,",array[i]);
        }
    }
    printf("]\n");
}

void swap(int *xp, int *yp) 
{ 
    int temp = *xp; 
    *xp = *yp; 
    *yp = temp; 
} 

// A function to implement bubble sort 
void bubbleSort(int arr[], int n) 
{ 
   int i, j; 
   for (i = 0; i < n-1; i++)       
  
       // Last i elements are already in place    
       for (j = 0; j < n-i-1; j++)  
           if (arr[j] > arr[j+1]) 
              swap(&arr[j], &arr[j+1]); 
} 

int backwardLinearSearch(int *a, int b, int array[])
{
    for (int i = SIZE - 1; i >= 0; i--)
    {
        if(array[i] == b && &array[i] != a) return i;
        click++;
    }

    return -1;
}

int main()
{
    int k = 10, array[SIZE] = {1, 8, 15, 5, 12, 7, 14, 25, 5};

    for (int i = 0; i < SIZE; i++)
    {
        // using pointer so the program dont use the same element.
        int *a = &array[i], b = k - *a, index;
        index = backwardLinearSearch(a, b, array);
        if (index != -1)
        {
            printf("%d + %d = %d\n",*a, array[index],k);
            time_complexity();
            return 0;
        }
    }

    time_complexity();
    printf("no match found!\n");
    return 0;
}